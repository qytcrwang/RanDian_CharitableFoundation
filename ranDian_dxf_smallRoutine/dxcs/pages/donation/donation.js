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
})