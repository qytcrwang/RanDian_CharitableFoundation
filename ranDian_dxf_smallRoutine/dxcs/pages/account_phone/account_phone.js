var wxb = require("../../utils/wxb.js");
var wxUtils = require("../../utils/util.js");
var constant = require("../../utils/constant.js");
Page({
  changePhoneSubmit:function(e){
    var _this = this;
    var newPhone = e.detail.value.phone;
    //获取userid
    wx.getStorage({
      key:'userid',
      success:function(res){
        //发送更新请求
        wxb.wxPost(
          "/user/updateUserInfo",
          {
            userId:res.data,
            mobile:newPhone,
          },function(backResult){
            if(backResult == null ||
              backResult.status != 1){
                wx.showToast({
                  title:constant.REQUEST_TIMEOUT,
                  icon:constant.TOAST_NONE,
                  duration:constant.TOAST_CLOSE_MILLIONS,
                })
              return;
            }
            //更新成功
            _this.setData({
              phone:newPhone
            });
            wx.showToast({
              title:constant.REQUEST_ALTER_SUCCESS,
              icon:constant.TOAST_NONE,
              duration:constant.TOAST_CLOSE_MILLIONS,
            });
            //跳转到我的信息页面
            
          }
        )
      } 
    })
  },
  /**
   * 页面的初始数据
   */
  data: {
    phone:''
  },
  onLoad:function(options){
    this.setData({
      phone:options.phone
    });
  }
})