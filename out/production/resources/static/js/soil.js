$(document).ready(function () {
    var temperature =0
    function get_element() {
        $.post( "http://localhost:5000/lastsoil", function(res) {
            temperature = res[0].value;
        });
    }
    window.onload = function(){
        var g1 = new JustGage({
            id: "g1",
            value: temperature,
            min: -15,
            max: 100,
            title: "Độ ẩm đât thực tế",
            label: "%",
            gaugeWidthScale: 0.2
        });

        setInterval(function() {
            g1.refresh(temperature);
        }, 1000);
    };
    setInterval(get_element,10000);

    $.get("http://localhost:5000/environment/getsoil", function(res, req){
        if(res.success){
            for(var temp of res.data ){
                $('#tablesoil > tbody').append(`
                    <tr>
                        <th>${temp.id}</th>
                        <th>${temp.value + " *C"}</th>
                        <th>${temp.date}</th>
                        <th class="status">${temp.status}</th>
                    </tr>
                `)
            }
            $('#tablesoil').DataTable();
            if($('.status').val() == 0){
                $('.status').text("Device is not ready")
                $('.status').css("color","red")
            }else{
                $('.status').text("Device is ready")
                $('.status').css("color","blue")
            }
        }
    })
})