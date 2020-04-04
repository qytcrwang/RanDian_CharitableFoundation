var wxb = require('../../utils/wxb.js');
var constant = require('../../utils/constant.js');
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
  doncationGoods:function(e){
    var contriThings = e.detail.value.contriThings;
    var deliveryName = e.detail.value.delivery_name;
    var deliveryOrder = e.detail.value.delivery_order;
    var deliveryPeople = e.detail.value.delivery_people;
    var deliveryComment = e.detail.value.delivery_comment;
    if(contriThings == ""){
      wx.showToast({
        title:"请简要描述捐赠物品详情",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      });
      return;
    }
    if(deliveryName == ""
      || deliveryOrder == ""
      || deliveryPeople == ""){
      wx.showToast({
        title:"请完善快递信息",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      });
      return;
    }
    if(!this.data.isCheckDgProtocol){
      wx.showToast({
        title:"请勾选同意捐赠协议",
        icon:constant.TOAST_NONE,
        duration:constant.TOAST_CLOSE_MILLIONS
      });
      return;
    }
    wxb.wxPost(
      '/contriInfo/saveContriInfo',
      {
        userId:this.data.userid,
        contriType:0,
        contriThings:contriThings,
      },function(backResult){
        if(backResult.status == 1){
          wx.showModal({
            title:"捐赠成功",
            content:"您已成功向滴信慈善捐赠物品若干，请等待管理员入库",
            showCancel:false,
            success(res){
              if(res.confirm){
                wx.navigateTo({
                  url:"/pages/my_donations/my_donations"
                })
              }
            }
          });
        }else{
          wx.showToast({
            title:backResult.msg,
            icon:constant.TOAST_NONE,
            duration:2000
          })
        }
      }
    )
  },
  //捐钱
  donteMoney:function(e){
    var _this = this;
    var amount = e.detail.value.contriAmount;
    if(amount == ""){
      wx.showToast({
        title:"请输入捐赠金额",
        icon:constant.TOAST_NONE,
        duration:2000
      })
      return;
    }
    if(!this.data.isCheckDmProtocol){
      wx.showToast({
        title:"请勾选同意捐赠协议",
        icon:constant.TOAST_NONE,
        duration:2000
      })
      return;
    }
    wx.showModal({
      title: '确认捐赠',
      content: '您将要向滴信慈善捐赠'+amount+"元",
      success (res) {
        if (res.confirm) {
          //发起支付
          wxb.wxPost(
            '/contriInfo/saveContriInfo',
            {
              userId:_this.data.userid,
              contriType:1,
              contriAmount:amount,
            },function(backResult){
              if(backResult.status == 1){
                wx.showModal({
                  title:"捐赠成功",
                  content:"您已成功向滴信慈善捐赠"+amount+"元",
                  showCancel:false,
                  success(res){
                    if(res.confirm){
                      wx.navigateTo({
                        url:"/pages/my_donations/my_donations"
                      })
                    }
                  }
                });
              }else{
                wx.showToast({
                  title:backResult.msg,
                  icon:constant.TOAST_NONE,
                  duration:2000
                })
              }
            }
          )
        } else if (res.cancel) {
          
        }
      }
    })
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