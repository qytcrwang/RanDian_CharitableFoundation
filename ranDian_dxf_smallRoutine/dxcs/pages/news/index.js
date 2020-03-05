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
    /**wxb.Post('/api/companygw.index/news', {
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
    });**/
  },

  //转发
  onShareAppMessage: function (res) {
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
