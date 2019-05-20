<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>CampusPT</title>
<link rel="shortcut icon"
	href="http://oqlse9rck.bkt.clouddn.com/favicon.ico">
<link href="css/TothingWay.css" rel="stylesheet" />
<link href="css/forum.css" rel="stylesheet" />
<link rel="stylesheet" href="css/update.css" />
<link rel="stylesheet" href="css/storceInfo.css" />
<link rel="stylesheet" href="css/login_register.css" />
</head>

<body>
	<!--导航-->
	<nav class="navbar navbar-default nav-scroll navbar-fixed-top">
		<div class="container">
			<!--导航左半部分-->
			<div class="navbar-header">
				<!--手机模式导航按钮-->
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only"> CampusPT </span> <span class="icon-bar">
					</span> <span class="icon-bar"> </span> <span class="icon-bar"> </span>
				</button>
				<!--logo-->
				<a class="navbar-brand" href="index.jsp"></a>
			</div>
			<!--导航右半部分-->
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.jsp"> 首页 </a></li>
					<li><a href="allreleaseorders.do"> 全职 </a></li>
					<li><a href="about.jsp" target="_blank"> 关于我们 </a>
					<li class="dropdown" id="contern_login"><a href="#"
						data-toggle="modal" data-target="#login"> 登录 </a></li>
					<li class="register" id="contern_register"><a href="#"
						data-toggle="modal" data-target="#register"> 注册 </a></li>
					<!--登录成功后显示的个人信息下拉菜单-->
					<li class="dropdown" id="conter_user_info"><a href="#"
						class="dropdown-toggle " data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false"> <span
							id="success_username"> </span> <span class="caret"> </span>
					</a>
						<ul class="dropdown-menu">
							<li style="display:none" id="sessionUid">
								${sessionScope.user.uid }</li>
							<li><a href="userinfo.do?uid=${sessionScope.user.uid }">
									个人中心 </a></li>
							<li><a href="logout.do?op=logout_user"> 注销 </a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.nav-collapse -->
		</div>
	</nav>


	<!--banner-->
	<div class="cover">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<h1>为努力工作的你</h1>
				</div>
			</div>
			<!--/.row-->
		</div>
		<!--/.cover-->
	</div>

	<!--副导航-->
	<ul class="nav-tab">
		<li class="active"><a href="#exchange" data-toggle="tab"
			class="exchange"> 招聘信息 </a></li>
	</ul>
	<!--副导航对应内容-->
	<div class="tab-content">
		<!--对应副导航技术交流部分-->
		<div role="tabpanel" class="tab-pane fade in active" id="exchange">
			<div class="container">
				<div class="row">
					<!--技术交流左部分-->
					<div class="col-xs-12 col-sm-8">
						<!--技术交流内容部分-->
						<div class="content-m">
							<div class="post-head">
								<h1>
									<a href="#" class="company"> ${rOrder.title} </a>
								</h1>
								<!--                          <div class="post-meta">
                                    <span class="people">
                                        发布人:  ${rOrder.user.username}             ${rOrder.releaseTime }
                                    </span> 
                                </div>		-->
							</div>

							<div class="middle-inf">
								<span class="money"> ${rOrder.salary } </span> <span>
									&nbsp;&nbsp;&nbsp;&nbsp; ${rOrder.payMethod }&nbsp; |&nbsp; </span> <span
									class="number"> ${rOrder.position.pname } &nbsp; |
									&nbsp;${rOrder.recruitNum } 人 </span>
							</div>

							<div class="clearfix">
								<c:if test="${rOrder.user.uid==sessionScope.user.uid }">
									<button class="list_btn btn " disabled="disabled"
										style="cursor: not-allowed;background-color: #e7e7e7;  color: #999; ">
										报名参加</button>
								</c:if>
								<c:if test="${rOrder.user.uid!=sessionScope.user.uid }">
									<button class="list_btn btn " id="sign_up">报名参加</button>
								</c:if>
							</div>
						</div>
						<div class="content-m">${rOrder.description }</div>

						<div class="content-m">
							<div class="title-m">
								<h4>工作地点</h4>
								<hr />
								<div class="work_address">${rOrder.school.sname }</div>
							</div>
						</div>
					</div>
					<!--技术交流右部分-->
					<div class="col-xs-12 col-sm-4">
						<!--公告-->
						<div class="content-r">
							<h4>发布信息</h4>
							<div class="work_user ">
								<div class="notice_img">
									<img src="images/company_default.png" alt="aa">
								</div>
								<div class="work_user_notice">
									<div style="display:none;" class="information">
										<span style="display:none;" class="fc">编号：</span> <span
											style="display:none;" id="sessionOid">${rOrder.oid }</span>
									</div>
									<div class="information">
										<span class="fc">发布人：</span> <span id="fm">${rOrder.user.username }</span>
									</div>
									<div class="information">
										<span class="fc">发布事件：</span> <span id="fn">${rOrder.releaseTime }</span>
									</div>
									<div class="information">
										<span class="fc"> 联系方式：</span> <span id="fb">${rOrder.user.phone }</span>
									</div>
								</div>
							</div>
							<div class="text-center">
								<a href="store.do?uid=${rOrder.user.uid }"
									class="more_information">查看该用户全部信息 &gt;</a>
							</div>

						</div>
					</div>
				</div>
				<!--/.row-->
			</div>
			<!--/.container-->
		</div>
	</div>
	<!--/.tab-content-->

	<div class="footer">Copyright © 2019 CampusPT All rights
		reserved.</div>

	<!-- register -->
	<div class="modal fade" id="register" role="dialog">
		<div class="modal-dialog modal-sm min_width" role="document">
			<!--弹框——注册表单-->
			<div class="modal-content" id="register-main" style="display:block;">
				<!--标题-->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true"> &times; </span>
					</button>
					<h5 class="modal-title">CampusPT</h5>
				</div>
				<!--注册表单-->

				<div class="modal-body">
					<!--User name-->
					<div class="input-wrapper">
						<input type="text" placeholder="用户名" name="register_username"
							id="register_username" />
						<!--Error message-->
						<span
							class="animated fadeInRight register-username-wrong register_tips"
							id="usernameTip"> </span>
					</div>
					<!--Password-->
					<div class="input-wrapper">
						<input type="password" name="register_password"
							id="register_password" class="register-password"
							id="set-type-register" placeholder="密码" />
						<!--显示与隐藏密码-->
						<a href="javascript:;" class="btn-eye-register"> <i
							class="icon-eye-open" id="icon-eye-register"> </i>
						</a>
						<!--Error message-->
						<span
							class="animated fadeInRight pw-error register-password-wrong register_tips"
							id="passwordTip"> </span>
					</div>
					<div class="input-wrapper">
						<select class="form-control selectpicker" title="请选择学校"
							name="register_school" id="register_school">

						</select>
					</div>
					<!--phone-->
					<div class="input-wrapper">
						<input type="text" placeholder="手机号码" name="register_phone"
							id="register_phone" /> <input type="button" class="phone_a"
							id="get_phone_num" value="免费获取验证码" />
						<!--Error message-->
						<span
							class="animated fadeInRight register-email-wrong right_50 register_tips"
							id="phoneTip"> </span>
					</div>
					<div class="input-wrapper">
						<input type="text" placeholder="验证码" id="captcha" />
						<!--Error message-->
						<span
							class="animated fadeInRight code-error register-code-wrong register_tips"
							id="captchaTip"> </span>
					</div>
				</div>
				<!--/.modal-body-->

				<!--注册按钮-->
				<div class="modal-footer">
					<!--注册按钮-->
					<button type="button" class="btn btn-primary btn-block"
						id="register_btn">注册</button>
				</div>

			</div>

		</div>
		<!--/.modal-dialog-->
	</div>

	<!-- login -->
	<div class="modal fade" id="login" role="dialog">
		<div class="modal-dialog modal-sm min_width" role="document">
			<!--弹框——登录-->
			<div class="modal-content" id="first">
				<div class="modal-header">
					<!--关闭按钮-->
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true"> &times; </span>
					</button>
					<!--标题-->
					<h5 class="modal-title">CampusPT</h5>
				</div>
				<div class="modal-body">
					<!--User name-->
					<div class="input-wrapper">
						<input type="text" placeholder="用户名" id="login_username" />
						<!--Error message-->
						<span
							class="animated fadeInRight login-username-wrong login_wrong"
							id="login_username_tip"> <!-- 用户名或密码错误 -->
						</span>
					</div>
					<div class="input-wrapper">
						<!--Password-->
						<input type="password" placeholder="密码" id="login_password" />
						<!--Error message-->
						<span
							class="animated fadeInRight login-password-wrong login_wrong"
							id="login_password_tip"> <!-- 用户名或密码错误 -->
						</span>
					</div>
				</div>
				<div class="modal-footer">
					<!--登录按钮-->
					<button type="button" class="btn btn-primary btn-block"
						id="login_user_btn">登录</button>
				</div>
			</div>

			<!-- 弹框——无法登录 -->

		</div>
	</div>
	<script type="text/javascript" src="js/TothingWay.js"></script>
	<script src="js/login_register.js"></script>
</body>

</html>