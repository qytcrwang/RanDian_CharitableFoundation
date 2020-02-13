//index.js
//获取应用实例
var app = getApp();
var wxb = require('../../utils/wxb.js');
Page({
  data: {
    color: '',
  },

  onLoad: function () {
    wxb.that = this;
    wxb.style();

  },

  fromSubmit: function (e) {
    console.log('fromSubmit');
    var params = e.detail.value;
    console.log(e);
    wxb.that = this;   //正确打开海天应用的方式
    wxb.globalData = app.globalData; //正确打开海天应用的方式
    wx.showLoading({
      title: '正在加载中..',
    });
    wxb.Post('/api/companygw.index/consult', {
      openid: wxb.getOpenId(),
      product_name: params.product_name,
      name: params.name,
      tel: params.tel,
      remarks: params.remarks,
    }, function (data) {
      console.log(data);
      wx.hideLoading();
      wx.showToast({
        title: '提交成功',
      });

      var pages = getCurrentPages()
      var num = pages.length
      wx.navigateBack({
        delta: num - 1,
      })
    });
  }
})
