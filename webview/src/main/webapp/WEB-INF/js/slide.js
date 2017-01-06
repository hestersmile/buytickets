$(function(){
	var menu=$("#menu");
	var menu_li=menu.find("li:has(a)");
	var menu_li_width=menu.width()/3;
	var menu_margin_right=parseInt(menu.css("margin-right"));
	var distance=(type-1)*menu_li_width+menu_margin_right;
	var slide=$("#slide");
	slide.css("right",distance);

	menu_li.each(function(index){
		$(this).mouseover(function(){
			slide.css("right",(2-index)*menu_li_width+menu_margin_right);
		});
		$(this).mouseout(function(){
			slide.css("right",distance);
		});
	});

	$("#search").click(function(){
		$("#search_area").toggle();
	});
	$(window).resize(function(){
		menu_li_width=menu.width()/3;
		menu_margin_right=parseInt(menu.css("margin-right"));
		distance=(type-1)*menu_li_width+menu_margin_right;
		slide.css("right",distance);
	});
});
