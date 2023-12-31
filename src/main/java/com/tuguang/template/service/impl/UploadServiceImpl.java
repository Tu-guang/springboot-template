package com.tuguang.template.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.tuguang.template.common.ErrorCode;
import com.tuguang.template.exception.BusinessException;
import com.tuguang.template.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * 上传文件服务实现类
 *
 * @author
 */
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {
    @Value("${upload.path}")
    private String basePath;

    /**
     * 上传文件
     *
     * @param
     * @return
     */
    @Override
    public String upload(MultipartFile file, HttpServletRequest request) {
        //获取文件原始名称
        String originalFilename = file.getOriginalFilename();
        //获取文件的类型
        String fileType = FileUtil.extName(originalFilename);
        //获取文件大小
        long size = file.getSize();
        //获取文件
        File uploadParentFile = new File(basePath);
        //判断文件目录是否存在
        if (!uploadParentFile.exists()) {
            //如果不存在就创建文件夹
            uploadParentFile.mkdirs();
        }
        //定义一个文件唯一标识码（UUID）
        String uuid = UUID.randomUUID().toString();

        File uploadFile = new File(basePath + uuid + StrUtil.DOT + fileType);
        //将临时文件转存到指定磁盘位置
        try {
            file.transferTo(uploadFile);
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return uuid + StrUtil.DOT + fileType;
    }

}