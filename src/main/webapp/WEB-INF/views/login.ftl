<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>Sign In</title>
    <script src="/assets/static/jquery-2.1.0.min.js"></script>
  </head>

  <body>
	<form id="myFormId" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input name="username" id="username" type="text" value="hotv" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="password" id="password" type="password" value="123456" /></td>
			</tr>
			<tr>
				<td cols="2"><input name="submit" id="submit" type="button" value="Sign In" /></td>
			</tr>
		</table>
	</form>
  </body>
  
  <script>
  	$(function(){
  		$("#submit").click(function(){
  			$.ajax({  
		        type:'post',  
		        traditional :true,  
		        url:'/login.json',  
		        data:$("#myFormId").serialize(),  
		        success:function(data){
		        	if(data.success){
		        		location.href = "/index.html";
		        	}else{
		        		alert(data.message);
		        	}
		        },
		        error:function(data){
		        	alert(data.message);
		        }
		    });
  		});
  	});
  </script>
</html>