function format(x) {
    x = x.toLocaleString('vi', {style : 'currency', currency : 'VND'});
    return x
}
$('.price').each(function () {
    $(this).text(format(parseInt($(this).text())))
})
// console.log($('.price'))