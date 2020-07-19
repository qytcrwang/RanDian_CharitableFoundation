var wxb = require('../../utils/wxb.js');
var constant = require('../../utils/constant');
var utils = require('../../utils/util.js');
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
    isCheckDmProtocol:false,
    //是否显示协议
    isShowMoneyAgreement:false,
    //用户捐赠协议中甲方信息
    partyA:"",
    partyAUnit:"",
    partyAPosition:"",
    partyALegal:"",
    partyALink:"",
    partyALinkPhone:"",
    //捐赠用途
    userFor:"",
    todayDate:"",
    todayMonth:"",
    todayYear:"",
    //捐赠金额
    contriAmount:"",
    contriThings:"",
    contentComment:"",
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
        );
        wxb.wxPost(
          "/contriInfo/getLastProtocolInfo",
          {
            userId:res.data
          },function(backResult){
            if(backResult == null ||
              backResult.data == null){
                return;
            }
            _this.setData({
              partyA:backResult.data.partyA,
              partyAUnit:backResult.data.partyAUnit,
              partyAPosition:backResult.data.partyAPosition,
              partyALegal:backResult.data.partyALegal,
              partyALink:backResult.data.partyALink,
              partyALinkPhone:backResult.data.partyALinkPhone,
              userFor:backResult.data.userFor
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
    var amount = e.detail.value.contriAmount;
    if(amount == ""){
      wx.showToast({
        title:"请输入捐赠金额",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    if(!this.data.isCheckDmProtocol){
      wx.showToast({
        title:"请完善并同意捐赠协议",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    wx.showModal({
      title: '确认捐赠',
      content: '您将要向滴信慈善捐赠'+amount+"元",
      success (res) {
        if (res.confirm) {
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
          //发起支付
          wxb.wxPost(
            '/contriInfo/saveContriInfo',
            {
              userId:_this.data.userid,
              contriType:1,
              contriAmount:amount,
              content:_this.data.contriAmount,
              contentComment:_this.data.contentComment,
              protocolType:1,//捐钱
              partyA:_this.data.partyA,
              partyAUnit:_this.data.partyAUnit,
              partyALegal:_this.data.partyALegal,
              partyAPosition:_this.data.partyAPosition,
              partyALink:_this.data.partyALink,
              partyALinkPhone:_this.data.partyALinkPhone,
              userFor:_this.data.userFor,
              partyASignTime:_this.data.todayYear+"年"+_this.data.todayMonth+"月"+_this.data.todayDate+"日",
              partyBSignTime:_this.data.todayYear+"年"+_this.data.todayMonth+"月"+_this.data.todayDate+"日"
            },function(backResult){
              if(backResult.status == 1){
                wx.showModal({
                  title:"捐赠成功",
                  content:"您已成功向滴信慈善捐赠"+amount+"元",
                  showCancel:false,
                  success(res){
                    if(res.confirm){
                      wx.navigateTo({
                        url:"/pages/my_donations/my_donations"
                      })
                    }
                  }
                });
              }else{
                wx.showToast({
                  title:"捐赠异常，请稍后再试",
                  icon:constant.TOAST_NONE,
                  duration:2000
                })
              }
            }
          )
        } else if (res.cancel) {
          
        }
      }
    });
    
  },
  //展示协议
  showMoneyAgreement:function(){
    //设置签署时间
    var date = new Date();
    var todayYear = date.getFullYear();
    var todayMonth = (date.getMonth() + 1)<10? "0"+(date.getMonth()+1):date.getMonth()+1;
    var todayDate = date.getDate()<10? "0"+date.getDate():date.getDate();
    this.setData({
      isShowMoneyAgreement:true,
      todayYear:todayYear,
      todayMonth:todayMonth,
      todayDate:todayDate
    })
  },
  getContriAmount:function(e){
    var contriAmount = e.detail.value;
    this.setData({
      contriAmount:contriAmount,
      contentComment:utils.rmbToCN(contriAmount),
    })
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
  modalCancel:function(){
    this.setData({
      isShowGoodsAgreement:false,
      isShowMoneyAgreement:false,
      isCheckDmProtocol:false,
      isCheckDgProtocol:false
    })
  },
  partyAUnitChange:function(e){
    var selectedValue = e.detail.value;
    this.setData({
      partyAUnit:selectedValue,
    })
  },
  userForChange:function(e){
    var selectedValue = e.detail.value;
    this.setData({
      userFor:selectedValue,
    })
  },
  getContriAmount:function(e){
    var contriAmount = e.detail.value;
    this.setData({
      contriAmount:contriAmount,
      contentComment:utils.rmbToCN(contriAmount),
    })
  },
  agreeProtocol:function(e){
    var partyA = e.detail.value.partyA;
    var partyAPosition = e.detail.value.partyAPosition;
    var partyALegal = e.detail.value.partyALegal;
    var partyALink = e.detail.value.partyALink;
    var partyALinkPhone = e.detail.value.partyALinkPhone;
    if(partyA == ""){
      wx.showToast({
        title:"请完善协议中的甲方",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    if(partyAPosition == ""){
      wx.showToast({
        title:"请完善协议中的甲方住所",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    if(this.data.partyAUnit == ""){
      wx.showToast({
        title:"请选择甲方单位性质",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    if(partyALink == ""){
      wx.showToast({
        title:"请完善协议中的甲方联系人",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    if(partyALinkPhone == ""){
      wx.showToast({
        title:"请完善协议中的甲方联系方式",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      })
      return;
    }
    this.setData({
      isCheckDmProtocol:true,  
      isShowMoneyAgreement:false,
      isShowGoodsAgreement:false,
      partyA:partyA,
      partyALegal:partyALegal,
      partyAPosition:partyAPosition,
      partyALink:partyALink,
      partyALinkPhone:partyALinkPhone,
    })
  }
})