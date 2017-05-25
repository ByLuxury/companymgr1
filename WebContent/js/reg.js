function checkformname(){
	var regname=/^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$/;
	var fname=document.getElementById("username");
	var ftname=document.getElementById("sname");
	var ftj=document.getElementById("tj");
	if(fname.value==""){
		ftname.className="frred";
		ftname.innerHTML="<font color='red'>× 请输入用户名</font>";
	}
	else{
		if(fname.value.match(regname)){
			 ftj.removeAttribute('disabled');
			ftname.className="fgren";
			ftname.innerHTML="<font color='green'>√用户名可用!</font>";
		}
		else{
			ftname.className="frred";
			ftname.innerHTML="<font color='red'>× 格式错误</font>";
			ftj.disabled=true;
		}}
	}
function checkpwd(){
	var fpwd=document.getElementById("pwd");
	var ftpwd=document.getElementById("spwd");
	if(fpwd.value==""||fpwd.value.length<4||fpwd.value.length>20){
		ftpwd.className="frred";
		ftpwd.innerHTML="<font color='red'>× 不可用</font>";
	}
	else{
		ftpwd.className="fgren";
		ftpwd.innerHTML="<font color='green'>√密码名可用!</font>";
	}
} 
function validate() {
	var pwd1 = document.getElementById("pwd").value;
	var pwd2 = document.getElementById("pwd2").value;
	//<!-- 对比两次输入的密码 -->
	if(pwd1 == pwd2) {
		document.getElementById("tj").removeAttribute('disabled');
		document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
		
	}
	else {
		document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
		document.getElementById("tj").disabled = true;
	}
}
function check(){
	var form = document.getElementById("form");
	var inputs=document.getElementsByTagName("input");
	var username = inputs[0].value,pwd =inputs[1].value,pwd2 = inputs[2].value;
	if(username == ""|| pwd ==""|| pwd2==""){
		alert("不能为空")
		return false;
	}
	form.submit();
}
function ale(){
        //这个基本没有什么说的，就是弹出一个提醒的对话框
  
}
// function rabit(){
// 	var rabit = new Array();
// 	rabit[0]=checkformname();
// 	rabit[1]=checkpwd();
// 	rabit[2]=validate();
// 	return rabit;
// }
// function checksubmit(){
// 	var w = new Array();  
// 	w = Rabbit();  
// 	var a = 0;  
// 	var s = 1;  
// 	for (var i = 0; i <= 3; i++) {  
// 		if(w[i]==true){  
// 			a++;console.warn(a);  
// 		}  
// 		console.warn(w[i]);  
// 	}  

// 	if (a == 3) {  
// 		window.location.href='file:///C:/Users/%E8%92%99/Desktop/text/ruanjianbei/home.html';   
// 	}  
// 	else{  
// 		alert('请按规定输入完整的注册资料！');  
// 		var rabit;  
// 		rabit = checkformname();  
// 		if (rabit == false) {  
// 			var fname=document.getElementById("username");
// 			fname.focus();  
// 		}  
// 		rabit = checkpwd();  
// 		if (rabit == false) {  
// 			var fpwd=document.getElementById("pwd");
// 			fpwd.focus();  
// 		}  
// 		Rabit = password2();  
// 		if (Rabit == false) {  
// 			var password2focus = document.getElementById('password2');  
// 			password2focus.focus();  
// 		}  
// 		Rabit = password();  
// 		if (Rabit == false) {  
// 			var passwordfocus = document.getElementById('password');  
// 			passwordfocus.focus();  
// 		} 
// 	}