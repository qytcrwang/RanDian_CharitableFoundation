// pages/view/view.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    realName:''
  },
  onLoad:function(options){
    this.setData({
      realName:options.realName
    });
  }
})