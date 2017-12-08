
function checkUtil()
{
    return;
	var allInput = document.getElementsByTagName("input");
    if(allInput.length > 0){
        for(var i = 0; i < allInput.length; i++){
        	var inputName = allInput[i].name;
            if(allInput[i].type && allInput[i].type == "text" && inputName.indexOf("Name") < 0){
                var reg = null;
                if(inputName == "day"){
                    reg = /^\d{4}-\d{1,2}-\d{1,2}$/;
                }else if(inputName.indexOf("searchTime") == 0){
                    reg = /^\d{4}-\d{1,2}$/;
                }else if(inputName == "searchYear"){
                    reg = /^\d{4}$/;
                }
                
                if(allInput[i].value != null && allInput[i].value.length == 0){
                	alert("查询条件不能为空，请重新输入！");
                    return false;
                }
                if(reg!=null && !reg.test(allInput[i].value)){
                	alert("查询条件的格式不正确，请重新输入！");
                    return false;
                }
                
                var flag = inputName.indexOf("End");
                if(flag>0){
                	var endValue = allInput[i].value;
                	var name = inputName.substring(0,flag);
                	var startValue = document.getElementById(name+"Start").value;
              		if(startValue > endValue){
              			alert("开始日期不能大于结束日期，请重新输入！");
                    	return false;
              		}
                }
            }
        }
    }
}

function setUserIdList(){
	var userIdList = document.getElementById("userIdList");
	var userName = document.getElementById("userName").value;
	var userTemp = document.getElementById("userTemp").value;
	if(userTemp == null || userTemp.length <= 0){
		alert("系统中没有用户或权限不足，请与管理员联系！");
    	return false;
    }
	if(userName != null && userName.length > 0){
		userName =userName.toLowerCase().replace(/(^\s*)|(\s*$)/g,"");
	}

    var idTemp ="";
	var userArry = userTemp.split(",");
	for(var i =0;i<userArry.length;i++){
    	var id = userArry[i].split(":")[0];
    	var name = userArry[i].split(":")[1].toLowerCase();
    	if(userName != null && userName.length > 0){
    		if(name.indexOf(userName)>=0){
        		idTemp += "'"+id+"',";
            }	
    	}else{
    		idTemp += "'"+id+"',";
        }
	}
	
	if(idTemp.length>0){
		idTemp = idTemp.substring(0,idTemp.length-1);		
	}else{
		alert("没有找到相关用户，请确认输入！");
    	return false;
    }
	userIdList.value = " AND bam.user_id in ("+idTemp+") ";
}

function getDay()   
{
    var today = new Date();   
    var day = today.getDate();   
    var month = today.getMonth() + 1;   
    var year = today.getFullYear(); 
    if(month<10){
	 	month ="0"+month;	
    }
    if(day<10){
   	 day ="0"+day;	
    }  
    var date = year + "-" + month + "-" + day; 
    document.getElementById("day").value = date;   
}
function getMonth()   
{   
	var today = new Date();     
    var month = today.getMonth() + 1;   
    var year = today.getFullYear();  
    
    if(month<10){
	 	month ="0"+month;	
    }
    
    var date = year + "-" + month;   
    document.getElementById("searchTime").value = date; 
}

function getYear()
{
	var today = new Date();   
    var year = today.getFullYear();   
    var date = year;   
    document.getElementById("searchYear").value = date; 
}


