package com.hotv.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hotv.springboot.entity.SysUserRole;

/**
 * mybatis映射接口
 * 注意：一下方法名必须与对应的mapper.xml文件中的sql id一致
 * @author hotv
 */
@Mapper
public interface SysUserRoleMapper {

	/**
	 * 获取列表
	 * @return
	 */
	List<SysUserRole> list();
	
	
}
