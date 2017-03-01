
        function getCookie(name)
        {
            var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)"); 
            if(arr=document.cookie.match(reg)){
                return unescape(arr[2]);
            }
            else{
                return null;
            }
        }

        function getUrlRank() {
            var url = window.location.href;
            var splite = url.split("/");
            var rankUrl = splite.length>2?splite.indexOf(splite.length-2):null;
            var rank = -1;

            switch (rankUrl) {
                case "boss" :
                    rank = 1;
                    break;
                case "leader" :
                    rank = 2;
                    break;
                case "employee" :
                    rank = 3;
                    break;
                case "admin" :
                    rank = 0;
                    break;
                case "common" :
                    rank = 1000000;
                    break;
            }
            return rank;
        }


        function auth() {
            if(getCookie('token')==null){
                window.location.replace("http://localhost:9001/common/login.html");
            } else if(getCookie("role") > getUrlRank()){
                window.location.replace("http://localhost:9001/common/Permission.html");
            }
        }

        auth();