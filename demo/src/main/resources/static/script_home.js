$(document).ready(function(){
    Vue.component('product-component', {
        props:['product'],
        template: `
                <div class="product_box">
                    <div class="product_picture_box">
                        <img src="/img/default.jpeg" class="img_picture">
                    </div>
                    <div class="product_detail_box">
                        <h5>品名:{{product.name}}</h5><br/>
                        <h5>类别:{{product.category}}</h5><br/>
                        <h5>规格:{{product.specification}}</h5><br/>
                        <h3>价格:{{product.price}}</h3>
                    </div>
                </div>
              `
    });

    $("#mail").bind('keypress',function(event){
        if(event.keyCode == "13")
        {
            new Vue({
                el: '#product_container',
                data: {
                    product: {}
                },
                created: function () {
                    // Alias the component instance as `vm`, so that we
                    // can access it inside the promise function
                    var vm = this
                    // Fetch our array of posts from an API
                    $.get(
                        "http://localhost:8080/product-ByCode",
                        {code:$("#mail").val()},
                        function(data,status){
                            var product=JSON.parse(data);
                            vm.product=product;
                        });
                }
            });
        }
    });
    
    $("#a_product").click(function () {
        window.location.href="http://localhost:8080/product";
    });

    $("#a_home").click(function(){
        window.location.href="http://localhost:8080/home";
    });
});


