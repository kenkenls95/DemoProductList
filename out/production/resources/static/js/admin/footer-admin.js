$(document).ready(function () {
    $.get("http://"+window.location.host+"/api/user/img/"+$(".user-name").text(), function(data, status){
        if(data.data != null){
            $('.user-logo').attr('src',data.data.imageurl)
            userId = data.data.id
        }
    });
    switch ($('#role').text()){
        case "[ROLE_ADMIN]":
            $('#role').text("Trang ADMIN");
            $('#role').attr('href','/admin/profile');
            break;
        case "[ROLE_USER]":
            $('#role').text("Thông tin khách hàng")
            $('#role').attr('href','/user')
            $('#role-menu').append("<a href='rules'>Chính sách giao hàng</a>")
            break;
    }


    // xoa cookies

    $('.logout').on('click',function () {
        setCookie("User_Guild",null,0)
        setCookie("OrderId",null,0)
        setCookie("User_Id",null,0)
        function setCookie(cname, cvalue, exdays) {
            var d = new Date();
            d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
            var expires = "expires="+d.toUTCString();
            document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
        }
    })

})