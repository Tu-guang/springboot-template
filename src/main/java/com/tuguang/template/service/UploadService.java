package com.tuguang.template.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 上传文件服务接口类
 *
 * @author
 */
public interface UploadService {


    String upload(MultipartFile file, HttpServletRequest request);
}
