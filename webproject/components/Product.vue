<template>
    <div class="product_box">
        <div class="product_picture_box">
            <img :src="product.productPicture" class="img_picture">
        </div>
        <div class="product_detail_box">          
            <div class="product_detail_info">
                <div class="show_detail_info_title">品名:</div>
                <div class="show_detail_info_value">{{product.name}}</div>
                <div class="show_detail_info_title">类别:</div>
                <div class="show_detail_info_value">{{product.category.name}}</div>
                <div class="show_detail_info_title">规格:</div>
                <div class="show_detail_info_value">{{product.specification}}</div>
            </div>
            <div class="product_detail_price">
                <div class="show_price_title">价格：</div>
                <div class="show_price_value_box">
                    <div class="show_price_value_symbol">
                        ￥ 
                    </div>
                    <div class="show_price_value">
                        {{product.price}}
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Product',
  props:['product'],
  data:function() {
    return {
    }
  },
  methods:{
      
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.product_box{
    width: 100%;
    height: 300px;
    border: 1px solid lightgray;
}

.product_picture_box{
    width:299px;
    height: 298px;
    padding: 2px;
    float: left;
}

.product_detail_box{
    width: 699px;
    height: 298px;
    padding: 2px;
    float: left;
}

.img_picture{
    width: 295px;
    height: 294px;
}

.query_button{
    cursor:hand;
}

.product_detail_info{
    height: 294px;
    width: 300px;
    text-align: left;
    border-right: 1px solid lightgray;
    float: left;
}

.product_detail_price{
    height: 294px;
    width: 394px;
    text-align: left;
    float: left;
}

.show_detail_info_title{
    height: auto;
    width: 297px;
    font-family: "Microsoft YaHei";
    font-size: 30px;
    margin: 1px;
}

.show_detail_info_value{
    height: auto;
    width: 297px;
    font-family: "Microsoft YaHei";
    font-size: 30px;
    margin: 1px;
    border-bottom: 1px solid black;
}

.show_price_title{
    height: 64px;
    width: 394px;
    font-family: "Microsoft YaHei";
    font-size: 30px;
    padding: 2px;
}

.show_price_value_box{
    height: 230px;
    width: 394px; 
    text-align: center;
}

.show_price_value{
    height: auto;
    width: 334px;
    font-family: "Microsoft YaHei";
    font-size: 120px;
    color: green;
    float: left;
    margin-top: 50px;
}

.show_price_value_symbol{
    height: auto;
    width: 60px;
    font-family: "Microsoft YaHei";
    font-size: 30px;
    float: left;
    margin-top: 185px;
}
</style>