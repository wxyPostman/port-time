$(function() {


	$("#btn_Rel").click(function() {
		$("#rel_title").val("");
		$("#rel_recuritnum").val("");
		$("#rel_salary").val("");
		$("#rel_sname option[text='请选择学校']").attr("selected", true)
		$("#rel_pname option[text='请选择兼职种类']").attr("selected", true)
		$("#rel_paymethod option[text='请选择支付方式']").attr("selected", true)

		$("#rel_description").val("");
		$('#btn_DefineRel').show();
		$('#btn_ModifyRel').attr("style", "display:none;");
	})


	$("#userinfo_change_btn").click(function() {
		var input_new_pwd = $("#input_new_pwd").val();
		var input_new_pwd1 = $("#input_new_pwd1").val();
		var password = $("#input_change_pwd").val();
		var uid = $("#input_uid").val();
		$.ajax({
			data : {
				uid : uid,
				password : password,
				input_new_pwd : input_new_pwd,
				input_new_pwd1 : input_new_pwd1
			},
			url : "../changepwd.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
				alert(jsonData.msg);
				if (jsonData.status != 400) {
					$("#change_userinfo").modal('hide');
				}
			}
		})
	})

	$("#btn_DefineRel").click(function() {
		var rel_title = $("#rel_title").val();
		var rel_recuritnum = $("#rel_recuritnum").val();
		var rel_salary = $("#rel_salary").val();
		var rel_sname = $("#rel_sname").val();
		var rel_pname = $("#rel_pname").val();
		var rel_paymethod = $("#rel_paymethod").val();
		var rel_description = $("#rel_description").val();
		var uid = $("#rel_uid").val();

		console.log(uid, rel_title, rel_recuritnum, rel_salary, rel_sname, rel_pname, rel_paymethod, rel_description);
		$.ajax({
			data : {
				rel_title : rel_title,
				rel_recuritnum : rel_recuritnum,
				rel_salary : rel_salary,
				rel_sname : rel_sname,
				rel_pname : rel_pname,
				rel_paymethod : rel_paymethod,
				rel_description : rel_description,
				uid : uid,
				op : "save"
			},
			url : "myrel.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
				alert(jsonData.msg);
				if (jsonData.status != 400) {
					//模态框隐藏
					$("#ios_release_modal").modal('hide');
					$("#release").load(location.href + " #release");
				}
			}
		})
	})

	$("#btn_ModifyRel").click(function() {
		var rel_title = $("#rel_title").val();
		var rel_recuritnum = $("#rel_recuritnum").val();
		var rel_salary = $("#rel_salary").val();
		var rel_sname = $("#rel_sname").val();
		var rel_pname = $("#rel_pname").val();
		var rel_paymethod = $("#rel_paymethod").val();
		var rel_description = $("#rel_description").val();
		var uid = $("#rel_uid").val();
		var oid = $("#rel_oid").val();

		console.log(uid, rel_title, rel_recuritnum, rel_salary, rel_sname, rel_pname, rel_paymethod, rel_description, oid);
		$.ajax({
			data : {
				rel_title : rel_title,
				rel_recuritnum : rel_recuritnum,
				rel_salary : rel_salary,
				rel_sname : rel_sname,
				rel_pname : rel_pname,
				rel_paymethod : rel_paymethod,
				rel_description : rel_description,
				uid : uid,
				oid : oid,
				op : "modify"
			},
			url : "myrel.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
				alert(jsonData.msg);
				if (jsonData.status != 400) {
					$("#rel_title").val("");
					$("#rel_recuritnum").val("");
					$("#rel_salary").val("");
					$("#rel_sname option[text='请选择学校']").attr("selected", true)
					$("#rel_pname option[text='请选择兼职种类']").attr("selected", true)
					$("#rel_paymethod option[text='请选择支付方式']").attr("selected", true)
					$("#rel_description").val("");
					//模态框隐藏
					$("#ios_release_modal").modal('hide');
					//局部隐藏
					$("#release").load(location.href + " #release");
				}
			}
		})
	})

	$("#starI").mouseover(function() {
		for (let i = 0; i < $("#starI i").length; i++) {
			//console.log($("#starI i")[i]);
			
			$("#starI i")[i].onclick = function() {
				var s =i+1;
				$("#starNum").text(s);
				for (let j = 0; j < $("#starI i").length; j++) {
					$("#starI i")[j].classList.remove("controllerStarColor");
				}
				for (let k = 0; k < i+1; k++) {
					$("#starI i")[k].classList.add("controllerStarColor");
				}
				
			}

		}
	});
	
	$("#btn_score").click(function(){
		var id =$("#id").text().trim();
		var score =$("#starNum").text().trim();
		var oid =$("#oid").text().trim();
		if(confirm("确定打"+score+"分吗?")){
			$.ajax({
				data : {
					id : id,
					oid : oid,
					score:score,
					op : "score"
				},
				url : "myrel.do",
				type : "POST",
				success : function(data) {
					var jsonData = JSON.parse(unescape(data));
					alert(jsonData.msg);
					if (jsonData.status != 400) {
						
						//模态框隐藏
						$("#score").modal('hide');
						//局部刷新
						$("#receive").load(location.href + " #receive");
					}
				}
			})
		}
	})
})

