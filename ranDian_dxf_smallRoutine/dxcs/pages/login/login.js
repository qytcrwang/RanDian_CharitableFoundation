//获取应用实例
const app = getApp()
//加载全局方法
var wxUtils = require('../../utils/wxb.js');
const wxb = require('../../utils/wxb.js');
var log = require('../../utils/log.js');
Page({
    data: {
        //判断小程序的API，回调，参数，组件等是否在当前版本可用。
        canIUse: wx.canIUse('button.open-type.getUserInfo'),
    },
    onLoad: function() {
    },

    bindGetUserInfo: function(e) {
        if (e.detail.userInfo) {
            //用户按了允许授权按钮
            wx.getSetting({
                success: function(res) {
                    if (res.authSetting['scope.userInfo']) {
                        app.globalData.userInfo = e.detail.userInfo;
                        wxb.wxLogin();
                        wx.reLaunch({
                            url:'/pages/index/index'
                        });
                    } else {
                        console.log("未获取到用户信息");
                    }
                }
            });
        } else {
            //用户按了拒绝按钮
            wx.showModal({
                title: '警告',
                content: '拒绝授权，部分信息可能无法显示.',
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
