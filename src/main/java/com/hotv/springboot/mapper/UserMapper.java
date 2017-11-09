package com.hotv.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hotv.springboot.core.QueryFilter;
import com.hotv.springboot.entity.User;

/**
 * mybatis映射接口
 * 注意：一下方法名必须与对应的mapper.xml文件中的sql id一致
 * @author hotv
 */
@Mapper
public interface UserMapper {

	/**
	 * 根据userId获取对象
	 * @param userId
	 * @return
	 */
	User getUserById(@Param("userId") String userId);
	
	/**
	 * 获取用户列表
	 * @param userId
	 * @return
	 */
	List<User> getList();
	

	/**
	 * 根据username获取用户 主要是使用QueryFilter
	 * @param userId
	 * @return
	 */
	User getUserByUsername(QueryFilter filter);
	
}
