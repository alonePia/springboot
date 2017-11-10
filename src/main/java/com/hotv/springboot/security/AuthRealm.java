package com.hotv.springboot.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.catalina.Role;
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

import com.fasterxml.jackson.databind.Module;
import com.hotv.springboot.entity.User;


public class AuthRealm extends AuthorizingRealm {
   private Logger logger = Logger.getLogger(AuthRealm.class);

   //认证.登录
   @Override
   protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
       String username = utoken.getUsername();
       //User user = userService.findUserByUserName(username);
       User user = null;
       return new SimpleAuthenticationInfo(user, user.getUsername(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
   }
   //授权
   @Override
   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
       User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
       List<String> permissions=new ArrayList<>();
       Set<Role> roles =null;
       if(roles.size()>0) {
           for(Role role : roles) {
               Set<Module> modules = null;
               if(modules.size()>0) {
                   for(Module module : modules) {
                       permissions.add("module.getMname()");
                   }
               }
           }
       }
       SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
       info.addStringPermissions(permissions);//将权限放入shiro中.
       return info;
   }

}
