//获取应用实例
const app = getApp()

Page({
    data: {
        //判断小程序的API，回调，参数，组件等是否在当前版本可用。
        canIUse: wx.canIUse('button.open-type.getUserInfo'),
    },

    onLoad: function() {
        var that = this;
        // 查看是否授权
        wx.getSetting({
            success: function(res) {
                if (res.authSetting['scope.userInfo']) {
                    wx.getUserInfo({
                        success: function(res) {
                            // 用户已经授权过,不需要显示授权页面,所以不需要改变 isHide 的值
                            // 根据自己的需求有其他操作再补充
                            // 我这里实现的是在用户授权成功后，调用微信的 wx.login 接口，从而获取code
                            wx.login({
                                success: res => {
                                    // 获取到用户的 code 之后：res.code
                                    console.log("用户的code:" + res.code);
                                    if(res.code){
                                        wx.request({
                                            url:'http://localhost:8081/wx/login',
                                            data:{
                                                code:res.code
                                            },
                                            method:'POST',
                                            dataType:'json',
                                            success:function(res){
                                                //成功
                                                wx.showToast({
                                                    title:'登陆成功',
                                                    icon:'success',
                                                    duration:2000
                                                  })
                                                console.log(res);
                                            }
                                        })
                                    }
                                    // 可以传给后台，再经过解析获取用户的 openid
                                    // 或者可以直接使用微信的提供的接口直接获取 openid ，方法如下：
                                    // wx.request({
                                    //     // 自行补上自己的 APPID 和 SECRET
                                    //     url: 'https://api.weixin.qq.com/sns/jscode2session?appid=自己的APPID&secret=自己的SECRET&js_code=' + res.code + '&grant_type=authorization_code',
                                    //     success: res => {
                                    //         // 获取到用户的 openid
                                    //         console.log("用户的openid:" + res.data.openid);
                                    //     }
                                    // });
                                }
                            });
                        }
                    });
                } else {
                    
                }
            }
        });
    },

    bindGetUserInfo: function(e) {
        if (e.detail.userInfo) {
            //用户按了允许授权按钮
            wx.getSetting({
                success: function(res) {
                    if (res.authSetting['scope.userInfo']) {
                        wx.login({
                            success: res => {
                                // 获取到用户的 code 之后：res.code
                                console.log("用户的code:" + res.code);
                                if(res.code){
                                    wx.request({
                                        url:'http://localhost:8081/wx/login',
                                        data:{
                                            code:res.code
                                        },
                                        method:'POST',
                                        dataType:'json',
                                        success:function(res){
                                            if(res.data.status == 1){
                                                //储存用户id信息
                                                wx.setStorage({
                                                    key:'userid',
                                                    data:res.data.data.id
                                                });
                                                //成功
                                                wx.showToast({
                                                    title:res.data.msg,
                                                    icon:'success',
                                                    duration:2000
                                                });
                                                wx.reLaunch({
                                                    url:'/pages/index/index'
                                                })
                                            }else{
                                                wx.showToast({
                                                    title:res.data.msg,
                                                    icon:'none',
                                                    duration:2000
                                                });
                                            }
                                            
                                        }
                                    })
                                }
                            }
                        });
                    } else {
                        
                    }
                }
            });
        } else {
            //用户按了拒绝按钮
            wx.showModal({
                title: '警告',
                content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
                showCancel: false,
                confirmText: '返回授权',
                success: function(res) {
                    // 用户没有授权成功，不需要改变 isHide 的值
                    if (res.confirm) {
                        console.log('用户点击了“返回授权”');
                    }
                }
            });
        }
    }
})
