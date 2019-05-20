window.onload = function() {
    // Swiper
    var mainSwiper = new Swiper('#swiper-main', {
        mode: 'vertical',
        mousewheelControl: true,
        resistance: '100%',
        keyboardControl: true,
        speed: 800,
        onFirstInit: function(swiper) {
            swiperAnimateCache(swiper); //隐藏动画元素 
            swiperAnimate(swiper); //初始化完成开始动画
        },
        onSlideChangeEnd: function(swiper) {
            swiperAnimate(swiper); //每个slide切换结束时也运行当前slide动画
            if (mainSwiper.slides[1].isActive()) {
                setTimeout(function() {
                    $("#resource-contain").addClass("active");
                }, 800);
            } else {
                $("#resource-contain").removeClass("active");
            }
        },
    });
    $("#arrow").click(function() {
        mainSwiper.swipeNext();
    });
}