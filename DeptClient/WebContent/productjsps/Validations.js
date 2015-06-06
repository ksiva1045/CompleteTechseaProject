function isNull(input,i){
	var filter=/^([a-z A-Z])+$/;
	var err="error"+i;

	if(input.value==null || input.value==""){	 
		document.getElementById(err).innerHTML="Do not leave the field as empty";
		input.focus();
	}  
	else if(!filter.test( input.value)){
		document.getElementById(err).innerHTML="Enter valid Details";
		input.value="";
		input.focus();
	}
	else{
		document.getElementById(err).innerHTML="";
	}
}





function isNumber(input,i){
	var num=/^([0-9])+$/;
	var err="error"+i;

	if(input.value==null || input.value==""){ 
		document.getElementById(err).innerHTML="Do not leave the field as empty";
		input.focus();
	}  
	else if(!num.test( input.value)){
		document.getElementById(err).innerHTML="Enter valid Details";
		input.value="";
		input.focus();
	}
	else{
		document.getElementById(err).innerHTML="";
	}
}




function isSelect(input){
	alert("hai");
	if(input.value=="-" || input.value==""){ 
		document.getElementById(err).innerHTML="Do not leave the field as empty";
		input.focus();
	} 
}




function isDate(input,i){
	var err="error"+i;
	
	if(input.value==null || input.value==""){ 
		document.getElementById(err).innerHTML="Enter valid Date";
		input.focus();
	}  
	else{
		document.getElementById(err).innerHTML="";
	}
}



function EmpValidation(){
	alert("hai");
	document.frm.submit();
}