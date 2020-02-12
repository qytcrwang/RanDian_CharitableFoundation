//index.js
//获取应用实例
var app = getApp();
var wxb = require('../../utils/wxb.js');
Page({
  data: {
    color: '',
    datas: [],
    id: 0,
    setting: [],
  },

  onLoad: function (e) {
    console.log(e);
    wxb.that = this;
    wxb.style();
    wxb.that.setData({
      id: e.id,
    });

    this.getDetail();

  },

  getDetail: function (e) {
    wxb.that = this;   //正确打开海天应用的方式
    wxb.globalData = app.globalData; //正确打开海天应用的方式

    wx.showLoading({
      title: '加载中...',
    })
    wxb.Post('/api/companygw.index/detail2', {
      id: wxb.that.data.id,
    }, function (data) {
      wx.hideLoading();
      wxb.that.setData({
        datas: data,
      })
    });
  },

  calling: function () {
    wx.makePhoneCall({
      phoneNumber: wxb.that.data.setting.service_tel, //此号码并非真实电话号码，仅用于测试
      success: function () {
        console.log("拨打电话成功！")
      },
      fail: function () {
        console.log("拨打电话失败！")
      }
    })
  },

  //转发
  onShareAppMessage: function (res) {
    wxb.that = this;   //正确打开海天应用的方式
    wxb.globalData = app.globalData; //正确打开海天应用的方式
    return {
      title: '企业官网',
      path: '/pages/product/detail?id=' + wxb.that.data.id,
      success: function (res) {
        // 转发成功
        wx.showToast({
          title: '已转发',
        })
      },
      fail: function (res) {
        // 转发失败
        wx.showToast({
          title: '转发失败',
        })
      }
    }
  }

})
