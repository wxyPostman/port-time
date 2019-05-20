<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>
        CampusPT
    </title>
    <link rel="shortcut icon" href="http://oqlse9rck.bkt.clouddn.com/favicon.ico">
    <meta content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" name="viewport" />
    <link href="css/help-code.css" rel="stylesheet" />
    <link href="css/help.css" rel="stylesheet" />
</head>

<body>
    <!--当窗口小于319px时，不显示内容，提示窗口太小-->
    <div class="screen-phone">
        <div class="cell">
            <div class="banner">
                <div class="screen-shape">
                </div>
                <p class="plase-rotate">
                    窗口太小，看不到啦
                </p>
            </div>
        </div>
    </div>

    <!--竖向滚动轮播开始-->
    <div class="swiper-container" id="swiper-main">
        <div class="swiper-wrapper">

            <!--第一屏-->
            <div class="swiper-slide help-bg">
                <div class="part">
                    <div class="part_text ani" swiper-animate-effect="fadeInUp" swiper-animate-duration="0.5s">

                    </div>
                    <div class="part_pic ani" swiper-animate-effect="fadeInLeft" swiper-animate-duration="1s">

                    </div>
                    <div class="part_pic2 ani" swiper-animate-effect="fadeInRight" swiper-animate-duration="1s">

                    </div>
                </div>

                <!--导向箭头-->
                <a href="#" class="arrow" id="arrow">
                    <!--导向箭头图标-->
                    <i class="icon-angle-down"></i>
                </a>
            </div>

            <!--第二屏-->
            <div class="resource-contain swiper-slide" id="resource-contain">
                <div class="box">
                    <!--第二屏标题-->
                    <h5 class="ani" swiper-animate-effect="fadeIn" swiper-animate-duration="0.5s">
                        CampusPT 合作高校
                    </h5>
                    <!--第二屏中间内容部分-->
                    <div class="items list-inline container ani" swiper-animate-effect="fadeInUp"
                        swiper-animate-duration="0.5s" swiper-animate-delay="0.3s">
                        <div class="row">
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="school">
                                    <img src="images/hzdzkj.jpg" alt="杭州电子科技大学">
                                    <p>
                                        杭州电子科技大学
                                    </p>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="school">
                                    <img src="images/zjlg.jpg" alt="浙江理工大学">
                                    <p>
                                        浙江理工大学
                                    </p>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="school">
                                    
                                    <img src="images/zjweuedu.png" alt="浙江水利水电学院">
                                    <p>
                                        浙江水利水电学院
                                    </p>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="school">
                                    <img src="images/zjgsdx.png" alt="浙江工商大学">
                                    <p>
                                        浙江工商大学
                                    </p>
                                </div>
                            </div>
                            <div class="col-xs-12 col-sm-6 col-md-3">
                                <div class="school">
                                    <img src="images/hzsfdx.jpg" alt="杭州师范大学">
                                    <p>
                                        杭州师范大学
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!--第三屏-->
            <div class="contact-us swiper-slide">
                <div class="container">
                    <div class="row">
                        <!--二维码图片（左边部分）-->
                        <div class="ani col-xs-12 col-sm-6 col-md-3" swiper-animate-effect="fadeInDown"
                            swiper-animate-duration="0.5s">
                            <img src="images/wx.png" width="156px" height="156px" />
                        </div>
                        <!--联系方式（中间部分）-->
                        <div class="ani col-xs-12 col-sm-6 col-md-4" swiper-animate-effect="fadeInDown"
                            swiper-animate-duration="0.5s">
                            <div class="address">
                                <!--电话图片-->
                                <div class="tel"></div>
                                <p>
                                    中国
                                    <span> ·</span>
                                    杭州 下沙大学城
                                    <br /> 联系电话：18705987671
                                    <br /> 地址：杭州 下沙街道
                                    <br /> 邮编：310000
                                </p>
                            </div>
                        </div>
                        <!--域名版权（右边部分）-->
                        <div class="rights ani col-xs-12 col-sm-6 col-md-5" swiper-animate-effect="fadeInDown"
                            swiper-animate-duration="0.5s">
                            <p class="right">
                                Email：wxyqinghua@foxmail.com
                                <br /> www.campuspt.com
                                <br /> Copyright all rights reserved campuspt 版权所有
                            </p>
                        </div>
                        <div class="line-box ani col-xs-12 col-sm-12 col-md-12" swiper-animate-effect="fadeIn"
                            swiper-animate-duration="0.5s">
                            <!--分割横线-->
                            <div class="line"></div>
                        </div>
                        <div class="title ani col-xs-12 col-sm-12 col-md-12" swiper-animate-effect="fadeInUp"
                            swiper-animate-duration="0.5s">
                            <!--文字信息图片-->
                            <div class="txt"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!--/.swiper-wrapper-->
    </div>
    <!--/.swiper-container-->
    <script src="js/help-code.js">
    </script>
    <script src="js/help.js">
    </script>
</body>

</html>