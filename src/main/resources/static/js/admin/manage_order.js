$(document).ready(function () {
    $(".btn-detail-bill").on("click", function () {
        var orderId = $(this).data("bill");
        var userId = $(this).data("userid")
        // $('#table-detail > tbody').html("")
        axios.get("/api/user/detail/" + userId).then(function (data) {
            $('#name').text(data.data.data.fullname)
            $('#diachi').text(data.data.data.address)
            $('#diachiemail').text(data.data.data.email)
            $('#phone').text(data.data.data.phone)
        })
        axios.get("/api/order/detail/" + orderId).then(function(res){
            // console.log(res.data.data.products.length)
            if(res.data.success) {
                if(res.data.data.products.length > 0){
                    $('#ngaylap').text(res.data.data.products[0].created_date)
                    var j =1;
                    var sum =0;
                    $('#table-detail > tbody').html("")
                    for(var pro of res.data.data.products){
                        $('#table-detail > tbody').append(`<tr>
                                <td>${j}</td>
                                <td>${pro.product.name}</td>
                                <td>${pro.orderquantity}</td>
                                <td class="price">${pro.orderprice}</td>
                                <td class="price">${pro.orderquantity*pro.orderprice}</td>
                                </tr>`)
                        sum += pro.orderquantity*pro.orderprice;
                        j++;
                    }
                    $('#sum').text(sum)
                    function format(x) {
                        x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
                        return x
                    }
                    $('.price').each(function () {
                        $(this).text(format(parseInt($(this).text())))
                    })
                    $('#modal-create-bill').modal()
                }else {
                    $('.modal-body').html("Không có sản phẩm nào")
                    $('#modal-create-bill').modal()
                }
            }
        })
    });
    $('.btn-update-bill').on('click',function () {
        var orderId = $(this).data('id')
        console.log(orderId)
        axios.get("/api/order/status/"+orderId).then(function (res) {
            if(res.data.success){
                swal({
                    title: 'Bạn có chắc',
                    text: res.data.message,
                    type: 'warning',
                    showCancelButton: true
                }).then(function (value) {
                    if(value.value){
                        axios.get("/api/order/update/" + orderId).then(function (res1) {
                            if(res1.data.success){
                                swal(
                                    "Đã xử lý",
                                    res1.data.message,
                                    "warning"
                                ).then(function () {
                                    location.reload()
                                })
                            }
                        })
                    }
                })
            }
        })
    })
    $("#myTable").dataTable()
})