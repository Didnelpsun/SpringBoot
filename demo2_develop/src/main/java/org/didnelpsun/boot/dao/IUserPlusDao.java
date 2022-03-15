// IUserPlusDao.java
package org.didnelpsun.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.didnelpsun.boot.bean.User;

// 操作哪个类型的数据就向泛型传输哪个类型的数据
@Mapper
public interface IUserPlusDao extends BaseMapper<User> {
    // MyBatis-Plus封装了基本的增删改查方法
}
