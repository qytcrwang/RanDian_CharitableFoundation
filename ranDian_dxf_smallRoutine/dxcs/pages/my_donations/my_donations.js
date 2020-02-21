// pages/goods/goods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //页面切换
    ongoingTab: true,//进行中
    completedTab: false,//已完成
    ongoingNum: 4,//进行中个数
    completedNum: 4,//已完成个数

    //进行中数据
    ongoingList: [
      { id: 1, title: "新型冠状病毒资金捐助", time: "2019-03-02" },
      { id: 2, title: "新型冠状病毒志愿者活动", time: "2019-03-02" },
      { id: 3, title: "新型冠状病毒志愿者活动", time: "2019-03-02" },
      { id: 4, title: "新型冠状病毒志愿者活动", time: "2019-03-02" },
    ],
    //已完成数据
    completedList: [
      { id: 1, title: "新型冠状病毒志愿者活动", time: "2019-03-02" },
      { id: 2, title: "新型冠状病毒志愿者活动", time: "2019-03-02" },
      { id: 3, title: "新型冠状病毒志愿者活动", time: "2019-03-02" },
      { id: 4, title: "新型冠状病毒志愿者活动", time: "2019-03-02" },
    ],

  },
  //tab切换 - 进行中
  toOngoingTab: function (e) {
    this.setData({
      ongoingTab: true,
      completedTab: false,
    })
  },
  //tab切换 - 已完成
  toCompletedTab: function (e) {
    this.setData({
      ongoingTab: false,
      completedTab: true,
    })
  },
  //点击查看详情
  detailsLook() {
    wx.navigateTo({
      url: '../detailsLook/detailsLook',
    })
  }
})