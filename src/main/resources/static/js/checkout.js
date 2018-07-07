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
        var linkPost = "/api/product/save"
        var dataProduct = {}
        dataProduct.fullname = $('#fullname').val()
        dataProduct.email = $('#email').val()
        dataProduct.phone = $("#phone").val()
        dataProduct.address = $('#address').val()
        dataProduct.cartId =
        axios.post(linkPost, dataProduct).then(function(res){
            if(res.data.success) {
                swal(
                    'Cảm ơn bạn đã sử dụng dịch vụ',
                    res.data.message,
                    'success'
                ).then(function() {
                    document.location.href = location.origin
                });
            }
        })
    })
    console.log(location.origin)
})