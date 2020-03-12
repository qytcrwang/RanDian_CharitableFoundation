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

module.exports = {
  formatTime: formatTime,
  dateFormat: dateFormat,
  getCurYear:getCurYear,
  getCurMonth:getCurMonth
}
