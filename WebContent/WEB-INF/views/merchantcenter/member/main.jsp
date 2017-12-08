<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<body>
	<!-- 动态引用页面头文件 -->
	<jsp:include page="/head.htm" flush="true" />
    <script language="javascript" type="text/javascript">
        $().ready(function() {
            var url = this.location.href + "?tspan=" + (new Date());
            $.post(url, { load: 1 }, function(data) {
                //alert(data);
                if (data == 1) {
                    $("#vadd").hide();
                    $("#dvSync").show();
                } else {
                    $("#dvSync").hide();
                    $("#vadd").show();
                }
            });
        });

  	//载入中的GIF动画
    var loadingUrl = "../App_Themes/normal/images/ajax-loader.gif";
    
    //选择文件后的事件,iframe里面调用的
    var uploading = function(){
        $("#ifUpload").css('display','none');
        $("#uploading").html("<img src='"+loadingUrl+"' align='absmiddle' /> 上传中");
    };
 
    //重新上传方法    
    function uploadinit(n){        
   if( n==1)
   {
        $("#uploaddiv").css('display','');
         $("#ifUpload").css('display','');
        $("#reload").css('display','none');
        }
        else
        {
        $("#uploaddiv").css('display','none');
        $("#reload").css('display','');
        $("#uploading").html("");
        }
    }
    
    //上传时程序发生错误时，给提示，并返回上传状态
    var uploaderror = function(){
        art.dialog({
            content: '程序异常，上传未成功。',
            time: 4
        });
        //uploadinit(0);
    };
    //获取当前时间
        function Gettime()
        {
            var now=new Date;
            var vYear = now.getFullYear();
            var vMon = now.getMonth() + 1;
            var vDay = now.getDate();
            var vHour = now.getHours();
            var vMinute = now.getMinutes();
            var vSecond = now.getSeconds();
            vMon = vMon<10 ? "0" + vMon : vMon;
            vDay = vDay<10 ? "0" + vDay : vDay;
            vHour = vHour<10 ? "0" + vHour : vHour;
            vMinute = vMinute<10 ? "0" + vMinute : vMinute;
            vSecond = vSecond<10 ? "0" + vSecond : vSecond;
            return vYear + "-" + vMon + "-" + vDay + " " + vHour + ":" + vMinute + ":" + vSecond;
        }
    
    //上传成功后的处理
    var uploadsuccess = function(data){              
               //刷新图片  
               var time= Gettime();  
              //alert(data);
               //$("#panelViewPic").html("<img  src='../../inc/viewpic.aspx?1&1&'+time+' width=80 height=80 />");
               var src = 'http://img.mytongtu.com/user'+"/"+data;
               //alert(src);
               $("#panelViewPic").html("<img  src='"+src+"' width=80 height=80 />");
                uploadinit(0);
            };

            

            function syncGCBUserRelation() {
                var url = this.location.href + "?tspan=" + (new Date());
                $.post(url, { sync: 1 }, function(data) {
                    if (data == 0) {
                        art.dialog({ content: '操作成功！', time: 4 });
                        $("#syncClick").removeAttr("href").removeAttr("onclick");
                    } else {
                        art.dialog({ content: '账号同步失败！', time: 4 });
                    }
                });
            }

            function reloadVehicle() {
                var list = art.dialog.list; for (var i in list) { list[i].close(); };
            }
    
    </script>

    <script type="text/javascript" language="javascript">
        $("html").attr("style","overflow-x:hidden;overflow-y:auto");   
    </script>

    <div id="page">
        

<div id="left">
    <div class="leftmenu2">
        <ul>
         	<li id="menu1" onclick="choose()" class="leftmenu1_icon_m1">
         		<a href='#'><span class="forpng">会员信息管理</span></a>
         	</li>
            <li id="menu2" onclick="choose()" class="leftmenu1_icon_m1">
            	<a href='#'><span class="forpng">会员在线充值</span></a>
            </li>
        </ul>
        <ul id="ctl00_ContentPlaceHolder1_menu1_ulMenuList"></ul>     
    </div>
</div>
<div id="ctl00_ContentPlaceHolder1_menu1_divMenuId" style="display: none">1</div>

<script language="javascript" type="text/javascript">
    function choose() {
        var menuId = "";
        if (document.getElementById("ctl00_ContentPlaceHolder1_menu1_divMenuId").innerHTML != "") {
            menuId = document.getElementById("ctl00_ContentPlaceHolder1_menu1_divMenuId").innerHTML;

            var css = "leftmenu1_icon_m" + menuId + " active";
            document.getElementById("menu" + menuId).className = css;

        }
    }
    
    //选择定制菜单
    function choosemenu()
    {
        var menuId=document.getElementById("ctl00_ContentPlaceHolder1_menu1_divMenuId").innerHTML;
        var css="active";
        document.getElementById("memu"+menuId).className=css;
    }
</script>
<script language='javascript'  type='text/javascript'>choose(); </script>


       
    </div>
    

	<jsp:include page="/footer.htm" flush="true" />

</body>
</html>

<script language="javascript" type="text/javascript">
    $(function() {
        $(".btncss").each(function() {
            $(this).bind('click', function() {
                $.get('/inc/Stats.aspx', { BSBUTTONID: $(this).attr("id"), BSBUTTONNAME: $(this).attr("btname"), BSPAGEURL: window.document.location.pathname });
            });
        });
    });        
</script>