function star(e){
	//得到当前所在行
		var rows = e.parentNode.parentNode.rowIndex;
		//得到所在行的第一列的内容
		var id = $("#myrec tr:eq(" + rows + ") td:eq(0)").html();
		var oid = $("#myrec tr:eq(" + rows + ") td:eq(8)").html();
		console.log(id,oid);
		$("#oid").text(oid);
		$("#id").text(id);
}

function delRel(e) {

	//得到当前所在行
	var rows = e.parentNode.parentNode.rowIndex;
	//得到所在行的第一列的内容
	var oid = $("#myrel tr:eq(" + rows + ") td:eq(0)").html()
	var con = confirm("确定删除?");
	if (con == true) {
		$.ajax({
			data : {
				oid : oid,
				op : "delrel"
			},
			url : "myrel.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
				alert(jsonData.msg);
				//局部刷新
				$("#release").load(location.href + " #release");


			}
		})
	}
}

function delRec(e) {
	//得到当前所在行
	var rows = e.parentNode.parentNode.rowIndex;
	var id = $("#myrec tr:eq(" + rows + ") td:eq(0)").html();
	var con = confirm("确定删除?");
	if (con == true) {
		$.ajax({
			data : {
				id : id,
				op : "delrec"
			},
			url : "myrel.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
				alert(jsonData.msg);
				//局部刷新
				$("#receive").load(location.href + " #receive");


			}
		})
	}
}

function admit(e) {
	//得到当前所在行
	var rows = e.parentNode.parentNode.rowIndex;
	var id = $("#myrelrec tr:eq(" + rows + ") td:eq(0)").html();
	var con = confirm("确定录取?");
	if (con == true) {
		$.ajax({
			data : {
				id : id,
				op : "admit"
			},
			url : "myrel.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
				alert(jsonData.msg);
				//局部刷新
				$("#recOrd").load(location.href + " #recOrd");


			}
		})
	}
}
$(function() {
	$.ajax({
		data : {
			op : "getschool"
		},
		url : "../reg.do",
		type : "POST",
		success : function(data) {
			var jsonData = JSON.parse(unescape(data));
			$("#rel_sname").empty();
			if (jsonData.length > 0) {
				$("#rel_sname").append("<option data-hidden='true' value='无' disable>请选择学校</option>")
				for (var i = 0; i < jsonData.length; i++) {
					$("#rel_sname").append("<option>" + jsonData[i].sname + "</option>")
				}
			} else {
				alert("没有查找到数据");
			}
		}
	})
})
$(function() {
	$.ajax({
		data : {
			op : "getposition"
		},
		url : "../reg.do",
		type : "POST",
		success : function(data) {
			var jsonData = JSON.parse(unescape(data));
			$("#rel_pname").empty();
			if (jsonData.length > 0) {
				$("#rel_pname").append("<option data-hidden='true' value='无' disable>类型</option>")
				for (var i = 0; i < jsonData.length; i++) {
					$("#rel_pname").append("<option>" + jsonData[i].pname + "</option>")
				}
			} else {
				alert("没有查找到数据");
			}
		}
	})
})
function refuse(e) {
	//得到当前所在行
	var rows = e.parentNode.parentNode.rowIndex;
	var id = $("#myrelrec tr:eq(" + rows + ") td:eq(0)").html();
	var con = confirm("确定拒绝?");
	if (con == true) {
		$.ajax({
			data : {
				id : id,
				op : "refuse"
			},
			url : "myrel.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
				alert(jsonData.msg);
				//局部刷新
				$("#recOrd").load(location.href + " #recOrd");
			}
		})
	}
}
function success(e) {
	//得到当前所在行
	var rows = e.parentNode.parentNode.rowIndex;
	var id = $("#myrelrec tr:eq(" + rows + ") td:eq(0)").html();
	var con = confirm("确定该单已完成?");
	if (con == true) {
		$.ajax({
			data : {
				id : id,
				op : "success"
			},
			url : "myrel.do",
			type : "POST",
			success : function(data) {
				//					var jsonData=JSON.parse(unescape(data));		
				//					alert(jsonData.msg);
				//局部刷新
				$("#recOrd").load(location.href + " #recOrd");
			}
		})
	}
}



function score(e) {
	//得到当前所在行
	var rows = e.parentNode.parentNode.rowIndex;
	var id = $("#myrec tr:eq(" + rows + ") td:eq(0)").html();
}
function modifyRel(e) {

	//得到当前所在行
	var rows = e.parentNode.parentNode.rowIndex;
	//得到所在行的第一列的内容
	$("#rel_oid").val($("#myrel tr:eq(" + rows + ") td:eq(0)").html());
	$("#rel_title").val($("#myrel tr:eq(" + rows + ") td:eq(1)").html());
	$("#rel_recuritnum").val($("#myrel tr:eq(" + rows + ") td:eq(3)").html());
	$("#rel_salary").val($("#myrel tr:eq(" + rows + ") td:eq(2)").html());
	$("#rel_sname option[value=" + $("#myrel tr:eq(" + rows + ") td:eq(4)").html() + "]").attr("selected", true);
	$("#rel_pname option[value=" + $("#myrel tr:eq(" + rows + ") td:eq(6)").html() + "]").attr("selected", true);
	$("#rel_paymethod option[value=" + $("#myrel tr:eq(" + rows + ") td:eq(7)").html() + "]").attr("selected", true);
	$("#rel_description").val($("#myrel tr:eq(" + rows + ") td:eq(8)").html());

	$('#btn_DefineRel').attr("style", "display:none;");
	$('#btn_ModifyRel').show();
}