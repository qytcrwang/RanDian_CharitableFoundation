
var wxb = require("../../utils/wxb.js");
var wxUtils = require("../../utils/util.js");
var constant = require("../../utils/constant.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //页面切换
    ongoingTab: true,//进行中
    completedTab: false,//已完成
    ongoingNum:'',//进行中个数
    completedNum:'',//已完成个数

    //进行中数据
    ongoingList: [],
    //已完成数据
    completedList: [],

  },
  onShow(){
    var _this = this;
    //获取userid
    wx.getStorage({
      key:'userid',
      success:function(res){
        //获取userid
        wxb.wxPost(
          "/contriInfo/getSelfContriInfo",
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
              ongoingList:backResult.data.ongoingList,
              ongoingNum:backResult.data.ongoingList.length,
              completedList:backResult.data.completedList,
              completedNum:backResult.data.completedList.length,
            })
          }
        )
      }
    })
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