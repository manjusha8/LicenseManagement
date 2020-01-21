$(document).ready(function() {

	$('#Update').click(function() {
		console.log("clicked submit");

		$("#modify").show();
		$.ajax({
			type : "GET",
			url : "UpdateDetails",
			success : function(result) {
				console.log(result);
				$("#msg").html(result);
			},
			error : function(error) {
				console.log(error);
				$("#msg").html(error);
			}
		});
	});
});
