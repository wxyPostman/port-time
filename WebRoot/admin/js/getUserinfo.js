$("#username").keypress(function(event) {
	var keynum = (event.keyCode ? event.keyCode : event.which);
	if (keynum == '13') {
		var username = $("#username").val();
		$.ajax({
			data : {
				username : username,
				op:"alluser"
			},
			url : "admin.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
			
				$("#userinfo_total").empty();
				
				if(jsonData.length>0){
					$("#userinfo_total").append(
						"<tr><th>用户名</th>"+
						"<th>电话号码</th>"+
						"<th>所在学校</th>"+
						"<th>评分</th>"+
						"<th>操作</th>"+
						"</tr>"
					);
					for(let i=0;i<jsonData.length;i++){
						$("#userinfo_total").append(
								"<tr>" +
								"<td>"+jsonData[i].username +"</td>" +
								"<td>"+jsonData[i].phone +"</td>" +
								"<td>"+jsonData[i].school.sname +"</td>" +
								"<td>"+(parseFloat(jsonData[i].totalScore)/parseFloat(jsonData[i].appraiseNum)).toFixed(1) +"</td>" +
								"<td><button class='btn btn-danger' onclick=deleteUser("+ jsonData[i].uid +")>"+ "删除" +"</button></td>" +
								+"</tr>"
							)
					}
				}else{
					alert("没有查找到数据");
				}
			}
		})
	}


});
function deleteUser(t) {
	if(confirm("确定要删除该用户?慎重！！!")){
		$.ajax({
			data : {
				uid : t,
				op:"delUser"
			},
			url : "admin.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.status == 200) {
					alert(jsonData.msg);
					location.reload();
				} else {
					alert(jsonData.msg);
					location.reload();
				}
			}
		})
	}
	
}

$(function(){
	$.ajax({
		data:{
			op:"alluser"
		},
		url : "admin.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(unescape(data));
				$("#userinfo_total").empty();
				
				if(jsonData.length>0){
					$("#userinfo_total").append(
						"<tr><th>用户名</th>"+
						"<th>电话号码</th>"+
						"<th>所在学校</th>"+
						"<th>评分</th>"+
						"<th>操作</th>"+
						"</tr>"
					);
					for(let i=0;i<jsonData.length;i++){
						$("#userinfo_total").append(
								"<tr>" +
								"<td>"+jsonData[i].username +"</td>" +
								"<td>"+jsonData[i].phone +"</td>" +
								"<td>"+jsonData[i].school.sname +"</td>" +
								"<td>"+ Number(parseFloat(jsonData[i].totalScore)/parseFloat(jsonData[i].appraiseNum)).toFixed(1) +"</td>" +
								"<td><button class='btn btn-danger' onclick=deleteUser("+ jsonData[i].uid +")>"+ "删除" +"</button></td>" +
								+"</tr>"
							)
					}
				}else{
					alert("没有查找到数据");
				}
			}
	})
})
$(function(){
	$.ajax({
		data:{
			op:"allposition"
		},
		url:"admin.do",
		type:"POST",
		success:function(data){
			var jsonData = JSON.parse(unescape(data));
			$("#partTimeType_total").empty();
			if(jsonData.length>0){
				$("#partTimeType_total").append("<tr><th>类型</th>"+
						"<th>操作</th></tr>");
				for(var i=0;i<jsonData.length;i++){
					$("#partTimeType_total").append("<tr><th>"+ jsonData[i].pname+"</th>"+
					"<th><button class='btn btn-danger' onclick=deletePosition("+ jsonData[i].pid +")>"+ "删除" +"</button></th></tr>");
					}
				}else{
					alert("没有查找到数据");
				}
		}
	})
}) 
function deletePosition(pid){
	$.ajax({
		data : {
			pid : pid,
			op:"allposition"
		},
		url : "admin.do",
		type : "POST",
		success : function(data) {
			var jsonData = JSON.parse(data);
			if (jsonData.status == 200) {
				alert(jsonData.msg);
				location.reload();
			} else {
				alert(jsonData.msg);
				location.reload();
			}
		}
	})
}
$("#position_btn").click(function(){
	var pname=$("#add_position_input").val();
	$.ajax({
		data:{
			pname:pname,
			op:"allposition"
		},
		url : "admin.do",
		type : "POST",
		success : function(data) {
			var jsonData = JSON.parse(data);
			if (jsonData.status == 200) {
				alert(jsonData.msg);
				location.reload();
			} else {
				alert(jsonData.msg);
				location.reload();
			}
		}
	})
})
function deleteEmpl(a) {
	if(confirm("确认删除吗？")){
		$.ajax({
			data : {
				sid : a,
				op:"delSchool"
			},
			url : "admin.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.status == 200) {
					alert(jsonData.msg);
					location.reload();
				} else {
					alert(jsonData.msg);
					location.reload();

				}
			}
		})
	}
	
}

$(function(){
	$.ajax({
		data:{
			op:"allSchool"
		},
		url:"admin.do",
		type:"POST",
		success:function(data){
			var jsonData = JSON.parse(unescape(data));
			$("#school_total").empty();
			if(jsonData.length>0){
				$("#school_total").append("<tr><th>学校</th>"+
						"<th>操作</th></tr>");
				for(var i=0;i<jsonData.length;i++){
					$("#school_total").append("<tr><th>"+ jsonData[i].sname+"</th>"+
					"<th><button class='btn btn-danger' onclick=deleteEmpl("+ jsonData[i].sid +")>"+ "删除" +"</button></th></tr>");
					}
				}else{
					alert("没有查找到数据");
				}
		}
	})
}) 
	$("#save-school").click(function() {
		var sname = $("#add_school_input").val();
		$.ajax({
			data : {
				sname : sname,
				op:"saveSchool"
			},
			url : "admin.do",
			type : "POST",
			success : function(data) {
				var jsonData = JSON.parse(data);
				if (jsonData.status == 200) {
					alert(jsonData.msg);
					snamenull();
					$("#addSchool").modal('hide');
					location.reload();
				} else {
					alert(jsonData.msg);
					snamenull();
					location.reload();
				}
			}
		})
	})

$(function(){
	$.ajax({
		data:{
			op:"allOrders"
		},
		url:"admin.do",
		type:"POST",
		success:function(data){
			var jsonData = JSON.parse(unescape(data));
			$("#orders_total").empty();
			if(jsonData.length>0){
				$("#orders_total").append("<tr><th>发单人</th>"+
										"<th>标题</th>"+
										"<th>描述</th>"+
										"<th>发布时间</th>"+
										"<th>薪资</th>"+
										"<th>操作</th></tr>");
				for(var i=0;i<jsonData.length;i++){
					$("#orders_total").append("<tr><th>"+ jsonData[i].user.username+"</th>"+
							"<th>"+ jsonData[i].title+"</th>"+
							"<th>"+ jsonData[i].description+"</th>"+
							"<th>"+ jsonData[i].releaseTime+"</th>"+
							"<th>"+ jsonData[i].salary+"</th>"+
					"<th><button class='btn btn-danger' onclick=deleteOrders("+ jsonData[i].oid +")>"+ "删除" +"</button></th></tr>");
					}
				}else{
					alert("没有查找到数据");
				}
		}
	})
}) 
function deleteOrders(oid) {
	$.ajax({
		data : {
			oid : oid,
			op:"allOrders"
		},
		url : "admin.do",
		type : "POST",
		success : function(data) {
			var jsonData = JSON.parse(data);
			if (jsonData.status == 200) {
				alert(jsonData.msg);
				location.reload();
			} else {
				alert(jsonData.msg);
				location.reload();
			}
		}
	})
}