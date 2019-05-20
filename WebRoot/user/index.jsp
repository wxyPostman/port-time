<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
		<link href="css/index.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/login_register.css" />
	</head>

	<body>
				<!--导航-->
		<nav class="navbar navbar-default navbar-fixed-top animated">
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
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="active">
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
						</li>
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

		<!-- Swiper -->
		<div class="swiper-container">
			<div class="swiper-wrapper banner_wrapper">
				<div class="swiper-slide slide_banner1"></div>
				<div class="swiper-slide slide_banner2"></div>
				<div class="swiper-slide slide_banner3"></div>
			</div>

			<!-- Add Pagination -->
			<div class="swiper-pagination"></div>
		</div>

		<!--banner-->
		<div class="banner">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-3 icon">
						<img src="images/NavIcon1.png" class="center-block" width="40px" height="40px" />
						<p>
							众多的兼职信息
						</p>
					</div>
					<div class="col-xs-12 col-sm-3 icon icon2">
						<img src="images/NavIcon4.png" class="center-block" width="40px" height="40px" />
						<p>
							众多的兼职信息
						</p>
					</div>
					<div class="col-xs-12 col-sm-3 icon">
						<img src="images/NavIcon2.png" class="center-block" width="40px" height="40px" />
						<p>
							众多的兼职信息
						</p>
					</div>
					<div class="col-xs-12 col-sm-3 icon">
						<img src="images/NavIcon3.png" class="center-block" width="35px" height="40px" />
						<p>
							众多的兼职信息
						</p>
					</div>
				</div>
			</div>
		</div>

		<!--副导航-->
		<ul class="nav-tab">
			<li class="active">
				<a href="#technology" data-toggle="tab" class="technology">
					职业精选
				</a>
			</li>
			<li>
				<a href="#download" data-toggle="tab" class="download">
					热门职业
				</a>
			</li>
		</ul>

		<!--副导航对应内容-->
		<div class="tab-content">

			<!--热点技术-->
			<div role="tabpanel" class="tab-pane fade in active" id="technology">
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-4">
							<!--内容-->
							<figure class="effect-oscar">
								<img src="images/zj.jpg" />
								<figcaption>
									<h3>
                                    简单易做
                                </h3>
									<p>
										<i class="icon-fire"> </i>
									</p>
									<a href="allreleaseorders.do?pname=简单易做" >
										View more
									</a>
								</figcaption>
							</figure>
						</div>

						<div class="col-xs-12 col-sm-4">
							<!--内容-->
							<figure class="effect-oscar">
								<img src="images/zj2.jpg" />
								<figcaption>
									<h3>
                                    跑腿办事
                                </h3>
									<p>
										<i class="icon-fire"></i>
									</p>
									<a href="allreleaseorders.do?pname=跑腿办事" >
										View more
									</a>
								</figcaption>
							</figure>
						</div>
						<div class="col-xs-12 col-sm-4">
							<!--内容-->
							<figure class="effect-oscar">
								<img src="images/zj3.jpg" />
								<figcaption>
									<h3>
                                    优秀青年
                                </h3>
									<p>
										<i class="icon-fire"></i>
									</p>
									<a href="allreleaseorders.do?pname=优秀青年">
										View more
									</a>
								</figcaption>
							</figure>
						</div>
						<div class="col-xs-12 col-sm-4">
							<!--内容-->
							<figure class="effect-oscar">
								<img src="images/zj4.jpg" />
								<figcaption>
									<h3>
                                    特色职位
                                </h3>
									<p>
										<i class="icon-fire"></i>
									</p>
									<a href="allreleaseorders.do?pname=特色职位" >
										View more
									</a>
								</figcaption>
							</figure>
						</div>
						<div class="col-xs-12 col-sm-4">
							<!--内容-->
							<figure class="effect-oscar">
								<img src="images/zj5.jpg" />
								<figcaption>
									<h3>
                                    体力达人
                                </h3>
									<p>
										<i class="icon-fire"></i>
									</p>
									<a href="allreleaseorders.do?pname=体力达人">
										View more
									</a>
								</figcaption>
							</figure>
						</div>
						<div class="col-xs-12 col-sm-4">
							<!--内容-->
							<figure class="effect-oscar">
								<img src="images/zj6.jpg" />
								<figcaption>
									<h3>
                                    专业技能
                                </h3>
									<p>
										<i class="icon-fire"> </i>
									</p>
									<a href="allreleaseorders.do?pname=专业技能">
										View more
									</a>
								</figcaption>
							</figure>
						</div>
					</div>
				</div>
				<!--/.container-->
			</div>
			 <!--下载热门-->
        <div role="tabpanel" class="tab-pane fade" id="download">
            <div class="container">
                <div class="row">
                	
                	
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/11.jpg" />
                            <figcaption>
                                <h3>
                                    节约时间
                                </h3>
                                <p>
                                    就是珍惜生命
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                    
                    
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/12.jpg" />
                            <figcaption>
                                <h3>
                                    随时派单
                                </h3>
                                <p>
                                   迅速，可靠 
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                    
                    
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/13.jpg" />
                            <figcaption>
                                <h3>
              小积累，大成功                    
                                </h3>
                                <p>
                         脚踏实地
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                    
                    
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/14.jpg" />
                            <figcaption>
                                <h3>
                                    直接了解
                                </h3>
                                <p>
                                   真实需求
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                    
                    
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/15.jpg" />
                            <figcaption>
                                <h3>
                                    团队合作
                                </h3>
                                <p>
                                   拉近你我联系
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                    
                    
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/16.jpg" />
                            <figcaption>
                                <h3>
                                    简单便捷
                                </h3>
                                <p>
                                    一本电脑解决一切
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                    
                    
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/17.jpg" />
                            <figcaption>
                                <h3>
                                    充实丰富
                                </h3>
                                <p>
                                    行程满满
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                    
                    
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/18.jpg" />
                            <figcaption>
                                <h3>
                                     业余时间                   
                                </h3>
                                <p>
                                    找活网来解决
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                    
                    
                    
                    <div class="col-xs-12 col-sm-4">
                        <!--内容-->
                        <figure class="effect-sarah">
                            <img src="images/19.jpg" />
                            <figcaption>
                                <h3>
                                    及时传达
                                </h3>
                                <p>
                                    操作简单
                                </p>
                                <a href="#" target="_blank">
                                    View more
                                </a>
                            </figcaption>
                        </figure>
                    </div>
                </div>
            </div>
            <!--/.container-->
        </div>
    </div>

		<!--猜你喜欢-->
		<div class="guess-you-like" data-stellar-background-ratio="0.5">
			<h1>
            猜你喜欢
        </h1>
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-4">
						<!--icon-->
						<div class="col-xs-2 like-icon">
							<i class="icon-heart-empty"></i>
						</div>
						<!--content-->
						<div class="col-xs-10">
							<h3 class="title_color">
                            高薪全职
                        </h3>
							<div class="separator-line">
							</div>
							<p>
								高薪离我们并不遥远,这里有你想要的
							</p>
						</div>
					</div>
					<div class="col-xs-12 col-sm-4">
						<!--icon-->
						<div class="col-xs-2 like-icon">
							<i class="icon-heart-empty"></i>
						</div>
						<!--content-->
						<div class="col-xs-10">
							<h3 class="title_color">
                            靠谱兼职
                        </h3>
							<div class="separator-line">
							</div>
							<p>
								放学后就忙着打游戏? 不如来看看兼职,简单轻松
							</p>
						</div>
					</div>
					<div class="col-xs-12 col-sm-4">
						<!--icon-->
						<div class="col-xs-2 like-icon">
							<i class="icon-heart-empty"></i>
						</div>
						<!--content-->
						<div class="col-xs-10">
							<h3 class="title_color">
                            名校云集
                        </h3>
							<div class="separator-line">
							</div>
							<p>
								杭州下沙各大高校合作,发布准确
							</p>
						</div>
					</div>
				</div>
				<!--/.row-->
			</div>
			<!--/.container-->
		</div>

	 <!--横向轮播-->
    <div class="swiper-container swiper_two_height">
        <div class="swiper-wrapper">
            <!--第一屏-->
            <div class="swiper-slide clearfix">
                <!--image-->
                <div class="col-xs-12 col-sm-6 slide-content img1">
                </div>
                <!--content-->
                <div class="col-xs-12 col-sm-6 slide-content-r">
                    <!--标题-->
                    <div class="col-sm-3 col-xs-12">
                        <span class="about">
                            Go
                        </span>
                    </div>
                    <!--text-->
                    <div class="col-sm-9 col-xs-12">
                        <h3>
                            不知道找什么兼职?
                        </h3>
                        <p>
                            推荐和热门职业选择版块也许可以帮到您,您可以搜索浏览,总有一个职业适合您
                        </p>
                        <a href="allreleaseorders.do" class="btn btn-enter">
                            Go
                        </a>
                    </div>
                </div>
            </div>
            <!--第二屏-->
            <div class="swiper-slide">
                <!--image-->
                <div class="col-xs-12 col-sm-6 slide-content img2">
                </div>
                <!--content-->
                <div class="col-xs-12 col-sm-6 slide-content-r">
                    <div class="col-sm-3 col-xs-12">
                        <!--icon-->
                        <span class="about about-quote">
                            <i class="icon-quote-left">
                            </i>
                        </span>
                    </div>
                    <!--text-->
                    <div class="col-sm-9 col-xs-12">
                        <h3>
                            逛逛找活网？
                        </h3>
                        <p>
                 找活网(CampusPT)是中国具有广泛影响力的大学生兼职网站。
                 每年为数十万所高校提供兼职岗位，帮助大学生高效准确地寻求合适的兼职职位，用短的时间、经济的成本找到合适的岗位。
                        </p>
                        <a href="allreleaseorders.do" class="btn btn-enter">
                            Go
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <!--/.swiper-wrapper-->

        <!--分页器-->
        <div class="swiper-pagination">
        </div>
    </div>

	<div class="footer">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-6 foot-l">
					Copyright © 2019.中软国际 CampusPT All rights reserved.
				</div>
				<div class="col-xs-12 col-sm-6 foot-r">
					<i class="icon-tasks"></i> CampusPT
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

		<script src="js/TothingWay.js">
		</script>
		<script src="js/index.js">
		</script>
		<script src="js/login_register.js"></script>
		
	</body>

</html>