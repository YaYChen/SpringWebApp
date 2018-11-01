<template>
    <div class="layout_main">
        <app-header v-bind:activeIndex="activeIndex"/> 
        <search-product-component/>
        <app-footer/>
    </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import SearchProduct from '@/components/SearchProduct.vue'

export default {
    data:function(){
        return{
           activeIndex:'1'
        }
    },
    components: {
        'search-product-component':SearchProduct,
        'app-header':Header,
        'app-footer':Footer
    },
    methods:{
        
    }
}
</script>

<style>

.layout_main{
    width: 100%;
    height: auto;
}
</style>
