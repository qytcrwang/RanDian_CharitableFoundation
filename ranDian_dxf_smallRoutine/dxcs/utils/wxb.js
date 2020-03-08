//调用接口请求全部用POST
//api : 接口地址 /wx之后的部分
//params : 参数
//callback : 回调函数
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
            if(backResult.status == 1){
              wx.setStorage({
                key:'userid',
                data:backResult.data.id 
              })
              //设置全局登录状态为true
              app.globalData.isLogin = true;
            }
          })
        }
      }
    })
}
    
module.exports = {
    wxPost:wxPost,
    wxLogin:wxLogin,
}