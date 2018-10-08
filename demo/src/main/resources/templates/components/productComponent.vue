<template>
    <div class="product_box">
        <div class="product_picture_box">
            <img src="/img/default.jpeg" class="img_picture">
        </div>
        <div class="product_detail_box">
            <h5>品名:</h5><br/>
            <h5>类别:</h5><br/>
            <h5>规格:</h5><br/>
            <h3>价格:</h3>
        </div>
    </div>
</template>

<script>
    export default {

    }
</script>

<style scoped>
    .product_box{
        width: 100%;
        height: 300px;
        border: 1px solid lightgray;
    }

    .product_picture_box{
        width:300px;
        height: 300px;
        padding: 2px;
        float: left;
    }

    .product_detail_box{
        width: 598px;
        height: 300px;
        padding: 2px;
        float: left;
    }

    .img_picture{
        width: 294px;
        height: 294px;
    }
</style>

