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
  },
  //初始化页面加载用户id
  onLoad: function () {
    var _this = this;
    wx.getStorage({
      key:'userid',
      success:function(res){
        _this.setData({
          userid:res.data
        })
      }
    })
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
  //提交捐赠信息
  doncationSubmit:function(e){
    var contriType = this.data.signTab? "1":"0";
    var contriAmount = this.data.signTab? e.detail.value.contriAmount:"";
    var contriThings = this.data.signTab? "":e.detail.value.contriThings;
    wxb.wxPost(
      '/contriInfo/saveContriInfo',
      {
        userId:this.data.userid,
        contriType:contriType,
        contriAmount:contriAmount,
        contriThings:contriThings,
      },function(backResult){
        if(backResult.status == 1){
          wx.showToast({
            title:backResult.msg,
            icon:'success',
            duration:2000
          })
        }else{
          wx.showToast({
            title:backResult.msg,
            duration:2000
          })
        }
      }
    )
  }
})