
var oWait = 60;
var oWait2 = 60;
var codeTimer = null;
var codeTimer2 = null;
var oCodeBtn = document.getElementById('code-btn');
var oCodeBtn2 = document.getElementById('code-btn2');
oCodeBtn.onclick = function() {
    codeTime(this);
}
oCodeBtn2.onclick = function() {
    codeTime2(this);
}
function codeTime(o) {
    if (oWait == 0) {
        o.removeAttribute("disabled");
        o.innerHTML = "重发验证码";
        oWait = 60;
    } else {
        o.setAttribute("disabled", true);
        o.innerHTML = oWait + "秒后重发";
        oWait--;
        setTimeout(function() {
            codeTime(o)
        }, 1000)
    }
}
function codeTime2(e) {
    if (oWait2 == 0) {
        e.removeAttribute("disabled");
        e.innerHTML = "重发验证码";
        oWait2 = 60;
    } else {
        e.setAttribute("disabled", true);
        e.innerHTML = +oWait2 + "秒后重发";
        oWait2--;
        setTimeout(function() {
            codeTime2(e)
        }, 1000)
    }
};
/*以下是cookie操作的js*/
function setCookie(c_name,value,expiredays){
  var exdate=new Date();
  exdate.setDate(exdate.getDate()+expiredays);
  document.cookie=c_name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}
