
var wxb = require("../../utils/wxb.js");
var wxUtils = require("../../utils/util.js");
var constant = require("../../utils/constant.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //页面切换
    enrolmentTab : true,//已报名
    ongoingTab: false,//进行中
    completedTab: false,//已完成

    enrolmentNum: '',//已报名个数
    ongoingNum: '',//进行中个数
    completedNum: '',//已完成个数

    //已报名数据
    enrolmentList:[
    ],
    //进行中数据
    ongoingList: [
     
    ],
    //已完成数据
    completedList: [
    ],

  },
  onShow(){
    var _this = this;
    //获取userid
    wx.getStorage({
      key:'userid',
      success:function(res){
        //获取userid
        wxb.wxPost(
          "/activity/getUserList",
          {
            userId:res.data,
          },function(backResult){
            if(backResult == null ||
              backResult.data == null ||
              backResult.data.length <= 0 ||
              backResult.status != 1){
              wx.showToast({
                  title:constant.REQUEST_TIMEOUT,
                  duration:2000,
                  icon:'/img/close.png'
              })
              return;
            }
            _this.setData({
              ongoingList:backResult.data[0],
              completedList:backResult.data[1],
              enrolmentList:backResult.data[0].concat(backResult.data[1]),
              ongoingNum:backResult.data[0].length,
              completedNum:backResult.data[1].length,
              enrolmentNum:backResult.data[0].length+backResult.data[1].length,
            })
          }
        )
      }
    }) 
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