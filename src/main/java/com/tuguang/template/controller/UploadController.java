package com.tuguang.template.controller;

import com.tuguang.template.common.BaseResponse;
import com.tuguang.template.common.ResultUtils;
import com.tuguang.template.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(tags = "上传")
@RestController
@RequestMapping("/file")
public class UploadController {
    @Resource
    private UploadService  uploadService;

    @ApiOperation("上传接口")
    @PostMapping("/upload")
    public BaseResponse<String> upload(@RequestParam("file") MultipartFile file,
                                       HttpServletRequest request){
        return ResultUtils.success(uploadService.upload(file,request));
    }
}
