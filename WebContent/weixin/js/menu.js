var isClick =0;
$(document).ready(function(){
	try{
	showdiv();
	}catch(e){}
	//截取url
	var url = window.location.pathname;
	var basePath = $("#basePath").val();
	if(url=="/CateSystem/weiXinCY/storeDish-weixin"||url=="/CateSystem/weiXinCY/storeWMDish-weixin"||url=="/weiXinCY/storeDish-weixin"||url=="/weiXinCY/storeWMDish-weixin"){
	/**
	获取菜品类别和菜品
	**/
	$("#loading").show();
	$("#afterLoading").hide();
	$("#loading").html("<div style='padding-top:50%;text-align:center;'><img src='../mobile/images/loading.gif' style='';></div>");
	var orgCode = $("#orgCode").val();
	var openid = $("#openid").val();
	$.ajax({
		url:"../weiXinCY/getStoreDish-weixin",
		method:"get",
		data:"orgCode="+orgCode+"&openid="+openid,
		success:function(data){
		console.log(data);
		$("#loading").hide();
		$("#afterLoading").show();
			var html = "<ul id='ul_type'></ul>";
			var html1 = "<li id='li_type' class='on'>所有菜品</li>";
			var html2="";
			var dishType = data.dishType;
			if(dishType.length>0){
				var allmoney = 0;
				var menucount = 0;
				for(var i=0;i<dishType.length;i++){
					html1 = html1 + "<li id='li_type"+dishType[i].dtChDishTypeNo+"' class=''>"+dishType[i].dtVchDishTypeName+"</li>";
					var htmlBegin = "htmlBegin"+dishType[i].dtChDishTypeNo;
					window['htmlBegin'] = "<ul id='ul_type"+dishType[i].dtChDishTypeNo+"'>";
					var htmlEnd = "</ul>";
					var dish = "dishInfos"+dishType[i].dtChDishTypeNo;
					var dishList="dishList"+dishType[i].dtChDishTypeNo;
					window['dishList']= "";
					var dishInfos = data[dish];
					for(var j=0;j<dishInfos.length;j++){
						//设置默认图片
						var picture="../common/images/nopic.jpg";
						if(dishInfos[j].diChPicture!=null&&dishInfos[j].diChPicture!==""){
							picture=basePath+dishInfos[j].diChPicture;
						}
						if(dishInfos[j].diIntDeduct==0){
							if(dishInfos[j].diChSuitflag=='Y'){
								var suit ="套菜详情：";
								$.ajax({
									url:"../weiXinCY/getSuitDish-weixin",
									method:"get",
									async:false,
									data:"dsChSuitNo="+dishInfos[j].diChDishNo+"&orgCode="+orgCode,
									success:function(data){
									for(var k=0;k<data.length;k++){
										suit =  suit+data[k].dsChSuitNo+" "+data[k].dsNumNum+"份  ";
									}
								}
								});
								window['dishList'] = window['dishList'] + "<li id='li"+dishInfos[j].diChDishNo+"' class=''><span><img src='"+picture+"' alt='"+suit+"'>"
								  + "</span><label><span id='diVchDishName'>"+dishInfos[j].diVchDishName+"</span><p style='color:red;'>(套餐:点击图片查看详情)</P><label><span class='icon hart' data="+dishInfos[j].diChDishNo+"></span><span class='price'>￥"
								  + "<label class='price_n'>"+dishInfos[j].diNumPrice+"</label></span><label><span class='btn  minus' style='display: none;'></span><span class='num'>"
								  + "<input type='text' readonly='true' value='"+dishInfos[j].diIntDeduct+"' style='display: none;'></span><span class='btn plus'></span></label></label></label><input id='sn' type='hidden' value='"+dishInfos[j].sn+"'></li>";
							}else{
								window['dishList'] = window['dishList'] + "<li id='li"+dishInfos[j].diChDishNo+"' class=''><span><img src='"+picture+"' alt='味型特点："+dishInfos[j].diVchDishName+"'>"
											  + "</span><label><span id='diVchDishName'>"+dishInfos[j].diVchDishName+"</span><label><span class='icon hart' data="+dishInfos[j].diChDishNo+"></span><span class='price'>￥"
											  + "<label class='price_n'>"+dishInfos[j].diNumPrice+"</label></span><label><span class='btn  minus' style='display: none;'></span><span class='num'>"
											  + "<input type='text' readonly='true' value='"+dishInfos[j].diIntDeduct+"' style='display: none;'></span><span class='btn plus'></span></label></label></label><input id='sn' type='hidden' value='"+dishInfos[j].sn+"'></li>";
							}
						}else{
							if(dishInfos[j].diChSuitflag=='Y'){
								var suit ="套菜详情：";
								$.ajax({
									url:"../weiXinCY/getSuitDish-weixin",
									method:"get",
									async:false,
									data:"dsChSuitNo="+dishInfos[j].diChDishNo+"&orgCode="+orgCode,
									success:function(data){
									for(var k=0;k<data.length;k++){
										suit =  suit+data[k].dsChSuitNo+" "+data[k].dsNumNum+"份  ";
									}
								}
								});
								window['dishList'] = window['dishList'] + "<li id='li"+dishInfos[j].diChDishNo+"' class=''><span><img src='"+picture+"' alt='"+suit+"'>"
								  + "</span><label><span id='diVchDishName'>"+dishInfos[j].diVchDishName+"</span><p style='color:red;'>(套餐:点击图片查看详情)</P><label><span class='icon hart' data="+dishInfos[j].diChDishNo+"></span><span class='price'>￥"
								  + "<label class='price_n'>"+dishInfos[j].diNumPrice+"</label></span><label><span class='btn  minus'></span><span class='num'>"
								  + "<input type='text' readonly='true' value='"+dishInfos[j].number+"'></span><span class='btn plus'></span></label></label></label><input id='sn' type='hidden' value='"+dishInfos[j].sn+"'></li>";
							}else{
								window['dishList'] = window['dishList'] + "<li id='li"+dishInfos[j].diChDishNo+"' class=''><span><img src='"+picture+"' alt='味型特点："+dishInfos[j].diVchDishName+"'>"
								  + "</span><label><span id='diVchDishName'>"+dishInfos[j].diVchDishName+"</span><label><span class='icon hart' data="+dishInfos[j].diChDishNo+"></span><span class='price'>￥"
								  + "<label class='price_n'>"+dishInfos[j].diNumPrice+"</label></span><label><span class='btn  minus'></span><span class='num'>"
								  + "<input type='text' readonly='true' value='"+dishInfos[j].number+"'></span><span class='btn plus'></span></label></label></label><input id='sn' type='hidden' value='"+dishInfos[j].sn+"'></li>";
							}
						}
						allmoney = allmoney + (dishInfos[j].diNumPrice)*(dishInfos[j].number);
						menucount = menucount + dishInfos[j].number;
					}
						html2 = html2 + window['htmlBegin'] + window['dishList'] + htmlEnd;
				}
				$("#allmoney").html(allmoney.toFixed(2));
				$("#menucount").html(menucount);
				$("#typeList").html(html1);
				$(".all").html(html+html2);
				
				//显示加减按钮 show plus minus button
				showbtn();
				var menu_ul_lis =$("#usermenu li");
				for(var i=0;i<menu_ul_lis.length;i++){
					var li =menu_ul_lis[i];
					var num=$("input",$(li)).val();
					if(num==""){
						$("input",$(li)).val(0);
						num=0;
					}
					if(num==0){
						$(".minus",$(li)).hide();
						$("input",$(li)).hide();
					}
				}
				$("#usermenu .all ul li .plus").click(function(){
					plus(this)										   
				});
				$("#usermenu .all ul li .minus").click(function(){
					minus(this);										   
				});
				
				//大类选择
				$("#typeList li").click(function(){
					var idStr = this.id;
					var id =idStr.replace("li_type","");
					$("#typeList li").removeClass("on");
					$(this).addClass("on")
					$(".likediv").hide();
					$("#ILike .hartblckgray").removeClass("on");
					$(".all").show();
					var top =$("#ul_type"+id+"").get(0).offsetTop;
					//alert(top)
					var topM=$("#usermenu").get(0).scrollHeight-$("#usermenu").get(0).offsetHeight;
					var st =$("#usermenu").scrollTop();
					if(st<=topM){
						if(top<=topM){
							$("#usermenu").scrollTop(top);
						}
						else{
							$("#usermenu").scrollTop(topM);
						}
					}
					isClick=1;
					
					
				});
				
				//图片弹层
				$("#usermenu  ul li img").click(function(){
					showDetails(this);
				});
				
			}
			try{
			hidediv();
			}catch(e){}
		}
		});
	//获取购物车菜品
	}else if(url=="/CateSystem/weiXinCY/storeDishConfirm-weixin"||url=="/CateSystem/weiXinCY/storeWMDishConfirm-weixin"||url=="/weiXinCY/storeDishConfirm-weixin"||url=="/weiXinCY/storeWMDishConfirm-weixin"){
		var orgCode = $("#orgCode").val();
		var allmoney = 0;
		var menucount = 0;
		$.ajax({
			url:"../weiXinCY/getCartDish-weixin",
			method:"get",
			data:"orgCode="+orgCode,
			success:function(data){
			console.log(data);
			var html = "";
			if(data.length>0){
				for(var i=0;i<data.length;i++){
					//设置默认图片
					var picture="../common/images/nopic.jpg";
					if(data[i].diChPicture!=null&&data[i].diChPicture!==""){
						picture=basePath+data[i].diChPicture;
					}
					if(data[i].diChSuitflag=='Y'){
						html = html + "<li id='"+data[i].dishNo+"'><span><img src="+picture+"></span><label><span id='diVchDishName'>"+data[i].dishName+"</span><p style='color:red;'>(套餐:点击图片查看详情)</P><label><span class='price'>￥"
						+ "<label class='price_n'>"+data[i].price+"</label></span><label><span class='btn minus' onclick='minus(this)'></span><span class='num'>"
						+ "<input type='text' value="+data[i].number+" readonly='true'></span><span class='btn plus' onclick='plus(this)'></span></label></label>"		
						+ "</label><input type='text' class='markinput' placeholder='备注' value=''>	<input id='sn' type='hidden' value='"+data[i].sn+"'></li>";
					}else{
						html = html + "<li id='"+data[i].dishNo+"'><span><img src="+picture+"></span><label><span id='diVchDishName'>"+data[i].dishName+"</span><label><span class='price'>￥"
									+ "<label class='price_n'>"+data[i].price+"</label></span><label><span class='btn minus' onclick='minus(this)'></span><span class='num'>"
									+ "<input type='text' value="+data[i].number+" readonly='true'></span><span class='btn plus' onclick='plus(this)'></span></label></label>"		
									+ "</label><input type='text' class='markinput' placeholder='备注' value=''>	<input id='sn' type='hidden' value='"+data[i].sn+"'></li>";
					}
					menucount = menucount + data[i].number;
					allmoney = allmoney + (data[i].price)*(data[i].number);
				}
				$("#usermenu").html(html);
				$("#allmoney").html(allmoney.toFixed(2));
				$("#menucount").html(menucount);
				showbtn();//显示按钮
			}else{
				alert("您还未选择菜品~");
			}
		}
		});
	}
	
	showbtn();//显示按钮
	var menu_ul_lis =$("#usermenu li");
	for(var i=0;i<menu_ul_lis.length;i++){
		var li =menu_ul_lis[i];
		var num=$("input",$(li)).val();
		if(num==""){
			$("input",$(li)).val(0);
			num=0;
		}
		if(num==0){
			$(".minus",$(li)).hide();
			$("input",$(li)).hide();
		}
	}
	$("#usermenu .all ul li .plus").click(function(){
		plus(this)										   
	});
	$("#usermenu .all ul li .minus").click(function(){
		minus(this);										   
	});
	
	
	
	$("#ILike").click(function(){
		var menu_ul_lis =$(".all li.like");
		//alert(menu_ul_lis.length)
		var like_ul=$(".likediv ul");
		like_ul.html("");
		for(var i=0;i<menu_ul_lis.length;i++){
			var li  =  document.createElement("li");
			li.id= menu_ul_lis[i].id;
			li.className= menu_ul_lis[i].className;
			li.innerHTML= menu_ul_lis[i].innerHTML;
			like_ul.append(li);
			$("input",$(li)).val($("input",$(menu_ul_lis[i])).val())
		}
		
		$(".likediv").show();
		$(".all").hide();
		$("#typeList li").removeClass("on");
		$(".hartblckgray",$(this)).addClass("on");
		
		$("#usermenu .likediv ul .hart").click(function(){
			var li = $(this).parent().parent().parent();
			var id =li.get(0).id.replace("li","");
			check_i_like(id);
			$("#usermenu .all ul #"+li.get(0).id+"").removeClass("like");
			li.remove();			
		});
		$("#usermenu .likediv ul li .plus").click(function(){
			var li = $(this).parent().parent().parent().parent();			
			var li_id=li.get(0).id
			plus(this,li_id);			
			
		});
		$("#usermenu .likediv ul li .minus").click(function(){
			var li = $(this).parent().parent().parent().parent();
			var li_id=li.get(0).id												
			minus(this,li_id);										   
		});
		$("#usermenu  ul li img").click(function(){
			showDetails();
		});
	});
	$("#usermenu .all ul .hart").click(function(){
		var li = $(this).parent().parent().parent();										
		li.toggleClass("like");
		var id =li.get(0).id.replace("li","");
		check_i_like(id);
		
	});
	
	$("#usermenu  ul li img").click(function(){
		showDetails(this);
	});
	
	$(".details  .content a").click(function(){
		hideDetails();
	});
	
	$("#typeList li").click(function(){
		var idStr = this.id;
		var id =idStr.replace("li_type","");
		$("#typeList li").removeClass("on");
		$(this).addClass("on")
		$(".likediv").hide();
		$("#ILike .hartblckgray").removeClass("on");
		$(".all").show();
		var top =$("#ul_type"+id+"").get(0).offsetTop;
		//alert(top)
		var topM=$("#usermenu").get(0).scrollHeight-$("#usermenu").get(0).offsetHeight;
		var st =$("#usermenu").scrollTop();
		if(st<=topM){
			if(top<=topM){
				$("#usermenu").scrollTop(top);
			}
			else{
				$("#usermenu").scrollTop(topM);
			}
		}
		isClick=1;
		
		
	});
	$("#usermenu").get(0).onscroll=function(){
		if(isClick==1){
			isClick=0;
			return false;
		}
		var st =$("#usermenu").scrollTop();
		var uls = $("#usermenu .all ul");		
		var h= 0;
		if(uls.length>0){
			h=$(uls[0]).height();
		}
		if(st>0){
			for(i=1;i<uls.length;i++){			
				var h_ul = $(uls[i]).height()+h;
				if(h<st&st<h_ul){
					var u_id =uls[i].id;
					id = u_id.replace("ul_type","");
					$("#typeList li").removeClass("on");
					$("#li_type"+id+"").addClass("on");
					return;
				}
				h=h_ul;
				
			}
		}
		else{
			$("#typeList li").removeClass("on");
			$($("#typeList li")[0]).addClass("on");
		}
	}
});
function showDetails(elm){
	$(".details").show();
	showDetailInfo(elm);
}
function showDetailInfo(elm){
	var li = $(elm).parent().parent();
	var des=elm.alt;
	var name =$(">label>span",li).html();
	var money = $(">label>label .price_n",li).html();
	
	$(".details .name").html(name);
	$(".details .money").html(money);
	$(".details p").html(des);
	$(".details img").get(0).src=elm.src;
	var p_ts = $('.p_ts',li).html();
	if(p_ts==undefined) 
	{
		$(".details .p_ts").hide();
	}
	else{
		$(".details .p_ts").show();
		$(".details .p_ts").html(p_ts);
	}
}

