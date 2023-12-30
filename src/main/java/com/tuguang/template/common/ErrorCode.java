package com.tuguang.template.common;

/**
 * 自定义错误码
 *
 */
public enum ErrorCode {

    SUCCESS(200, "success"),
    PARAMS_ERROR(301, "请求参数错误"),
    NOT_LOGIN_ERROR(402, "未登录"),
    NO_AUTH_ERROR(403, "无权限"),
    NOT_FOUND_ERROR(405, "请求数据不存在"),
    AUTH_ERROR(406, "登录过期"),
    FORBIDDEN_ERROR(400, "禁止访问"),
    SYSTEM_ERROR(500, "系统内部异常"),
    OPERATION_ERROR(501, "操作失败");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
