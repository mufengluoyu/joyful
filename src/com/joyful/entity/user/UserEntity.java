package com.joyful.entity.user;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joyful.common.util.excel.annotation.ExcelField;
import com.joyful.entity.base.BaseEntity;

public class UserEntity extends BaseEntity{
    private String id;

    private String userName;

    private String password;

    private Integer age;

    @ExcelField(title="ID", type=1, align=2, sort=1)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    
    @JsonIgnore
	@NotNull(message="姓名不能为空")
	@ExcelField(title="姓名", align=2, sort=20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
    @NotNull(message="密码不能为空")
    @ExcelField(title="密码", align=2, sort=30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    @ExcelField(title="年龄", align=2, sort=40)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}