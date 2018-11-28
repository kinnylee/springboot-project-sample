package com.kinnylee.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lijl-c
 * @date 2018/10/29
 */
@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

  @Value("${upload.folder}")
  private String uploadFolder;

  @PostMapping("/")
  public Object upload(MultipartFile file){
    if(file.isEmpty()) {
      return "empty file error.";
    }

    try {
      byte[] bytes = file.getBytes();
      Path path = Paths.get(uploadFolder + file.getOriginalFilename());
      Files.write(path, bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return "ok";
  }
}
