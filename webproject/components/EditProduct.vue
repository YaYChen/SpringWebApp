<template>
   <div class="layout_center">
       <div class="input_group_div">
            <div class="input-group mb-3">
                <input ref="input_search" type="text" class="form-control" placeholder="Bar Code"  @keyup.enter="inputListener">
                <div class="input-group-append">
                    <span id="query_button" class="input-group-text query_button">Query</span>
                </div>
            </div>
        </div>
        <div id="product_container" class="product_list_div">
            <product-editer-component
                    ref="product_view"
                    v-if="showProduct"
                    v-bind:product="product"
                    v-bind:update="update"
                    @disableEditer="disableEditer"
            ></product-editer-component>
        </div>
   </div>
</template>

<script>
import ProductEditer from '@/components/ProductEditer.vue'

export default {
    name:"EditProduct",
    data: function(){
        return{
            showProduct:false,
            product:'',
            update:false
        }      
    },
    components: {
        'product-editer-component':ProductEditer
    },
    methods:{
        inputListener:function(){
            var vm=this;
            vm.showProduct=true;
            vm.code=vm.$refs.input_search.value;
            this.$axios.get("http://localhost:8080/product-ByCode",{
                params: {
                    code:vm.$refs.input_search.value
                    }
                })
                .then(function(response){
                    if(response.data==""){ // "",[]
                        vm.update=false;
                        vm.product={
                            id:0,
                            code:vm.$refs.input_search.value,
                            name:'',
                            category:{id:1,name:"烟草"},
                            specification:'',
                            productPicture:'',
                            purchasePrice:'',
                            price:''
                        }
                        alert("The product is not exit,please add...");
                    }else{
                        vm.update=true;
                        vm.product=response.data;
                        vm.id=vm.product.id;
                    }
                    
                })
                .catch(function(error){
                    console.log(error);
                });
        },
        disableEditer:function(){
            var vm=this;
            vm.showProduct=false;
        }
    },
    created:function(){
        
    }
}
</script>

<style scoped>
.layout_center{
    width: 100%;
    min-height: 800px;
    margin:10px auto;
}

.input_group_div{
    width: 1000px;
    height: auto;
    margin:10px auto;
    border-bottom:2px solid black;
    display: block;
}

.product_list_div{
    width: 1000px;
    height: auto;
    margin:10px auto;
}
</style>