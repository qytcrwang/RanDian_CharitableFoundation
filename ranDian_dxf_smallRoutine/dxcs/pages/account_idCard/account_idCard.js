var wxb = require("../../utils/wxb.js");
var wxUtils = require("../../utils/util.js");
var constant = require("../../utils/constant.js");
Page({
  changeIdCardSubmit:function(e){
    var _this = this;
    var newIdCard = e.detail.value.idCard;
    //获取userid
    wx.getStorage({
      key:'userid',
      success:function(res){
        //发送更新请求
        wxb.wxPost(
          "/user/updateUserInfo",
          {
            userId:res.data,
            idCardNumber:newIdCard,
          },function(backResult){
            if(backResult == null ||
              backResult.status != 1){
                wx.showToast({
                  title:constant.REQUEST_TIMEOUT,
                  duration:2000,
                  icon:'/img/close.png'
                })
              return;
            }
            //更新成功
            _this.setData({
              idCard:newIdCard
            });
            wx.showToast({
              title:constant.REQUEST_SUCCESS,
              icon:'success',
              duration:2000
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
    idCard:''
  },
  onLoad:function(options){
    this.setData({
      idCard:options.idCard
    });
  },
})