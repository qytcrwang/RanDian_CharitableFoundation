var wxb = require('../../utils/wxb.js');
var constant = require('../../utils/constant.js')
var app = getApp();

Page({
    data: {
        imgUrls: [
            '/img/activity1.png',
            '/img/activity2.png',
            '/img/activity2.png'
        ],
        indicatorDots: true,
        vertical: false,
        autoplay: true,
        interval: 3000,
        duration: 1200,
        iconArray: [
            {
                "iconUrl": '/img/icon_activity.png',
                "iconText": '活动',
                "navigateUrl": constant.PAGE_ACTIVITIES
            },
            {
                "iconUrl": '/img/icon_donation.png',
                "iconText": '募捐',
                "navigateUrl": constant.PAGE_DONATION
            },
            {
                "iconUrl": '/img/icon_kfund.png',
                "iconText": '儿童基金'
            },
            {
                "iconUrl": '/img/icon_sfund.png',
                "iconText": '大学生计划'
            },
        ],
        itemArray: [
            {
                "itemUrl": '/img/activity1.png',
                "itemText": '11月20日话剧《风声》'
            },
            {
                "itemUrl": '/img/activity2.png',
                "itemText": '11月20日话剧《原野》'
            },
            {
                "itemUrl": '/img/activity3.png',
                "itemText": '11月28日“夜店”演唱会'
            },
        ]
    },
    cusImageLoad: function(e){
        var that = this;
        that.setData(wxb.wxAutoImageCal(e));
    },
    onIconClick:function(e){
        console.log(e.currentTarget);
        wx.navigateTo({
            url:e.currentTarget.id
        })
    }
})