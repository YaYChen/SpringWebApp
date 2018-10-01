package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.utils.models.ReturnMessage;
import com.example.demo.utils.models.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductMapper productMapper;

    @Autowired
    public ProductController(ProductMapper mapper){
        this.productMapper=mapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String product_home(){
        return "product";
    }

    @RequestMapping(value = "/products-ByCategory",method = RequestMethod.GET)
    public String products(@RequestParam("categroy") String _category){
        List<Product> products = productMapper.getProductsByCategory(_category);
        String usersJson = JSON.toJSONString(products);
        return usersJson;
    }

    @RequestMapping(value = "/product-ByCode",method = RequestMethod.GET)
    public String product_ByCode(@RequestParam("code") String _code){
        Product product=productMapper.getOne(_code);
        String usersJson = JSON.toJSONString(product);
        return usersJson;
    }

    @RequestMapping(value = "/update-product",method = RequestMethod.POST)
    public String  update(@RequestParam("product") String _product){
        ReturnMessage returnMessage=new ReturnMessage();
        try{
            Product product=JSON.parseObject(_product,Product.class);
            productMapper.update(product);
            returnMessage.status= StatusEnum.OK;
            String message=JSON.toJSONString(returnMessage);
            return message;
        }catch (Exception e){
            returnMessage.status=StatusEnum.NG;
            returnMessage.message=e.getMessage();
            String message=JSON.toJSONString(returnMessage);
            return message;
        }
    }

    @RequestMapping(value = "/insert-product",method = RequestMethod.POST)
    public String insert(@RequestParam("product") String _product){
        ReturnMessage returnMessage=new ReturnMessage();
        try{
            Product product=JSON.parseObject(_product,Product.class);
            productMapper.insert(product);
            returnMessage.status= StatusEnum.OK;
            String message=JSON.toJSONString(returnMessage);
            return message;
        }catch (Exception e){
            returnMessage.status=StatusEnum.NG;
            returnMessage.message=e.getMessage();
            String message=JSON.toJSONString(returnMessage);
            return message;
        }
    }

    @RequestMapping(value = "/delete-product",method = RequestMethod.GET)
    public String delete(@RequestParam("id") String _id){
        ReturnMessage returnMessage=new ReturnMessage();
        try{
            int id=Integer.getInteger(_id);
            productMapper.delete(id);
            returnMessage.status= StatusEnum.OK;
            String message=JSON.toJSONString(returnMessage);
            return message;
        }catch (Exception e){
            returnMessage.status=StatusEnum.NG;
            returnMessage.message=e.getMessage();
            String message=JSON.toJSONString(returnMessage);
            return message;
        }
    }
}
