$(document).ready(function(){
    $("#query_button").click(function(){
        $.get(
            "http://localhost:8080/users",
            function(data,status){
                    var json=JSON.parse(data);
                    json.forEach(
                        function(value,index,array){
                            const innerHTML="<h2>"+value.id+"</h2></br><h2>"+value.username+"</h2></br><h2>"+value.password+"</h2></br>";
                            $("#div_result").append(innerHTML);
                        });
        });
    });

    $("#mail").bind('keypress',function(event){
        if(event.keyCode == "13")
        {
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
                    vm.product = {name:1,category:1,specification:1,price:1}
                    $.get(
                        "http://localhost:8080/product/product-ByCode",
                        {code:$("#mail").val()},
                        function(data,status){
                            var product=JSON.parse(data);
                            vm.product=product;
                        });
                }
            });
        }
    });
});
