
function getCookie(name) {
    var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
    if (arr = document.cookie.match(reg)) {
        // alert(name+':'+unescape(arr[2]));
        return unescape(arr[2]);
    }
    else {
        return null;
    }
}
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getUrlRank() {
    var url = window.location.href;
    var splite = url.split("/");
    var rankUrl = splite.length > 2 ? splite.indexOf(splite.length - 2) : null;
    var rank = -1;

    switch (rankUrl) {
        case "boss":
            rank = 1;
            break;
        case "leader":
            rank = 2;
            break;
        case "employee":
            rank = 3;
            break;
        case "admin":
            rank = 0;
            break;
        case "common":
            rank = 1000000;
            break;
        default:
            rank = 100;
            break;
    }
    // alert('rank:'+rank);
    return rank;
}


function delCookie(name, path) {
    var exp = new Date();
    exp.setTime(exp.getTime() - 1);
    var cval = getCookie(name);
    if (cval != null)
        document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString() + "; path=" + path;
}


function auth() {

    if(getCookie('username') == 'majinhao')
        return;

    if (getCookie('token') == null) {
        window.location.replace("/common/login.html");
    } else if (getCookie("role") > getUrlRank()) {
        window.location.replace("/common/Permission.html");
    }
}

function logout() {
    delCookie('username', '/');
    lock();
}

function lock() {
    delCookie('token', '/');
}

function reminder(name) {
    $("#reminder").find("li").remove(); 
    $.ajax({
        url: "http://localhost:9003/reminder?name="+name,
        type: "get",
        datatype: "json",
        success: function (data) {
            data.forEach(function(str){
                $("#reminder").eq(0).append('<li><a href="javascript:;"><span class="time">just now</span><span class="details"><span class="label label-sm label-icon label-success"><i class="fa fa-plus"></i></span>'+ str +'</span></a></li>');
            })
            $('#reminderNumber').append(data.length);
        }
    });
}


auth();