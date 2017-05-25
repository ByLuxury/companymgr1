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

function check(){
   var a = /^(\d{4})-(\d{2})-(\d{2})$/;
   var ss=document.getElementById("createtime");
  if (!a.test(document.getElementById("createtime").value)) { 
   		 ss.value="格式错误";
   		 ss.style.color="red";
 		return false 
 } 
else{
		ss.style.color="Black";
	return true
} 
} 

function jee(){
	var sl=document.getElementById("sl");
	var dj=document.getElementById("dj");
	var je=document.getElementById("je");
	 je.value=je.value+sl.value;
	 je.value=je.value+"*";
	 je.value=je.value+dj.value;
	var numbers;
	numbers=eval(je.value);
	je.value=numbers;
}

 function se(){
	var shuilv=document.getElementById("shuilv");
	var je=document.getElementById("je");
	var shuie=document.getElementById("shuie");
	var number=(Number(shuilv.value)*Number(je.value)).toFixed(2);
	shuie.value=number;
}
 function jisshui(){
 	var je=document.getElementById("je");
 	var shuie=document.getElementById("shuie");
 	var sum=document.getElementById("sum");
 	var number=(Number(je.value)+Number(shuie.value)).toFixed(2);
 	sum.value=number;
 }

 function link(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';  
}
function tip(){
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none';
}
