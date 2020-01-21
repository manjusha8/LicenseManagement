$(document).ready(function() {

	console.log("addDetails ajax");
	$('#add').click(function() {
		
		$("#addDetails").attr( "style", "display: block !important;" );
		console.log("AddDetails ajax");

		
		
//		$.ajax({
//			type : "POST",
//			url : "RegisterEmail",
//			data : {
//				email : $("#email").val()
//			},
//			success : function(result) {
//				$("#msg").html(result);
//				console.log("result is :"+result);
//				
//			},
//			error : function(error) {
//				console.log(error);
//				$("#msg").html(error);
//			}
//		});
	});
});
