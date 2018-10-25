package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.utils.models.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//跨域注解
public class ProductController {

    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductMapper mapper){
        this.productMapper=mapper;
    }

    @RequestMapping(value = "/product")
    public String product(){
        return "product";
    }

    @GetMapping(value = "/products-ByCategory")
    @ResponseBody
    public ResponseEntity<List<Product>> products(@RequestParam("category") String category){
        return ResponseEntity.ok(productMapper.getProductsByCategory(category));
    }

    @GetMapping(value = "/product-ByCode")
    @ResponseBody
    public ResponseEntity<Product> product_ByCode(@RequestParam("code") String code){
        return ResponseEntity.ok(productMapper.getOne(code));
    }

    @PostMapping(value = "/update-product")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> update(@RequestBody Product product){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            if(product.getProductPicture().indexOf(SystemInfo.imgFilePath)==-1){
                product.setProductPicture(SystemInfo.imgFilePath+product.getProductPicture());
            }
            productMapper.update(product);
            map.put("message", "");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }catch (Exception e){
            map.put("message", e.getMessage());
            System.out.println(e.getMessage());
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_MODIFIED);
        }
    }

    @PostMapping(value = "/insert-product")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> insert(@RequestBody Product product){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            product.setProductPicture(SystemInfo.imgFilePath+product.getProductPicture());
            productMapper.insert(product);
            map.put("message", "");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }catch (Exception e){
            map.put("message", e.getMessage());
            System.out.println(e.getMessage());
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping(value = "/delete-product")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> delete(@RequestParam("id") long id){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            productMapper.delete(id);
            map.put("message", "");
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
        }catch (Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<Map<String,Object>>(map, HttpStatus.NOT_MODIFIED);
        }
    }
}
