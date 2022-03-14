//// User.java
//package org.didnelpsun.boot.bean;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Controller;
//
//import java.util.Date;
//import java.util.Map;
//import java.util.Set;
//
//@ConfigurationProperties(prefix = "user")
//@Controller
//@Data
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//public class User {
//    private Integer id;
//    private String name;
//    private Date birthday;
//    private Boolean sex;
//    private Account primeAccount;
//    private String[] interests;
//    private Set<Account> accounts;
//    private Map<String, Float> scores;
//}

// User.java
package org.didnelpsun.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private Integer id;
    private String name;
    private Date birthday;
    private String sex;
    private String address;
}
