package com.tuguang.template.common;

import com.tuguang.template.constant.CommonConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页请求
 *
 */
@Data
public class PageRequest {

    /**
     * 当前页号
     */
    @ApiModelProperty(value = "当前页号，默认1")
    private long current = 1;

    /**
     * 页面大小
     */
    @ApiModelProperty(value = "页面大小，默认10")
    private long pageSize = 10;

    /**
     * 排序字段
     */
    @ApiModelProperty(value = "排序字段")
    private String sortField;

    /**
     * 排序顺序（默认升序）
     */
    @ApiModelProperty(value = "排序顺序（默认升序）")
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;
}
