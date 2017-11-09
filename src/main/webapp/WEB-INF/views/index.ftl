<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>FreeMarker Index</title>
  </head>

  <body>
	
	<h1>spring boot Freemarker、Mybatis</h1>
	<#if userList?exists && (userList?size != 0)>
		<#list userList as user>
			<p>用户名:${user.username!}、地址：${user.address!}</p>	
		</#list>
	</#if>
  </body>
</html>