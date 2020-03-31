var wxb = require('../../utils/wxb.js');
Page({
  /**
   * 页面的初始数据
   */
  data: {
    donateMoneyTab:true,
    donateGoodsTab:false,
    userid:'',
    //是否勾选捐钱协议
    isCheckDmProtocol:false,
    //是否勾选物品捐赠协议
    isCheckDgProtocol:false,
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
    if(contriType == 1
      && !this.data.isCheckDmProtocol){
      wx.showToast({
        title:"请勾选同意捐赠协议",
        image:"/img/close.png",
        duration:2000
      })
      return;
    }
    if(contriType == 0
      && !this.data.isCheckDgProtocol){
        wx.showToast({
          title:"请勾选同意捐赠协议",
          image:"/img/close.png",
          duration:2000
        })
        return;
      }
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
            title:"捐赠成功",
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
  },
  //勾选同意捐钱协议按钮
  dmProtocolChecked:function(){
    var isCheckDmProtocol = this.data.isCheckDmProtocol;
    this.setData({
      isCheckDmProtocol:!isCheckDmProtocol
    })
  },
  //勾选同意捐物协议按钮
  dgProtocolChecked:function(){
    var isCheckDgProtocol = this.data.isCheckDgProtocol;
    this.setData({
      isCheckDgProtocol:!isCheckDgProtocol
    })
  }
})