<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<link href="css/TothingWay.css" rel="stylesheet" />
		<link href="css/forum.css" rel="stylesheet" />
		<script type="text/javascript" src="js/TothingWay.js"></script>
		<link rel="stylesheet" href="css/storceInfo.css" />
		<link rel="stylesheet" href="css/login_register.css" />
		<script type="text/javascript" src="js/storeinfo.js"></script>

	</head>

	<body>
		<!--导航-->
    <nav class="navbar navbar-default nav-scroll navbar-fixed-top">
        <div class="container">
            <!--导航左半部分-->
            <div class="navbar-header">
                <!--手机模式导航按钮-->
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">
                        CampusPT
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
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="index.jsp">
                            首页
                        </a>
                    </li>
                    <li>
                        <a href="allreleaseorders.do">
                            全职
                        </a>
                    </li>
                    <li>
                        <a href="about.jsp" target="_blank">
                            关于我们
                        </a>
                   <li class="dropdown" id="contern_login">
							<a href="#" data-toggle="modal" data-target="#login">
								登录
							</a>
						</li>
						<li class="register" id="contern_register">
							<a href="#" data-toggle="modal" data-target="#register">
								注册
							</a>
						</li>
						<!--登录成功后显示的个人信息下拉菜单-->
						<li class="dropdown" id="conter_user_info">
							<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
								<span id="success_username">
									
								</span>
								<span class="caret">
                            	</span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="userinfo.do?uid=${sessionScope.user.uid }">
										个人中心
									</a>
								</li>
								<li>
									<a href="logout.do?op=logout_user">
										注销
									</a>
								</li>
							</ul>
						</li>
                   </ul>
            </div>
            <!-- /.nav-collapse -->
        </div>
    </nav>
		<div class="container">
			<div class="row">
				<div class="box_wxy clearfix">
					<div class="col-xs-12 col-sm-12 clearfix">
						<div class="storeLeftImg">
							<img src="images/company_default.png" alt="...">
						</div>
						<div class="storeRightInfo">
							<h3>
                            ${user.username }
                        </h3>
							<ul>
								<li>
									<b>
                                    ${count }个
                                </b>
									<span>
                                                                                                                     在招职位
                                </span>
								</li>
								<li class="score clearfix">
									<div class="score_num"  id="score_num">
									<fmt:formatNumber type="number" value='${user.totalScore/user.appraiseNum}'  maxFractionDigits="1"/>
										
									</div>
									<div class="star-wrap">
										<div class="star-default">
											<i class="star" id="star"></i>
										</div>
										<span>
                                        ${user.appraiseNum }人评价
                                    </span>
									</div>
								</li>
							</ul>
						</div>
					</div>
				</div>

				<div class="box_wxy clearfix">
					<div class="store_title">
						<!--副导航-->
						<ul class="nav-tab">
							<li class="active">
								<a href="#technology" data-toggle="tab" class="technology">
									雇主信息
								</a>
							</li>
							<li>
								<a href="#download" data-toggle="tab" class="download">
									最近招聘
								</a>
							</li>
						</ul>

						<!--副导航对应内容-->
						<div class="tab-content">
							<!--热点技术-->
							<div role="tabpanel" class="tab-pane fadeIn active" id="technology">
								<div class="container">
									<div class="row">
										<div class="col-xs-12 col-sm-12">

												<ul class="companyInfo">
													<li>
														<span>
						                               个体用户
                            </span>
													</li>
													<li>
														性别:
														<span>
                                ${user.gender }
                            </span>
													</li>
													<li>
														联系电话:
														<span>
                                	${user.phone }
                            </span>                      
													</li>
													
													<li>
														邮箱:
														<span>
                                ${user.email }
                            </span>
													</li>													
													<li>
														所在学校:
														<span>
                                ${user.school.sname }
                            </span>
													</li>
													<li>
														行业类型:
														<span>
                             	   个体营业
                            </span>
													</li>
													<li>
														成立日期:
														<span>
                                2019年05月12日
                            </span>
													</li>
													
													
													
												</ul>
											
										</div>
									</div>
								</div>
								<!--/.container-->
							</div>
				<c:forEach items="${list }" var="order">
						<div role="tabpanel" class="tab-pane fadeIn" id="download">				
							<div class="box_wxy clearfix" id="download">			
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<div class="col-xs-12 col-sm-6">
												<h4><a href="odetail.do?orderId=${order.oid }">${order.title}</a></h4>
												<div class="list_field">
													<span>
                                 		   工作时间: ${order.releaseTime }
                                </span>
													<span>
                                   		  工作类型: ${order.position.pname }
                                </span>
												</div>

												<div class="list_field">
													<span>
                                    	工作地点: ${order.school.sname }
                                </span>
													<span>
                            		        招聘人数: ${order.recruitNum }人
                                </span>
												</div>
											</div>

											<div class="col-xs-12 col-sm-6">
												<div class="list_btn">
													<a href="odetail.do?orderId=${order.oid }">
														报名参加
													</a>
												</div>
												<div class="salary">
													<span class="money">
                                    ${order.salary }
                                </span>
													<span>
                                  	  ${order.payMethod }
                                </span>
												</div>
											</div>

										</div>
									</div>						
								</div>
					</c:forEach>		
							
							
							</div>

						</div>
					</div>
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
                        <span aria-hidden="true">
                            &times;
                        </span>
                    </button>
                    <h5 class="modal-title">
                        CampusPT
                    </h5>
                </div>
                <!--注册表单-->
                
                <div class="modal-body"  >
                    <!--User name-->
                    <div class="input-wrapper">
                        <input type="text" placeholder="用户名" name="register_username" id="register_username" />
                        <!--Error message-->
                        <span class="animated fadeInRight register-username-wrong register_tips" id="usernameTip">
                           
                        </span>
                    </div>
                    <!--Password-->
                    <div class="input-wrapper">
                        <input type="password" name="register_password" id="register_password" class="register-password" id="set-type-register" placeholder="密码" />
                        <!--显示与隐藏密码-->
                        <a href="javascript:;" class="btn-eye-register">
                            <i class="icon-eye-open" id="icon-eye-register">
                            </i>
                        </a>
                        <!--Error message-->
                        <span class="animated fadeInRight pw-error register-password-wrong register_tips" id="passwordTip">
                            
                        </span>
                    </div>
                    <div class="input-wrapper">
                        <select class="form-control selectpicker" title="请选择学校" name="register_school" id="register_school">
   								
						</select>
                    </div>
                    <!--phone-->
                    <div class="input-wrapper">
                        <input type="text" placeholder="手机号码"  name="register_phone" id="register_phone"/>
                        <input type="button" class="phone_a" id="get_phone_num" value="免费获取验证码"/> 
                        <!--Error message-->
                        <span class="animated fadeInRight register-email-wrong right_50 register_tips" id="phoneTip">
                           
                        </span>
                    </div>
                    <div class="input-wrapper">
                        <input type="text" placeholder="验证码" id="captcha" />
                        <!--Error message-->
                        <span class="animated fadeInRight code-error register-code-wrong register_tips" id="captchaTip">
                            
                        </span>
                    </div>
                </div>
                <!--/.modal-body-->

                <!--注册按钮-->
                <div class="modal-footer">
                    <!--注册按钮-->
                    <button type="button" class="btn btn-primary btn-block" id="register_btn">
                        	注册
                    </button>
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
                        <span aria-hidden="true">
                            &times;
                        </span>
                    </button>
						<!--标题-->
						<h5 class="modal-title">
                        CampusPT
                    </h5>
					</div>
					<div class="modal-body">
						<!--User name-->
						<div class="input-wrapper">
							<input type="text" placeholder="用户名" id="login_username" />
							<!--Error message-->
							<span class="animated fadeInRight login-username-wrong login_wrong" id="login_username_tip">
                            	<!-- 用户名或密码错误 -->
                        </span>
						</div>
						<div class="input-wrapper">
							<!--Password-->
							<input type="password" placeholder="密码" id="login_password" />
							<!--Error message-->
							<span class="animated fadeInRight login-password-wrong login_wrong" id="login_password_tip">
                           <!-- 用户名或密码错误 -->
                        </span>
						</div>
					</div>
					<div class="modal-footer">
						<!--登录按钮-->
						<button type="button" class="btn btn-primary btn-block" id="login_user_btn">
                        	登录
                    </button>
					</div>
				</div>

				<!-- 弹框——无法登录 -->

			</div>
		</div>
	</body>

		<script src="js/login_register.js"></script>
</html>