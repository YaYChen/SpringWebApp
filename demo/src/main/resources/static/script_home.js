$(document).ready(function(){
    $("#query_button").click(function(){
        $.get(
            "http://localhost:8080/users",
            function(data,status){
                    var json=JSON.parse(data);
                    json.forEach(
                        function(value,index,array){
                            var innerHTML="<h2>"+value.id+"</h2></br><h2>"+value.username+"</h2></br><h2>"+value.password+"</h2></br>";
                            $("#div_result").append(innerHTML);
                        });
        });
    });

    $("#mail").bind('keypress',function(event){
        if(event.keyCode == "13")
        {
            import loadingComponent from './loading.vue';
            const loading={
                install:function(Vue){
                    Vue.component('Loading',loadingComponent);
            },
            export default loading
        }
    });
});