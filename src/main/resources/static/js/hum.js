$(document).ready(function () {
    var temperature =0
    function get_element() {
        $.post( "http://localhost:5000/lasthum", function(res) {
            temperature = res[0].value;
        });
    }
    window.onload = function(){
        var g1 = new JustGage({
            id: "g1",
            value: temperature,
            min: -15,
            max: 100,
            title: "Độ ẩm thực tế",
            label: "%",
            gaugeWidthScale: 0.2
        });

        setInterval(function() {
            g1.refresh(temperature);
        }, 1000);
    };
    setInterval(get_element,10000);

    $.get("http://localhost:5000/environment/gethum", function(res, req){
        if(res.success){
            console.log(res.data)
            for(var hum of res.data ){
                $('#tablehum > tbody').append(`
                    <tr>
                        <th>${hum.id}</th>
                        <th>${hum.value + " *C"}</th>
                        <th>${hum.date}</th>
                        <th class="status">${hum.status}</th>
                    </tr>
                `)
            }
            $('#tablehum').DataTable();
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