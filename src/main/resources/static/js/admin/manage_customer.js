$(document).ready(function () {
    axios.get("/api/user/alluser").then(function(res){
        console.log(res.data.data)
        for(var user of res.data.data){
            if(user.user != null){
                $('#tableuser > tbody').append(`
                              <tr>
                                    <td>${user.id}</td>
                                    <td>${user.user.username}</td>
                                    <td>${user.role.description}</td>
                                    <td><button class="btn btn-default btn-edit-role" data-id="${user.user.id}">Sửa</button> <button class="btn btn-warning btn-ban-role" data-id="${user.user.id}">${user.status}</button></td>
                              </tr>
                            `)
            }
        }
        $('#tableuser').DataTable();
        $('.btn-edit-role').on('click',function () {
            var id = $(this).data("id")
            console.log(id)
            swal({
                title: 'Bạn có chắc ?',
                text: "",
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
            var id = $(this).data('id')
            axios.get("/api/user/disable/" + id).then(function (value) {
                console.log(value.data)
                if(value.data.success){
                    swal (
                        "Thành công",
                        value.data.message,
                        'success'
                    ).then(function (value1) {
                        location.reload()
                    })
                }else {
                    console.log(value.data.message)
                }
            })
        })
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
})