function getAllUsers(){
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange=function()
    {
        if(xmlhttp.readyState==4&&xmlhttp.status==200){
            var json=JSON.parse(xmlhttp.responseText);
            json.forEach(
                function(value,index,array){
                    var innerHTML="<h2>"+value.id+"</h2></br><h2>"+value.username+"</h2></br><h2>"+value.password+"</h2></br>";
                    document.getElementById("div_result").innerHTML+=innerHTML;
                });
        }

    }
    xmlhttp.open("GET","http://localhost:8080/users",true);
    xmlhttp.send(null);
}