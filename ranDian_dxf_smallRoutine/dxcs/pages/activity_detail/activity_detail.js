Page({

  /**
   * 页面的初始数据
   */
  data: {
    //活动详情
    activityDetails:null,
    //图片
    imgs:[
      '/img/activity1.png',
      '/img/activity2.png',
     '/img/activity3.png'
    ],
    currentPostId: ''

  },

  changeGoodStatus(activityId){
    // 设置活动id为页面共享
    this.setData({
      currentPostId: activityId
    });
    // 获取缓存
    var goodList = wx.getStorageSync('goodList');
    if (goodList) {
      // 获取活动收藏状态
      var goodStatus = goodList[activityId];
      // 更新活动收藏状态
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
    // 获取活动收藏状态
    var goodStatus = goodList[this.data.currentPostId];
    // 活动收藏状态切换
    goodStatus = !goodStatus;
    // 存储活动收藏状态
    goodList[this.data.currentPostId] = goodStatus;
    // 三个参数为,Storage键、值、活动收藏状态
    this.showToast('goodList', goodList, goodStatus);
  },

  showToast: function (key, value, status) {

    wx.setStorageSync(key, value);
    // 更新活动收藏状态
    this.setData({
      goodStatus: status
    });
    // 显示提示
    wx.showToast({
      title: status ? "点赞成功" : "取消成功"
    })
  },

  getActivityDetails(activityId){
    let that = this;
    wx.request({
      method:'POST',
      data: {
        id: activityId,
        userId:1
      },
      url:"http://localhost:8081/wx/activity/getInfo",
      success(res){
        console.log(res);
        if(res.data.status===1){
          var a = res.data.data.pic_url.split(",");
          console.log(a);
          that.setData({
            activityDetails:res.data.data,
            // imgs:a
          });
          // console.log(imgs);
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options);
    let activityId = options.id;
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