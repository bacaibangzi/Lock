﻿$(document).ready(function(){
	$(".nav .more").click(function(){
		var offsetLeft = this.offsetLeft;
		var elm = $(">ul" ,$(this));		
		var lis =$(">ul >li" ,$(this));
		var h=lis.length*38+20;
		elm.css('height',''+(lis.length*44+20)+'px');	
		var bodywidth = $(window).width();
		var nn= $(".nav >ul >li").length;
		var nn_li_width =parseInt(bodywidth/nn);
		var elm_width =elm.width();
		if(nn_li_width>(elm_width+3)){
			elm.css('margin-left',''+(parseInt((nn_li_width-elm_width)/2))+'px');
		}
		else{
			if(offsetLeft==0){
				elm.css("margin-left","10px");
			}
			else if(offsetLeft>(bodywidth-nn_li_width-5)&offsetLeft<(bodywidth-nn_li_width+5))
			{
				elm.css("margin-left",""+(nn_li_width-elm_width-10)+"px");
			}
			else
			{
				elm.css('margin-left',''+(parseInt((nn_li_width-elm_width)/2))+'px');
			}
		}
		$(".adron" ,$(this)).css('margin-left',''+((nn_li_width-12)/2)+'px');
		$(".nav .more >ul").hide();
		$(".nav .adron").removeClass("on");	
		$(".adron" ,$(this)).addClass("on");	
		elm.show();
	});
	
	function isNull( str ){ 
		if ( str == "" ) return true; 	
		var regu = "^[ ]+$"; 
		var re = new RegExp(regu); 			
		return re.test(str); 
	}
	// 获取验证码
var timeFlag;
	$('#showdialog').on('click', function(){
		$('#valiCode').dialog({closeCb: reset});
		return false;
	});
	$('#saveCode').on('click', function(){
		var tel = $('#userTel').val();
		if(/1\d{10}/.test(tel)){
			var code = $('#userCode').val();
			if(isNull(code)){
				alert('请输验证码');
			}
			else{
				submitTel();
			}
		}
		else{
			alert('请输入正确的手机号码');
		}
	});
	$('#cancleCode').on('click', function(){
		$('#valiCode').dialog('close');
		reset();
	});

	$('#getCode').on('click', function(){
		var tel = $('#userTel').val();

		if(/1\d{10}/.test(tel)){
			$('#codeWrap').show();
			// 发送验证码...
			getcode(function(){setTimer();});
		}else{
			alert('请输入正确的手机号码');
		}
	});
	
	function reset(){
		clearTimeout(timeFlag);
		$('#getCode').text('获取验证码').removeClass('disabled');
		$('#userTel').val('').attr('disabled', false);
		$('#userCode').val('');
	}
	function setTimer(){
		var _this = this;

		var overplus = 60;
		
		function setTxt(time){
			$('#getCode1').text(time + '秒后可重新获取');
			$('#userTel').attr('disabled', true);
		}
		function update(){
			setTxt(overplus);
			timeFlag = setTimeout(function(){
				if(overplus > 1){
					$("#getCode1").css("display","block");
					$("#getCode").hide();
					overplus --;
					setTxt(overplus);
					update();
					
				}else{
					$("#getCode").show();
					$("#getCode1").css("display","none");
					$('#userTel').attr('disabled', false);
				}
			}, 1000);
		}
		update();
	}
});