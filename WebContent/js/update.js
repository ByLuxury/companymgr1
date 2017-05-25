function link(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';  
}
function tip(){
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none';
}
function checkvid(){
	var str=document.getElementById('vid');
	if(str.value.match("[0-9]{10}$")==null){
		str.value="ID不符合要求";
		str.style.color="red";
	}
	else{
		str.style.color="Black";
	}
}