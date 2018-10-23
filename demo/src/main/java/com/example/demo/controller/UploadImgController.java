package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@CrossOrigin//跨域注解
public class UploadImgController {

    @RequestMapping(value = "/upload-img",method = RequestMethod.POST)
    @CrossOrigin//跨域注解
    public String product(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            String filePath = "F:\\imgs\\" + file.getOriginalFilename();
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.mkdirs();
            }
            try {
                file.transferTo(desFile);
                return "Success!";
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                return "Failed!";
            }
        } else {
            return "上传失败，因为文件是空的.";
        }
    }
}