function hideDetails(){
	$(".details").hide();
}

function plus(elm,id){	
	var L_elm= $(elm).parent();
	var m_elm=$(".minus",L_elm);
	var num=$("input",L_elm);
	var nstr =num.val();
	if(nstr==""){nstr=0}
	var n =parseInt(nstr)+1;
	num.val(n);
	if(n>0){
		m_elm.show();
		num.show();
	}
	if(id!=undefined){
		var allListNum_elm = $("#usermenu .all ul #"+id+" input")
		allListNum_elm.val(n);
		if(n>0){
			 $("#usermenu .all ul #"+id+" .minus").show();
			 allListNum_elm.show();
		}
	}
	
	var p =parseFloat($(".price_n",L_elm.parent()).html());
	var allmoney_elm = $("#allmoney");
	var allmoney=parseFloat(allmoney_elm.html());
	var c_allmoney =parseFloat(allmoney+p).toFixed(2)
	allmoney_elm.html( parseFloat(c_allmoney));
	
	var menucount_elm = $("#menucount");
	var menucount=parseInt(menucount_elm.html());
	var mc =menucount+1;
	menucount_elm.html(mc);
	showbtn();
	
}
function minus(elm,id){
	var L_elm= $(elm).parent();
	var m_elm=$(elm);
	var num=$("input",L_elm);
	var nstr =num.val();
	if(nstr==""){nstr=0}
	var n =parseInt(nstr)-1;
	if(n>=0){num.val(n);}
	
	if(n==0){
		m_elm.hide();
		num.hide();
	}
	if(id!=undefined){
		var allListNum_elm = $("#usermenu .all ul #"+id+" input")
		allListNum_elm.val(n);
		if(n==0){
			 $("#usermenu .all ul #"+id+" .minus").hide();
			 allListNum_elm.hide();
		}
	}

	var p =parseFloat($(".price_n",L_elm.parent()).html())
	var allmoney_elm = $("#allmoney");
	var allmoney=parseFloat(allmoney_elm.html())
	var c_allmoney =parseFloat(allmoney-p).toFixed(2)
	allmoney_elm.html( parseFloat(c_allmoney));
	
	var menucount_elm = $("#menucount");
	var menucount=parseInt(menucount_elm.html());
	var mc =menucount-1;
	menucount_elm.html(mc);
	showbtn();
	
}

