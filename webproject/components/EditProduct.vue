<template>
   <div class="layout_center">
       <div class="input_group_div">
            <div class="input-group mb-3">
                <input id="input_search" type="text" class="form-control" placeholder="Bar Code"  @keyup.enter="inputListener">
                <div class="input-group-append">
                    <span id="query_button" class="input-group-text query_button">Query</span>
                </div>
            </div>
        </div>
        <div id="product_container" class="product_list_div">
            <product-editer-component
                    ref="product_view"
                    v-if="showProduct"
                    v-bind:code="code"
                    v-bind:update="update"
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
            showProduct:true,
            code:'',
            update:false
        }      
    },
    components: {
        'product-editer-component':ProductEditer
    },
    methods:{
        inputListener:function(){
            var vm=this;
            code=this.$refs.input_search.value;
            this.$axios.get("http://localhost:8080/product-ByCode",{
                params: {
                    code:this.$refs.input_search.value
                    }
                })
                .then(function(response){
                    if(!response.data.length){ // "",[]
                        update=false;
                        vm.showProduct=true;
                        alert("The product is not exit,please add...");
                    }else{
                        update=true;
                        vm.showProduct=true;
                        vm.product=response.data;
                    }
                    
                })
                .catch(function(error){
                    console.log(error);
                });
        }
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