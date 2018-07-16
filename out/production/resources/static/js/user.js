$(document).ready(function () {
    var dataUser = {};
    $.get("http://"+window.location.host+"/api/user/"+$(".user-name").text(), function(data, status){
        if(data.data != null){
            dataUser.id = data.data.id;
            dataUser.createdDate = data.data.createdDate
            dataUser.imageurl = data.data.imageurl
            $('#username').val(data.data.username)
            $('#fullname').val(data.data.fullname)
            $('#address').val(data.data.address)
            $('#email').val(data.data.email)
            $('#phone').val(data.data.phone)
            $('#preview-product-img').attr('src',data.data.imageurl)
            switch (data.data.gender){
                case "Male":
                    document.getElementById("male").checked = true;
                break;
                case "Female":
                    document.getElementById("female").checked = true;
                break;
                case "Other":
                    document.getElementById("other").checked = true;
                break;
            }

            $(".btn-detail-bill").on("click", function () {
                var pdInfo = $(this).data("bill");
                $('#table-detail > tbody').html("")
                axios.get("/api/order/detail/" + pdInfo).then(function(res){
                    if(res.data.success) {
                        $('#name').text(data.data.username)
                        $('#diachi').text(data.data.address)
                        $('#diachiemail').text(data.data.email)
                        $('#ngaylap').text(data.data.createdDate)
                        var j =1;
                        var sum =0;
                        for(var pro of res.data.data.products){
                            $('#table-detail > tbody').append(`<tr>
                                <td>${j}</td>
                                <td>${pro.product.name}</td>
                                <td>${pro.orderquantity}</td>
                                <td class="price" ><span style="float: right">${pro.orderprice}</span></td>
                                <td class="price"><span style="float: right">${pro.orderprice * pro.orderquantity}</span></td>
                                </tr>`)
                            sum += pro.orderquantity*pro.orderprice;
                            j++;
                        }
                        $('#sum').text(sum)
                        $('#modal-create-bill').modal()
                        function format(x) {
                            x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
                            return x
                        }
                        $('.price').each(function () {
                            $(this).text(format(parseInt($(this).text())))
                        })
                    }
                }, function(err){
                })
            });
        }
        $('#table').DataTable();
    })

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#preview-product-img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#input-select-img-product").change(function() {
        readURL(this);
        var formData = new FormData();
        NProgress.start();
        formData.append('file', $("#input-select-img-product")[0].files[0]);
        axios.post("/api/upload/upload-image", formData).then(function(res){
            NProgress.done();
            if(res.data.success) {
                $('#preview-product-img').attr('src', res.data.link);
                dataUser.imageurl =  res.data.link
            }
        }, function(err){
            NProgress.done();
        })
    });

    $(".btn-save-user").on("click", function () {
        if($("#username").val() === "" || $("#fullname").val() === "" || dataUser.imageurl === undefined || $("#address").val() === ""||$("#email").val() === ""
         ) {
            swal(
                "Xẩy ra lỗi",
                'Bạn phải điền đủ thông tin',
                'error'
            );
            return;
        }

        if($('#re-new-password').val() !== $('#new-password').val()){
            swal(
                "Xẩy ra lỗi",
                "Mật khẩu mới không trùng",
                'error'
            )
            return;
        }

        dataUser.username = $('#username').val()
        dataUser.fullname = $('#fullname').val()
        dataUser.email = $('#email').val()
        dataUser.address = $('#address').val()
        dataUser.updatedDate = new Date().toJSON()
        dataUser.oldpassword = $('#old-password').val()
        dataUser.password = $('#new-password').val()
        if(document.getElementById("male").checked){
            dataUser.gender = "Male"
        }
        if(document.getElementById("female").checked){
            dataUser.gender = "Female"
        }
        if(document.getElementById("other").checked){
            dataUser.gender = "Other"
        }


        NProgress.start();

        var linkPost = "/api/user/update-user/" + dataUser.id;

        axios.post(linkPost, dataUser).then(function(res){
            NProgress.done();
            if(res.data.success) {
                swal(
                    'Good job!',
                    res.data.message,
                    'success'
                ).then(function() {
                    // location.reload();
                    document.location.href = location.origin
                });
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
                'Some error when saving user',
                'error'
            )
        })
    })
})