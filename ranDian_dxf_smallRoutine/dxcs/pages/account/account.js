// pages/view/view.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userTypeArray:['普通','儿童','大学生','企业'],
    userTypeIndex:'',
    realName:'',
    idCard:'',
    phone:'',
    userid:''   
  },
  onLoad(){
    //获取储存区的userid
    var that = this;
    wx.getStorage({
      key:'userid',
      success:function(res){
        //将userid缓存到本页面
        that.setData({
          userid:res.data
        })
        //根据userid加载用户账户数据
        wx.request({
          url:'http://localhost:8081/wx/user/getUserInfo',
          data:{
            userId:res.data,
          },
          method:'POST',
          dataType:'json',
          success:function(backResult){
            if(backResult.data.status == 1){
              //获取用户信息成功
              var userInfo = backResult.data.data;
              that.setData({
                realName:userInfo.name,
                idCard:userInfo.idCardNumber,
                phone:userInfo.mobile,
                userTypeIndex:userInfo.type
              });
            }else{
              console.log("获取用户数据失败")
            }
          }
        })
      }
    })
   
    console.log('页面加载了')

  },
  gotoRealName(){
    wx.navigateTo({
      url:'../account_name/account_name?realName=高俊'
    })
  },
  gotoIdCard(){
    wx.navigateTo({
      url:'../account_idCard/account_idCard?idCard=1234567'
    })
  },
  gotoPhone(){
    wx.navigateTo({
      url:'../account_phone/account_phone?phone=17621378282'
    })
  },
  gotoSignature(){
    wx.navigateTo({
      url:'../account_signature/account_signature?signature=高俊'
    })
  },
  bindUserTypePickerChange(e){
    this.setData({
      userTypeIndex:e.detail.value
    })
    //更新用户信息

  }
})