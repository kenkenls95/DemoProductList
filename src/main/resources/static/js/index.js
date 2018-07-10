
$(document).ready(function() {
    if($('.user-name').text() != ""){
        swal(
            'Xin chào '+$('.user-name').text()+' đã đến với KCShop',
            "",
            'success'
        )
    }
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



    function update(id,qty,cname) {

        if(getCookie(cname) == ""){
            var order =[]
            var product ={}
            product.id =id
            product.qty = qty
            order.push(product)
            setCookie(cname,JSON.stringify(order),7)
        }else if(getCookie(cname) != null) {
            var order = JSON.parse(getCookie(cname))
            if(!order){
                order = []
            }else {
                order = JSON.parse(getCookie(cname))
            }
            var product = {}
            var flag = true
            product.id = id
            product.qty = qty
            for(var pro of order){
                if(pro.id === product.id){
                    pro.qty += product.qty
                    flag = false
                }
            }
            if(flag){
                order.push(product);
            }
            setCookie(cname,JSON.stringify(order),7)
        }
    }

    function getCookie(cname) {
        var name = cname + "=";
        var decodedCookie = decodeURIComponent(document.cookie);
        var ca = decodedCookie.split(';');
        for(var i = 0; i <ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ') {
                c = c.substring(1);
            }
            if (c.indexOf(name) == 0) {
                return c.substring(name.length, c.length);
            }
        }
        return "";
    }

    function setCookie(cname, cvalue) {
        document.cookie = cname + "=" + cvalue + ";";
    }


});