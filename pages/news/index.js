//index.js
//获取应用实例
var app = getApp();
var wxb = require('../../utils/wxb.js');
Page({
  data: {
    color: '',
    datas: [],
    page: 1,
    more: 0,
    type: 0,
  },

  onShow: function () {
    wxb.that = this;   //正确打开海天应用的方式
    wxb.globalData = app.globalData; //正确打开海天应用的方式

    this.setData({
      datas: [],
      page: 1,
      more: 0,
    });

    this.getHome();
  },

  onLoad: function () {
    wxb.that = this;
    wxb.style();
  },


  more: function (e) {
    this.getHome();
  },

  getHome: function (e) {
    wxb.that = this;   //正确打开海天应用的方式
    wxb.globalData = app.globalData; //正确打开海天应用的方式
    wx.showLoading({
      title: '加载中...',
    })
    wxb.Post('/api/companygw.index/news', {
      page: wxb.that.data.page,
    }, function (data) {
      var mLists = wxb.that.data.datas;
      for (var a in data.list) {
        mLists.push(data.list[a]);
      }
      console.log(data);
      wx.hideLoading();
      wxb.that.setData({
        datas: mLists,
        page: wxb.that.data.page + 1,
        more: data.more,
      })
    });
  },

  //转发
  onShareAppMessage: function (res) {
    wxb.that = this;   //正确打开海天应用的方式
    wxb.globalData = app.globalData; //正确打开海天应用的方式
    return {
      title: '企业官网',
      path: '/pages/news/index',
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
