$(document).ready(function() {

	console.log("email ajax");
	$('#email').change(function() {
		console.log("email ajax");

		var email = $("#email").val();
		console.log("email id in ajax : "+email);
		
		$.ajax({
			type : "POST",
			url : "RegisterEmail",
			data : {
				email : $("#email").val()
			},
			success : function(result) {
				$("#msg").html(result);
				console.log("result is :"+result);
				
			},
			error : function(error) {
				console.log(error);
				$("#msg").html(error);
			}
		});
	});
});
