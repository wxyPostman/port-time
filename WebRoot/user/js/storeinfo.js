$(function(){
	//设置评分星星宽度
	console.log(parseFloat($("#score_num").text().trim())/5);
	var width=parseFloat($("#score_num").text().trim())/5*100+"%";
	$("#star").width(width);
});
