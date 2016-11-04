package org.feiyu.myblog.admin.dao;/**
 * Created by feiyu on 2016/10/22.
 */

import org.apache.ibatis.annotations.Param;
import org.feiyu.myblog.admin.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author feiyu
 * @version 1.0
 * @Title: UserDao
 * @description 用户管理数据库访问层
 * @create 2016/10/22
 */
@Repository("userDao")
public interface UserDao {

    /**
     * @title: login
     * Create By feiyu
     * @description: 博主登录操作
     * @params:  * @param name
     * @param password
     * @Date: 2016/10/22
     * @return: User 用户实体
     */
    User login(@Param("userName") String name, @Param("password") String password);

    /**
     * @title: getUserInfo
     * Create By feiyu
     * @description: 获取博主信息
     * @params:  * @param null
     * @Date: 2016/10/22
     * @return: User 用户实体
     */
    User getUserInfo();

    /**
     * @title: upDate
     * Create By feiyu
     * @description: 修改用户信息
     * @params:  * @param User
     * @Date: 2016/10/24
     * @return: int 受影响的行数
     */
    int update(@Param("user") User user);

    int updatePwd(String password);
}
