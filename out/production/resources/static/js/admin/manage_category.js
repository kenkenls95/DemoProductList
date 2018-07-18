$(document).ready(function () {
    $('#table-categoty').dataTable()
    $('.btn-detail').on('click',function () {
        var id = $(this).data("id")
        axios.get("/api/category/detail/"+id).then(function (res) {

        })
    })
})