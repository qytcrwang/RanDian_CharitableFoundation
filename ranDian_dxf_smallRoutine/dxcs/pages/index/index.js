var wxb = require('../../utils/wxb.js');
var constant = require('../../utils/constant.js');
var app = getApp();

Page({
    data: {
        swiperArrays: [
            {
                "imgUrl":'/img/activity1.png',
                "src":'www.baidu.com'
            },
            {
                "imgUrl":'/img/activity2.png',
                "src":'www.baidu.com'},
            {
                "imgUrl":'/img/activity2.png',
                "src":'www.baidu.com'
            },
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
                "iconText": '儿童基金',
                "navigateUrl": constant.PAGE_KIDS
            },
            {
                "iconUrl": '/img/icon_sfund.png',
                "iconText": '大学生计划',
                "navigateUrl": constant.PAGE_UNIVERSITIES
            },
        ],
        itemArray: [
        ]
    },
    onLoad:function(){
        var _this = this;
        //加载轮播图
        wxb.wxPost(
            "/img/getImgList",
            {},function(backResult){
                console.log("backResult"+backResult)
                if(backResult == null ||
                    backResult.status != 1){
                        wx.showToast({
                            icon:'/img/close.png',
                            title:constant.REQUEST_TIMEOUT,
                            duration:2000
                        })
                        return;
                }
                _this.setData({
                    imgUrls:backResult.data
                })
            }
        )
        //加载近期公益活动列表
        
        wxb.wxPost(
            "/activity/getList",
            {
                page:1,
                size:3,
            },function(backResult){
                if(backResult == null ||
                    backResult.status != 1){
                        wx.showToast({
                            icon:'/img/close.png',
                            title:constant.REQUEST_TIMEOUT,
                            duration:2000
                        });
                        return;
                }
                var itemList = [];
                for(var i = 0; i < backResult.data.length; i++){
                    bindData(itemList,backResult.data[i]);
                }
                _this.setData({
                    itemArray:itemList
                })
            }
        )
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
    },
    onSwiperClick:function(e){
        wx.navigateTo({
            url:'../web/web'
        })
    },
    //右上角分享
    onShareAppMessage:function(res){
        var _this = this;
    
        return{
            title:'滴信慈善基金会',
            path:'pages/index/index',
            success:function(res){
                console.log(res);
            },
            fail:function(res){
                console.log(res);
            }
        }
    }
})
function bindData(itemList,itemData){
    itemList.push({
        itemText:itemData.title.length>15?itemData.title.substring(0,15)+"...":itemData.title,
        itemUrl:itemData.cover_url,
        itemId:itemData.id
    })

}