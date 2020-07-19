//调用接口请求全部用POST
//api : 接口地址 /wx之后的部分
//params : 参数
//callback : 回调函数
var log = require("../utils/log.js");
function wxPost(api, params, callback) {
  PostMain(api, params, callback);
}

//postMain 调用api接口主方法
function PostMain(api, params, callback) {
  var app = getApp();
  var apiurl =app.globalData.apiurl + api;
  wx.request({
    url: apiurl,
    data: params,
    method: 'POST',
    dataType: 'json',
    success: function (data) {
      console.log(data);
      switch (data.statusCode) {
        case 100:
          break;
        case 101:
          break;
        case 200:
          callback(data.data);
          break
        default:
          wx.showToast({
            image: '/img/kulian.png',
            title: data.data.msg,
          })
          break;
      }
    },
    fail: function (data) {
      wx.hideLoading();
      log.error(data);
      wx.showToast({
        title: '请求接口超时',
      })
    }
  })
}
//微信登录
function wxLogin(){
    var app = getApp();
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        if(res.code){
          wxPost('/login',{
            code:res.code
          },function(backResult){
            console.log(backResult)
            if(backResult.status == 1
                && backResult.data.id != null 
                && backResult.data.id != ''){
              wx.setStorage({
                key:'userid',
                data:backResult.data.id 
              })
              //设置全局登录状态为true
              app.globalData.isLogin = true;
            }
          })
        }
      },
      fail:res => {
        wx.showToast({
          title:'登陆失败',
          duration:2000,
          icon:'/img/close.png'
      })
      }
    })
}

function wxAutoImageCal(e) {
  console.log(e);
  var originalWidth = e.detail.width;
  var originalHeight = e.detail.height;
  var windowWidth = 0;
  var windowHeight = 0;
  var autoWidth = 0;
  var autoHeight = 0;
  var results = {};
  wx.getSystemInfo({
    success: function (res) {
      // success
      var winWidth = res.windowWidth;
      var winHeight = res.windowHeight;
      if (originalWidth > winWidth) {
        autoWidth = winWidth;
        autoHeight = (autoWidth * originalHeight) / originalWidth;
        results.imageWidth = autoWidth + 'px';
        results.imageHeight = autoHeight + 'px';
        console.log(results.imageHeight, results.imageWidth);
      }
      else {
        results.imageWidth = originalWidth + 'px';
        results.imageHeight = originalHeight + 'px';
        console.log(results.imageHeight, results.imageWidth);
      }
    }
  })
  return results;
}
module.exports = {
    wxPost:wxPost,
    wxLogin:wxLogin,
    wxAutoImageCal: wxAutoImageCal,
}