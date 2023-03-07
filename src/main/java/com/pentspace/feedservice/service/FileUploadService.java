package com.pentspace.feedservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    String uploadFile(String entityId, MultipartFile multipartFile);
    String readAndConvertImageToBase64Read(String key);
}
