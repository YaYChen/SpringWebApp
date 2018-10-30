package com.example.demo.mapper;

import com.example.demo.entity.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ProductMapper {

    @Select("select * from product_table where code = #{code}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "code",column = "code"),
            @Result(property = "name",column = "name"),
            @Result(property = "category",column= "category_id",
                    one=@One(select = "com.example.demo.mapper.CategoryMapper.getCategory",fetchType = FetchType.EAGER)),
            @Result(property = "specification",column = "specification"),
            @Result(property = "productPicture",column = "productPicture"),
            @Result(property = "purchasePrice",column = "purchasePrice"),
            @Result(property = "price",column = "purchasePrice")
    })
    Product getOne(String code);

    @Select("select * from product_table where category_id = #{category_id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "code",column = "code"),
            @Result(property = "name",column = "name"),
            @Result(property = "category",column= "category_id",
                    one=@One(select = "com.example.demo.mapper.CategoryMapper.getCategory",fetchType = FetchType.EAGER)),
            @Result(property = "specification",column = "specification"),
            @Result(property = "productPicture",column = "productPicture"),
            @Result(property = "purchasePrice",column = "purchasePrice"),
            @Result(property = "price",column = "purchasePrice")
    })
    List<Product> getProductsByCategory(int category_id);

    @Insert("insert into product_table(code,name,category_id,specification,productPicture,purchasePrice,price) " +
            " values(#{code}," +
            " #{name}," +
            " #{category.id}," +
            " #{specification}," +
            " #{productPicture}," +
            " #{purchasePrice}," +
            " #{price})")
    void insert(Product product);

    @Update("update product_table set " +
                    "code=#{code}," +
                    "name=#{product.name}," +
                    "specification=#{specification}," +
                    "productPicture=#{productPicture}," +
                    "purchasePrice=#{purchasePrice}," +
                    "price=#{price}," +
                    "category_id=#{category.id}" +
                    " WHERE id =#{id}")
    void update(Product product);

    @Delete("delete form product_table where id =#{id}")
    void delete(long id);

}
