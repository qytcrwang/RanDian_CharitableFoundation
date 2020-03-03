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
  onShow(){
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
  },
  gotoRealName(){
    var realName = this.data.realName;
    if(realName == null){
      realName = '';
    }
    wx.navigateTo({
      url:'../account_name/account_name?realName='+realName
    })
  },
  gotoIdCard(){
    var idCard = this.data.idCard;
    if(idCard == null){
      idCard = '';
    }
    wx.navigateTo({
      url:'../account_idCard/account_idCard?idCard='+idCard
    })
  },
  gotoPhone(){
    var phone = this.data.phone;
    if(phone == null){
      phone = '';
    }
    wx.navigateTo({
      url:'../account_phone/account_phone?phone='+phone
    })
  },
  //修改用户类型
  bindUserTypePickerChange(e){
    var newUserType = e.detail.value;
    var _this = this;
    this.setData({
      userTypeIndex:newUserType
    })
    //获取userid
    wx.getStorage({
      key:'userid',
      success:function(res){
        //发送更新请求
        wx.request({
          url:'http://localhost:8081/wx/user/updateUserInfo',
          data:{
            userId:res.data,
            userType:newUserType,
          },
          method:'POST',
          dataType:'json',
          success:function(backResult){
            if(backResult.data.status == 1){
              //更新成功
              _this.setData({
                userType:newUserType
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
  }
})