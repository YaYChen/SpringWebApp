<template>
    <div class="product_editer_box">
        <div class="img_upload_box">
            <label>Product Picture Upload:</label>
            <uploaderComponent id="imgUpload" v-bind:fileName="product.productPicture"/>
        </div>
        <div class="product_detial_box">
            <form>
            <div class="form-group">
                <label>Name:</label>
                <input type="text" class="form-control" id="input_name" placeholder="Enter Name" v-model="product.name">
            </div>
            <div class="form-group">
                <label>Category:</label>
                <input type="text" class="form-control" id="input_category" placeholder="Enter Category" v-model="product.category">
            </div>
            <div class="form-group">
                <label>Specification:</label>
                <input type="text" class="form-control" id="input_specification" placeholder="Enter Specification" v-model="product.specification">
            </div>
            <div class="form-group">
                <label>PurchasePrice:</label>
                <input type="text" class="form-control" id="input_purchasePrice" placeholder="Enter PurchasePrice" v-model="product.purchasePrice">
            </div>
            <div class="form-group">
                <label>Price:</label>
                <input type="text" class="form-control" id="input_price" placeholder="Enter Price" v-model="product.price">
            </div>
            <button type="submit" class="btn btn-primary" @click="submit">submit</button>
            <button type="button" class="btn btn-primary" @click="cancel">cancle</button>
            </form>
        </div>
    </div>
</template>

<script>
    import uploaderComponent from '@/components/el-uploader.vue'
    export default {
        name: 'ProductEditer',
        props:['product','update'],
        data:function() {
            return {
                
            }
        },
        components:{
            'uploaderComponent':uploaderComponent
        },
        methods:{
            submit:function(){
                var vm=this;
                let postData = this.$qs.stringify({
                    product:{
                        code:this.code,
                        name:this.$refs.input_name.value,
                        category:this.$refs.input_category.value,
                        specification:this.$refs.input_specification.value,
                        purchasePrice:this.$refs.input_purchasePrice.value,
                        price:this.$refs.input_price.value,
                        productPicture:this.$refs.imgUpload.filename
                    }
                });
                if(this.update==true){
                    this.$axios({
                        method: 'put',
                        url:'http://localhost:8080/update-product',
                        data:postData
                    }).then((response)=>{
                        console.log(response);
                    }).catch(function(error){
                        alert(error);
                    });
                }else{
                    this.$axios({
                        method: 'post',
                        url:'http://localhost:8080/insert-product',
                        data:postData
                    }).then((response)=>{
                        console.log(response);
                    }).catch(function(error){
                        alert(error);
                    }); 
                }
                
            },
            cancel:function(){
                this.$emit('disableEditer');
            }
        }
    }
</script>

<style scoped>
.product_editer_box{
    width: 100%;
    height: auto;
}
.img_upload_box{
    width: 100%;
    height: auto;
}
.product_detial_box{
    width: 100%;
    height: auto;
}
.button_box{
    width: 100%;
    height: auto;
}
</style>