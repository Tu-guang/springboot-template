package com.tuguang.template.aop;

import com.google.gson.Gson;
import com.tuguang.template.common.ErrorCode;
import com.tuguang.template.common.ResultUtils;
import com.tuguang.template.model.entity.User;
import com.tuguang.template.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT,HEAD,PATCH");
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.OK.value());
            return false;
        }
        String authorizationHeader = request.getHeader("Authorization");
        String Token = null;
        try {
            Token = authorizationHeader.substring(authorizationHeader.indexOf(" ") + 1);
            System.out.println(Token);
        } catch (Exception e) {

        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = null;

        if (!StringUtils.isEmpty(Token)) {
            User user = userService.getLoginUser(request);
            return user != null;
        }
        try {
            writer = response.getWriter();
            writer.print(new Gson().toJson(ResultUtils.error(ErrorCode.NOT_LOGIN_ERROR, "请先登录")));
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return false;
    }
}
