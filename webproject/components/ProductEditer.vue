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
        props:['product','code','id','update'],
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
                if(this.update==true){
                    var postData=JSON.stringify(vm.product);
                    this.$axios.post('http://localhost:8080/update-product',postData)
                    .then((response)=>{
                        console.log(response);
                    }).catch(function(error){
                        alert(error);
                    });
                }else{
                    var postData=JSON.stringify({
                        product:{
                            id:0,
                            code:vm.code,
                            name:vm.$refs.input_name.value,
                            category:vm.$refs.input_category.value,
                            specification:vm.$refs.input_specification.value,
                            purchasePrice:vm.$refs.input_purchasePrice.value,
                            price:vm.$refs.input_price.value,
                            productPicture:vm.$refs.imgUpload.filename
                        }
                    });
                    this.$axios.post('http://localhost:8080/insert-product',postData)
                    .then((response)=>{
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