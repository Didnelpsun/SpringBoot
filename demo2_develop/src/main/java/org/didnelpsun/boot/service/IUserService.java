// IUserService.java
package org.didnelpsun.boot.service;

import org.didnelpsun.boot.bean.User;
import java.util.List;

public interface IUserService {
    // 查询所有用户
    List<User> selectAllUsers();
    // 查询一个用户
    User selectUser(Integer id);
    // 插入用户
    void insertUser(User user);
    // 更新用户
    void updateUser(User user);
    // 删除用户
    void deleteUser(Integer id);
    // 根据用户名模糊查询用户
    List<User> selectUsersByName(String name);
    // 获取用户总数
    Integer getUsersSum();
}
