<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <title>FreeMarker Index</title>
  </head>

  <body>
	
	<h1>spring boot Freemarker、Mybatis</h1>
	<#if userList?exists && (userList?size != 0)>
		<#list userList as user>
			<p>用户名:${user.username!}、密码：${user.password!}</p>	
		</#list>
	</#if>
	
	<@shiro.authenticated />
	
	<@shiro.hasAnyRoles name="ADMIN,:sys:add">
		<p><a href="#">新增</a><p>
	</@shiro.hasAnyRoles>
	
	<@shiro.hasAnyRoles name="ADMIN,:sys:delete">
		<p><a href="#">删除</a><p>
	</@shiro.hasAnyRoles>
	
	<@shiro.hasAnyRoles name="ADMIN,:sys:update">
		<p><a href="#">修改</a><p>
	</@shiro.hasAnyRoles>
	
	<@shiro.hasAnyRoles name="ADMIN,:sys:detail">
		<p><a href="#">详情</a><p>
	</@shiro.hasAnyRoles>
	
  </body>
</html>