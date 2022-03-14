// UserService.java
package org.didnelpsun.boot.service;

import org.didnelpsun.boot.bean.User;
import org.didnelpsun.boot.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    @Autowired
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> selectAllUsers() {
        return userDao.selectAllUsers();
    }

    @Override
    public User selectUser(Integer id) {
        return userDao.selectUser(id);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> selectUsersByName(String name) {
        return userDao.selectUsersByName(name);
    }

    @Override
    public Integer getUsersSum() {
        return userDao.getUsersSum();
    }
}