function getCookie(c_name){
  if(document.cookie.length>0){
    c_start=document.cookie.indexOf(c_name + "=")
    if (c_start!=-1){ 
      c_start=c_start + c_name.length+1 
      c_end=document.cookie.indexOf(";",c_start)
      if (c_end==-1) c_end=document.cookie.length
        return unescape(document.cookie.substring(c_start,c_end));
    } 
  }
  return "";
}
function format2(time){  
    var datetime = new Date();  
    datetime.setTime(time);  
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();  
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();  
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();  
    return hour+":"+minute+":"+second;  
} 
function connect() {   //注意每连接一次会再建立一个连接，原来的连接不会被消除
  var socket = new SockJS('/hellowebsocket'); //1        
  stompClient = Stomp.over(socket); //2       
  stompClient.connect("xsw","xsw", function(frame) { //3     
    var username = $("#websocket-username").text();
    //console.log(username+"建立连接的时间"+new Date().getTime());
    stompClient.subscribe('/topic/logout/'+username, function(respnose){ //4 
      var name = $("#websocket-username").text();
      var use = $("#websocket-username").text();
      //console.log(name+"收到消息的时间："+new Date().getTime()+",use的数据是："+use);
      if(JSON.parse(respnose.body).responseMessage=="断开连接"){ 
        //console.log(name+"断开连接的时间："+new Date().getTime()+",use的数据是："+use);
        stompClient.unsubscribe("sub-0");
        $("#websocket-username").text("");
        $(".before-login").show();
        $(".after-login").hide();
        $.ajax({
          url:"logout",
          type:"post",
          data:{"name":""},
          async:false,
          success:function(data){ 
            },error:function(){
                alert("网络错误");
            }
        });
      }else if(JSON.parse(respnose.body).responseMessage==use){   
        alert("您的账号在其他地方登录，请查看是否账号泄露并修改密码");
        stompClient.unsubscribe("sub-0");
        $("#websocket-username").text("");
        var name = $("#websocket-username").text();
        $(".before-login").show();
        $(".after-login").hide();
        $.ajax({
          url:"logout",
          type:"post",
          data:{"name":name},
          async:false,
          success:function(data){ 
            },error:function(){
                alert("网络错误");
            }
        });
        $("#websocket-username").text("");
      }
    });    
    stompClient.subscribe('/topic/message/'+username, function(respnose){ //4     
      $(".message-divider").show();
      $(".system-message").show();
      var cot = parseInt($(".system-message-num").text());
        $(".system-message-num").text(cot+1);
    });
    stompClient.subscribe('/topic/chat/'+username, function(respnose){ //4  
      var htmlType = $(".html-type-for-person").text();
      if((htmlType=="聊天记录"&&$(".chat-name").text()==JSON.parse(respnose.body).from)||($(".chat-messgae-flag").text()=="yes")&&$("#personal-username").text()==JSON.parse(respnose.body).from){
        $(".chat-box").append("<li class=\"list-group-item\"><div class=\"media\"><div class=\"media-left\"><img class=\"media-object img-circle\" src=\"myhead/"+JSON.parse(respnose.body).from+"\" width=\"32px\" height=\"32px\"/>"+
                "</div><div class=\"media-body\"><h4 class=\"media-heading\">"+JSON.parse(respnose.body).from+"<span>"+format2(JSON.parse(respnose.body).time)+"</span></h4><p>"+JSON.parse(respnose.body).info+"</p></div></div></li>");
        $(".chat-box").scrollTop($(".chat-box")[0].scrollHeight);
        $.ajax({  
               url:"checkReadMessage.do", 
               contentType:"application/x-www-form-urlencoded; charset=UTF-8",
               type:"post",  
               data:{"cFrom":JSON.parse(respnose.body).from,"cTo":$("#websocket-username").text()},
               success:function(data){  
               },error:function(){
                alert("网络错误");
               }
          });
      }else{
        $(".message-divider").show();
        $(".user-message").show();
        var cot = parseInt($(".user-message-num").text());
            $(".user-message-num").text(cot+1);
      }
    }); 
  });     
}   
function getNeedReadMessage(){
  var temp = 0;
  $.ajax({     /*页面刷新时获得未读消息数量*/
        url:"getMessageNummer.do", 
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        type:"post",  
        data:{"mTo":$("#websocket-username").text(),"mRead":"no"},
        dataType:"json",
        async:false,
        success:function(data){ 
          if(data==0){
            $(".system-message").hide();
          }else{
            $(".system-message").show();
            $(".system-message-num").text(data);
            temp++;
          }
        },error:function(){
          alert("网络错误");
        }
  });
  $.ajax({     /*页面刷新时获得聊天消息数量*/
        url:"getChatMessageNum.do", 
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        type:"post",  
        data:{"name":$("#websocket-username").text()},
        dataType:"json",
        async:false,
        success:function(data){ 
          if(data[0]==0){
            $(".user-message").hide();
          }else{
            $(".user-message").show();
            $(".user-message-num").text(data[0]);
            temp++;
          }
        },error:function(){
          alert("网络错误");
        }
  });
  if(temp == 0){
    $(".message-divider").hide();
  }else{
    $(".message-divider").show();
  }
}
$(document).ready(function(){
  connect();
  $.ajax({  
        url:"GetUserSession.do", 
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        type:"post",  
        async:false,
        success:function(data){ 
          if(data[0]=="nouse"){
            $(".after-login").css("display","none");
            $(".before-login").css("display","block");
          }else if(data[0]=="wrong"){
            alert("您的账号在其他地方登录，请查看账号信息是否泄露");
            $(".after-login").css("display","none");
            $(".before-login").css("display","block");
          }else{
            $(".after-login").css("display","block");
            $(".before-login").css("display","none");
            $(".on-line-username").text(data[1]);
          }
        },error:function(){
          alert("网络错误");
        }
     });
  $(".after-login").click(function(){   //点击用户名，查看未读消息
    getNeedReadMessage();
  });
  $(".system-message").click(function(){   //查看系统消息
    window.location.href="systemMessage";
  });
  $(".user-message").click(function(){   //查看聊天记录
    window.location.href="chatMessage";
  });
  $(".logout").click(function(){   //退出登录
    var name = $("#websocket-username").text();
    $.ajax({  
          url:"logout.do", 
          contentType:"application/x-www-form-urlencoded; charset=UTF-8",
          type:"post", 
          data:{"name":name},
          async:false,
          success:function(data){  
            $(".after-login").css("display","none");
          $(".before-login").css("display","block");
          //$("#websocket-username").text("");
          //window.location.reload();
          },error:function(){
            alert("网络错误");
          }
       });
  });
  /*以下是弹框退出的事件*/
  $('#login').on('hide.bs.modal', function(e) {
        setTimeout(function() {
            $("#last").removeClass('animated fadeInDown');
            $("#first").css('display', 'block');
            $("#second").css('display', 'none');
            $("#last").css('display', 'none');
        }, 500);
        $("main").removeClass('blur');
        $(".login-username").val("");
        $(".login-password").val("");
        $(".login-password-wrong").css("display","none");
        $(".login-username-wrong").css("display","none");
        $(".find-password-email").val("");
        $(".find-password-email-wrong").css("display","none");
        $(".find-password-code").val("");
        $(".find-password-code-wrong").css("display","none");
        $(".reset-password-email").val("");
        $(".reset-password-email-wrong").css("display","none");
        $(".reset-password-pass").val("");
        $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").css("display","none");
        $(".reset-password-code").val("");
        $(".reset-password-code-wrong").css("display","none");
    });
    $('#register').on('hide.bs.modal', function(e) {
        setTimeout(function() {
            $("#register-main").removeClass('animated fadeInDown');
            $("#register-main").removeClass('animated fadeOutUp');
            $("#register-success").removeClass('animated fadeOutUp');
            $("#register-success").removeClass('animated fadeInDown');
            $("#register-main").css('display', 'block');
            $("#register-success").css('display', 'none');
        }, 500);
        $("main").removeClass('blur');
        $(".register-email").val("");
        $(".register-email-wrong").css("display","none");
        $(".register-username").val("");
        $(".register-username-wrong").css("display","none");
        $(".register-password").val("");
        $(".register-password-wrong").css("display","none");
        $(".register-password-eye").css("display","none");
        $(".register-email-code").val("");
        $(".register-email-code-wrong").css("display","none");
        $(".register-code").val("");
        $(".register-code-wrong").css("display","none");
    });
    
    /*以下是登录注册点击的事件*/
    $('#login').on('show.bs.modal', function () {
      var strCookie = getCookie("abc");
      var nn = getCookie("ITName");
      var pp = getCookie("ITPass");
    if(strCookie=="yes"){
       var xsw = decodeURI(nn);   //cookie填充
         var xxx = decodeURI(pp);
         $(".login-username").val(xsw);
         $(".login-password").val(xxx);
         $(".login-remeber").iCheck('check');
    }else{
       var xsw = decodeURI(nn);
       var xxx = decodeURI(pp);
       $(".login-username").val(xsw);
       $(".login-remeber").attr("checked",false);
    }
    $("main").addClass('blur');
    });
    $('#register').on('show.bs.modal', function() {
        $("main").addClass('blur');
    });
    
    /*以下是注册后返回的事件*/
    $(".back").click(function() {
        $("#register-success").removeClass('fadeInDown');
        $("#register-success").addClass('fadeOutUp');
        setTimeout(function() {
            $("#register-success").css('display', 'none');
            $("#register-main").css('display', 'block');
            $("#register-main").addClass('animated fadeInDown');
            $("#register-success").removeClass('animated fadeOutUp');
        }, 500);
        $("#tooltip-register").attr("src","yanzhengma.do?t="+Date());
    });
    
    /*以下是注册的事件*/
  $(".register-email").focus(function(){
    $(".register-email-wrong").css("display","none");
    $(".register-email-right").css("display","none");
    $(".register-email-img").css("display","block");
    password = $(".register-password").val();
    var reg = /[\u4e00-\u9fa5]/g;
    if(password.length==0){
      
    }else if(password.length<6){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码位数不能小于6位")
        $(".register-password-wrong").css("display","block");
    }else if(password.length>16){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码位数不能大于16位")
        $(".register-password-wrong").css("display","block");
    }else if(reg.test(password)){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码中不能含有中文")
        $(".register-password-wrong").css("display","block");
    }else if($.isNumeric(password)){ 
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码不能全为数字")
        $(".register-password-wrong").css("display","block");
    }else{
      $(".register-password-eye").css("display","none");
    }
  });
  $(".register-email").blur(function(){
    var useremail = $(".register-email").val();
    var emailpattern =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
    if(useremail.length==0){
      
    }else if(emailpattern.test(useremail)){
      var temp = {"email":useremail};
      $.ajax({  
              url:"ConfirmEmail.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){  
                if(data=="no"){
                  $(".register-email-wrong").text("该邮箱已被注册")
                  $(".register-email-wrong").css("display","block");
                }else{
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }else{
        $(".register-email-wrong").text("请输入正确的邮箱地址")
        $(".register-email-wrong").css("display","block");
    }
  });
  
  $(".register-username").focus(function(){
    $(".register-username-wrong").css("display","none");
    password = $(".register-password").val();
    var reg = /[\u4e00-\u9fa5]/g;
    if(password.length==0){
    }else if(password.length<6){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码位数不能小于6位")
        $(".register-password-wrong").css("display","block");
    }else if(password.length>16){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码位数不能大于16位")
        $(".register-password-wrong").css("display","block");
    }else if(reg.test(password)){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码中不能含有中文")
        $(".register-password-wrong").css("display","block");
    }else if($.isNumeric(password)){ 
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码不能全为数字")
        $(".register-password-wrong").css("display","block");
    }else{
      $(".register-password-eye").css("display","none");
    }
  });
  $(".register-username").blur(function(){
    var username = $(".register-username").val();
    if(username==""){
    }else if(username[0]==" "){
        $(".register-username-wrong").text("用户名不能以空格开头");
        $(".register-username-wrong").css("display","block");
    }else if(username[0]>='0'&&username[0]<='9'){
        $(".register-username-wrong").text("用户名不能以数字开头");
        $(".register-username-wrong").css("display","block");
    }else if(username.length>12){
        $(".register-username-wrong").text("用户名长度不能大于12");
        $(".register-username-wrong").css("display","block");
    }else if(username.indexOf("+")!=-1||username.indexOf("#")!=-1||username.indexOf("&")!=-1||username.indexOf("^")!=-1||username.indexOf("%")!=-1){
        $(".register-username-wrong").text("用户名中含有不合法字符");
        $(".register-username-wrong").css("display","block");
    }else if(username.indexOf("管理员")!=-1||username.indexOf("IT.Share")!=-1||username.indexOf("ITShare")!=-1||username.indexOf("IT Share")!=-1||username.indexOf("IT.share")!=-1||username.indexOf("ITshare")!=-1||username.indexOf("IT share")!=-1){
        $(".register-username-wrong").text("用户名中含有敏感字词");
        $(".register-username-wrong").css("display","block");
    }else{
      var temp = {"username":username};
      $.ajax({  
              url:"ConfirmUser.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){  
                if(data=="no"){
                  $(".register-username-wrong").text("该用户名已被注册")
                  $(".register-username-wrong").css("display","block");
                }else{
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }
  });
  
  $(".register-password").focus(function(){
    $(".register-password-wrong").css("display","none");
    var value = $(".register-password").val();
    if(value==""){
      $(".register-password-eye").css("display","none");
    }else{
      $(".register-password-eye").css("display","block");
    }
  });
  $(".register-password").keyup(function(){
    if ($(".register-password").val() == "") {
            $(".register-password-eye").css('display', 'none');
        } else {
           $(".register-password-eye").css('display', 'block');
        };
  });
  
  $(".register-code").focus(function(){
    $(".register-code-wrong").css("display","none");
    password = $(".register-password").val();
    var reg = /[\u4e00-\u9fa5]/g;
    if(password.length==0){
    }else if(password.length<6){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码位数不能小于6位")
        $(".register-password-wrong").css("display","block");
    }else if(password.length>16){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码位数不能大于16位")
        $(".register-password-wrong").css("display","block");
    }else if(reg.test(password)){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码中不能含有中文")
        $(".register-password-wrong").css("display","block");
    }else if($.isNumeric(password)){ 
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码不能全为数字")
        $(".register-password-wrong").css("display","block");
    }else{
      $(".register-password-eye").css("display","none");
    }
  });
  
  $(".register").click(function(){   //点击注册重置验证码
    $("#tooltip-register").attr("src","yanzhengma.do?t="+Date());
  });
  
  $(".register-subbmit").click(function(e){
    var reg = /[\u4e00-\u9fa5]/g;
    var useremail = $(".register-email").val();
    var emailpattern =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
    var username = $(".register-username").val();
    var password = $(".register-password").val();
    var cfmpassword = $(".register-cfm-password").val();
    var code = $(".register-code").val();
    var t = 0;
    if(emailpattern.test(useremail)){
      var temp = {"email":useremail};
      $.ajax({  
              url:"ConfirmEmail.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){  
                if(data=="no"){
                  $(".register-email-wrong").text("该邮箱已被注册")
                  $(".register-email-wrong").css("display","block");
                }else{
                  t=t+1;
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }else{
        $(".register-email-wrong").text("请输入正确的邮箱地址")
        $(".register-email-wrong").css("display","block");
    }
    if(username==""){
        $(".register-username-wrong").text("请输入用户名");
        $(".register-username-wrong").css("display","block");
    }else if(username[0]==" "){
        $(".register-username-wrong").text("用户名不能以空格开头");
        $(".register-username-wrong").css("display","block");
    }else if(username[0]>='0'&&username[0]<='9'){
        $(".register-username-wrong").text("用户名不能以数字开头");
        $(".register-username-wrong").css("display","block");
    }else if(username.length>12){
        $(".register-username-wrong").text("用户名长度不能大于12");
        $(".register-username-wrong").css("display","block");
    }else if(username.indexOf("+")!=-1||username.indexOf("#")!=-1||username.indexOf("&")!=-1||username.indexOf("^")!=-1||username.indexOf("%")!=-1){
        $(".register-username-wrong").text("用户名中含有不合法字符");
        $(".register-username-wrong").css("display","block");
    }else if(username.indexOf("管理员")!=-1||username.indexOf("IT.Share")!=-1||username.indexOf("ITShare")!=-1||username.indexOf("IT Share")!=-1||username.indexOf("IT.share")!=-1||username.indexOf("ITshare")!=-1||username.indexOf("IT share")!=-1){
        $(".register-username-wrong").text("用户名中含有敏感字词");
        $(".register-username-wrong").css("display","block");
    }else{
      var temp = {"username":username};
      $.ajax({  
              url:"ConfirmUser.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){  
                if(data=="no"){
                  $(".register-username-wrong").text("该用户名已被注册")
                  $(".register-username-wrong").css("display","block");
                }else{
                  t=t+1;
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }
    if(password.length<6){
      $(".register-password-eye").css("display","none")
        $(".register-password-wrong").text("密码位数不能小于6位")
        $(".register-password-wrong").css("display","block");
    }else if(password.length>16){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码位数不能大于16位")
        $(".register-password-wrong").css("display","block");
    }else if(reg.test(password)){
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码中不能含有中文")
        $(".register-password-wrong").css("display","block");
    }else if($.isNumeric(password)){ 
      $(".register-password-eye").css("display","none");
        $(".register-password-wrong").text("密码不能全为数字")
        $(".register-password-wrong").css("display","block");
    }else{
      t=t+1;
    }
    $.ajax({  
          url:"getsession1.do", 
          contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            type:"post",
          async:false,
          success:function(data){  
            if(code.toLowerCase()==data.toLowerCase()){
              t = t + 1;
            }else{
                $(".register-code-wrong").text("验证码错误")
                $(".register-code-wrong").css("display","block");
            }
          },error:function(){
            alert("网络错误");
          }
      });
    if(t=="4"){
      var temp = {"aName":username,"aEmail":useremail,"aPassword":password,"aUse":"no","aSession":"xsw"};
       $("#register-main").addClass('animated fadeOutUp');
          $("#register-main").removeClass('fadeInDown');
          setTimeout(function() {
              $("#register-main").css('display', 'none');
              $("#register-success").css('display', 'block');
              $("#register-success").addClass('animated fadeInDown');
              $("#register-main").removeClass('animated fadeOutUp');
          }, 500);
          $.ajax({  
              url:"Register.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              success:function(data){  
              },error:function(){
              }
         });
    }else{
      $("#tooltip-register").attr("src","yanzhengma.do?t="+Date());
    }
  });
  
  /*以下是注册激活的事件*/
  $(".register-email-code").focus(function(){
    $(".register-email-code-wrong").css("display","none");
  });
  $(".register-email-code-subbmit").click(function(){
    var email = $(".register-email").val();
    var temp = {"cEmail":email};
    $.ajax({  
            url:"RegisterCode.do", 
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            type:"post",  
            data:temp,  
            async:false,
            success:function(data){  
              var inputcode = $(".register-email-code").val();
              var name = "";
              if(data==inputcode){
                $.ajax({  
                      url:"SaveRegister.do", 
                      contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                      type:"post",  
                      data:temp,  
                      async:false,
                      success:function(data){  
                        name = data.aName;
                      },error:function(){
                        alert("网络错误");
                      }
                 });
                $('#register').modal('hide');
                $(".after-login").css("display","block");
                $(".before-login").css("display","none");
                $(".on-line-username").text(name);
                $("#websocket-username").text(name);
                connect();
                $.ajax({  
                      url:"resetuser.do", 
                      contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                        type:"post",
                      success:function(data){  
                      }
                  });
              }else if(data=="timeover"){
                $(".register-email-code-wrong").text("验证码已过期");
                $(".register-email-code-wrong").css("display","block");
              }else{
                $(".register-email-code-wrong").text("验证码错误");
                $(".register-email-code-wrong").css("display","block");
              }
            },error:function(){
              alert("网络错误");
            }
       });
  });
  
  $(".register-send-code-again").click(function(){
    var email = $(".register-email").val();
    var temp = {"cEmail":email};
    $.ajax({  
            url:"SendCodeAgain1.do", 
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            type:"post",  
            data:temp,  
            success:function(data){ 
            },error:function(){
            }
       });
  });
  
  /*以下是登录的事件*/
  $(".login-username").focus(function(){
    $(".login-username-wrong").css("display","none");
  });
  $(".login-password").focus(function(){
    $(".login-password-wrong").css("display","none");
  });
  $(".login-submit").click(function(){
    $("#websocket-username").text("");
    var username = $(".login-username").val();
    var password = $(".login-password").val();
    var temp = {"aName":username,"aPassword":password};
    $.ajax({  
            url:"login.do", 
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            type:"post",  
            data:temp,  
            async:false,
            success:function(data){ 
              if(data=="wrong"){
                $(".login-password-wrong").text("密码错误");
                $(".login-password-wrong").css("display","block");
              }else if(data=="nouser"){
                $(".login-username-wrong").text("用户名不存在");
                $(".login-username-wrong").css("display","block");
              }else if(data=="noactive"){
                $(".login-username-wrong").text("用户未激活");
                $(".login-username-wrong").css("display","block");
              }else if(data=="ban"){
                $(".login-username-wrong").text("用户已被封禁");
                $(".login-username-wrong").css("display","block");
              }else{
                var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
              if(keys){
                for(var i = keys.length; i--;)
                  document.cookie=keys[i]+'=0;expires=' + new Date( 0).toUTCString()
              } 
              var uname = encodeURI(username);
                var upass = encodeURI(password);
                setCookie("ITName",uname,7);
                setCookie("ITPass",upass,7);
                if($(".login-remeber").is(':checked')){
                  setCookie("abc","yes",7);   //abc用来标记记住密码
                }else{
                  setCookie("abc","no",7);
                }
                $('#login').modal('hide');
                $(".after-login").css("display","block");
                $(".before-login").css("display","none");
                $(".on-line-username").text(username);
                $("#websocket-username").text(username);
                window.setTimeout("connect();",200); 
              }
            },error:function(){
              alert("网络错误");
            }
       });
  });
  
  /*以下是找回密码的事件*/
  $(".find-password-email").focus(function(){
    $(".find-password-email-wrong").css("display","none");
  });
  $(".find-password-email").blur(function(){
    var email = $(".find-password-email").val();
    var temp = {"email":email};
    if(email==""){
      
    }else{
      $.ajax({  
              url:"ConfirmEmail.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){  
                if(data=="no"){
                }else{
                  $(".find-password-email-wrong").text("邮箱不存在");
                  $(".find-password-email-wrong").css("display","block");
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }
  });
  
  $(".find-password-code").focus(function(){
    $(".find-password-code-wrong").css("display","none");
  });
  
  $(".find-password-get-code").click(function(){
    var email = $(".find-password-email").val();
    var code = $(".find-password-code").val();
    var temp = {"email":email};
    var t = 0;
    $.ajax({  
            url:"ConfirmEmail.do", 
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            type:"post",  
            data:temp,  
            async:false,
            success:function(data){  
              if(data=="no"){
                t = t + 1;
              }else{
                $(".find-password-email-wrong").text("邮箱不存在");
                $(".find-password-email-wrong").css("display","block");
              }
            },error:function(){
              alert("网络错误");
            }
       });
    $.ajax({  
          url:"getsession1.do", 
          contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            type:"post",
          async:false,
          success:function(data){  
            if(code.toLowerCase()==data.toLowerCase()){
              t = t + 1;
            }else{
                $(".find-password-code-wrong").text("验证码错误")
                $(".find-password-code-wrong").css("display","block");
            }
          },error:function(){
            alert("网络错误");
          }
      });
    if(t==2){
      $("#second").removeClass('animated fadeInDown');
          $("#second").addClass('animated fadeOutUp');
          setTimeout(function() {
              $("#second").css('display', 'none');
              $("#last").css('display', 'block');
              $("#second").removeClass('animated fadeOutUp');
              $("#last").addClass('animated fadeInDown');
          }, 500);
          $(".reset-password-email").val(email);
      $.ajax({  
              url:"FindPassCode.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              success:function(data){  
              },error:function(){
              }
         });
    }else{
      $("#tooltip-login").attr("src","yanzhengma.do?t="+Date());
    }
  });
  
  /*以下是重置密码的事件*/
  $(".reset-password-email").focus(function(){
    $(".reset-password-email-wrong").css("display","none");
    password = $(".reset-password-pass").val();
    var reg = /[\u4e00-\u9fa5]/g;
    if(password.length==0){
    }else if(password.length<6){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码位数不能小于6位")
        $(".reset-password-pass-wrong").css("display","block");
    }else if(password.length>16){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码位数不能大于16位")
        $(".reset-password-pass-wrong").css("display","block");
    }else if(reg.test(password)){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码中不能含有中文")
        $(".reset-password-pass-wrong").css("display","block");
    }else if($.isNumeric(password)){ 
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码不能全为数字")
        $(".reset-password-pass-wrong").css("display","block");
    }else{
      $(".reset-password-pass-eye").css("display","none");
    }
  });
  $(".reset-password-email").blur(function(){
    var useremail = $(".reset-password-email").val();
    var emailpattern =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
    if(useremail.length==0){
        $(".reset-password-email-wrong").text("请输入正确的邮箱地址")
        $(".reset-password-email-wrong").css("display","block");
    }else if(emailpattern.test(useremail)){
      var temp = {"email":useremail};
      $.ajax({  
              url:"ConfirmEmail.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){  
                if(data=="no"){
                }else{
                  $(".reset-password-email-wrong").text("该邮箱不存在")
                  $(".reset-password-email-wrong").css("display","block");
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }else{
        $(".reset-password-email-wrong").text("请输入正确的邮箱地址")
        $(".reset-password-email-wrong").css("display","block");
    }
  });
  
  $(".reset-password-pass").focus(function(){
    $(".reset-password-pass-right").css("display","none");
    $(".reset-password-pass-wrong").css("display","none");
    var value = $(".reset-password-pass").val();
    if(value==""){
      $(".reset-password-pass-eye").css("display","none");
    }else{
      $(".reset-password-pass-eye").css("display","block");
    }
  });
  $(".reset-password-pass").keyup(function(){
    if ($(".reset-password-pass").val() == "") {
            $(".reset-password-pass-eye").css('display', 'none');
        } else {
           $(".reset-password-pass-eye").css('display', 'block');
        };
  });
  
  $(".reset-password-code").focus(function(){
    $(".reset-password-code-wrong").css("display","none");
    password = $(".reset-password-pass").val();
    var reg = /[\u4e00-\u9fa5]/g;
    if(password.length==0){
    }else if(password.length<6){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码位数不能小于6位")
        $(".reset-password-pass-wrong").css("display","block");
    }else if(password.length>16){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码位数不能大于16位")
        $(".reset-password-pass-wrong").css("display","block");
    }else if(reg.test(password)){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码中不能含有中文")
        $(".reset-password-pass-wrong").css("display","block");
    }else if($.isNumeric(password)){ 
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码不能全为数字")
        $(".reset-password-pass-wrong").css("display","block");
    }else{
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-right").css("display","block");
    }
  });
  
  $(".reset-password-getcode-again").click(function(){    //重置密码获取验证码
    var useremail = $(".reset-password-email").val();
    var emailpattern =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
    if(useremail.length==0){
        $(".reset-password-email-wrong").text("请输入正确的邮箱地址")
        $(".reset-password-email-wrong").css("display","block");
    }else if(emailpattern.test(useremail)){
      var temp = {"email":useremail};
      $.ajax({  
              url:"ConfirmEmail.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){  
                if(data=="no"){
                  var flag = {"cEmail":useremail};
                  $.ajax({  
                          url:"SendCodeAgain2.do", 
                          contentType:"application/x-www-form-urlencoded; charset=UTF-8",
                          type:"post",  
                          data:flag,  
                          success:function(data){ 
                          },error:function(){
                          }
                     });
                }else{
                  $(".reset-password-email-wrong").text("该邮箱不存在")
                  $(".reset-password-email-wrong").css("display","block");
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }else{
        $(".reset-password-email-wrong").text("请输入正确的邮箱地址")
        $(".reset-password-email-wrong").css("display","block");
    }
  });
  
  $(".reset-password-code-submit").click(function(){   //确认重置密码
    var t = 0;
    var useremail = $(".reset-password-email").val();
    var emailpattern =/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
    if(useremail.length==0){
        $(".reset-password-email-wrong").text("请输入正确的邮箱地址")
        $(".reset-password-email-wrong").css("display","block");
    }else if(emailpattern.test(useremail)){
      var temp = {"email":useremail};
      $.ajax({  
              url:"ConfirmEmail.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){  
                if(data=="no"){
                  t = t + 1;
                }else{
                  $(".reset-password-email-wrong").text("该邮箱不存在")
                  $(".reset-password-email-wrong").css("display","block");
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }else{
        $(".reset-password-email-wrong").text("请输入正确的邮箱地址")
        $(".reset-password-email-wrong").css("display","block");
    }
    password = $(".reset-password-pass").val();
    var reg = /[\u4e00-\u9fa5]/g;
    if(password.length==0){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("请输入重置的密码")
        $(".reset-password-pass-wrong").css("display","block");
    }else if(password.length<6){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码位数不能小于6位")
        $(".reset-password-pass-wrong").css("display","block");
    }else if(password.length>16){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码位数不能大于16位")
        $(".reset-password-pass-wrong").css("display","block");
    }else if($.isNumeric(password)){ 
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码不能全为数字")
        $(".reset-password-pass-wrong").css("display","block");
    }else if(reg.test(password)){
      $(".reset-password-pass-eye").css("display","none");
        $(".reset-password-pass-wrong").text("密码中不能含有中文")
        $(".reset-password-pass-wrong").css("display","block");
    }else{
      t = t + 1;
    }
    var usercode = $(".reset-password-code").val();
    var temp = {"cEmail":useremail,"code":usercode,"password":password};
    if(t==2){
      $.ajax({  
              url:"ResetConfirmCode.do", 
              contentType:"application/x-www-form-urlencoded; charset=UTF-8",
              type:"post",  
              data:temp,  
              async:false,
              success:function(data){ 
                if(data[0]=="yes"){
                  $('#login').modal('hide');
                  $(".after-login").css("display","block");
                  $(".before-login").css("display","none");
                  $(".on-line-username").text(data[1]);
                  $("#websocket-username").text(data[1]);
                  connect();
                }else if(data[0]=="timeover"){
                  $(".reset-password-code-wrong").text("验证码已过期");
                  $(".reset-password-code-wrong").css("display","block");
                }else{
                  $(".reset-password-code-wrong").text("验证码错误");
                  $(".reset-password-code-wrong").css("display","block");
                }
              },error:function(){
                alert("网络错误");
              }
         });
    }
  });
  
  $(".goToPersonalCenter").click(function(){    //连接到个人中心
    var tt = $(".on-line-username").text();
    window.location.href="personal?user="+tt;
  });
  
  $(".btn-eye-register").click(function() {
        if ($('#icon-eye-register').hasClass('icon-eye-open')) {
            $("#icon-eye-register").removeClass('icon-eye-open');
            $("#icon-eye-register").addClass('icon-eye-close');
            $("#set-type-register").attr('type', 'text');
        } else {
            $("#icon-eye-register").removeClass('icon-eye-close');
            $("#icon-eye-register").addClass('icon-eye-open');
            $("#set-type-register").attr('type', 'password');
        };
    })
    $(".back").click(function() {
        $("#register-success").removeClass('fadeInDown');
        $("#register-success").addClass('fadeOutUp');
        setTimeout(function() {
            $("#register-success").css('display', 'none');
            $("#register-main").css('display', 'block');
            $("#register-main").addClass('animated fadeInDown');
            $("#register-success").removeClass('animated fadeOutUp');
        }, 500);
    });
    $('#register').on('hide.bs.modal', function(e) {
            setTimeout(function() {
                $("#register-main").removeClass('animated fadeInDown');
                $("#register-main").removeClass('animated fadeOutUp');
                $("#register-success").removeClass('animated fadeOutUp');
                $("#register-success").removeClass('animated fadeInDown');
                $("#register-main").css('display', 'block');
                $("#register-success").css('display', 'none');
            }, 500);
        })
        // 登录
    $(".unable-login").click(function() {
      $("#tooltip-login").attr("src","yanzhengma.do?t="+Date());
        $("#first").addClass('animated fadeOutUp');
        setTimeout(function() {
            $("#first").css('display', 'none');
            $("#second").css('display', 'block');
            $("#second").addClass('animated fadeInDown');
            $("#first").removeClass('animated fadeOutUp');
        }, 500);
    });
    $(".btn-eye-login").click(function() {
        if ($('#icon-eye-login').hasClass('icon-eye-open')) {
            $("#icon-eye-login").removeClass('icon-eye-open');
            $("#icon-eye-login").addClass('icon-eye-close');
            $("#set-type-login").attr('type', 'text');
        } else {
            $("#icon-eye-login").removeClass('icon-eye-close');
            $("#icon-eye-login").addClass('icon-eye-open');
            $("#set-type-login").attr('type', 'password');
        };
    });
    $('#login').on('hide.bs.modal', function(e) {
            setTimeout(function() {
                $("#last").removeClass('animated fadeInDown');
                $("#first").css('display', 'block');
                $("#second").css('display', 'none');
                $("#last").css('display', 'none');
            }, 500);
        })
});