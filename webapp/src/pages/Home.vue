<template>
  <div class="layout_center">
        <div class="input_group_div">
            <div class="input-group mb-3">
                <input ref="input_search" type="text" class="form-control" placeholder="Bar Code" v-on:keyup.enter="inputListener">
                <div class="input-group-append">
                    <span id="query_button" class="input-group-text query_button">Query</span>
                </div>
            </div>
        </div>
        <div id="product_container" class="product_list_div">
            <product-component
                    ref="product_view"
                    v-bind:product="product"
            ></product-component>
        </div>
    </div>
</template>

<script>

import Product from '../components/public/Product'

export default {
    name: 'Home',
    props: {
      product: ''
    },
    data () {
        return {
            //'product':{name:'1',category:'1',specification:'1',price:'1',imgPath:'../../static/img/default.jpeg'}
        }
    },
    components:{
        'product-component':Product,
    },
    methods:{
        inputListener:function(){
            this.$refs.product_view.searchProduct(this.$refs.input_search.value)
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.layout_center{
    width:100%;
    height: 100%;
}
.input_group_div{
    width: 1000px;
    height: auto;
    margin:0 auto;
    border-bottom:2px solid black;
    display: block;
}
.product_list_div{
    width: 1000px;
    height: auto;
    margin:10px auto;
}
</style>
