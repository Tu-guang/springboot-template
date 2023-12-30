package com.tuguang.template.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String username;

    private String account;

    private String password;

    private String check_password;
}
