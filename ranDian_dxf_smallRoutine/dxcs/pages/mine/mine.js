// pages/mine/mine.js
Page({
  data: {
    isLogin:false
  },
  //页面加载时查看用户是否授权，未授权用户不显示部分信息。
  onLoad:function(){
    var _this = this;
    //查看是否已经登陆
    wx.checkSession({
      success:function(res){
        console.log(res,"登陆未过期");
        _this.setData({
          isLogin:true
        })
      },
      fail:function(res){
        console.log(res,"登陆过期了")
      }
    })
    //查看是否授权
    /*wx.getSetting({
      success(res){
        if(res.authSetting['scope.userInfo']){
          
          wx.getUserInfo({
            //用户已经授权，不需要再显示授权页面，所以不需要改变isHide的值
            success:function(res){
              //调用微信的登陆接口
            }
          })
          wx.switchTab({
            url:'page/index/index'
          })
        }else{
          //用户没有授权
          that.setData({
            isHide:true
          })
          console.log(that.isHide)
        }
      }
    })*/
  },
  gotoLogin(){
    wx.navigateTo({
      url:'../login/login',
    })
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