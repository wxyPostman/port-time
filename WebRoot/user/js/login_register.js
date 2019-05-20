//倒计时
var countdown = 60;

function sendemail() {
	var obj = $("#get_phone_num");
	settime(obj);
}
var phoness="";
var cap="";
function  Captcha(){
	
	var phone=$("#register_phone").val();
	$.ajax({
		data:{
			phone:phone,
			op:"getphone"
		},
		url:"../reg.do",
		type:"POST",
		success:function(data){
			var jsonData = JSON.parse(unescape(data));
			//alert("发送成功！")		
			cap=jsonData;
			
		}
		
	})
	return cap;
}
$("#get_phone_num").click(function() {
	if(phoness!="undefined"&&phoness!=""&&phoness!=null){
		$("#phoneTip").text(phoness);
		$("#phoneTip").css("display", "block");

	}else{
		console.log(phoness);
		Captcha();
		sendemail();
	}
	
});
function settime(obj) { //发送验证码倒计时
	if(countdown == 0) {
		obj.attr('disabled', false);
		//obj.removeattr("disabled"); 
		obj.val("免费获取验证码");
		countdown = 60;
		return;
	} else {
		obj.attr('disabled', true);
		obj.val("重新发送(" + countdown + ")");
		countdown--;
	}
	setTimeout(function() {
		settime(obj)
	}, 1000)
}
$(function() {
	$.ajax({
		url:"../GetSession_login.do",
		type:"POST",
		success:function(data){
			var jsonData=JSON.parse(unescape(data));
			if(data != 400){
				console.log(jsonData.username);
				//$("#success_username").text(jsonData.data);
				$("#login").modal('hide');
				$("#contern_login").css("display","none");
				$("#contern_register").css("display","none");
				$("#conter_user_info").css("display","block");
				$("#success_username").text(jsonData.username);
			}else{
				$("#conter_user_info").css("display","none");
				$("#contern_login").css("display","block");
				$("#contern_register").css("display","block");
			}
		}
	})
	
	
	
	
	$("#login_username").blur(function() {
		if(!/^[a-zA-Z0-9\u4e00-\u9fa5]{2,15}$/.test($("#login_username").val())) {
			$("#login_username_tip").text("用户名需要2-15位");
			$("#login_username_tip").css("display", "block");
			
		} else {
			$("#login_username_tip").text("");
			$("#login_username_tip").css("display", "none");
		}
	});

	$("#login_password").blur(function() {
		if(!/^[a-zA-Z0-9]{6,15}$/.test($("#login_password").val())) {
			$("#login_password_tip").text("密码需要6-15位(不允许特殊字符)");
			$("#login_password_tip").css("display", "block");
			//$("#login_user_btn").attr('disabled',true);
		} else {
			$("#login_password_tip").text("");
			$("#login_password_tip").css("display", "none");
		}
	});
	
	$("#login_user_btn").click(function() {
		getUser();
	})
});

function getUser() {
	var username = $("#login_username").val();
	var password = $("#login_password").val();
	$.ajax({
		data:{
			username: username,
			password: password,
			op:"check_un"
		},
		url:"../check.do",
		type:"POST",
		xhrFields: {withCredentials: true},
		success:function(data){
			var jsonData=JSON.parse(unescape(data));
			//console.log(jsonData.status,jsonData.data,jsonData.msg);
			if(jsonData.status==400){
				$("#login_username_tip").text("用户名或密码错误");
				$("#login_username_tip").css("display", "block");
				
			}else{
				$("#login").modal('hide');
				$("#contern_login").css("display","none");
				$("#contern_register").css("display","none");
				alert("登录成功");
				$("#conter_user_info").css("display","block");
				$("#success_username").text(jsonData.data.username);
				window.location.reload();
			}
		}
	})
}

