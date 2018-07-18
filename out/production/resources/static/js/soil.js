$(document).ready(function () {
    var temperature =0
    function get_element() {
        $.post( "http://localhost:5000/environment/soilmoisture/lastsoil", function(res) {
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
    setInterval(get_element,1);

    $.get("http://localhost:5000/environment/getsoil", function(res, req){
        if(res.success){
            for(var soil of res.data ){
                var datetime
                var day
                var time
                datetime = soil.date.split(".")
                datetime = datetime[0].split("T")
                day = datetime[0].split("-")
                time = datetime[1]
                $('#tablesoil > tbody').append(`
                    <tr>
                        <th>${soil.id}</th>
                        <th>${soil.value + " %"}</th>
                        <th>${day[0]+'/'+day[1]+'/'+day[2]} ${time+'s'}</th>
                    </tr>
                `)
            }
            $('#tablesoil').DataTable();
        }
    })

    $("#left-menu > li > a").click(function () {
        $('ul.sub-menu').not($(this).siblings()).slideUp();
        $(this).siblings("ul.sub-menu").slideToggle();
    });
})