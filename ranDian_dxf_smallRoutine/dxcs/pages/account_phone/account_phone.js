// pages/view/view.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    phone:''
  },
  onLoad:function(options){
    this.setData({
      phone:options.phone
    });
  }
})