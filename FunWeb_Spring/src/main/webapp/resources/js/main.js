$(document).ready(function() {	
	$.ajax({		
		url: "AJAX_recipeList",
		type: "POST",
		contentType: "application/json; charset=utf-8;",
		dataType: "json",
		success: function(data){
			for(var i = 0 ; i < data.length ; i++){
				$('.hot_recipe').append("<tr><td id='contxt'><a href='#'>"+data[i].subject+"</a></td><td>"+data[i].date+"</td><td>"+data[i].readcount+"</td></tr>");
			}
		},
		error: function(data){
			console.log();
		}
	});
});