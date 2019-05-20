$(function() {
	onSize();
	$(window).resize(function() {
		onSize();
	});
	$("#headerRightMy").click(function() {
		$("#AlertA").toggle("slow");
	})
	$(".panel").click(function() {
		ckh(this);
	})
});

function onSize() {
	if ($(window).width() > 767) {
		$("#in_width").addClass("in_width");
		$("#nav_box").addClass("nav_box");
		$("#in_width").height(($(document).height() - 60));
	} else {
		$("#in_width").removeClass("in_width");
		$("#nav_box").removeClass("nav_box");
		$("#in_width").height("100%");
	}
}

function ckh(obj) {
	$(obj).addClass("panel_active");
	$(obj).siblings().removeClass("panel_active");
}
function snamenull() {
	$("#add_school_input").val("");
}
