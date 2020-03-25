var wxb = require('../../utils/wxb.js');

Page({

  /**
   * 页面的初始数据
   */
  data: {
    //活动详情
    messageDetails:null,
    //活动日期
    noticeTime:null

  },

  dateFormat: function (timestamp){
    let d = new Date(timestamp * 1000);// 时间戳为10位需*1000，时间戳为13位的话不需乘1000
    let yyyy = d.getFullYear() + '-';
    let MM = (d.getMonth()+1 < 10 ? '0'+(d.getMonth()+1) : d.getMonth()+1) + '-';
    let dd = d.getDate() + ' ';
    let HH = d.getHours() + ':';
    let mm = d.getMinutes() + ':';
    let ss = d.getSeconds();
    return yyyy + MM + dd + HH + mm + ss;
  },

  getMessageDetails(msgId){
    let that = this;
    wxb.wxPost(
      "/notice/getNoticeById",
      {
        id:msgId
      },function(res){
        if(res.status===1){
          let d = new Date(res.data.time * 1000);// 时间戳为10位需*1000，时间戳为13位的话不需乘1000
          let yyyy = d.getFullYear() + '-';
          let MM = (d.getMonth()+1 < 10 ? '0'+(d.getMonth()+1) : d.getMonth()+1) + '-';
          let dd = d.getDate() + ' ';
          let HH = d.getHours() + ':';
          let mm = d.getMinutes() + ':';
          let ss = d.getSeconds();
          // console.log(yyyy + MM + dd + HH + mm + ss);
          that.setData({
            messageDetails:res.data,
            noticeTime:yyyy + MM + dd + HH + mm + ss
          });
        }
      }
    )
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let msgId = options.id;
    this.getMessageDetails(msgId);
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