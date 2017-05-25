function checkformname(){
	var regname=/^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$/;
	var fname=document.getElementById("username");
	var ftname=document.getElementById("sname");
	var fdlu=document.getElementById("dlu");
	if(fname.value==""){
		ftname.className="frred";
		ftname.innerHTML="<font color='red'>× 请输入用户名</font>";
	}
	else{
		if(fname.value.match(regname)){
			 fdlu.removeAttribute('disabled');
			ftname.className="fgren";
			ftname.innerHTML="<font color='green'>√用户名可用!</font>";
		}
		else{
			ftname.className="frred";
			ftname.innerHTML="<font color='red'>× 格式错误，请检查</font>";
			fdlu.disabled=true;
		}}
	}
function checkpwd(){
		var fpwd=document.getElementById("pwd");
		var ftpwd=document.getElementById("spwd");
		if(fpwd.value==""||fpwd.value.length<4||fpwd.value.length>20){
			ftpwd.className="frred";
			ftpwd.innerHTML="<font color='red'>× 用户密码:4-20位</font>";
		}
		else{
			ftpwd.className="fgren";
			ftpwd.innerHTML="<font color='green'>√密码名可用!</font>";
		}
	} 