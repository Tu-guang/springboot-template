package com.tuguang.template.model.dto.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户创建请求
 *
 * @author
 */
@Data
public class UserAddRequest implements Serializable {


    /**
     * 账号
     */
    private String account;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户简介
     */
    private String profile;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 用户角色：user/ admin
     */
    private String role;

    /**
     * 密码
     */
    private String password;


    private static final long serialVersionUID = 1L;
}