<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>
			CampusPT
		</title>
		<link rel="shortcut icon" href="http://oqlse9rck.bkt.clouddn.com/favicon.ico">
		<link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="css/userinfo.css" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
		<script src="js/jquery.raty.js" type="text/javascript"></script>
		
	</head>

	<body>
		<!--导航-->
		<nav class=" userinfo_nav navbar navbar-default nav-scroll navbar-fixed-top">
			<div class="container">
				<!--导航左半部分-->
				<div class="navbar-header">
					<!--手机模式导航按钮-->
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">
                        C&nbsp;a&nbsp;m&nbsp;p&nbsp;u&nbsp;s&nbsp;P&nbsp;T
                    </span>
                    <span class="icon-bar">
                    </span>
                    <span class="icon-bar">
                    </span>
                    <span class="icon-bar">
                    </span>
                </button>
					<!--logo-->
					<a class="navbar-brand" href="index.jsp"></a>
				</div>
				<!--导航右半部分-->
				<div id="navbar" class="clearfix navbar-collapse userinfo_nav_ul collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="userinfo_border">
							<a href="index.jsp">
								首页
							</a>
						</li>
						<li class="userinfo_border">
							<a href="allreleaseorders.do">
								全职
							</a>
						</li>
						<li class="userinfo_border">
							<a href="about.jsp" target="_blank">
								关于我们
							</a>
						</li>
						<!--登录成功后显示的个人信息下拉菜单-->
						<li class="dropdown" id="conter_user_info">
							<span>
								您好,  ${sessionScope.user.username }
							</span>

							<a href="logout.do?op=logout_user">
								&nbsp;退出
							</a>
						</li>
					</ul>
				</div>
				<!-- /.nav-collapse -->
			</div>
		</nav>
		<div class="container-fluid margin-top-50">
			<div class="row">
				<div class="col-xs-12 col-sm-12 bgcolor text-center">
					<div class="userinfo_header_img_box">
						<div class="userinfo_header_img">
							<img src="images/userimg.jpg" />
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="userinfo_title">
					<h3>
					个人中心
				</h3>
					<hr />
				</div>
				<div class="userinfo_left_tab col-xs-12 col-sm-3 ">
					<ul id="myTab" class="nav nav-tabs  nav-stacked">
						<li class="active">
							<a href="#userinfo_centent" data-toggle="tab">
								<i class="fa fa-user-circle-o" aria-hidden="true"></i>
								<span>
								&nbsp;&nbsp;基本信息
								</span>
							</a>
						</li>
						<li>
							<a href="#release" data-toggle="tab">
								<i class="fa fa-commenting" aria-hidden="true"></i>
								<span>
								&nbsp;我的发布
								</span>
							</a>
						</li>
						<li>
							<a href="#recOrd" data-toggle="tab">
								<i class="fa fa-commenting" aria-hidden="true"></i>
								<span>
								&nbsp;收到的报名
								</span>
							</a>
						</li>
						<li>
							<a href="#receive" data-toggle="tab">
								<i class="fa fa-check-circle-o" aria-hidden="true"></i>
								<span>
								&nbsp;我的报名
								</span>
							</a>
						</li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-9 ">
					<div id="myTabContent" class="tab-content">
						<!--基本信息选项卡-->
						<div class="tab-pane fade in active" id="userinfo_centent">
							<table class="table table-hover userinfo_table">
								<tbody>
									<tr>
										<th>
											用户名
										</th>
										<td>
											 ${sessionScope.user.username }
										</td>
									</tr>
									
									<tr>
										<th>
											手机号码
										</th>
										<td>
											 ${sessionScope.user.phone }
										</td>
									</tr>
									<tr>
										<th>
											学校
										</th>
										<td>
											 ${sessionScope.user.school.sname }
										</td>
									</tr>
									
									<tr class="text-right userinfo_change">
										<th>

										</th>
										<td>
											<button class="btn btn-info" data-toggle="modal" data-target="#change_userinfo">修改密码</button>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						<!--我的发布信息选项卡-->
						<div class="tab-pane fade in" id="release">
							<p class="list-group-item active ">
								已发布招聘
								
								<input type="button" class="btn btn-info pull-right" value="发布招聘" data-toggle="modal" data-target="#ios_release_modal"  id="btn_Rel"/></p>
							<table class="table table-hover table_release table-bordered " id="myrel">

								<tr>
									<th>订单编号</th>
									<th>招聘标题</th>
									<th>招聘薪资</th>
									<th>招聘人数</th>
									<th>学校</th>
									<th>发布日期</th>
									<th>兼职种类</th>
									<th>支付方式</th>
									
									<th>操作</th>
									
									
								</tr>
								
									<c:forEach items="${relOList }" var="order">
										<tr>
											<td>${order.oid }</td>
	                      				 	<td>${order.title }</td>
											<td>${order.salary }</td>
											<td>${order.recruitNum }</td>
											<td>${order.school.sname }</td>
											<td>${order.releaseTime }</td>
											<td>${order.position.pname}</td>
											<td>${order.payMethod }</td>
											<td style="display:none">${order.description }</td>
											
											<td><input type="button" class="btn btn-danger btn-sm" value="取消"  onclick="delRel(this)"/></td>
	  										
	  									</tr>	
  									</c:forEach>
									
								
								
							</table>
								</br></br></br>	</br>	
						</div>
						<!--我收到的报名信息选项卡-->
						<div class="tab-pane fade in" id="recOrd">
							<p class="list-group-item active ">
								收到的报名
								
								
							<table class="table table-hover table_release table-bordered " id="myrelrec">

								<tr>
									<th>订单编号</th>
									<th>订单标题</th>
									<th>接单人姓名</th>
									<th>报名时间</th>
									<th>接单人手机号</th>
									<th>状态</th>						
									<th>操作</th>
									<th>操作</th>
									
									
								</tr>
								
									<c:forEach items="${relRecOList }" var="order">
										<tr>
											<td style="display:none">${order.id }</td>
											<td>${order.releaseOrders.oid }</td>
	                      				 	<td>${order.releaseOrders.title }</td>
											<td>${order.user.username }</td>
											<td>${order.receiveTime}</td>
											<td>${order.user.phone }</td>
											<c:if test="${order.status==0 }">
											<td>等待处理</td>
											<td><input type="button" class="btn btn-warning btn-sm"  value="录取"  onclick="admit(this)"/></td>
											<td><input type="button" class="btn btn-danger btn-sm" value="拒绝"  onclick="refuse(this)"/></td>
											</c:if>
											<c:if test="${order.status==1 }">
											<td>已录取</td>
											<td><input type="button" class="btn btn-warning btn-sm"  value="完成"  onclick="success(this)"/></td>
											<td></td>
											</c:if>
											<c:if test="${order.status==2 }">
											<td>已拒绝</td>
											<td></td>
											<td></td>
											</c:if>
											<c:if test="${order.status==3 }">
											<td>已完成</td>
											<td></td>
											<td></td>
											</c:if>
	  										
	  									</tr>	
  									</c:forEach>
									
								
								
							</table>
								</br></br></br>	</br>	
						</div>	
						
						<!--我的报名信息选项卡-->
						<div class="tab-pane fade in" id="receive">
							<p class="list-group-item active">
								已报名招聘
							</p>
							<table class="table table-hover table_receive table-bordered " id="myrec">

								<tr>
									<th>编号</th>
									<th>标题</th>
									<th>所在学校</th>
									<th>招聘人数</th>
									<th>招聘薪资</th>
									<th>支付方式</th>
									<th>发布时间</th>								
									<th>发布人</th>	
									<th>状态</th>								
									<th>操作</th>
									
								</tr>
								<tr>
									<c:forEach items="${recOList }" var="order">
										<tr>
											<td>${order.id }</td>
	                      				 	<td>${order.releaseOrders.title }</td>
	                      				 	<td>${order.releaseOrders.school.sname }</td>
	                      				 	<td>${order.releaseOrders.recruitNum }人</td>
											<td>${order.releaseOrders.salary }元</td>
											<td>${order.releaseOrders.payMethod }</td>	
											<td>${order.releaseOrders.releaseTime }</td>
											<td>${order.releaseOrders.user.username }</td>
											<td style="display:none">${order.releaseOrders.oid }</td>
											<c:if test="${order.status==0 }">
												<td>等待录取</td>
												<td><input type="button" class="btn btn-danger btn-sm" value="取消" onclick="delRec(this)"/></td>
											</c:if>
											<c:if test="${order.status==1 }">
												<td>已被录取</td>
												<td><input type="button" class="btn btn-danger btn-sm" value="取消" onclick="delRec(this)"/></td>
											</c:if>
											<c:if test="${order.status==2 }">
												<td>已被拒绝</td>
												<td><input type="button" class="btn btn-danger btn-sm" value="取消" onclick="delRec(this)"/></td>
											</c:if>
											<c:if test="${order.status==3 }">
												<td>已完成</td>
												<td><input type="button" class="btn btn-warning btn-sm" value="评分" onclick="star(this)" data-toggle="modal" data-target="#score"/></td>
											</c:if>
											<c:if test="${order.status==4 }">
												<td>已评分</td>
												<td><input type="button" class="btn btn-danger btn-sm" value="取消" onclick="delRec(this)"/></td>
											</c:if>
											
											
											
	  									</tr>	
  									</c:forEach>
									
								
							</table>
							</br></br></br></br>
						</div>
					</div>
				</div>

							
			</div>
		</div>

		<!-- login模态框 -->
		<div class="modal fade" id="change_userinfo" role="dialog">
			<div class="modal-dialog modal-sm min_width" role="document">
				<!--弹框——登录-->
				<div class="modal-content" id="first">
					<div class="modal-header">
						<!--关闭按钮-->
						<button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">
                            &times;
                        </span>
                    </button>
						<!--标题-->
						<h5 class="modal-title">
                       	 密码修改
                    </h5>
					</div>
					<div class="modal-body">
						<!--User name-->
						<div class="input-wrapper">
							<input type="hidden"  id="input_uid" value="${sessionScope.user.uid}"/>
							<!--Error message-->
                        <span class="animated fadeInRight register-username-wrong register_tips" id="chaneg_pwd_tip">
                           
                        </span>
						<div class="input-wrapper">
							<input type="password" placeholder="原密码" id="input_change_pwd"/>
							<!--Error message-->
                        <span class="animated fadeInRight register-username-wrong register_tips" id="change_pwd_tip">
                           
                        </span>
						</div>
						<div class="input-wrapper">
							<input type="password" placeholder="新密码" id="input_new_pwd"/>
							<!--Error message-->
							<span class="animated fadeInRight register-username-wrong register_tips" id="new_pwd_tip">
                           
                       		 </span>
						</div>
						<div class="input-wrapper">
							<input type="password" placeholder="确认密码" id="input_new_pwd1"/>
							<!--Error message-->
							<span class="animated fadeInRight register-username-wrong register_tips" id="new_pwd1_tip">
                           
                       		 </span>
						</div>
						
					</div>
					<div class="modal-footer">
						<button  type="button" class="btn btn-primary btn-block" id="userinfo_change_btn">
                        	确定
                    	</button>
					</div>
				</div>
			</div>
		</div>
