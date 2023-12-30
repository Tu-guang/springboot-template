package com.tuguang.template.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 已登录用户视图（脱敏）
 *
 **/
@Data
public class LoginUserVO implements Serializable {

    /**
     * 用户 id
     */

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 用户简介
     */
    private String profile;

    /**
     * 用户角色：user/admin/ban
     */
    private String role;

    /**
     * 登录鉴权：token
     */
    private String token;

    /**
     * 创建时间
     */
    private Date create_time;

    /**
     * 更新时间
     */
    private Date update_time;

    private static final long serialVersionUID = 1L;
}