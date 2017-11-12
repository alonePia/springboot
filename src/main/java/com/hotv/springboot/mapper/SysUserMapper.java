package com.hotv.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hotv.springboot.core.QueryFilter;
import com.hotv.springboot.entity.SysUser;

/**
 * mybatis映射接口
 * 注意：一下方法名必须与对应的mapper.xml文件中的sql id一致
 * @author hotv
 */
@Mapper
public interface SysUserMapper {
	
	/**
	 * 获取用户列表
	 * @param userId
	 * @return
	 */
	List<SysUser> list();
	
	/**
	 * 根据username获取对象
	 * @param filter
	 * @return
	 */
	SysUser getUserByUsername(QueryFilter filter);
	
	/**
	 * 登录
	 * @param filter
	 * @return
	 */
	SysUser login(SysUser sysUser);
}
