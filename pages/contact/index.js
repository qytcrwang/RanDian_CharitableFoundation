//index.js
//获取应用实例
var app = getApp();
var wxb = require('../../utils/wxb.js');
Page({
  data: {
    color: '',
    datas: [],
  },

  onShow: function () {
    wxb.that = this;   //正确打开海天应用的方式
    wxb.globalData = app.globalData; //正确打开海天应用的方式
    
  },

  onLoad: function () {
    wxb.that = this;
    wxb.style();
    this.getHome();
  },

  getHome: function (e) {
    wxb.that = this;   //正确打开海天应用的方式
    wxb.globalData = app.globalData; //正确打开海天应用的方式
    wx.showLoading({
      title: '加载中...',
    })
    wxb.Post('/api/companygw.index/getCompany', {

    }, function (data) {
      console.log(data);
      wx.hideLoading();
      wxb.that.setData({
        datas: data,
      })
    });
  }
})
