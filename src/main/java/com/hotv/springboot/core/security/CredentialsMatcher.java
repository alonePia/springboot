package com.hotv.springboot.core.security;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 自定义密码比较器
 * @author hotv
 *
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher{
	Logger logger = Logger.getLogger(CredentialsMatcher.class);

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用MD5加密的方式去检验)
        String inPassword = new String(new Md5Hash(utoken.getPassword()).toHex());
        //获得数据库中的密码
        String dbPassword= (String) info.getCredentials();
        //进行密码的比对
        //logger.debug("CredentialsMatcher doCredentialsMatch inPassword:"+inPassword);
        //logger.debug("CredentialsMatcher doCredentialsMatch dbPassword:"+dbPassword);
        logger.debug("CredentialsMatcher doCredentialsMatch "+this.equals(inPassword, dbPassword));
        return this.equals(inPassword, dbPassword);
    }
    
}
