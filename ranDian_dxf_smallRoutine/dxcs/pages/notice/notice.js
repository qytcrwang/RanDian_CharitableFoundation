Page({
  data: {
    color: '',
    datas: [
      {id:'1',title:'测试1',add_time:'2019-09-18'},
      {id:'2',title:'测试1',add_time:'2019-09-18'},
      {id:'3',title:'测试1',add_time:'2019-09-18'}
    ],
    page: 1,
    more: 0,
    type: 0,
  },

  onShow: function () {
  },
  onLoad: function () {
  },
  more: function (e) {
    this.getHome();
  },
  getHome: function (e) {
    wx.showLoading({
      title: '加载中...',
    })
  },
})
