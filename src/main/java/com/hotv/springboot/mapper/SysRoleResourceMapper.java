package com.hotv.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hotv.springboot.core.QueryFilter;
import com.hotv.springboot.entity.SysRoleResource;

/**
 * mybatis映射接口
 * 注意：一下方法名必须与对应的mapper.xml文件中的sql id一致
 * @author hotv
 */
@Mapper
public interface SysRoleResourceMapper {

	/**
	 * 获取列表
	 * @return
	 */
	List<SysRoleResource> list();
	
	/**
	 * 根据登陆用户获取权限
	 * @return
	 */
	List<SysRoleResource> getResourcesByUsername(QueryFilter filter);
	
}