</div>
		<!--release发布模态框-->
		<div class="modal fade" id="ios_release_modal" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="modal_title" >发布招聘</h4>
					</div>
					<div class="modal-body" >
						<div class="release_title">
						<input type="hidden" value="${order.oid }"   id="rel_oid" />
						</div>
						<div class="release_title">
						<input type="hidden" value="${sessionScope.user.uid }"   id="rel_uid" />
						</div>
						<div class="release_title">
						<input type="text" placeholder="  标题"  id="rel_title" />
						</div>
						<div class="release_rec_num">
							<input type="text" placeholder="招聘人数" id="rel_recuritnum" />
						</div>
						<div class="release_salary">
							<input type="text" placeholder="招聘薪资" id="rel_salary"/>
						</div>
						<div class="release_sid_fropdown">
        <!--这个是个多选框，用onchange事件的时候 ，将这个select的id传进去-->
               <select name="trains"  class="form-control" id="rel_sname">
               </select>
						</div>
						<div class="release_pid_fropdown">
        <!--这个是个多选框，用onchange事件的时候 ，将这个select的id传进去-->
               <select name="trains"  class="form-control" id="rel_pname">
               </select>
						</div>
						<div class="release_pay">
							<select name="trains"  class="form-control" id="rel_paymethod">
                   <option value="无">请选择支付方式</option>
                   <option value="月结">月结</option>
                   <option value="日结">日结</option>
                   <option value="完工结">完工结</option>
               </select>
						</div>
						<div class="release_descrip">
							<textarea placeholder="订单描述" id="rel_description"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary" id="btn_DefineRel">确定发布</button>
						<button type=button  style="display:none" class="btn btn-primary" id="btn_ModifyRel">确定修改</button>
					</div>
				</div>
			</div>

		</div>


		<div class="modal fade" id="score" role="dialog">
			<div class="modal-dialog modal-sm min_width" role="document">
				<!--弹框——评分-->
				<div class="modal-content" id="first">
					<div class="modal-header">
						<!--关闭按钮-->
						<button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">
                            &times;
                        </span>
                    </button>
						<!--标题-->
						<h5 class="modal-title">
                       	评分
                    </h5>
					</div>
						<div class="modal-body">
						<!--Star-->
						<div class="input-wrapper starI" id="starI">
								<span id="id" style="display:none" >1</span>
								<span id="oid" style="display:none" >2</span>
								<span id="starNum" style="display:none" >3</span>
        						<i style="font-size:32px; line-height:80px;" class="fa fa-star" aria-hidden="true"></i>
		        				<i style="font-size:32px;" class="fa fa-star" aria-hidden="true"></i>
		    				    <i style="font-size:32px;" class="fa fa-star" aria-hidden="true"></i>
     						  	<i style="font-size:32px;" class="fa fa-star" aria-hidden="true"></i>
      							<i style="font-size:32px;" class="fa fa-star" aria-hidden="true"></i>
						</div>
						<div class="modal-footer">
						<button  type="button" id="btn_score" class="btn btn-primary btn-block" id="userinfo_change_btn">
                        	确定
                    	</button>
					</div>
						
					</div>
				</div>
			
			
			</div>
		</div>
		<script src="js/TothingWay.js"></script>
		<script src="js/login_register.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/userinfo.js" type="text/javascript" charset="utf-8"></script>
		
		
	</body>

</html>