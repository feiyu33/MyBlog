package org.feiyu.myblog.admin.service;
/**
 * Created by feiyu on 2016/10/21.
 */

import org.feiyu.myblog.admin.dao.UserDao;
import org.feiyu.myblog.admin.entity.User;
import org.feiyu.myblog.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>description 用户管理业务操作实现类</p>
 *
 * @author feiyu
 * @version 1.0
 * @create 2016/10/21
 */

/**
 * @Transactional 注解中的属性：
 * propagation : 事务的传播行为
 * isolation : 事务的隔离级别
 * readOnly : 只读
 * rollbackFor : 发生哪些异常回滚
 * noRollbackFor ： 发生哪些异常不回滚
 */
@Service("userService")
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public boolean login(String name,String password) throws Exception {
        String pwd = MD5Util.MD5Encode(password);
        User user = userDao.login(name,pwd);
        if(user != null){
            return true;
        }
        return false;
    }

    public User getUserInfo() throws Exception {
        return userDao.getUserInfo();
    }

    public boolean update(User user) throws Exception {
        int rows = userDao.update(user);
        if(rows == 1){
            return true;
        }
        return false;
    }

    public boolean updatePwd(String name, String password,String newPassword) throws Exception {
        User user = userDao.login(name,MD5Util.MD5Encode(password));
        if(user != null){
            String pwd = MD5Util.MD5Encode(newPassword);
            int rows = userDao.updatePwd(pwd);
            if(rows == 1){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }
}
