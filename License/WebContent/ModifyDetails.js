$(document).ready(function() {

	console.log("modify ajax");
	$('#Update').click(function() {
		
		
		$.ajax({
			type : "GET",
			url : "FetchServlet",
			data : {
				email : $("#email").val()
			},
			success : function(result) {
				$("#msg").html(result);
				result=result.split(",");
				console.log("result is :"+result[10]);
				document.getElementById("licenseType_disable").value = result[10];
				document.getElementById("address_show").value = result[5];
				document.getElementById("contactNo_show").value = result[2];
				document.getElementById("dob_show").value = result[11];

				document.getElementById("bloodGroup_show").value = result[4];
				document.getElementById("place_show").value = result[6];

				document.getElementById("fatherName_disable").value = result[1];
				document.getElementById("issueDtae_disable").value = result[8];
				document.getElementById("expiryDtae_disable").value = result[9];


				
			},
			error : function(error) {
				console.log(error);
				$("#msg").html(error);
			}
		});
		
		
		
		
		$("#modify").attr( "style", "display: block !important;" );
		$("#message").attr( "style", "display: none !important;" );

		console.log("modifyDetails ajax");
	});
});
