var wxb = require("../../utils/wxb.js");
var wxUtils = require("../../utils/util.js");
var constant = require("../../utils/constant.js");
Page({
  changeRealNameSubmit:function(e){
    var _this = this;
    var newRealName = e.detail.value.realName;
    //获取userid
    wx.getStorage({
      key:'userid',
      success:function(res){
        //发送更新请求
        wxb.wxPost(
          "/user/updateUserInfo",
          {
            userId:res.data,
            name:newRealName,
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
              realName:newRealName
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
    realName:''
  },
  onLoad:function(options){
    this.setData({
      realName:options.realName
    });
  },
  //文本框失去焦点时获取文本框的输入值
  bindRealNameInput:function(e){
    this.setData({
      realName:e.detail.value
    })
  }
})