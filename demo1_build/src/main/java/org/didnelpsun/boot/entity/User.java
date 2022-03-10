// User.java
package org.didnelpsun.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private String name;
    private String password;
    private Integer age;
    public User(String name, String password){
        this.name = name;
        this.password = password;
        log.info("缺失age值");
    }
}
