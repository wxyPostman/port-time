<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>CampusPT</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js">
            </script>
            <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js">
            </script>
        <![endif]-->
</head>

<body class="skin-blue sidebar-mini sidebar-collapse">
	<div class="container-fluid headerFFF">
		<div class="row">
			<div class="col-md-12 Header">
				<div id="herder">
					<div class="col-md-3 DX">
						<div class="DXSTDIO">
							<span class="glyphicon glyphicon-align-justify"> </span> <span
								class="DXred"> CampusPT </span>
						</div>
					</div>
					<div class="col-md-6 col-md-offset-3">
						<div class="HeaderR clearfix">
							<div class="headerRightMy clearfix" id="headerRightMy">
								<img src="img/avatar1_small.jpg" class="headerimg" /> 
								<span id="success_adminname">	${sessionScope.admin.adminName }</span> 
								<span class="glyphicon glyphicon-chevron-down"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="AlertA">
				<div class="AlertABtm">
					<i class="fa fa-key" aria-hidden="true"></i> 
					<a href="logout.do?op=logout_admin">
										注销
					</a>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row box_container">
			<div class="col-sm-2 in_width" id="in_width">
				<nav class="navbar navbar-default nav_box" id="nav_box"
					role="navigation">
					<!-- Brand and toggle get grouped for better mobile display -->
				  <div class="navbar-header">
      				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        				<span class="sr-only">Toggle navigation</span>
       					<span class="icon-bar"></span>
        				<span class="icon-bar"></span>
        				<span class="icon-bar"></span>
      				</button>
      					<a class="navbar-brand" href="#">CampusPt</a>
    				</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="ollapse navbar navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav" id="LeftNav">
							<div class="panel panel_box  panel_active">
								<div class="panel-heading">
									<a role="button" class="active" href="admin.do?op=count_all"> <i
										class="fa fa-tachometer" aria-hidden="true"></i> 本站概况
									</a>
								</div>
							</div>
							<div class="panel">
								<div class="panel-heading" role="tab">
									<a href="userinfo.jsp"> 
										<i class="fa fa-user" aria-hidden="true"></i> 用户管理
									</a>
								</div>
							</div>
							<div class="panel">
								<div class="panel-heading" role="tab">
									<a href="schoolinfo.jsp"> <i
										class="fa fa-graduation-cap" aria-hidden="true"></i> 学校管理
									</a>
								</div>
							</div>
							
							<div class="panel ">
									<div class="panel-heading" role="tab">
										<a href="positioninfo.jsp">
											<i class="fa fa-list-ul" aria-hidden="true"></i> 兼职管理
										</a>
									</div>
								</div>
								<div class="panel">
								<div class="panel-heading" role="tab">
									<a href="orderinfo.jsp"> 
										<i class="fa fa-shopping-bag" aria-hidden="true"></i> 订单管理
									</a>
								</div>
							</div>
						</ul>
					</div>
				</nav>
			</div>
			<div class="col-sm-10 col-xs-12  RightDiv">
				<div class="row">
					<div class="col-lg-3 col-md-6 col-xs-12 margin_top_20">
						<div class="box_wxy clearfix">
							<div class="RightTopOL">
								<span class="glyphicon glyphicon-user"> </span>
							</div>
							<div class="RightTopOR">
								<span> ${registedUserNum} </span> <br />  已注册用户数 
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-xs-12  margin_top_20">
						<div class="box_wxy clearfix">
							<div class="RightTopOL COLORO">
								<span class="glyphicon glyphicon-tags"> </span>
							</div>
							<div class="RightTopOR">
								<span>  ${releasedOrdersNum}</span> <br /> 已发布兼职数
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-xs-12 margin_top_20">
						<div class="box_wxy clearfix">
							<div class="RightTopOL COLORT">
								<span class="glyphicon glyphicon-shopping-cart"> </span>
							</div>
							<div class="RightTopOR">
								<span>${completedNum } </span> <br />  已完成
							</div>
						</div>
					</div>
					<div class="col-lg-3 col-md-6 col-xs-12 margin_top_20">
						<div class="box_wxy clearfix">
							<div class="RightTopOL COLORS">
								<span class="glyphicon glyphicon-hdd"> </span>
							</div>
							<div class="RightTopOR">
								<span> ${applyNum} </span> <br /> 已报名数
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-xs-12">
						<div class="margin_20">
							<div class="user_number">每月完成招聘数</div>
							<div id="main" class="main_canvas"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js">
    </script>
	
	<script src="js/echarts.js"></script>
	<script type="text/javascript" src="js/index.js">
    </script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js">
    </script>

</body>

</html>