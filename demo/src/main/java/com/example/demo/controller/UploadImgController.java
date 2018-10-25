package com.example.demo.controller;

import com.example.demo.utils.models.SystemInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin//跨域注解
public class UploadImgController {

    @RequestMapping(value = "/upload-img",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Object>> product(@RequestBody MultipartFile file){
        Map<String,Object> map = new HashMap<String,Object>();
        if (!file.isEmpty()) {
            String filePath = SystemInfo.imgFilePath + file.getOriginalFilename();
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.mkdirs();
            }
            try {
                file.transferTo(desFile);
                map.put("message", "");
                return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
            } catch (IllegalStateException | IOException e) {
                map.put("message", e.getMessage());
                return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_MODIFIED);
            }
        } else {
            map.put("message", "上传失败，因为文件是空的.");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_MODIFIED);
        }
    }
}
