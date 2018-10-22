<template>
    <div class="layout_main">
        <app-header/> 
        <edit-product/>
        <app-footer/>
    </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import EditProduct from '@/components/EditProduct.vue'

export default {
    data:function(){
        return{
           
        }
    },
    components: {
        'app-header':Header,
        'app-footer':Footer,
        'edit-product':EditProduct
    },
    methods:{
        
    }
}
</script>

<style>

.layout_main{
    width: 100%;
    margin: 0 auto;
    height: 100%;
}
</style>
