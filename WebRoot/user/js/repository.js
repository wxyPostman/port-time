$(function() {
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        paginationClickable: true,
        grabCursor : true,
        speed:800,
    });


	$("#side-avatar").click(function() {
    	$('.side-nav-container').toggleClass('unfold');
    })
    
    
});