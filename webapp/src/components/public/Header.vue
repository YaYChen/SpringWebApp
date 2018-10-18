<template>
  <div class="layout_header">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Brand -->
            <a class="navbar-brand" href="#">Logo</a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a id="a_home" class="nav-link" href="/home">Home</a>
                </li>

                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        Management
                    </a>
                    <div class="dropdown-menu">
                        <a id="a_product" class="dropdown-item" href="#">Product</a>
                        <a id="a_storage" class="dropdown-item" href="#">Storage</a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>
</template>

<script>
export default {
  name: 'Header',
  data () {
    return {
      
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.layout_header{
    height: 12.5%;
    width: 100%;
}
</style>
