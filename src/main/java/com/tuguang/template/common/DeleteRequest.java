package com.tuguang.template.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    private static final long serialVersionUID = 1L;
}