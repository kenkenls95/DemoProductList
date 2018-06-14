/**
 * Created by ManhNguyen on 1/17/18.
 */

$(document).ready(function() {
    // $(".show-sa-test").on('click', function () {
    //     swal({
    //         title: 'Are you sure?',
    //         text: 'You will not be able to recover this imaginary file!',
    //         type: 'warning',
    //         showCancelButton: true,
    //         confirmButtonText: 'Yes, delete it!',
    //         cancelButtonText: 'No, keep it'
    //     }).then(function (result) {
    //         if (result.value) {
    //         swal(
    //             'Deleted!',
    //             'Your imaginary file has been deleted.',
    //             'success'
    //         )
    //         // result.dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
    //     } else if (result.dismiss === 'cancel') {
    //         swal(
    //             'Cancelled',
    //             'Your imaginary file is safe :)',
    //             'error'
    //         )
    //     }
    // })
    // });

    // Increase and decrease value in product
    $(function () {
        $('.add').on('click',function(){
            var $qty=$(this).closest('p').find('.qty');
            var currentVal = parseInt($qty.val());
            if (!isNaN(currentVal)) {
                $qty.val(currentVal + 1);
            }
        });
        $('.minus').on('click',function(){
            var $qty=$(this).closest('p').find('.qty');
            var currentVal = parseInt($qty.val());
            if (!isNaN(currentVal) && currentVal > 0) {
                $qty.val(currentVal - 1);
            }
        });
    });

    $("#left-menu > li > a").click(function () {
        $('ul.sub-menu').not($(this).siblings()).slideUp();
        $(this).siblings("ul.sub-menu").slideToggle();
    });
});