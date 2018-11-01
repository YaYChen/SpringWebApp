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
            <product-component
                    ref="product_view"
                    v-if="showProduct"
                    v-bind:product="product"
            ></product-component>
        </div>
   </div>
</template>

<script>
import Product from '@/components/Product.vue'

export default {
    name:"SearchProduct",
    data: function(){
        return{
            showProduct:false,
            product:''
        }      
    },
    components: {
        'product-component':Product
    },
    methods:{
        inputListener:function(){
            var vm=this;
            this.$axios.get("http://localhost:8080/product-ByCode",{
                params: {
                    code:this.$refs.input_search.value
                    }
                })
                .then(function(response){
                    vm.showProduct=true;
                    vm.product=response.data;
                    vm.$refs.input_search.value="";                                
                })
                .catch(function(error){
                    console.log(error);
                });
        }
    },
    created:function(){
        
    }
}
</script>

<style scoped>
.layout_center{
    width:100%;
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