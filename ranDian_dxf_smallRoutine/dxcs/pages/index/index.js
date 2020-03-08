//index.js
//获取应用实例
var app = getApp();
var wxb = require("../../utils/wxb.js");
Page({
  data: {
    color: '',
    datas: [],
    // service_tel: "0551-12345678", 服务电话
    // complaint_tel: "0551-12345678" 投诉电话
    setting: [],
    //轮播图数据
    bannerList:[
      {imgSrc:'/img/activity1.png'},
      {imgSrc:'/img/activity2.png'},
      {imgSrc:'/img/activity3.png'}
    ],
    //推荐活动列表
    recommendActivityList:[
      {id:'1',imgSrc:'/img/activity1.png',title:'老年中心举办了此次活动'},
      {id:'2',imgSrc:'/img/activity2.png',title:'老年中心举办了此次活动'},
      {id:'3',imgSrc:'/img/activity3.png',title:'老年中心举办了此次活动'},
      {id:'4',imgSrc:'/img/activity1.png',title:'老年中心举办了此次活动'}
    ],
    list:[
      {id:'',imgSrc:'/img/activity1.png',title:'标题',content:'老年中心举办了此次活动'},
      {id:'',imgSrc:'/img/activity2.png',title:'标题',content:'老年中心举办了此次活动'},
      {id:'',imgSrc:'/img/activity3.png',title:'标题',content:'老年中心举办了此次活动'}
    ]
  },

  //获取首页轮播图
  /*getSwiperList(){
    let that = this;
    wx.request({
      url:"http://mock-api.com/VKyv1Gzw.mock/swiperList",
      success(res){
        if(res.data.code===0){
          that.setData({
            swiperList:res.data.data.swiperList,
          })
        }
      }
    })
  },*/

  onShow: function () {
  },

  onLoad: function () {
  },
})
