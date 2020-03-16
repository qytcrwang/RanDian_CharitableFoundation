const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

var dateFormat = function(timestamp,format){
  //默认格式yyyy-MM-dd hh:mm:ss
  if(!format){
    format = "yyyy-MM-dd hh:mm:ss";
  }
  function timeFormat(num){
    return num<10? '0'+num:num;
  }
  //因为后台拿到的时间戳是精确到秒数的，这里需要精确到毫秒数
  var timestamp = parseInt(timestamp)*1000;
  var time = new Date(timestamp);
  //年
  var year = time.getFullYear();
  //月
  var month = timeFormat((time.getMonth()+1));
  //日
  var date = timeFormat(time.getDate());
  //小时
  var hour = timeFormat(time.getHours());
  //分钟
  var minute = timeFormat(time.getMinutes());
  //秒数
  var second = timeFormat(time.getSeconds());

  if(format == "yyyy-MM-dd hh:mm:ss"){
    return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
  }else if(format == "yyyy-MM-dd"){
    return year+"-"+month+"-"+date;
  }
}

//获取当前的年
var getCurYear = function(){
  var curDate = new Date();
  return curDate.getFullYear();
}

//获取当前的月份
var getCurMonth = function(){
  var curDate = new Date();
  return curDate.getMonth()+1;
}

//将时间转换成时间差
function getDateDiff(dateTime) {
  let dateTimeStamp = new Date(dateTime).getTime();
  let result = '';
  let minute = 1000 * 60;
  let hour = minute * 60;
  let day = hour * 24;
  let halfamonth = day * 15;
  let month = day * 30;
  let year = day * 365;
  let now = new Date().getTime();
  let diffValue = now - dateTimeStamp;
  if (diffValue < 0) {
    return;
  }
  let monthEnd = diffValue / month;
  let weekEnd = diffValue / (7 * day);
  let dayEnd = diffValue / day;
  let hourEnd = diffValue / hour;
  let minEnd = diffValue / minute;
  let yearEnd = diffValue / year;
  if (yearEnd >= 1) {
    result = dateTime;
  } else if (monthEnd >= 1) {
    result = "" + parseInt(monthEnd) + "月前";
  } else if (weekC >= 1) {
    result = "" + parseInt(weekEnd) + "周前";
  } else if (dayC >= 1) {
    result = "" + parseInt(dayEnd) + "天前";
  } else if (hourC >= 1) {
    result = "" + parseInt(hourEnd) + "小时前";
  } else if (minC >= 1) {
    result = "" + parseInt(minEnd) + "分钟前";
  } else {
    result = "刚刚";
  }
  return result;
};

module.exports = {
  formatTime: formatTime,
  dateFormat: dateFormat,
  getCurYear:getCurYear,
  getCurMonth:getCurMonth
}
