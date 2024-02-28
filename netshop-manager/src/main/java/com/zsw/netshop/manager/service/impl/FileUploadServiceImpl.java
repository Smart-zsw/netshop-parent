package com.zsw.netshop.manager.service.impl;

import cn.hutool.core.date.DateUtil;
import com.zsw.netshop.common.exception.ShopException;
import com.zsw.netshop.manager.properties.MinioProperties;
import com.zsw.netshop.manager.service.FileUploadService;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import io.minio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private MinioProperties minioProperties;

    @Override
    public String upload(MultipartFile file) {
        try {
            // 创建MinioClient对象
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint(minioProperties.getEndpointUrl())
                            .credentials(minioProperties.getAccessKey(), minioProperties.getSecreKey())
                            .build();
            // 创建bucket
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioProperties.getBucketName()).build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioProperties.getBucketName()).build());
            } else {
                System.out.println("Bucket 'asiatrip' already exists.");
            }
            //获取上传文件名称
            // 1 让每个上传文件的名称是唯一的     uuid生成 R.jpg
            // 2 根据当前日期对上传文件进行分组 20240228

            // 20240228/R.jpg
            String dateDir = DateUtil.format(new Date(), "yyyyMMdd");

            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            String filename = dateDir+"/"+uuid+file.getOriginalFilename();

            // 文件上传
            minioClient.putObject(
                    PutObjectArgs.builder().bucket(minioProperties.getBucketName())
                            .object(filename)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );
            //获取上传文件在minio路径
            //http://174.139.20.140:9001/netshop-bucket/R.jpg
            return minioProperties.getEndpointUrl()+"/"+minioProperties.getBucketName()+"/"+filename;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ShopException(ResultCodeEnum.DATA_ERROR);

        }
    }
}
