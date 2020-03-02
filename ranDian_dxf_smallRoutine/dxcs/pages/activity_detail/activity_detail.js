// pages/activity_detail/activity_detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //活动详情
    activityDetails:null,
    //图片
    imgs:[]

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let activityId = options.id;
    this.getActivityDetails(activityId);
  },

  getActivityDetails(activityId){
    let that = this;
    wx.request({
      method:'POST',
      data: {
        id: activityId
      },
      url:"http://mock-api.com/VKyv1Gzw.mock/activity/getInfo",
      success(res){
        if(res.data.status===1){
          var a = res.data.data.pic_url.split(",");
          console.log(a);
          that.setData({
            activityDetails:res.data.data,
            imgs:[a]
          });
          // console.log(imgs);
        }
      }
    })
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