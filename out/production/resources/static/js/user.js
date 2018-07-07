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
            if(data.message == "ROLE_ADMIN"){
                $('#content').append(`
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <h3>Quản lý tài khoản</h3>
                        <table class="table table-bordered table-hover" id="tableuser">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Tên Tài Khoản</th>
                                    <th>Trạng Thái</th>
                                    <th>Hành Động</th>
                                </tr>
                            </thead>
                            <tbody>
            
                            </tbody>
                        </table>
                    </div>
                `)
                $.get("http://"+window.location.host+"/api/user/alluser", function(res, req){
                    for(var user of res.data){
                        if(user.user != null){
                            $('#tableuser > tbody').append(`
                              <tr>
                                    <td>${user.id}</td>
                                    <td>${user.user.username}</td>
                                    <td>${user.role.description}</td>
                                    <td><button class="btn btn-default btn-edit-role" data-id="${user.user.id}">Sửa</button> <button class="btn btn-warning btn-ban-role">Chặn</button></td>
                              </tr>  
                            `)
                            $('#tableuser').DataTable();
                            $('.btn-edit-role').on('click',function () {
                                var id = $(this).data("id")
                                console.log(id)
                                swal({
                                    title: 'Are you sure?',
                                    text: "You won't be able to revert this!",
                                    type: 'warning',
                                    showCancelButton: true
                                }).then(function(result) {
                                    if (result.value) {
                                        NProgress.start();
                                        axios.post("/api/user/update-role/", {
                                            userId : id
                                        }).then(function(res){
                                            NProgress.done();
                                            if(res.data.success) {
                                                swal(
                                                    'Good job!',
                                                    res.data.message,
                                                    'success'
                                                ).then(function() {
                                                    location.reload();
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
                                                'Some error when saving product',
                                                'error'
                                            );
                                        })
                                    }
                                })
                            })
                            $('.btn-ban-role').on('click',function () {

                            })
                        }
                    }
                }
                )
            }else {
                $('#content').append(`
                    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                        <h3>Lịch sử mua hàng</h3>
            
                        <table class="table table-bordered table-hover" id="table" style="margin-top: 15px;">
                            <thead>
                            <tr>
                                <th>STT</th>
                                <th>Số hóa đơn</th>
                                <th>Ngày tạo</th>
                                <th>Địa chỉ</th>
                                <th>Trạng thái</th>
                                <th>Xem chi tiết</th>
                            </tr>
                            </thead>
                            <tbody>
            
                            </tbody>
                        </table>
                    </div>
                `)
                $.get("http://"+window.location.host+"/api/order/user/"+ data.data.id, function(res, req){
                    var i = 1;
                    for(var order of res.data){
                        $('#table > tbody').append(`<tr>
						<td>${i}</td>
			            <td>${order.id}</td>
			            <td>${order.createdDate}</td>
			            <td>${order.address}</td>
			            <td>${order.orderStatus.name}</td>
			            <td>
			            <button type="button" class="btn-detail-bill btn-default btn" data-bill="${order.id}"  class="btn">
                          Xem chi tiết
                        </button></td>
			            </tr>`)
                        i++;
                    }
                    $('#table').DataTable();

                    $(".btn-detail-bill").on("click", function () {
                        var pdInfo = $(this).data("bill");
                        $('#table-detail > tbody').html("")
                        NProgress.start();
                        axios.get("/api/order/detail/" + pdInfo).then(function(res){
                            NProgress.done();
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
                                <td>${pro.orderprice}</td>
                                <td class="money">${pro.orderquantity*pro.orderprice}</td>
                                </tr>`)
                                    sum += pro.orderquantity*pro.orderprice;
                                    j++;
                                }
                                $('#sum').text(sum)
                                $('#modal-create-bill').modal()
                            }
                        }, function(err){
                            NProgress.done();
                        })
                    });
                })
            }

        }
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
                'Error',
                'You need to fill all values',
                'error'
            );
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
                    window.location.replace('http://localhost:8080/logout');
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
            );
        })
    });





})