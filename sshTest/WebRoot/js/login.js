window.onload=function(){
   $("#registerTitle").click(function(){
	 $("#login").fadeOut();
	 $("#register").fadeIn();
	 $("#submit1").animate({
	      top:"500px",
	    }, 600, function () {
	    });
	 $("#form").animate({
	      height:"400px",
	    }, 600, function () {
	    });
	 $("#email").fadeIn();
   });
   $("#loginTitle").click(function(){
		 $("#login").fadeIn();
		 $("#register").fadeOut();
		 $("#submit").animate({
		      top:"430px",
		    }, 600, function () {
		    });
		 $("#form").animate({
		      height:"360px",
		    }, 600, function () {
		    });
		 $("#email").fadeOut();
	   });
}