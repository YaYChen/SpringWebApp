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
                <el-select class="form_select" v-model="product.category.id" placeholder="Category select..." >
                    <el-option
                        v-for="item in selectCategories"
                            :key="item.id"
                            :label="item.name"
                            :value="item.id"
                    >
                    </el-option>
                </el-select>
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
                selectCategories:[]
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
                    var postData=JSON.stringify(vm.product);
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
        },
        created:function(){
            var vm=this;
            this.$axios.get('http://localhost:8080/getCategories')
            .then((response)=>{
                vm.selectCategories=response.data;
            }).catch(function(error){
                alert(error);
            });
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
.form_select{
    width: 100%;
    height: auto;
    float: left;
}
</style>