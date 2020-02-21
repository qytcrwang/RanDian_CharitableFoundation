// pages/goods/goods.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //页面切换
    enrolmentTab : true,//已报名
    ongoingTab: false,//进行中
    completedTab: false,//已完成

    enrolmentNum: 2,//已报名个数
    ongoingNum: 4,//进行中个数
    completedNum: 4,//已完成个数

    //已报名数据
    enrolmentList:[
      {id:1,title:"新型冠状病毒志愿者活动",time:"2019-03-02"},
      {id:2,title:"新型冠状病毒志愿者活动",time:"2019-03-02"}
    ],
    //进行中数据
    ongoingList: [
      { id: 1, title: "新型冠状病毒志愿者活动", time: "2019-03-02" },
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
  //tab切换 - 已报名
  toEnrolmentTab: function (e) {
    this.setData({
      enrolmentTab: true,
      ongoingTab: false,
      completedTab: false,
    })
  },
  //tab切换 - 进行中
  toOngoingTab: function (e) {
    this.setData({
      enrolmentTab: false,
      ongoingTab: true,
      completedTab: false,
    })
  },
  //tab切换 - 已完成
  toCompletedTab: function (e) {
    this.setData({
      enrolmentTab: false,
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