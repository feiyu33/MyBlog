package org.feiyu.myblog.admin.service;
/**
 * Created by feiyu on 2016/10/21.
 */

import org.feiyu.myblog.admin.entity.User;

/**
 * <p>Title: Userservice</p>
 * <p>description 用户管理业务接口</p>
 *
 * @author feiyu
 * @version 1.0
 * @create 2016/10/21
 */
public interface UserService {

    /**
     * @title: login
     * Create By feiyu
     * @description: 用户登录
     * @params:  * @param null
     * @Date: 2016/10/21
     * @return: boolean
     */
    boolean login(String name,String password) throws Exception;

    /**
     * @title: getUserInfo
     * Create By feiyu
     * @description: 获取博主信息
     * @params:  * @param null
     * @Date: 2016/10/22
     * @return: User
     */
    User getUserInfo() throws Exception;

    /**
     * @title: update
     * Create By feiyu
     * @description: 更新博主信息
     * @params:  * @param User
     * @Date: 2016/10/24
     * @return: void
     */
    boolean update(User user) throws Exception;

    /**
     * @title: updatePwd
     * Create By feiyu
     * @description: 修改密码
     * @params:  * @param null
     * @Date: 2016/10/24
     * @return: void
     */
    boolean updatePwd(String userName,String rePwd, String password) throws Exception;
}
