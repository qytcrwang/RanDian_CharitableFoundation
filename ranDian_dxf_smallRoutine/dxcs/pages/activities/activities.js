var constant = require('../../utils/constant.js');
var wxb = require('../../utils/wxb');
var wxUtils = require('../../utils/util.js');
Page({
    data: {
        items: [],
        hidden: false
    },

    onLoad: function (options) {
        var _this = this;
        requestData(_this, mCurrentPage + 1);
    },

    //上拉触底触发函数
    onReachBottom:function(){
        var _this = this;
        requestData(_this,mCurrentPage + 1);
    },

    onItemClick: function (event) {
        var targetUrl = constant.PAGE_SPECIFIC;
        if (event.currentTarget.dataset.publishTime != null)
            targetUrl = targetUrl + "?publishTime=" + event.currentTarget.dataset.publishTime;
        wx.navigateTo({
            url: targetUrl
        });
    },

    
});
var mTitles = [];
var mSrcs = [];
var mTimes = [];
var mCurrentPage = 0;
var mId = [];

/**
 * 请求数据
 * @param _this Page的对象，用其进行数据的更新
 * @param targetPage 请求的目标页码
 */
function requestData(_this, targetPage) {
    wxb.wxPost(
        '/activity/getList',
        {
            page:targetPage,
            size:constant.PAGE_ACTIVITIES_PAGESIZE,
        },function(backResult){
            if(backResult == null
                || backResult.status != 1
                || backResult.data == null
                || backResult.data.length <= 0){
                console.log(constant.REQUEST_TIMEOUT);
                return;
            }
            var i = 0;
            for(; i < backResult.data.length; i++){
                bindData(backResult.data[i]);
            }
            //将数据写入list,用于给页面数据赋值
            var itemList = [];
            for(var i = 0; i < mTitles.length; i++){
                itemList.push({
                    title:mTitles[i],
                    src:mSrcs[i],
                    time:mTimes[i],
                    id:mId[i]
                })
            }
            _this.setData({
                items: itemList,
                hidden: true
            });

            mCurrentPage = targetPage;
        }
    )
}

/**
 * 绑定数据
 * @param itemData Gank的接口返回的content值，里面有各种相关的信息
 */
function bindData(itemData) {

    mTitles.push(itemData.title);
    mTimes.push(wxUtils.dateFormat(itemData.activity_start_time));
    mSrcs.push(itemData.cover_url);
    mId.push(itemData.id);
}
