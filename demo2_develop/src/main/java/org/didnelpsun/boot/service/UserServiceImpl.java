// UserService.java
package org.didnelpsun.boot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.didnelpsun.boot.bean.User;
import org.didnelpsun.boot.dao.IUserPlusDao;
import org.springframework.stereotype.Service;

// ServiceImpl有两个参数，第一个是操作的DAO接口，第二个是操作的数据类型
@Service
public class UserServiceImpl extends ServiceImpl<IUserPlusDao, User> implements IUserService {
}
