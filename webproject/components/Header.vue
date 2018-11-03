<template>
    <div class="layout_header">
        <div class="layout_box">
            <div class="header_logo">
                <h1>Market</h1>
            </div>
            <div class="header_nav">
                <el-menu 
                    :default-active="activeIndex" 
                    class="nav_menu_style" 
                    mode="horizontal" 
                    @select="handleSelect"
                    background-color="#ffffff"
                    text-color="#777777"
                    active-text-color="#000000"
                    >
                    <el-menu-item index="1" indexPath="/" class="nav_menu_item">Product Search</el-menu-item>
                    <el-menu-item index="2" class="nav_menu_item">List Create</el-menu-item>
                    <el-submenu index="3">
                        <template slot="title"><p class="nav_menu_item">Manager</p></template>
                        <el-menu-item index="3-1" indexPath="/Product" class="nav_menu_item">Product</el-menu-item>
                        <el-menu-item index="3-2" class="nav_menu_item">Oder</el-menu-item>
                        <el-menu-item index="3-3" class="nav_menu_item">Storge</el-menu-item>
                    </el-submenu>
                </el-menu>
            </div>
        </div>  
    </div>
</template>

<script>

export default {
    name: 'Header',
    props:['activeIndex'],
    data () {
        return {
            
        }
    },
    methods: {
        handleSelect(key, keyPath) {
            switch(key){
                case '1':
                    window.location.href="/";
                    break;
                case '3-1':
                    window.location.href="/Product";
                    break;
            }
            
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.layout_header{
    height: auto;
    width: 100%;
    margin-bottom: 10px;
    border-bottom: 2px solid black;
    padding: 1px;
    text-align: center;
}
.layout_box{
    margin: 0 auto;
    width: 1000px;
    height: 70px;
}
.header_logo{
    width: 200px;
    height:100%;
    float: left
}
.header_nav{
    width: 800px;
    height:100%;
    float: left;
}
.nav_menu_style{
    width: 100%;
    height: 100%;
}
.nav_menu_item{
    height: 100%;
    font-family: "Microsoft YaHei";
    font-size: 20px;
}
</style>
