$(function() {

	var scene = document.getElementById('scene');

	if(screen.width >= 768) {
		$(window).on('scroll', function() {
			var t = $(window).scrollTop();
			if(t > 10) {
				$(".navbar-default").addClass("nav-scroll fadeInDown");
			} else {
				$(".navbar-default").removeClass("nav-scroll fadeInDown");
			}
		})
	}
	if(screen.width <= 768) {
		$(window).on('scroll', function() {
			var t = $(window).scrollTop();
			if(t > 10) {
				$(".navbar-default").addClass("nav-scroll");
			} else {
				if($("#navbar").hasClass("in")) {
					$('.navbar-default').addClass("");
				} else {
					$(".navbar-default").removeClass("nav-scroll");
				}
			}
		})
	}
	$(".navbar-toggle").click(function() {
		var t = $(window).scrollTop();
		if(t < 10) {
			if($(".navbar-default").hasClass("nav-scroll")) {
				var navBar = null;
				navBar = setTimeout(function() {
					$('.navbar-default').removeClass("nav-scroll");
				}, 200)
			} else {
				var navBar2 = null;
				navBar2 = setTimeout(function() {
					$('.navbar-default').addClass("nav-scroll");
				}, 200)
			}
		}
	})
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
		$(".login-password-wrong").css("display", "none");
		$(".login-username-wrong").css("display", "none");
		$(".find-password-email").val("");
		$(".find-password-email-wrong").css("display", "none");
		$(".find-password-code").val("");
		$(".find-password-code-wrong").css("display", "none");
		$(".reset-password-email").val("");
		$(".reset-password-email-wrong").css("display", "none");
		$(".reset-password-pass").val("");
		$(".reset-password-pass-eye").css("display", "none");
		$(".reset-password-pass-wrong").css("display", "none");
		$(".reset-password-code").val("");
		$(".reset-password-code-wrong").css("display", "none");
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
		$(".register-email-wrong").css("display", "none");
		$(".register-username").val("");
		$(".register-username-wrong").css("display", "none");
		$(".register-password").val("");
		$(".register-password-wrong").css("display", "none");
		$(".register-password-eye").css("display", "none");
		$(".register-email-code").val("");
		$(".register-email-code-wrong").css("display", "none");
		$(".register-code").val("");
		$(".register-code-wrong").css("display", "none");
	});
	$(".btn-eye-register").click(function() {
		if($('#icon-eye-register').hasClass('icon-eye-open')) {
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
		$("#tooltip-login").attr("src", "yanzhengma.do?t=" + Date());
		$("#first").addClass('animated fadeOutUp');
		setTimeout(function() {
			$("#first").css('display', 'none');
			$("#second").css('display', 'block');
			$("#second").addClass('animated fadeInDown');
			$("#first").removeClass('animated fadeOutUp');
		}, 500);
	});
	$("#btn-register").click(function() {
		$("#register-main").addClass('animated fadeOutUp');
		setTimeout(function() {
			$("#register-main").css('display', 'none');
			$("#register-success").css('display', 'block');
			$("#register-success").addClass('animated fadeInDown');
			$("#register-main").removeClass('animated fadeOutUp');
		}, 500);
	});
	$(".btn-eye-login").click(function() {
		if($('#icon-eye-login').hasClass('icon-eye-open')) {
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
	var swiper = new Swiper('.swiper-container', {
		pagination: '.swiper-pagination',
		paginationClickable: true,
		speed: 800,
		grabCursor: true,
		loop: true,
		autoplay: 3000
	});
	$(function() {
		$(".data").click(function() {
			$.scrollTo('.banner', 500);
		});
		$(".library").click(function() {
			$.scrollTo('.banner', 500);
		});
		$(".technology").click(function() {
			$.scrollTo('.banner', 500);
		});
		$(".download").click(function() {
			$.scrollTo('.banner', 500);
		});
		$(".download").click(function() {
			$.scrollTo('.banner', 500);
		});
		$("#action").click(function() {
			$.scrollTo('.banner', 500);
		});
	});
	// 页面滚动到指定div实现代码
	function HoverTreeScroll(div_id) {
		var Obj = $('#' + div_id);
		//判断元素是否存在 何问起
		if(Obj.length != 1) {
			return false;
		}
		var offsetTop = arguments[1] ? arguments[1] : 0;
		var ObjTop = Obj.offset().top - $(window).height();
		var h_one = true;
		$(window).scroll(function() {
			if($(window).scrollTop() > ObjTop) {
				if(h_one) {
					//在这里些滚动指定DIV时执行的代码 
					var statistic1 = new CountUp("resource-number", 0, 66613, 0, 2.5);
					var statistic2 = new CountUp("download-number", 0, 66613, 0, 2.8);
					var statistic3 = new CountUp("user-number", 0, 66613, 0, 3.1);
					var statistic4 = new CountUp("praise-number", 0, 66613, 0, 3.4);
					statistic1.start();
					statistic2.start();
					statistic3.start();
					statistic4.start();
					h_one = false;
				}
			}
		});
	}
	HoverTreeScroll('statistics');

	// tooltip
	$("[data-toggle='tooltip']").tooltip();
	// 单多选按钮
	$('input').iCheck({
		checkboxClass: 'icheckbox_minimal-grey',
		radioClass: 'iradio_minimal-grey',
		increaseArea: '20%' // optional
	});
});
// stickUp.js
jQuery(function($) {
	$(document).ready(function() {
		var contentButton = [];
		var contentTop = [];
		var content = [];
		var lastScrollTop = 0;
		var scrollDir = "";
		var itemClass = "";
		var itemHover = "";
		var menuSize = null;
		var stickyHeight = 0;
		var stickyMarginB = 0;
		var currentMarginT = 0;
		var topMargin = 0;
		$(window).scroll(function(event) {
			var st = $(this).scrollTop();
			if(st > lastScrollTop) {
				scrollDir = "down"
			} else {
				scrollDir = "up"
			}
			lastScrollTop = st
		});
		$.fn.stickUp = function(options) {
			$(this).addClass("stuckMenu");
			var objn = 0;
			if(options != null) {
				for(var o in options.parts) {
					if(options.parts.hasOwnProperty(o)) {
						content[objn] = options.parts[objn];
						objn++
					}
				}
				if(objn == 0) {
					console.log("error:needs arguments")
				}
				itemClass = options.itemClass;
				itemHover = options.itemHover;
				if(options.topMargin != null) {
					if(options.topMargin == "auto") {
						topMargin = parseInt($(".stuckMenu").css("margin-top"))
					} else {
						if(isNaN(options.topMargin) && options.topMargin.search("px") > 0) {
							topMargin = parseInt(options.topMargin.replace("px", ""))
						} else {
							if(!isNaN(parseInt(options.topMargin))) {
								topMargin = parseInt(options.topMargin)
							} else {
								console.log("incorrect argument, ignored.");
								topMargin = 0
							}
						}
					}
				} else {
					topMargin = 0
				}
				menuSize = $("." + itemClass).size()
			}
			stickyHeight = parseInt($(this).height());
			stickyMarginB = parseInt($(this).css("margin-bottom"));
			currentMarginT = parseInt($(this).next().closest("div").css("margin-top"));
			vartop = parseInt($(this).offset().top)
		};
		$(document).on("scroll", function() {
			varscroll = parseInt($(document).scrollTop());
			if(menuSize != null) {
				for(var i = 0; i < menuSize; i++) {
					contentTop[i] = $("#" + content[i] + "").offset().top;

					function bottomView(i) {
						contentView = $("#" + content[i] + "").height() * 0.4;
						testView = contentTop[i] - contentView;
						if(varscroll > testView) {
							$("." + itemClass).removeClass(itemHover);
							$("." + itemClass + ":eq(" + i + ")").addClass(itemHover)
						} else {
							if(varscroll < 50) {
								$("." + itemClass).removeClass(itemHover);
								$("." + itemClass + ":eq(0)").addClass(itemHover)
							}
						}
					}
					if(scrollDir == "down" && varscroll > contentTop[i] - 50 && varscroll < contentTop[i] + 50) {
						$("." + itemClass).removeClass(itemHover);
						$("." + itemClass + ":eq(" + i + ")").addClass(itemHover)
					}
					if(scrollDir == "up") {
						bottomView(i)
					}
				}
			}
			if(vartop < varscroll + topMargin) {
				$(".stuckMenu").addClass("isStuck");
				$(".stuckMenu").next().closest("div").css({
					"margin-top": stickyHeight + stickyMarginB + currentMarginT + "px"
				}, 10);
				$(".stuckMenu").css("position", "fixed");
				$(".isStuck").css({
					top: "66px"
				}, 10, function() {})
			}
			if(varscroll + topMargin < vartop) {
				$(".stuckMenu").removeClass("isStuck");
				$(".stuckMenu").next().closest("div").css({
					"margin-top": currentMarginT + "px"
				}, 10);
				$(".stuckMenu").css("position", "static")
			}
		})
	})

});
jQuery(function($) {
	$(document).ready(function() {
		$('.nav-tab').stickUp();
	});

});