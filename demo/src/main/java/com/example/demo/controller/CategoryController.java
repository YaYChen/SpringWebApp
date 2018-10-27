package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//跨域注解
public class CategoryController {
    private CategoryMapper mapper;

    @Autowired
    public CategoryController(CategoryMapper mapper){this.mapper=mapper;}

    @GetMapping(value = "/getCategories")
    @ResponseBody
    public ResponseEntity<List<Category>> products(){
        return ResponseEntity.ok(mapper.getAll());
    }

    @PostMapping(value = "/update-category")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> update(@RequestBody Category category){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            mapper.update(category);
            map.put("message", "");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }catch (Exception e){
            map.put("message", e.getMessage());
            System.out.println(e.getMessage());
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping(value = "/insert-category")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> insert(@RequestBody Category category){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            mapper.insert(category);
            map.put("message", "");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }catch (Exception e){
            map.put("message", e.getMessage());
            System.out.println(e.getMessage());
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(value = "/delete-category")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> delete(@RequestParam("id") int id){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            mapper.delete(id);
            map.put("message", "");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_MODIFIED);
        }
    }
}
