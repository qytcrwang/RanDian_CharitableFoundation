//app.js
var wxb = require("/utils/wxb.js");
App({
  onLaunch: function () {
    wx.getSetting({
      success:res =>{
        if(res.authSetting['scope.userInfo']){
          //用户已经授权了获取昵称
          wxb.wxLogin();
        }else{
          wx.navigateTo({
            url:'/pages/login/login'
          })
        }
      }
    })
    // 展示本地存储能力
    //var logs = wx.getStorageSync('logs') || []
    //logs.unshift(Date.now())
    //wx.setStorageSync('logs', logs)

    // 获取用户信息
    /*wx.getSetting({
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
            }
          })
        }else{
          //用户未授权-跳转到授权页面
          wx.navigateTo({
            url:'/pages/login/login'
          })
        }
      }
    })*/
    
  },
  globalData:{
    //apiurl
    apiurl:'https://www.dixincs.com/wx',
    //apiurl:'https://localhost:443/wx',
    //登录状态
    isLogin:false,
    userInfo:null
  },
})