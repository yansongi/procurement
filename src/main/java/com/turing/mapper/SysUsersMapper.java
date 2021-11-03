package com.turing.mapper;

import com.turing.entity.SysUsers;
import com.turing.entity.SysUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysUsersMapper {
    int countByExample(SysUsersExample example);

    int deleteByExample(SysUsersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    List<SysUsers> selectByExample(SysUsersExample example);

    SysUsers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUsers record, @Param("example") SysUsersExample example);

    int updateByExample(@Param("record") SysUsers record, @Param("example") SysUsersExample example);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);

    //登录
    @Select("SELECT * FROM SYS_USERS WHERE LOGIN_ID=#{loginId} AND PASSWORD=#{password}")
    SysUsers login(SysUsers sysUsers);
}