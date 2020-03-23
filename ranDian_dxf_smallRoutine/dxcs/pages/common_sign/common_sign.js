var wxb = require("../../utils/wxb.js");
var constant = require("../../utils/constant.js");
var wxUtils = require("../../utils/util.js")
Page({
    /** 
     * 页面的初始数据
     */
    data: {
        sysW: null,
        lastDay: null,
        firstDay: null,
        year: null,
        hasEmptyGrid: false,
        cur_year: '',
        cur_month: '',
        firstDay: null,
        getDate:null,
        month:null,
        display:"none",
        curMonthTotal:'',
        consecutive:'',
        userId:'',
        //当日是否已经签到,默认false未签到
        isTodaySigned:false,
        week:[
            {
                wook: "一"
            }, {
                wook: "二"
            }, {
                wook: "三"
            }, {
                wook: "四"
            }, {
                wook: "五"
            }, {
                wook: "六"
            }, {
                wook: "日"
            },
        ],
        day:[
        ],
        days:[
        ]
    },
    //计算本周的日期
    getProWeekList:function(){
         let _this=this
         let date=new Date()
         let dateTime = date.getTime(); // 获取现在的时间
         let dateDay = date.getDay()==0?7:date.getDay();// 获取现在的
         let oneDayTime = 24 * 60 * 60 * 1000; //一天的时间
         let proWeekList;
         let weekday;
         for (let i = 0; i < 7; i++) {
            let time = dateTime - (dateDay - 1 - i) * oneDayTime;
            proWeekList = new Date(time).getDate(); //date格式转换为yyyy-mm-dd格式的字符串
            weekday = "day[" + i + "].wook"
            _this.setData({
                [weekday]: proWeekList,
            })
            //that.data.day[i].wook = new Date(time).getDate();
        }

    },
    dateSelectAction: function (e) {
        let cur_day = e.currentTarget.dataset.idx;
        this.setData({
            todayIndex: cur_day
        })
    },

    setNowDate: function () {
        const date = new Date();
        const cur_year = date.getFullYear();
        const cur_month = date.getMonth() + 1;
        const todayIndex = date.getDate();
        const weeks_ch = ['日', '一', '二', '三', '四', '五', '六'];
        this.calculateEmptyGrids(cur_year, cur_month);
        this.calculateDays(cur_year, cur_month);
        this.setData({
            cur_year: cur_year,
            cur_month: cur_month,
            weeks_ch,
            todayIndex,
        })
    },

    getThisMonthDays(year, month) {
        return new Date(year, month, 0).getDate();
    },
    getFirstDayOfWeek(year, month) {
        return new Date(Date.UTC(year, month - 1, 1)).getDay();
    },
    calculateEmptyGrids(year, month) {
        const firstDayOfWeek = this.getFirstDayOfWeek(year, month);
        let empytGrids = [];
        if (firstDayOfWeek > 0) {
            for (let i = 0; i < firstDayOfWeek; i++) {
                empytGrids.push(i);
            }
            this.setData({
                hasEmptyGrid: true,
                empytGrids
            });
        } else {
            this.setData({
                hasEmptyGrid: false,
                empytGrids: []
            });
        }
    },
    calculateDays(year, month) {
        let days = [];
        let weekday;
        const thisMonthDays = this.getThisMonthDays(year, month);

        for (let i = 1; i <= thisMonthDays; i++) {
            // days[i].push(i);
            weekday = "days[" + (i - 1) + "].item"
           this.setData({
               [weekday]:i,
               src:''
           })
        }
    },
    handleCalendar(e) {
        const handle = e.currentTarget.dataset.handle;
        const cur_year = this.data.cur_year;
        const cur_month = this.data.cur_month;
　　

          this.setData({
             days:[]
          })


        if (handle === 'prev') {
            let newMonth = cur_month - 1;
            let newYear = cur_year;
            if (newMonth < 1) {
                newYear = cur_year - 1;
                newMonth = 12;
            }

            this.calculateDays(newYear, newMonth);
            this.calculateEmptyGrids(newYear, newMonth);

            let firstDay = new Date(newYear, newMonth - 1, 1);
            this.data.firstDay = firstDay.getDay();
            this.setData({
                cur_year: newYear,
                cur_month: newMonth,
                marLet: this.data.firstDay
            })
            if (this.data.month == newMonth) {
                this.setData({
                    judge: 1
                })
            } else {
                this.setData({
                    judge: 0
                })
            }
        } else {
            let newMonth = cur_month + 1;
            let newYear = cur_year;
            if (newMonth > 12) {
                newYear = cur_year + 1;
                newMonth = 1;
            }

            this.calculateDays(newYear, newMonth);
            this.calculateEmptyGrids(newYear, newMonth);
            let firstDay = new Date(newYear, newMonth - 1, 1);
            this.data.firstDay = firstDay.getDay();
            this.setData({
                cur_year: newYear,
                cur_month: newMonth,
                marLet: this.data.firstDay
            })
            if (this.data.month == newMonth){
                this.setData({
                    judge:1
                })
            }else{
                this.setData({
                    judge: 0
                })
            }
        }
    },
    dataTime: function () {
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth();
        var months = date.getMonth() + 1;

        //获取现今年份
        this.data.year = year;

        //获取现今月份
        this.data.month = months;

        //获取今日日期
        this.data.getDate = date.getDate();

        //最后一天是几号
        var d = new Date(year, months, 0);
        this.data.lastDay = d.getDate();

        //第一天星期几
        let firstDay = new Date(year, month, 1);
        this.data.firstDay = firstDay.getDay();
    },
    onshow:function(){
        this.setData({
            display:"block",
        })
    },
    onhide:function(){
        this.setData({
            display: "none",
        })
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that = this;

        this.dataTime();
        var res = wx.getSystemInfoSync();
        this.setData({
            sysW: res.windowWidth /8-3,//更具屏幕宽度变化自动设置宽度
            marLet: this.data.firstDay,
            getDate: this.data.getDate,
            judge:1,
            month: this.data.month,
        });
    },
    //滑动切换
    swiperTab: function (e) {
        var that = this;
        that.setData({
            currentTab: e.detail.current
        });
    },
    //点击切换
    clickTab: function (e) {
        var that = this;
        if (this.data.currentTab === e.target.dataset.current) {
            return false;
        } else {
            that.setData({
                currentTab: e.target.dataset.current,

            })
        }
    },
    upper: function (e) {
        console.log(e)
    },
    lower: function (e) {
        console.log(e)
    },
    scroll: function (e) {
        console.log(e)
    },
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
        var _this = this;
        //初始化当前日期
        this.setNowDate();
        //初始化当前周日期
        this.getProWeekList();
        //初始化全月签到数据
        this.calculateDays();
        
        //加载签到数据
        wx.getStorage({
            key:'userid',
            success:function(res){
                _this.setData({
                    userId:res.data
                })
                wxb.wxPost(
                    "/user/getSignDaysList",
                    {
                        userId:res.data
                    },function(backResult){
                        if(backResult == null ||
                            backResult.data == null ||
                            backResult.data.length <= 0 ||
                            backResult.status != 1){
                            wx.showToast({
                                title:constant.REQUEST_TIMEOUT,
                                icon:'/img/close.png',
                                duration:2000
                            })
                            return;
                        }
                        var itemDayList = [];
                        var firstDayOfWeek = _this.data.day[0].wook;
                        for(var i = firstDayOfWeek-1; i < firstDayOfWeek+6;i++){
                            bindDay(itemDayList,backResult.data[i],i+1);
                        }
                        _this.setData({
                            day:itemDayList,
                        });
                        
                        var itemMonthDayList = [];
                        var firstDayOfMonth = _this.data.days[0].item;
                        for(var i = firstDayOfMonth-1; i < backResult.data.length; i++){
                            bindMonthDay(itemMonthDayList,backResult.data[i],i+1);
                        }
                        _this.setData({
                            days:itemMonthDayList
                        })
                    }
                );
                wxb.wxPost(
                    "/user/getConsecutiveSign",
                    {
                        userId:res.data
                    },function(backResult){
                        if(backResult == null ||
                            backResult.data == null ||
                            backResult.data.length <= 0 ||
                            backResult.status != 1){
                            return;
                        }
                        _this.setData({
                            consecutive:backResult.data.consecutive,
                            curMonthTotal:backResult.data.signSum,
                        }) 
                    }
                );
                wxb.wxPost(
                    "/user/isTodaySigned",
                    {
                        userId:res.data
                    },function(backResult){
                        if(backResult == null ||
                            backResult.data == null ||
                            backResult.data.length <= 0 ||
                            backResult.status != 1){
                            return;
                        }
                        _this.setData({
                            isTodaySigned:backResult.data
                        })
                    }
                )
            }
        })
        
    },
    bindSign:function(){
        var _this = this;
        wxb.wxPost(
            "/user/userSingIn",
            {
                userId:this.data.userId
            },function(backResult){
                if(backResult == null ||
                    backResult.data == null ||
                    backResult.data.length <= 0 ||
                    backResult.status != 1){
                    wx.showToast({
                        title:constant.REQUEST_TIMEOUT,
                        duration:2000,
                        icon:'/img/close.png'
                    })
                    return;
                }
                _this.setData({
                    isTodaySigned:true
                })
            }
        )
    }
});
function bindDay(itemDayList,itemDay,date){
    if(itemDay == "0"){
        itemDayList.push({
            wook:date,
        })
    }else{
        itemDayList.push({
            wook:date,
            src:'/img/signed.png'
        })
    }
}
function bindMonthDay(itemMonthDayList,itemDay,date){
    if(itemDay == "0"){
        itemMonthDayList.push({
            item:date,
        })
    }else{
        itemMonthDayList.push({
            item:date,
            src:'/img/signed.png'
        })
    }
}