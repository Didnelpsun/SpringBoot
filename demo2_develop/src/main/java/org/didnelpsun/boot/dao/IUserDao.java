// IUserDao.java
package org.didnelpsun.boot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.didnelpsun.boot.bean.User;
import java.util.List;

//@Repository
// 这里不能使用@Repository，因为这个注释需要配置扫描地址，否则报错
// Parameter 0 of method setUserDao in org.didnelpsun.boot.service.UserServiceImpl required a bean of type 'org.didnelpsun.boot.dao.IUserDao' that could not be found.
// @Mapper不需要配置扫描地址，所有的Mapper注解都会被扫描到
@Mapper
public interface IUserDao {
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
