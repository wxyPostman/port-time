<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CampusPT</title>
<link href="css/TothingWay.css" rel="stylesheet" />
<link href="css/resource.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/css/swiper.min.css">

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
					<li class="active"><a href="allreleaseorders.do"> 全职 </a></li>
					<li><a href="about.jsp" target="_blank"> 关于我们 </a></li>
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
							<li><a href="userinfo.do?uid=${sessionScope.user.uid }">
									个人中心 </a></li>
							<li><a href="logout.do?op=logout_user"> 注销 </a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.nav-collapse -->
		</div>
	</nav>

	<!--轮播-->
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<!--第一屏-->

			<div class="swiper-slide slide2">
				<h1 data-swiper-parallax="-1500">职位在线</h1>
				<p data-swiper-parallax="-3000">为超过20000学生找到兼职</p>
				<p data-swiper-parallax="-4500"></p>
				<div data-swiper-parallax="-6000">
					<a href="JavaScript:;" role="button"
						class="btn btn-study study_wxy"> 马上求职 </a>
				</div>
			</div>
			<!--第二屏-->
			<div class="swiper-slide slide1">
				<h1 data-swiper-parallax="-1500">职位在线</h1>
				<p data-swiper-parallax="-3000">嗖的一下,马上入职</p>
				<div data-swiper-parallax="-4500">
					<a href="JavaScript:;" role="button" class="btn btn-study study1">
						马上求职 </a>
				</div>
			</div>
		</div>
		<!--分页器-->
		<div class="swiper-pagination"></div>
	</div>
	<!--资源搜索-->
	<div class="container">
		<div class="search-cover">
			<form role="search">
				<div class="form-group">
					<input type="text" id="titletext" class="form-control search"
						value="" placeholder="标题搜索" /> <a href="" id="title-search"
						class="btn-search"> <span class="glyphicon glyphicon-search">
					</span>
					</a>

				</div>
			</form>
		</div>
	</div>
	<div class="container inner_list margin_top">
		<div class="clearfix">
			<dl class="inner_wrap">
				<dt>职位:</dt>
				<dd>
					<ul>
						<c:forEach items="${positionList }" var="position">
							<li>
								<!-- 当被选定时候class为inner_color_active,没有被选定的时候为inner_color --> <a
								href="JavaScript:;" id="${position.pid }" class="inner_color">
									${position.pname } </a>
							</li>
						</c:forEach>
					</ul>
				</dd>
			</dl>
		</div>
		<div class="clearfix">
			<dl class="inner_wrap">
				<dt>学校:</dt>
				<dd>
					<ul>
						<c:forEach items="${schoolList }" var="school">
							<li>
								<!-- 当被选定时候class为inner_color_active2,没有被选定的时候为inner_color --> <a
								href="JavaScript:;" id="${school.sid }" class="inner_color2">
									${school.sname } </a>
							</li>
						</c:forEach>
					</ul>
				</dd>
			</dl>
		</div>
		<div class="clearfix border_top">
			<dl class="inner_wrap">
				<dt class="margin_top_16">已选:</dt>
				<dd>
					<div class="inner_div" id="inner_div">
						<span id="inner_click_text1"> ${position.pname} </span> <span
							id="inner_click_text2"> ${school.sname} </span> <span
							class="glyphicon glyphicon-remove gly_cur" id="chk_true"
							aria-hidden="true"> </span>
					</div>
				</dd>
			</dl>
		</div>

	</div>
	<div class="container margin_top">
		<div class="row">
			<c:forEach items="${PageBean.list }" var="order">
				<div class="box_wxy clearfix">
					<div class="col-xs-12 col-sm-12">
						<div class="row">
							<div class="col-xs-12 col-sm-6">
								<h4>
									<a href="odetail.do?orderId=${order.oid }">${order.title}</a>
								</h4>
								<table class="table">
									<tr>
										<td><span> 发布时间: ${order.releaseTime } </span></td>
										<td><span> 工作类型: ${order.position.pname } </span></td>
									</tr>

									<tr>
										<td><span> 工作地点: ${order.school.sname } </span></td>
										<td><span> 招聘人数: ${order.recruitNum }人 </span></td>
									</tr>
								</table>
							</div>
							<div class="col-xs-12 col-sm-6">

								<c:if test="${order.user.uid==sessionScope.user.uid }">
									<div class="list_btn"
										style="background-color: #e7e7e7;  color: #999;">
										<a style="cursor: not-allowed; " href="javascript:void(0);">
											我的发布 </a>
									</div>
								</c:if>
								<c:if test="${order.user.uid!=sessionScope.user.uid }">
									<div class="list_btn">
										<a href="odetail.do?orderId=${order.oid }"> 报名参加 </a>
									</div>
								</c:if>

								<div class="salary">
									<span class="money"> ${order.salary } </span> <span>
										${order.payMethod } </span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	<div class="container">
		<div class="yahoo2 clearfix">
			<%-- 构建分页导航 --%>
			<!--   共有${PageBean.totalRecord}个职位，共${PageBean.totalPage }页，当前为${PageBean.currentPage}页-->
			<br />
			<c:if test="${PageBean.totalPage !=	1 }">
				<a
					href="allreleaseorders.do?currentPage=1&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">首页</a>
			</c:if>

			<c:if test="${PageBean.totalPage !=	1 }">
				<%--如果当前页为第一页时，就没有上一页这个超链接显示 --%>
				<c:if test="${PageBean.currentPage ==1}">
					<c:forEach begin="${PageBean.start}" end="${PageBean.end}" step="1"
						var="i">
						<c:if test="${PageBean.currentPage == i}">
							<a class="linkOn"> ${i}</a>
						</c:if>
						<c:if test="${PageBean.currentPage != i}">
							<a
								href="allreleaseorders.do?currentPage=${i}&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">${i}</a>
						</c:if>
					</c:forEach>
					<a
						href="allreleaseorders.do?currentPage=${PageBean.currentPage+1}&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">下一页</a>
				</c:if>

				<%--如果当前页不是第一页也不是最后一页，则有上一页和下一页这个超链接显示 --%>
				<c:if
					test="${PageBean.currentPage > 1 && PageBean.currentPage < PageBean.totalPage}">
					<a
						href="allreleaseorders.do?currentPage=${PageBean.currentPage-1}&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">上一页</a>
					<c:forEach begin="${PageBean.start}" end="${PageBean.end}" step="1"
						var="i">
						<c:if test="${PageBean.currentPage == i}">
							<a class="linkOn"> ${i}</a>
						</c:if>
						<c:if test="${PageBean.currentPage != i}">
							<a
								href="allreleaseorders.do?currentPage=${i}&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">${i}</a>
						</c:if>
					</c:forEach>
					<a
						href="allreleaseorders.do?currentPage=${PageBean.currentPage+1}&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">下一页</a>
				</c:if>

				<%-- 如果当前页是最后一页，则只有上一页这个超链接显示，下一页没有 --%>
				<c:if test="${PageBean.currentPage == PageBean.totalPage}">
					<a
						href="allreleaseorders.do?currentPage=${PageBean.currentPage-1}&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">上一页</a>
					<c:forEach begin="${PageBean.start}" end="${PageBean.end}" step="1"
						var="i">
						<c:if test="${PageBean.currentPage == i}">
							<a class="linkOn"> ${i}</a>
						</c:if>
						<c:if test="${PageBean.currentPage != i}">
							<a
								href="allreleaseorders.do?currentPage=${i}&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">${i}</a>
						</c:if>
					</c:forEach>
				</c:if>
			</c:if>
			<c:if test="${PageBean.totalPage==1 }">
				<a class="linkOn">1</a>
			</c:if>
			<%--尾页 --%>
			<c:if test="${PageBean.totalPage !=	1 }">
				<a
					href="allreleaseorders.do?currentPage=${PageBean.totalPage}&pageSize=${PageBean.pageSize }&sname=${school.sname}&pname=${position.pname}&title=${title}">尾页</a>
			</c:if>
		</div>
	</div>
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
	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-6 foot-l">Copyright © 2019.中软国际
					CampusPT All rights reserved.</div>
				<div class="col-xs-12 col-sm-6 foot-r">
					<i class="icon-tasks"></i> CampusPT
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/3.4.2/js/swiper.min.js"></script>
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
	<script src="js/resource.js"></script>
	<script src="js/TothingWay.js"></script>
	<script src="js/login_register.js"></script>
</body>

</html>