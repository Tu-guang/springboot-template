package com.tuguang.template.model.dto.user;

import com.tuguang.template.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户查询请求
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 账号
     */
    private String account;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 用户角色：user/ admin
     */
    private String role;


    private static final long serialVersionUID = 1L;
}