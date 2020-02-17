// pages/mine/mine.js
Page({
  data: {
    canIUse:wx.canIUse('button.open-type.getUserInfo')
  },
  //个人中心的消息,点击跳转到我的消息
  onLoad:function(){
    wx.getSetting({
      success(res){
        if(res.authSetting['scope.userInfo']){
          wx.getUserInfo({
            success:function(res){
              console.log("123");
              console.log(res.userInfo);
            }
          })
        }else{
          console.log("未授权");
          wx.navigateTo({
            url:'page/index/index'
          })
        }
      }
    })
  },
  bindGetUserInfo(e){
    console.log(e.detail.userInfo)
  },
  info(){
    wx.navigateTo({
      url: '../info/info',
    })
  },
  //个人中心的实名认证,点击跳转到实名认证
  realName() {
    wx.navigateTo({
      url: '../realName/realName',
    })
  },
  //个人中心的我的余额,点击跳转到我的余额
  restMoney() {
    wx.navigateTo({
      url: '../restMoney/restMoney',
    })
  },
  //个人中心的意见反馈,点击跳转到意见反馈
  view() {
    wx.navigateTo({
      url: '../view/view',
    })
  },
  //我的地址
  addr(){
    wx.navigateTo({
      url: '../myAddr/myAddr',
    })
  },
  //退出登录
  signOut(){
    wx.navigateTo({
      url: '../logs/log',
    })
  }
})