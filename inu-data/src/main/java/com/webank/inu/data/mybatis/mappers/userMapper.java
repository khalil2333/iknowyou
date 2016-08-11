package com.webank.inu.data.mybatis.mappers;

import com.webank.inu.data.mybatis.model.User;

/**
 * Created by potato on 2016/8/11.
 */
public interface UserMapper {
    public User getUser(int id);
}
