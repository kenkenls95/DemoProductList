$(document).ready(function () {
    axios.get("/api/user/alluser").then(function(res){
        console.log(res.data)
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
    })
})
