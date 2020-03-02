Page({
  changeIdCardSubmit:function(e){
    var _this = this;
    var newIdCard = e.detail.value.idCard;
    //获取userid
    wx.getStorage({
      key:'userid',
      success:function(res){
        //发送更新请求
        wx.request({
          url:'http://localhost:8081/wx/user/updateUserInfo',
          data:{
            userId:res.data,
            idCardNumber:newIdCard,
          },
          method:'POST',
          dataType:'json',
          success:function(backResult){
            if(backResult.data.status == 1){
              //更新成功
              _this.setData({
                idCard:newIdCard
              });
              wx.showToast({
                title:backResult.data.msg,
                icon:'success',
                duration:2000
              });
              //跳转到我的信息页面
              
            }else{
              wx.showToast({
                title:backResult.data.msg,
                duration:2000
              })
            }
          }
        })
      } 
    })
  },
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
  },
})