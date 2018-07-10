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
            $('#phone').text(data.data.data.phone)
        })
        axios.get("/api/order/detail/" + orderId).then(function(res){
            console.log(res.data.data.products.length)
            if(res.data.success) {
                if(res.data.data.products.length > 0){
                    $('#ngaylap').text(res.data.data.products[0].created_date)
                    var j =1;
                    var sum =0;
                    $('.modal-body').html("<form>\n" +
                        "\t\t\t\t\t<div class=\"form-group row\">\n" +
                        "\t\t\t\t\t\t<label for=\"name\" class=\"col-sm-4 col-form-label\">Tên Khách Hàng :</label>\n" +
                        "\t\t\t\t\t\t<div class=\"col-sm-8\">\n" +
                        "\t\t\t\t\t\t\t<label id=\"name\"></label>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div class=\"form-group row\">\n" +
                        "\t\t\t\t\t\t<label for=\"diachi\" class=\"col-sm-4 col-form-label\">Địa chỉ :</label>\n" +
                        "\t\t\t\t\t\t<div class=\"col-sm-8\">\n" +
                        "\t\t\t\t\t\t\t<label id=\"diachi\"></label>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div class=\"form-group row\">\n" +
                        "\t\t\t\t\t\t<label for=\"phone\" class=\"col-sm-4 col-form-label\">Phone :</label>\n" +
                        "\t\t\t\t\t\t<div class=\"col-sm-8\">\n" +
                        "\t\t\t\t\t\t\t<label id=\"phone\"></label>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div class=\"form-group row\">\n" +
                        "\t\t\t\t\t\t<label for=\"diachiemail\" class=\"col-sm-4 col-form-label\">Email :</label>\n" +
                        "\t\t\t\t\t\t<div class=\"col-sm-8\">\n" +
                        "\t\t\t\t\t\t\t<label id=\"diachiemail\"></label>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<div class=\"form-group row\">\n" +
                        "\t\t\t\t\t\t<label for=\"ngaylap\" class=\"col-sm-4 col-form-label\">Ngày lập hóa đơn :</label>\n" +
                        "\t\t\t\t\t\t<div class=\"col-sm-8\">\n" +
                        "\t\t\t\t\t\t\t<label id=\"ngaylap\"></label>\n" +
                        "\t\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t</div>\n" +
                        "\t\t\t\t\t<h4 style=\"margin-top: 30px;\"><strong>Chi tiết sản phẩm</strong></h4>\n" +
                        "\t\t\t\t\t<hr>\n" +
                        "\t\t\t\t\t<table class=\"table table-bordered table-hover\" id=\"table-detail\">\n" +
                        "\t\t\t\t\t\t<thead>\n" +
                        "\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t<th>STT</th>\n" +
                        "\t\t\t\t\t\t\t<th>Tên Sản Phẩm</th>\n" +
                        "\t\t\t\t\t\t\t<th>Số Lượng (Kg)</th>\n" +
                        "\t\t\t\t\t\t\t<th>Giá </th>\n" +
                        "\t\t\t\t\t\t\t<th>Thành tiền</th>\n" +
                        "\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t</thead>\n" +
                        "\t\t\t\t\t\t<tbody>\n" +
                        "\n" +
                        "\t\t\t\t\t\t</tbody>\n" +
                        "\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t<hr>\n" +
                        "\t\t\t\t\t<h4 style=\"margin-top: 30px;\"><strong>Tổng :  </strong><span id=\"sum\" class=\"price\"></span></h4>\n" +
                        "\t\t\t\t</form>")
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