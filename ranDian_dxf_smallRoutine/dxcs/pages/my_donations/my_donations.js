
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
        wx.request({
          url:'http://localhost:8081/wx/contriInfo/getSelfContriInfo',
          data:{
            userId:res.data,
          },
          method:'POST',
          dataType:'json',
          success:function(backResult){
            _this.setData({
              ongoingList:backResult.data.data.ongoingList,
              ongoingNum:backResult.data.data.ongoingList.length,
              completedList:backResult.data.data.completedList,
              completedNum:backResult.data.data.completedList.length,
            })
          }
        })
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