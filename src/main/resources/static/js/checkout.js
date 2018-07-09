$(document).ready(function () {
    $('.btn-save-order').on('click',function () {
        if($('#fullname').val() === "" || $('#email').val() === "" || $('#phone').val() === "" || $('#address').val() === ""){
            swal(
                'Lỗi',
                'Bạn cần điền đầy đủ thông tin',
                'error'
            );
            return;
        }
        var dataProduct = {}
        dataProduct.id = getCookie("User_Id")
        dataProduct.fullname = $('#fullname').val()
        dataProduct.email = $('#email').val()
        dataProduct.phone = $("#phone").val()
        dataProduct.address = $('#address').val()
        dataProduct.orderId = getCookie("OrderId")
            var linkPost = "/api/product/save"
        axios.post(linkPost, dataProduct).then(function(res){
            if(res.data.success) {
                swal(
                    'Cảm ơn bạn đã sử dụng dịch vụ',
                    res.data.message,
                    'success'
                ).then(function() {
                    setCookie("User_Guild",null,0)
                    setCookie("OrderId",null,0)
                    setCookie("User_Id",null,0)
                    document.location.href = location.origin
                });
            }else {
                swal(
                    "Xảy ra lỗi khi lưu hóa đơn",
                    res.data.message,
                    'warning'
                )
            }
        })
    })
    function setCookie(cname, cvalue, exdays) {
        var d = new Date();
        d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
        var expires = "expires="+d.toUTCString();
        document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
    }
    function getCookie(cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for(var i = 0; i <ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }
})