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

  }
})
