var wxb = require("../../utils/wxb.js");
var wxUtils = require("../../utils/util.js");
var constant = require("../../utils/constant.js");
Page({
  /**
   * 页面的初始数据
   */
  data: {
    userTypeArray:['普通','儿童','大学生','企业'],
    userTypeIndex:'',
    realName:'',
    idCard:'',
    phone:'',
    userId:''   
  },
  onShow(){
    //获取储存区的userid
    var _this = this;
    wx.getStorage({
      key:'userid',
      success:function(res){
        //将userid缓存到本页面
        _this.setData({
          userId:res.data
        })
        //根据userid加载用户账户数据
        wxb.wxPost(
          "/user/getUserInfo",
          {
            userId:_this.data.userId
          },function(backResult){
            if(backResult == null ||
              backResult.data == null ||
              backResult.data.length <= 0 ||
              backResult.status != 1){
              wx.showToast({
                  title:constant.REQUEST_TIMEOUT,
                  icon:constant.TOAST_NONE,
                  duration:constant.TOAST_CLOSE_MILLIONS
              })
              return;
            }
            //获取用户信息成功
            var userInfo = backResult.data;
            _this.setData({
              realName:userInfo.name,
              idCard:userInfo.idCardNumber,
              phone:userInfo.mobile,
              userTypeIndex:userInfo.type
            });
          }
        )
      }
    })
  },
  gotoRealName(){
    var realName = this.data.realName;
    if(realName == null){
      realName = '';
    }
    wx.navigateTo({
      url:'../account_name/account_name?realName='+realName
    })
  },
  gotoIdCard(){
    var idCard = this.data.idCard;
    if(idCard == null){
      idCard = '';
    }
    wx.navigateTo({
      url:'../account_idCard/account_idCard?idCard='+idCard
    })
  },
  gotoPhone(){
    var phone = this.data.phone;
    if(phone == null){
      phone = '';
    }
    wx.navigateTo({
      url:'../account_phone/account_phone?phone='+phone
    })
  },
  //修改用户类型
  bindUserTypePickerChange(e){
    var newUserType = e.detail.value;
    var _this = this;
    this.setData({
      userTypeIndex:newUserType
    })
    wxb.wxPost(
      "/user/updateUserInfo",
      {
        userId:_this.data.userId,
        userType:newUserType,
      },function(backResult){
        if(backResult == null ||
          backResult.status != 1){
            wx.showToast({
              title:constant.REQUEST_TIMEOUT,
              icon:constant.TOAST_NONE,
              duration:constant.TOAST_CLOSE_MILLIONS
            })
          return;
        }
        //更新成功
        _this.setData({
          userType:newUserType
        });
        wx.showToast({
          title:constant.REQUEST_ALTER_SUCCESS,
          icon:constant.TOAST_NONE,
          duration:constant.TOAST_CLOSE_MILLIONS
        });
      }
    )
  }
})