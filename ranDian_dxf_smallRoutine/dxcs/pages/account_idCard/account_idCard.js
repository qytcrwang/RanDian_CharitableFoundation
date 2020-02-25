// pages/view/view.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    idCard:''
  },
  onLoad:function(options){
    this.setData({
      idCard:options.idCard
    });
  }
})