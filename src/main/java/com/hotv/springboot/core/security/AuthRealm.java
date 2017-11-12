package com.hotv.springboot.core.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotv.springboot.core.QueryFilter;
import com.hotv.springboot.entity.SysRoleResource;
import com.hotv.springboot.entity.SysUser;
import com.hotv.springboot.mapper.SysRoleResourceMapper;
import com.hotv.springboot.mapper.SysUserMapper;

/**
 * 验证登录 及 分配权限
 * @author hotv
 * @since 2017-11-12
 */
public class AuthRealm extends AuthorizingRealm {
   private Logger logger = Logger.getLogger(AuthRealm.class);
   
   @Autowired
   private SysUserMapper sysUserMapper;
   
   @Autowired
   private SysRoleResourceMapper sysRoleResourceMapper;

   //认证.登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println("----------------AuthRealm 认证登录----------------");
		logger.debug("AuthRealm doGetAuthenticationInfo 认证登录");
		UsernamePasswordToken utoken = (UsernamePasswordToken) token;// 获取用户输入的token
		String username = utoken.getUsername();
		QueryFilter filter = new QueryFilter();
		filter.put("username", username);
		SysUser sysUser = sysUserMapper.getUserByUsername(filter);
		logger.debug("AuthRealm doGetAuthenticationInfo sysUser:" + sysUser.getUsername() + ",password:"
				+ sysUser.getPassword());
		return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), this.getClass().getName());// 放入shiro.调用CredentialsMatcher检验密码
	}
   
   //授权
   @Override
   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
	   System.err.println("----------------AuthRealm 授权----------------");
	   logger.debug("AuthRealm doGetAuthorizationInfo 授权");
	   SysUser sysUser=(SysUser) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
       //List<String> permissions=new ArrayList<>();
       Set<String> roles = new HashSet<String>();
       QueryFilter filter = new QueryFilter();
       filter.put("username", sysUser.getUsername());
       List<SysRoleResource> resources = sysRoleResourceMapper.getResourcesByUsername(filter);
       if(resources.size()>0) {
           for(SysRoleResource res : resources) {
        	   logger.debug("AuthRealm doGetAuthorizationInfo username:"+sysUser.getUsername()+", resource:"+res.getResource());
               //permissions.add(res.getResource());//权限
               roles.add(res.getResource());//角色
           }
       }
       SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
       info.setRoles(roles);
       //info.addStringPermissions(permissions);//将权限放入shiro中.
       return info;
   }

}
