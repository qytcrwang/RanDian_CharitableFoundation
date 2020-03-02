Page({
  changeRealNameSubmit:function(e){
    var _this = this;
    var newRealName = e.detail.value.realName;
    //获取userid
    wx.getStorage({
      key:'userid',
      success:function(res){
        //发送更新请求
        wx.request({
          url:'http://localhost:8081/wx/user/updateUserInfo',
          data:{
            userId:res.data,
            name:newRealName,
          },
          method:'POST',
          dataType:'json',
          success:function(backResult){
            if(backResult.data.status == 1){
              //更新成功
              _this.setData({
                realName:newRealName
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
    realName:''
  },
  onLoad:function(options){
    this.setData({
      realName:options.realName
    });
  },
  //文本框失去焦点时获取文本框的输入值
  bindRealNameInput:function(e){
    this.setData({
      realName:e.detail.value
    })
  },
  updateRealName(){
    console.log("用户输入的真实姓名：" + this.data.realName);
    if(this.data.realName != null && this.data.realName != ''){
      wx.request({
        url:'http://localhost:8081/updateUserInfo',
        data:{
          id:'1',
          name:this.data.realName
        },
        method:'post',
        success(res){
          wx.showToast({
            title:'更新成功',
            icon:'success',
            duration:2000
          });
          wx.navigateBack({
            delta:1
          }) 
        }
      });
    }else{
      wx.showToast({
        title:'请输入您的真实姓名',
        icon:'none',
        duration:2000
      })  
    }
  }
})