function showbtn(){
	var mc =parseInt($("#menucount").html())
	if(mc==0){
		$(".btn.show").hide()
		$(".btn.disabled").show()
	}else{
		$(".btn.show").show()
		$(".btn.disabled").hide()
	}
}
function addmark(elm){
	var li =$(elm).parent().parent().parent();
	$(".markinput",li).toggle();
}

function cancel(){
	hidepopup();
}


function getMyMenulist(){
	var lis =$("#usermenu li");
	var list = [];
	for(i=0;i<lis.length;i++){		
		var mark= $(".markinput",lis[i]).get(0).value;
		var count = $(".num >input",lis[i]).get(0).value;
		if(count>0){
			var id = lis[i].id;			
			var info = {'id':id,'count':count,'mark':mark}
			list.push(info);
		}
		
	}
	var allmark = $("#allmark").get(0).value;
	return {'data':list,mark:allmark};
}
function getMenuChecklist(){
	var lis =$("#usermenu .all li");
	var list = [];
	for(i=0;i<lis.length;i++){	
		var count = $(".num >input",lis[i]).get(0).value;
		var price = $(".price_n",lis[i]).text();
		var diVchDishName = $("#diVchDishName",lis[i]).text();
		var sn = $("#sn",lis[i]).get(0).value;
		if(count>0){
			var id = lis[i].id.replace("li","");
			
			var info = {'id':id,'count':count,'price':price,'diVchDishName':diVchDishName,'sn':sn}
			list.push(info);
		}
		
	}
	
	return list;
}
function getMenuCheckStoreDishlist(){
	var lis =$("#usermenu li");
	var list = [];
	for(i=0;i<lis.length;i++){	
		var count = $(".num >input",lis[i]).get(0).value;
		var price = $(".price_n",lis[i]).text();
		var diVchDishName = $("#diVchDishName",lis[i]).text();
		var sn = $("#sn",lis[i]).get(0).value;
		if(count>0){
			var id = lis[i].id.replace("li","");
			
			var info = {'id':id,'count':count,'price':price,'diVchDishName':diVchDishName,'sn':sn}
			list.push(info);
		}
		
	}
	
	return list;
}
