$(document).ready(function () {
    updateQty(getCookie("OrderId"))

    // auto suggestion
    var totalProduct
    var list = []
    var userId
    axios.get("/api/product/getallproduct").then(function (res) {
        list = res.data.data
        var suggest = []
        for(var label of list){
            suggest.push(reName(label))
        }
        function reName(label) {
            var obj = {}
            var money = format(parseInt(label.price))
            function format(x) {
                x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
                return x
            }
            obj.label = "<img style='height: 50px;width: 50px' src='"+label.image+"'/> "+"<span class='name-products' style='font-size: 90%'>"+label.name+"</span><span class='money'>"+money+"</span>"
            obj.value = label.name
            return obj
        }
        new Awesomplete(document.querySelector("#ajax-example input"),{ list: suggest });
        // get img sp
    })
    // $('.money').change(function () {
    //     var money = $(this).text()
    //     var fomat = money.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "1.").toString();
    //     $(this).text(fomat)
    // })


    // set logo user

        $.get("http://"+window.location.host+"/api/user/img/"+$(".user-name").text(), function(data, status){
            if(data.data != null){
                $('.user-logo').attr('src',data.data.imageurl)
                userId = data.data.id
                // console.log(data.data)
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


    // gio hang


        var quantitiy=0;
        $('.quantity-right-plus').click(function(e){

            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            $('#quantity').val(quantity + 1);


            // Increment

        });

        $('.quantity-left-minus').click(function(e){
            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            // Increment
            if(quantity>0){
                $('#quantity').val(quantity - 1);
            }
        });

        $(".check").on('click',function () {
            var linkPost = "/api/order/detail"
            var dataProduct = {}
            var imgProducts = []
            dataProduct.orderId = parseInt(getCookie("OrderId"))
            axios.post(linkPost, dataProduct).then(function(res){
                if(res.data.success) {
                    // console.table(res.data.data)
                    var products = res.data.data
                    for(var product of products){
                        for(var pro of list){
                            if(pro.id == product.productid){
                                var p = {}
                                p.orderid = product.id
                                p.name = pro.name
                                p.image = pro.image;
                                p.qty = product.orderquantity
                                p.price = product.orderprice
                                imgProducts.push(p)
                            }
                        }
                    }
                    // console.table(imgProducts)
                    $("#table-cart > tbody").html("")
                    for(var pro of imgProducts){
                        $("#table-cart > tbody").append(`
                        <tr>
                            <td class="text-center image" style="padding: 5px 0px">
                                <img class="img-thumbnail" style="width: 100px;height: 100px;" src="${pro.image}" alt="" data-id="${pro.orderid}">
                            </td>
                            <td class="text-center">
                                ${pro.name}
                            </td>
                            <td class="text-center">${pro.qty}</td>
                            <td class="text-center price-cart">${pro.price}</td>
                            <td class="text-center price-cart">${pro.qty * pro.price}</td>
                            <td class="text-center">
                            <a href="#" class="btn btn-lg">
                                <span style="color: red" class="glyphicon glyphicon-remove btn-remove-cart"></span>
                            </a>
                            </td>
                        </tr>
                        `)
                        totalProduct += pro.qty
                    }
                    function format(x) {
                        x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
                        return x
                    }
                    $('.price-cart').each(function () {
                        $(this).text(format(parseInt($(this).text())))
                    })
                    $('.total-cart').text(imgProducts.length)
                    $('.btn-checkout').attr('href','/product/order/checkout')
                    $('.btn-remove-cart').on('click',function () {
                        var id = $(this).parent().parent().parent().children('.image').children('img').data('id')
                        swal({
                            title: 'Bạn có muốn xóa ?',
                            type: 'warning',
                            showCancelButton: true
                        }).then(function(result) {
                            if (result.value) {
                                axios.post("/api/order/delete-orderproduct", {
                                    productId: id
                                }).then(function(res){
                                    if(res.data.success) {
                                        location.reload();
                                    }
                                })
                            }
                        })
                    })
                }else {
                    console.log(res.data.message)
                }
            })
        })


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

    // xu ly gio hang trong trang checkout

    getImgProducts()

        // fix loi khi dang nhap fb

    if (window.location.hash && window.location.hash == '#_=_') {
        if (window.history && history.pushState) {
            window.history.pushState("", document.title, window.location.pathname);
        } else {
            // Prevent scrolling by storing the page's current scroll offset
            var scroll = {
                top: document.body.scrollTop,
                left: document.body.scrollLeft
            };
            window.location.hash = '';
            // Restore the scroll offset, should be flicker free
            document.body.scrollTop = scroll.top;
            document.body.scrollLeft = scroll.left;
        }
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

    function getImgProducts() {
        var linkPost = "/api/order/detail"
        var dataProduct = {}
        var imgProducts = []
        dataProduct.orderId = parseInt(getCookie("OrderId"))
        axios.post(linkPost, dataProduct).then(function(res){
            if(res.data.success) {
                var products = res.data.data
                for(var product of products){
                    for(var pro of list){
                        if(pro.id == product.productid){
                            var p = {}
                            p.orderid = product.id
                            p.name = pro.name
                            p.image = pro.image;
                            p.qty = product.orderquantity
                            p.price = product.orderprice
                            imgProducts.push(p)
                        }
                    }
                }
                $('.total-cart').text(imgProducts.length)
                var total = 0
                for(var pro of imgProducts){
                    $('#table-checkout tbody').append(`
                    <tr class="cart-item">
                        <td class="product-name">${pro.name}</td>
                        <td class="product-qty ">${pro.qty}</td>
                        <td class="product-price price">${pro.price}</td>
                    </tr>
                    `)
                    total += pro.qty * pro.price
                }
                function format(x) {
                    x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
                    return x
                }
                $('#total').text(total)
                $('.price').each(function () {
                    $(this).text(format(parseInt($(this).text())))
                })
                $('#table-checkout').dataTable({
                    "searching": false,
                    "paging": false,
                    "lengthChange": false
                })
                $('#table-checkout_info').text("")
            }else {
                console.log(res.data.message)
            }
        })
        updateQty(getCookie("OrderId"))
    }


    $(".btn-shopping").click(function () {
        var quantity = 0;
        var id = $(this).data("id");
        var $qty = $(this).closest('.item-product__inner').find('.qty');
        if(id == $(this).val()) {
            if(quantity != 0) {
                quantity += parseInt($qty.val());
            } else {
                quantity = parseInt($qty.val());
            }
        }
        else {
            quantity = parseInt($qty.val());
        }
        // update(id,quantity,"Order");

        var orderId = getCookie("OrderId")
        var linkPost = "/api/product/update-orderproduct"
        var dataProduct = {}
        dataProduct.id = null;
        dataProduct.productId = id;
        dataProduct.orderId = parseInt(orderId);
        dataProduct.orderPrice = $(this).parent().parent().children(".item-product__price").children(".price").attr("data-price");
        dataProduct.orderQuantity = quantity;
        // console.log(dataProduct)


        axios.post("/api/product/update-orderproduct", dataProduct).then(function(res){
            NProgress.done();
            if(res.data.success) {
                swal(
                    'Sản phẩm đã được thêm!',
                    res.data.message,
                    'success'
                )
            } else {
                swal(
                    'Error',
                    res.data.message,
                    'error'
                );
            }
        }, function(err){
            NProgress.done();
            swal(
                'Error',
                'Some error when saving product',
                'error'
            );
        })
        updateQty(getCookie("OrderId"))
    });




     // so tren gio hang
    function updateQty(orderId) {
        axios.get("/api/order/detail/qty/" + orderId).then(function (res) {
            if(res.data.success){
                $('.number__shopping').text(res.data.data)
            }
        })
    }



})