$(document).ready(function () {
    var dataUser = {};
    $.get("http://" + window.location.host + "/api/user/" + $(".username").text(), function (data, status) {
        if (data.data != null) {
            dataUser.id = data.data.id;
            dataUser.createdDate = data.data.createdDate
            dataUser.imageurl = data.data.imageurl
            $('#username').val(data.data.username)
            $('#fullname').val(data.data.fullname)
            $('#address').val(data.data.address)
            $('#email').val(data.data.email)
            $('#phone').val(data.data.phone)
            $('#preview-product-img').attr('src', data.data.imageurl)
            switch (data.data.gender) {
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
                dataProduct = {
                    image: res.data.link
                };
            }
        }, function(err){
            NProgress.done();
        })
    });

    $(".btn-save-user").on("click", function () {
        if($("#username").val() === "" || $("#fullname").val() === "" || dataUser.imageurl === undefined || $("#address").val() === ""||$("#email").val() === ""
        ) {
            swal(
                'Xẩy ra lỗi',
                'Bạn phải điền đầy đủ thông tin',
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
        dataUser.imageurl = $('#preview-product-img').attr('src')
        console.log(dataUser)
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
                    'Thành công!',
                    'Tài khoản sẽ bị đăng xuất',
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