package com.turing.service.impl;

import com.turing.entity.SysUsers;
import com.turing.mapper.SysUsersMapper;
import com.turing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUsersMapper usersMapper;

    @Override
    public boolean login(SysUsers sysUsers) {
        return usersMapper.login(sysUsers) != null? true:false;
    }
}
