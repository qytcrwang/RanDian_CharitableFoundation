// pages/order/order.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    donateMoneyTab:true,
    donateGoodsTab:false
  },
  onLoad: function () {
  },

  toDonateMoney: function (e) {
    this.setData({
      donateMoneyTab: true,
      donateGoodsTab: false
    })
  },
  toDonateGoods: function (e) {
    this.setData({
      donateMoneyTab: false,
      donateGoodsTab: true
    })
  },
  //修改尺寸
  editSize(){
    wx.switchTab({
      url: '../index/index',
    })
  },
  //选择地址
  checkAddr(){
    wx.navigateTo({
      url: '../myAddr/myAddr',
    })
  },
  slider3change(e){
    console.log(`slider3发生change事件，携带值为`, e.detail.value)
  }
})