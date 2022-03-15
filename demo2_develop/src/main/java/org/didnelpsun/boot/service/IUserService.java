// IUserService.java
package org.didnelpsun.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.didnelpsun.boot.bean.User;

// IService需要一个泛型，为操作数据的类型
public interface IUserService extends IService<User> {
}
