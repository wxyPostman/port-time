$(function() {
	//正则法获取当前地址的参数值
	function getQueryString(name) {
		  var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
		  var r = window.location.search.substr(1).match(reg);
		  if (r != null) {
		    return unescape(r[2]);
		  }
		  return "";
		}
	
	var one =$("#inner_click_text1").text().trim();
	var two =$("#inner_click_text2").text().trim();
	if(one!=""||two!=""){
		$("#inner_div").css("display","block");
	}
	
    var mySwiper = new Swiper('.swiper-container', {
        loop: true,
        parallax: true,
        speed: 800,
        grabCursor: true,
        pagination: '.swiper-pagination',
    });
    $(".arrow").click(function() {
        if ($("#icon-angle").hasClass("icon-angle-down")) {
            $("#icon-angle").addClass("icon-angle-up");
            $("#icon-angle").removeClass("icon-angle-down");
            $(".nav-menu").css('display', 'block');
        } else if ($("#icon-angle").hasClass("icon-angle-up")) {
            $("#icon-angle").addClass("icon-angle-down");
            $("#icon-angle").removeClass("icon-angle-up");
            $(".nav-menu").css('display', 'none');
        }
    });
    $(".menu").click(function() {
        $('.active').removeClass('active');
        $(this).addClass("active");
        $(".tab-pane").removeClass('in')
    });
    $('.comment').click(function() {
        $('#new-quiz').css('display', 'block');
        return false;
    });
    $('#quiz-close').click(function() {
        $('#new-quiz').css('display', 'none');
        return false;
    });
    $('.btn-topic').click(function() {
        $('#new-topic').css('display', 'block');
    });
    $('#topic-close').click(function() {
        $('#new-topic').css('display', 'none');
    });
    $('.full-screen-btn1').click(function() {
        if ($("#icon-btn").hasClass("glyphicon-chevron-up")) {
            $('#text-editor').css('height', '500');
            $("#icon-btn").removeClass("glyphicon-chevron-up");
            $("#icon-btn").addClass("glyphicon-chevron-down");
        } else {
            $('#text-editor').css('height', '250');
            $("#icon-btn").removeClass("glyphicon-chevron-down");
            $("#icon-btn").addClass("glyphicon-chevron-up");
        }
    });
    $(".inner_color").mouseover(function(){
    	var title =getQueryString("title");
    	$(".inner_color").attr("href","allreleaseorders.do?pname="+this.innerHTML.trim()+"&sname="+$("#inner_click_text2").text().trim()+"&title="+title);
    });
    $(".inner_color2").mouseover(function(){
    	var title =getQueryString("title");
    	$(".inner_color2").attr("href","allreleaseorders.do?pname="+$("#inner_click_text1").text().trim()+"&sname="+this.innerHTML.trim()+"&title="+title);
    });
    
    $(".inner_color").click(function(){
        var str = this.innerHTML.trim();
        $("#inner_click_text1").text(str);
        $("#inner_div").css("display","block");
        $(".inner_color_active").removeClass("inner_color_active");
        cks1(this);
       // $(".inner_color").attr("href","JavaScript:;allreleaseorders.do?pname="+$("#inner_click_text1").text()+"&sname="+$("#inner_click_text2").text());


    });
    function cks1(obj){
        $(obj).addClass("inner_color_active");
        $(obj).removeClass("inner_color");
        
    }
    $(".inner_color2").click(function(){
        var str = this.innerHTML.trim();
        $("#inner_click_text2").text(str);
        $("#inner_div").css("display","block");
        $(".inner_color_active2").removeClass("inner_color_active2");
        cks2(this);
       // $(".inner_color2").attr("href","JavaScript:;allreleaseorders.do?pname="+$("#inner_click_text1").text()+"&sname="+$("#inner_click_text2").text());

    });
    function cks2(obj){
        $(obj).addClass("inner_color_active2");
        $(obj).removeClass("inner_color2");
    }

    
    
    $("#chk_true").click(function(){
        $("#inner_click_text1").text("");
        $("#inner_click_text2").text("");
      $("#inner_div").css("display","none");
      window.location.href="allreleaseorders.do";
    })
    //点击链接的时候调用
   $("#title-search").click(function(){
       //得到input的值
       var title = $("#titletext").val();
       //设置title-search的href的值
       $("#title-search").attr("href","allreleaseorders.do?title="+title);
       
   });
    


})