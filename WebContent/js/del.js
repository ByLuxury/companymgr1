function checkformvid()
{ 
	var date1 = document.getElementById("vid").value;
	if(date1.match("^\\d[0,9]{0,9}$")==null)
	{	
		document.getElementById("vvid").style.color="red";
		//document.getElementById("test").style.color="red";
		document.getElementById("vvid").innerHTML = '请输入';
	}	 
	else
	{	
		document.getElementById("vvid").style.color="black";
		//document.getElementById("test").style.color="yellow";
		
	}
	
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
function tick(){  
    var today;  
    today = new Date();  
    document.getElementById("localtime").innerHTML = showLocale(today);  
    window.setTimeout("tick()", 1000);  
}  
  
function link(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';  
}
function tip(){
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none';
}