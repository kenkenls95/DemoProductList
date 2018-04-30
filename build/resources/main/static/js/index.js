/**
 * Created by ManhNguyen on 1/17/18.
 */

$(document).ready(function() {
    $(".show-sa-test").on('click', function () {
        swal({
            title: 'Are you sure?',
            text: 'You will not be able to recover this imaginary file!',
            type: 'warning',
            showCancelButton: true,
            confirmButtonText: 'Yes, delete it!',
            cancelButtonText: 'No, keep it'
        }).then(function (result) {
            if (result.value) {
            swal(
                'Deleted!',
                'Your imaginary file has been deleted.',
                'success'
            )
            // result.dismiss can be 'overlay', 'cancel', 'close', 'esc', 'timer'
        } else if (result.dismiss === 'cancel') {
            swal(
                'Cancelled',
                'Your imaginary file is safe :)',
                'error'
            )
        }
    })
    });
});