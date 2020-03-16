
// 获取全局应用程序实例对象
const app = getApp();
var wxb = require("../../utils/wxb");
// 创建页面实例对象
Page({
  data: {
    trendsTap:true,
    newsTap:false,

    //动态列表数组
    trendsList:[
      {id:'',title:'',time:'',state:'',ifRead:''}
    ],
    //消息列表数组
    newsList:[{
      id:'1',title:'恭喜您注册成功',time:'2020-03-09',state:'',ifRead:''}
    ],
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad () {
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady () {
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow () {
    var _this = this;
    wx.getStorage({
      key:'userid',
      success:function(res){
        wxb.wxPost(
          '/notice/getNoticesWithOutContext',
          {
            msgType:'0'
          },function(backResult){
            console.log(backResult)
            if(backResult.status == 1){
              var _trendsList = [];
              for(var i = 0; i < backResult.data.length; i++){
                bindTrendsData(_trendsList,backResult.data[i]);
              }
              _this.setData({
                trendsList:_trendsList
              })
            }else{
              wx.showToast({
                image:'/img/close.png',
                title:'请求超时',
                duration:2000
              })
            }
          }
        )
      },
      fail:function(res){
        wx.showToast({
          image:'/img/close.png',
          title:'未获取到用户数据',
          duration:2000
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh () {
    
  },


  //以下为自定义点击事件
  //切换到动态列表页
  togoTrendsTap(){
    this.setData({
      trendsTap:true,
      newsTap:false,
    })
  },
  //切换到消息列表页
  togoNewsTap(){
    this.setData({
      trendsTap:false,
      newsTap:true,
    })
  }
})
function bindTrendsData(_trendsList,trendsObj){
  _trendsList.push({
    id:trendsObj.id,
    title:trendsObj.title.length>6? trendsObj.title.substring(0,5):trendsObj.title,
    time:trendsObj.time,
    state:trendsObj.state,
    ifRead:trendsObj.ifRead
  })
}

