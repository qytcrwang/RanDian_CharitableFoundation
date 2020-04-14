//app.js
var wxb = require("/utils/wxb.js");
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    //检查登录状态
    var _this = this;
    wx.checkSession({
      success:function(res){
        _this.globalData.isLogin = true;
      },
      fail:function(res){
        wxb.wxLogin();
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }else{
          //用户未授权-跳转到授权页面
          wx.navigateTo({
            url:'/pages/login/login'
          })
        }
      }
    })
  },
  globalData:{
    //apiurl
    apiurl:'http://localhost:8081/wx',
    //登录状态
    isLogin:false,
    userInfo:null
  },
})