<template>
    <div class="layout_header">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Brand -->
            <a class="navbar-brand" href="#">Logo</a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="/Product">Product</a>
                </li>

                <!-- Dropdown -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        Management
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/Product">Product</a>
                        <a class="dropdown-item" href="#">Storage</a>
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
    },
    methods: {
      
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.layout_header{
    height: auto;
    width: 100%;
}
</style>
