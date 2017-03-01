var dataSource="http://localhost:9002/unfinished/user"

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function dateMinus(dd,dadd){ //foreign code
	var a = new Date(dd);
	a = a.valueOf();
	a = a - dadd * 24 * 60 * 60 * 1000;
	a = new Date(a);
	//alert(a.getFullYear() + "年" + (a.getMonth() + 1) + "月" + a.getDate() + "日");
	return a;
}

function mktable() {
	var currentUser = $.cookie('username');
	$.getJSON(dataSource,{name:currentUser},function(data){
		//表头表体字符串的创建
		var today = new Date();
		var thead = "<tr>";
		var tbody = "<tr>"
		for(var i=0;i<14;i++) {
			thisdate = dateMinus(today,i);
			//加表头
			thead += "<td>";
			thead += thisdate.Format("MM/dd");
			thead += "</td>";
			//同步加表体
			thisbody = "<td class='incompleted'>未完成</td>";
			if(thisdate.getDay()==0||thisdate.getDay()==6){
					thisbody = "<td class='weekend'>休息日</td>";
			}
			data.forEach(function(d){
				var currdate = new Date(d);
				//已完成优先休息日显示
				if(thisdate.Format("MM/dd")==currdate.Format("MM/dd")){
					thisbody = "<td class='completed'>已完成</td>";
				} 
			});
			tbody += thisbody;
		}
		thead += "</tr>";
		tbody += "</tr>"
		$(".footstep_table thead").empty();
		$(".footstep_table thead").append(thead);
		$(".footstep_table tbody").empty();
		$(".footstep_table tbody").append(tbody);
	});
	
	
	
}

$(document).ready(function(){
	mktable();
});
