$(document).ready(function () {
    var id = 0;
    $('.overlay a').on('click', function () {
        if(id == 0){
            $('.overlay').css('height', '400px');
            id = 1;
        } else {
            $('.overlay').css('height', '30px');
            id = 0;
        }
    });
});