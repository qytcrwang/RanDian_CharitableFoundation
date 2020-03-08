var app = getApp();
var wxb = require('../../utils/wxb')
Page({
  data: {
    isLogin:{},
    //捐赠积分
    loveFund:'',
    //公益活动积分
    lovePoint:'',
  },
  //页面加载时查看用户是否授权，未授权用户不显示部分信息。
  onLoad:function(){
    var _this = this;
    console.log(app.globalData.isLogin)
    //查看是否已经登陆
    if(app.globalData.isLogin == true){
      _this.setData({
        isLogin:true
      })
    }else{
      _this.setData({
        isLogin:false
      })
    }
  },
  onShow:function(){
    var _this = this;
    wx.getStorage({
      key:'userid',
      success:function(res){
        wx.request({
          url:'http://localhost:8081/wx/user/getUserInfo',
          data:{
            userId:res.data
          },
          method:'POST',
          dataType:'json',
          success:function(backResult){
            if(backResult.data.status == 1){
              //查询用户信息成功
              var userLovePoint = backResult.data.data.lovePoint;
              var userLoveFund = backResult.data.data.loveFund;
              if(userLovePoint == null || userLovePoint == ''){
                userLovePoint = 0;
              };
              if(userLoveFund == null || userLoveFund == ''){
                userLoveFund = 0;
              }
              _this.setData({
                lovePoint:userLovePoint,
                loveFund:userLoveFund,
              });
            }
          }
        });
      }
    })
    
  },
  gotoLogin(){
    wx.navigateTo({
      url:'../login/login',
    })
  },
  //个人中心的实名认证,点击跳转到实名认证
  common_sign() {
    wx.navigateTo({
      url: '../common_sign/common_sign',
    })
  },
  //个人中心的我的余额,点击跳转到我的余额
  donations() {
    wx.navigateTo({
      url: '../my_donations/my_donations',
    })
  },
  //跳转到我的公益活动页面
  activities(){
    wx.navigateTo({
      url:'../my_activities/my_activities'
    })
  },
  //跳转到账户信息页面
  accountInfo(){
    wx.navigateTo({
      url:'../account/account'
    })
  },
  //个人中心的意见反馈,点击跳转到意见反馈
  view() {
    wx.navigateTo({
      url: '../feedback/feedback',
    })
  }
})