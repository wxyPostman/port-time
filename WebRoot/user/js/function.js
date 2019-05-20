$(function() {
    $('input').iCheck({
        checkboxClass: 'icheckbox_minimal-grey',
        radioClass: 'iradio_minimal-grey',
        increaseArea: '20%' // optional
    });
    $('[data-toggle="tooltip"]').tooltip();
    $(".upload-avatar").click(function() {
        $("#upload-main").addClass('animated fadeOutUp');
        $("#upload-main").removeClass('fadeInDown');
        setTimeout(function() {
            $("#upload-main").css('display', 'none');
            $("#upload-success").css('display', 'block');
            $("#upload-success").addClass('animated fadeInDown');
            $("#upload-main").removeClass('animated fadeOutUp');
        }, 500);
    });
    $(".upload-back").click(function() {
        $("#upload-success").removeClass('fadeInDown');
        $("#upload-success").addClass('fadeOutUp');
        setTimeout(function() {
            $("#upload-success").css('display', 'none');
            $("#upload-main").css('display', 'block');
            $("#upload-main").addClass('animated fadeInDown');
            $("#upload-success").removeClass('animated fadeOutUp');
        }, 500);
    });
    $('#edit-avatar').on('hide.bs.modal', function(e) {
        setTimeout(function() {
            $("#upload-main").removeClass('animated fadeInDown');
            $("#upload-main").removeClass('animated fadeOutUp');
            $("#upload-success").removeClass('animated fadeOutUp');
            $("#upload-success").removeClass('animated fadeInDown');
            $("#upload-main").css('display', 'block');
            $("#upload-success").css('display', 'none');
        }, 500);
    })
    $('.full-screen-btn').click(function() {
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
    $('.btn-quiz').click(function() {
        $('#new-quiz').css('display', 'block');
    });
    $('#quiz-close').click(function() {
        $('#new-quiz').css('display', 'none');
    });
    var editor = new wangEditor('text-editor');
    editor.create();
    $.stellar({
        horizontalScrolling: false,
        responsive: true
    });
});