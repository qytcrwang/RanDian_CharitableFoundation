var wxb = require('../../utils/wxb.js');
var constant = require('../../utils/constant');
Page({
  /**
   * 页面的初始数据
   */
  data: {
    signTab:true,
    applyForTab:false,
    userid:'',
    isTodaySigned:false,
    isApplyRent:false,
    isCheckDmProtocol:false
  },
  //初始化页面加载用户id
  onShow: function () {
    var _this = this;
    wx.getStorage({
      key:'userid',
      success:function(res){
        _this.setData({
          userid:res.data
        });
        //查询用户今日是否已经签到
        wxb.wxPost(
          "/user/isTodaySigned",
          {
            userId:res.data,
          },function(backResult){
            if(backResult == null ||
              backResult.data == null ||
              backResult.status != 1){
              wx.showToast({
                  title:constant.REQUEST_TIMEOUT,
                  duration:2000,
                  icon:'/img/close.png'
              })
              return;
            }
            _this.setData({
              isTodaySigned:backResult.data
            })
          }
        )
      }
    });
    
  },

  toSignTab: function (e) {
    this.setData({
      signTab: true,
      applyForTab: false
    })
  },
  toApplyForTab: function (e) {
    this.setData({
      signTab: false,
      applyForTab: true
    })
  },
  //签到
  doncationSubmit:function(e){
    var _this = this;
    //首先跳转到支付页面支付，支付成功后执行签到动作
    wxb.wxPost(
      "/user/userSingIn",
      {
        userId:_this.data.userid
      },function(backResult){
        if(backResult == null ||
          backResult.status != 1){
          wx.showToast({
              title:backResult.msg,
              duration:2000,
              icon:constant.TOAST_NONE
          })
          return;
        }
        _this.setData({
          isTodaySigned:true
        })
      }
    )
  },
  //申请房租
  applyRent:function(e){
    var _this = this;
    var applyAmount = e.detail.value.applyAmount;
    if(applyAmount == ""){
      wx.showToast({
        title:"请输入申请金额",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    var university = e.detail.value.university;
    if(university == ""){
      wx.showToast({
        title:"请输入毕业院校",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    var major = e.detail.value.major;
    if(major == ""){
      wx.showToast({
        title:"请输入所属专业",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    var salary = e.detail.value.salary;
    if(salary == ""){
      wx.showToast({
        title:"请输入期望薪资",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    var onjob = e.detail.value.onjob;
    if(onjob != "在职" && onjob != "未就业"){
      wx.showToast({
        title:"请输入在职状态",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    var companyName = e.detail.value.companyName;
    var companyAddress =e.detail.value.companyAddress;
    var companyPostion = e.detail.value.companyPostion;
    var comment = e.detail.value.comment;
    wxb.wxPost(
      "/rent/addRentApply",
      {
        userId:_this.data.userid,
        sentAmount:applyAmount,
        school:university,
        major:major,
        jobIntension:comment,
        hopeSalary:salary,
        jobState:onjob=="在职"? 1:0,
        companyName:companyName,
        companyAddress:companyAddress,
        companyPostion:companyPostion
      },function(backResult){
        if(backResult == null ||
            backResult.status == 0){
          wx.showToast({
            title:backResult.msg,
            icon:constant.TOAST_NONE,
            duration:constant.TOAST_CLOSE_MILLIONS
          })
        }
        wx.showModal({
          title:"申请成功",
          content:"您已成功向滴信慈善申请房租补贴，请耐心等待管理员审核",
          showCancel:false,
          success(res){
            if(res.confirm){
              wx.reLaunch({
                url:'../index/index',
              })
            }
          }
        });
        
      }
    )
  },
  //勾选同意捐钱协议按钮
  dmProtocolChecked:function(){
    var isCheckDmProtocol = this.data.isCheckDmProtocol;
    this.setData({
      isCheckDmProtocol:!isCheckDmProtocol
    })
  },
})