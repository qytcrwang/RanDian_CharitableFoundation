var wxb = require('../../utils/wxb.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    //活动详情
    activityDetails:{
      sign_etime:'',
      activity_stime:'',
      activity_etime:''
    },
    //图片
    imgs:[
      '/img/activity3.png',
      '/img/activity2.png'
    ],
    currentPostId: '',
    userId:''

  },

  //点赞状态：0未点赞，1点赞，2已点赞
  changeGoodStatus(activityId){
    // 设置活动id为页面共享
    this.setData({
      currentPostId: activityId
    });
    // 获取缓存
    var goodList = wx.getStorageSync('goodList');
    if (goodList) {
      // 获取活动点赞状态
      var goodStatus = goodList[activityId];
      // 更新活动点赞状态
      this.setData({
        goodStatus: goodStatus
      });
    } else {
      // 如果不存在缓存就设置一个新缓存
      var goodList = {};
      wx.setStorageSync('goodList', goodList);
    }
  },


  ongoodTap: function (event) {
    var goodList = wx.getStorageSync('goodList');
    // 获取活动点赞状态
    var goodStatus = goodList[this.data.currentPostId];
    
    if(goodStatus==2){//已经点过赞
      this.showToast('goodList', goodList, 2);
    }else{
      // 活动点赞状态切换
      goodStatus = 1;
      // 存储活动点赞状态
      goodList[this.data.currentPostId] = 2;
      // 三个参数为,Storage键、值、活动点赞状态
      this.addGoodNum(this.data.currentPostId);
      this.showToast('goodList', goodList, goodStatus);
    }
  },

  showToast: function (key, value, status) {

    wx.setStorageSync(key, value);
    // 更新活动点赞状态
    this.setData({
      goodStatus: status
    });
    // 显示提示
    if(status==1){
      wx.showToast({
        title: '点赞成功',
        icon: 'success',
        duration: 2000
      })
    }else{
      wx.showToast({
        title: '已经点赞过了~',
        icon: 'none',
        duration: 2000
      })
    }
  },

  //获取活动详情
  getActivityDetails(activityId){
    let that = this;
    var userId = wx.getStorageSync('userid');
    wxb.wxPost(
      "/activity/getInfo",
      {
        id: activityId,
        userId:userId
      },function(res){
        if(res.status===1){
          that.setData({
            activityDetails:res.data,
            // imgs:res.data.pic_url.split(",")
          });
        }
      }
    )
  },
  
  //活动点赞
  addGoodNum(activityId){
    let that = this;
    wxb.wxPost(
      "/activity/addGood",
      {
        id: activityId
      },function(res){
        if(res.status===1){
          that.getActivityDetails(activityId);
        }else{
          wx.showToast({
            title: '点赞失败，请联系管理员~',
            icon: 'none',
            duration: 2000
          })
        }
      }
    )
  },  

  //已报名提示
  joinedMessage(){
    wx.showToast({
      title: '不可重复报名~',
      icon: 'none',
      duration: 2000
    })
  },

  //报名活动
  joinActivity(){
    wx.showLoading({
      title: '加载中',
      mask:true//防止触摸穿透
    });
    let that = this;
    var activityId = this.currentPostId;
    var userId = wx.getStorageSync('userid');
    wxb.wxPost(
      "/activity/applyActivity",
      {
        id: activityId,
        userId:userId
      },function(res){
        if(res.status===1){
          that.getActivityDetails(activityId);
          wx.showToast({
            title: res.msg,
            icon: 'success',
            mask:true,
            duration: 2000
          })
        }else{
          wx.showToast({
            title: '报名失败，请联系管理员~',
            icon: 'none',
            duration: 2000
          })
        }
      }
    )
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let activityId = options.id;
    this.currentPostId = options.id;
    this.getActivityDetails(activityId);
    this.changeGoodStatus(activityId);
  },

  

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})