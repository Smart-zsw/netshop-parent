package com.zsw.netshop.manager.service.impl;

import com.zsw.netshop.common.exception.ShopException;
import com.zsw.netshop.manager.service.FileUploadService;
import com.zsw.netshop.model.vo.common.ResultCodeEnum;
import io.minio.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Override
    public String upload(MultipartFile file) {
        try {
            // 创建MinioClient对象
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint("http://174.139.20.140:9001")
                            .credentials("admin", "admin123456")
                            .build();
            // 创建bucket
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("netshop-buckert").build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("netshop-buckert").build());
            } else {
                System.out.println("Bucket 'asiatrip' already exists.");
            }
            //获取上传文件名称
            String filename = file.getOriginalFilename();

            // 文件上传
            minioClient.putObject(
                    PutObjectArgs.builder().bucket("netshop-bucket")
                            .object(filename)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .build()
            );
            //获取上传文件在minio路径
            //http://174.139.20.140:9001/netshop-bucket/R.jpg
            String url = "http://174.139.20.140:9001/netshop-bucket/"+filename;
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ShopException(ResultCodeEnum.DATA_ERROR);

        }
    }
}
