package com.hull.service;

import com.hull.dao.UserMapper;
import com.hull.entity.User;
import com.hull.utils.Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */

@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(String userId) {
        try {
            return userMapper.deleteByPrimaryKey(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        try {
//            record.setUserId(Tools.getUUID());    //自增长
            record.setCreateTime(new Date());
            return userMapper.insertSelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User selectByPrimaryKey(String userId) {
        try {
            return userMapper.selectByPrimaryKey(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        try {
            return userMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<User> selectAll(User user) {
        List<User> userList = new ArrayList<>();
        try {
            userList = userMapper.selectAll(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    @Transactional
    public void test() throws Exception {
        User user = new User();
        user.setUserId("99");
        user.setUserName("99");
        userMapper.insertSelective(user);
        user.setUserId("100");
        user.setUserName("100");
        userMapper.insertSelective(user);
        user.setUserId("100");
        user.setUserName("100");
        userMapper.insertSelective(user);
    }
}
