var wxb = require('../../utils/wxb.js');
Page({
  /**
   * 页面的初始数据
   */
  data: {
    donateMoneyTab:true,
    donateGoodsTab:false,
    userid:'',
  },
  onLoad: function () {
    var _this = this;
    wx.getStorage({
      key:'userid',
      success:function(res){
        _this.setData({
          userid:res.data
        })
      }
    })
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
  //提交捐赠信息
  doncationSubmit:function(e){
    var contriType = this.data.donateMoneyTab? "1":"0";
    var contriAmount = this.data.donateMoneyTab? e.detail.value.contriAmount:"";
    var contriThings = this.data.donateMoneyTab? "":e.detail.value.contriThings;
    wxb.wxPost(
      '/contriInfo/saveContriInfo',
      {
        userId:this.data.userid,
        contriType:contriType,
        contriAmount:contriAmount,
        contriThings:contriThings,
      },function(backResult){
        if(backResult.status == 1){
          wx.showToast({
            title:backResult.msg,
            icon:'success',
            duration:2000
          })
        }else{
          wx.showToast({
            title:backResult.msg,
            duration:2000
          })
        }
      }
    )
  }
})