var constant = require('../../utils/constant.js');
var wxb = require('../../utils/wxb');
var wxUtils = require('../../utils/util.js');
Page({
    data: {
      items: [],
      hidden: false,
      mTitles : [],
      mSrcs : [],
      mTimes : [],
      mIds : [],
      mCurrentPage : 0
    },

    onLoad: function (options) {
        var _this = this;
        _this.requestData(_this, this.data.mCurrentPage + 1);
    },
    //上拉触底触发函数
    onReachBottom:function(){
        var _this = this;
        _this.requestData(_this,this.data.mCurrentPage + 1);
    },

    onItemClick: function (event) {
        var targetUrl = constant.PAGE_SPECIFIC;
        if (event.currentTarget.dataset.publishTime != null)
            targetUrl = targetUrl + "?publishTime=" + event.currentTarget.dataset.publishTime;
        wx.navigateTo({
            url: targetUrl
        });
    },
  /**
   * 请求数据
   * @param _this Page的对象，用其进行数据的更新
   * @param targetPage 请求的目标页码
   */
  requestData:function(_this, targetPage) {
    wxb.wxPost(
      '/activity/getList',
      {
        page: targetPage,
        size: constant.PAGE_ACTIVITIES_PAGESIZE,
      }, function (backResult) {
        if (backResult == null
          || backResult.status != 1
          || backResult.data == null
          || backResult.data.length <= 0) {
          console.log(constant.REQUEST_TIMEOUT);
          return;
        }
        var i = 0;
        for (; i < backResult.data.length; i++) {
          _this.bindData(backResult.data[i]);
        }
        //将数据写入list,用于给页面数据赋值
        var itemList = [];
        var titles = _this.data.mTitles;
        for (var i = 0; i < titles.length; i++) {
          itemList.push({
            title: titles[i],
            src: _this.data.mSrcs[i],
            time: _this.data.mTimes[i],
            id:_this.data.mIds[i]
          })
        }
        _this.setData({
          items: itemList,
          hidden: true,
          mCurrentPage: targetPage
        });
      }
    )
  },

/**
 * 绑定数据
 * @param itemData Gank的接口返回的content值，里面有各种相关的信息
 */
bindData:function(itemData) {
    var _this = this;
    _this.data.mTitles.push(itemData.title);
    _this.data.mTimes.push(wxUtils.dateFormat(itemData.activity_start_time));
    _this.data.mSrcs.push(itemData.cover_url);
    _this.data.mIds.push(itemData.id);
  }
    
});



