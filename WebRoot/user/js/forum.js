window.onscroll = function() {
    var oScrollToTop = document.getElementById("scrollToTop");
    if (document.documentElement.scrollTop + document.body.scrollTop > 300) {
        oScrollToTop.style.display = "block";
        startMove(oScrollToTop, {
            opacity: 100
        });
    } else {
        oScrollToTop.style.display = "none";
        startMove(oScrollToTop, {
            opacity: 0
        })
    }
}
$('#scrollToTop').click(function() {
    $('html,body').animate({
        scrollTop: '0px'
    }, 800);
});
$('[data-toggle="tooltip"]').tooltip();
$('.btn-quiz').click(function() {
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
$('.full-screen-btn2').click(function() {
    if ($("#icon-btn2").hasClass("glyphicon-chevron-up")) {
        $('#text-editor2').css('height', '500');
        $("#icon-btn2").removeClass("glyphicon-chevron-up");
        $("#icon-btn2").addClass("glyphicon-chevron-down");
    } else {
        $('#text-editor2').css('height', '250');
        $("#icon-btn2").removeClass("glyphicon-chevron-down");
        $("#icon-btn2").addClass("glyphicon-chevron-up");
    }
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
$('input').iCheck({
    checkboxClass: 'icheckbox_minimal-grey',
    radioClass: 'iradio_minimal-grey',
    increaseArea: '20%' // optional
});
var editor = new wangEditor('text-editor');
editor.create();