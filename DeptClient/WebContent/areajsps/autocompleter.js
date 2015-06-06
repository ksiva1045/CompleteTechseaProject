$(document).ready(function() {
        $(function() {    	
                $("#productid").autocomplete({   
                source : function(request, response) {
                	  var productCatId = $('#productcatid1').val();
                $.ajax({               	
                        url : "ProductSearchByWord",
                        type : "GET",
                        data : {
                        	term : request.term,
                        	productCatId:productCatId
                        },
                        dataType : "json",
                        success : function(data) { 
                        	alert(productCatId);
                                response(data);
                                
                        }
                });
        }
});
});
});






$(document).ready(function() {
        $(function() {
                $("#location").autocomplete({     
                source : function(request, response) {
                $.ajax({
                        url : "AreaSearchByWord",
                        type : "GET",
                        data : {
                                term : request.term
                        },
                        dataType : "json",
                        success : function(data) {                        		                       		
                                response(data);
                                
                        }
                });
        }
});
});
});