$(function() {
	$("#get_phone_num").click(function() {
		sendemail();
	});

	$("#register_username").blur(function() {
		var register_username = $("#register_username").val();
		if (!/^[a-zA-Z0-9\u4e00-\u9fa5]{2,6}$/.test($("#register_username").val())) {
			$("#usernameTip").text("用户名为 2-6 位");
			$("#usernameTip").css("display", "block");
			
		} else {
			$.ajax({
				data : {
					register_username : register_username,
					op:"check_run"
				},
				url : "../check.do",
				type : "POST",
				async : true, //是否为异步请求
				cache : false, //是否缓存结果
				success : function(data) {
					var jsonData = JSON.parse(data);
					console.log(jsonData.status, jsonData.data, jsonData.msg);
					if (jsonData.status == 400) {
						$("#usernameTip").text(jsonData.msg);
						$("#usernameTip").css("display", "block");
						
					} else {
						$("#usernameTip").text("");
						$("#usernameTip").css("display", "block");
						
					}
				}
			})
		}
	});
	$("#register_password").blur(function() {
		var register_password = $("#register_password").val();
		if (!/^[a-zA-Z0-9]{6,16}$/.test($("#register_password").val())) {
			$("#passwordTip").text("密码为 6-16 位");
			$("#passwordTip").css("display", "block");
			
		} else {
			$("#passwordTip").text("");
			$("#passwordTip").css("display", "block");
		}
	});

	$("#register_phone").blur(function() {
		
		var register_phone = $("#register_phone").val();
		if (!/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/.test($("#register_phone").val())) {
			$("#phoneTip").text("电话号码不正确");
			$("#phoneTip").css("display", "block");
		} else {
			$.ajax({
				data : {
					register_phone : register_phone,
					op:"check_phone"
				},
				url : "../check.do",
				type : "POST",
				async : true, //是否为异步请求
				cache : false, //是否缓存结果
				success : function(data) {
					var jsonData = JSON.parse(data);
					//console.log(jsonData.status, jsonData.data, jsonData.msg);
//					if (jsonData.status == 400) {
//						$("#phoneTip").text(jsonData.msg);
//						$("#phoneTip").css("display", "block");	
//						
//					} else {
//						$("#phoneTip").text("");
//						$("#phoneTip").css("display", "block");
//						
//					}
					if (jsonData.status == 400) {
						
						phoness=jsonData.msg;
						
					} else {
						$("#phoneTip").text("");
						$("#phoneTip").css("display", "block");
						phoness="undefined";
						
					}
					
				}
			})
		}
	});

//   注册
	$("#register_btn").click(function() {
		var register_username = $("#register_username").val();
		var register_password = $("#register_password").val();
		var register_school = $("#register_school").val();
		var register_phone = $("#register_phone").val();
		var captcha=$("#captcha").val();
		
		
		if((register_username == "undefined" || register_username == null || register_username == "")||
			(register_password == "undefined" || register_password == null || register_password == "")||
			(register_school == "无")||
			(register_phone == "undefined" || register_phone == null || register_phone == "")||
			(captcha=="undefined"||  captcha == null || captcha == "")
		){
			if (register_username == "undefined" || register_username == null || register_username == "") {
				$("#usernameTip").text("用户名不能为空！");
				$("#usernameTip").css("display","block");
			}else{
				$("#usernameTip").text("");
				//$("#usernameTip").css("display","none");
			} 
			if (register_password == "undefined" || register_password == null || register_password == "") {
				$("#passwordTip").text("密码不能为空！");
				$("#passwordTip").css("display","block");
			} else{
				$("#passwordTip").text("");
			//	$("#passwordTip").css("display","none");
			}
			if (register_school == "无") {
//				console.log("没有学校");
				alert("没有学校");
//				$("#usernameTip").text("用户名不能为空！");
//				$("#usernameTip").css("display","block");
			} 
			if (register_phone == "undefined" || register_phone == null || register_phone == "") {
				$("#phoneTip").text("手机号不能为空！");
				$("#phoneTip").css("display","block");
			} else {
				$("#phoneTip").text("");
				$("#phoneTip").css("display","none");
		}if(captcha=="undefined"||  captcha == null || captcha == ""){
				$("#captchaTip").text("请输入验证码！");
				$("#captchaTip").css("display","block");
		}else{
			$("#captchaTip").text("");
			}
			
	}else{
		if(captcha!=cap){	
			$("#captchaTip").text("请输入正确的验证码！");
			$("#captchaTip").css("display","block");
		}else{
			console.log("你好");
			$.ajax({
				data : {
					register_username : register_username,
					register_password : register_password,
					register_school : register_school,
					register_phone : register_phone
				},
				url : "../reg.do",
				type : "POST",
				async : true, //是否为异步请求
				cache : false, //是否缓存结果
				success : function(data) {
					var jsonData = JSON.parse(data);
					if (jsonData.status == 200) {
						alert(jsonData.msg);
						setValNull()
						$("#register").modal("hide");
					} else {
						alert(jsonData.msg);
					}
				}
			})
		}
	}
		
		

	});


});
function setValNull(){
	$("#register_username").val("");
	$("#register_password").val("");
	$("#register_phone").val("");
	$("#register_school").text("请选择学校");
	
	$("#captcha").val("");
}

//报名招聘
$("#sign_up").click(function(){
	
	var uid =$("#sessionUid").text().trim();
	var oid = $("#sessionOid").text().trim();
	console.log(uid,oid);
	$.ajax({
	url:"signup.do",
	data:{
		uid:uid,
		oid:oid
	},
	type:"POST",
	success:function(data){
		var jsonData=JSON.parse(unescape(data));
		alert(jsonData.msg);
		if(jsonData.data==1){
			
			$("#conter_user_info").css("display","none");
			$("#contern_login").css("display","block");
			$("#contern_register").css("display","block");
			$("#login").modal();
		}else{
			
		}
		
	}
})
});
$(function(){
	$.ajax({
		data:{
			op:"getschool"
		},
		url:"../reg.do",
			type:"POST",
			success:function(data){
				var jsonData = JSON.parse(unescape(data));
				$("#register_school").empty();
				if(jsonData.length>0){
					$("#register_school").append("<option data-hidden='true' value='无' disable>请选择学校</option>")
					for(var i=0;i<jsonData.length;i++){
						$("#register_school").append("<option>"+jsonData[i].sname+"</option>")
					}
					}else{
						alert("没有查找到数据");
					}
				}
			
	})
})
//注销
$("#logout").click(function(){
		$.ajax({
		url:"logout.do",
		type:"POST",
		success:function(data){
			var jsonData=JSON.parse(unescape(data));
			alert(jsonData.msg);
			if(data != 400){
				$("#navbar").load(location.href + " #navbar");
			}else{
				
			}
		}
	})
});


