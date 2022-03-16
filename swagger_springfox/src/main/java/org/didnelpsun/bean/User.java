// User.java
package org.didnelpsun.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

@ApiModel("用户实体类")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    @ApiModelProperty("用户ID")
    private Integer id;
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("地址")
    private String address;
}