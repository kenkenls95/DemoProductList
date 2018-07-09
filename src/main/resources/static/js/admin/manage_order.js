$(document).ready(function () {
    $("#myTable").dataTable()

    $(".btn-detail-bill").on("click", function () {
        var orderId = $(this).data("bill");
        var userId = $(this).data("userid")
        $('#table-detail > tbody').html("")
        axios.get("/api/user/detail/" + userId).then(function (data) {
            $('#name').text(data.data.data.fullname)
            $('#diachi').text(data.data.data.address)
            $('#diachiemail').text(data.data.data.email)
        })
        axios.get("/api/order/detail/" + orderId).then(function(res){
            console.log(res.data.data)
            if(res.data.success) {
                if(res.data.data.products.length > 0){
                    $('#ngaylap').text(res.data.data.products[0].created_date)
                    var j =1;
                    var sum =0;
                    for(var pro of res.data.data.products){
                        $('#table-detail > tbody').append(`<tr>
                                <td>${j}</td>
                                <td>${pro.product.name}</td>
                                <td>${pro.orderquantity}</td>
                                <td>${pro.orderprice}</td>
                                <td class="money">${pro.orderquantity*pro.orderprice}</td>
                                </tr>`)
                        sum += pro.orderquantity*pro.orderprice;
                        j++;
                    }
                    $('#sum').text(sum)
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
                                    "Thành công",
                                    res1.data.message,
                                    "success"
                                )
                            }
                        }).then(function () {
                            location.reload()
                        })
                    }
                })
            }
        })
    })
})