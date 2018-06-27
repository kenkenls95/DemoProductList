$(document).ready(function () {
    var temperature =0
    function get_element() {
        $.post( "http://localhost:5000/environment/humidity/lasthum", function(res) {
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
    setInterval(get_element,1);

    $.get("http://localhost:5000/environment/gethum", function(res, req){
        if(res.success){
            for(var hum of res.data ){
                var datetime
                var day
                var time
                datetime = hum.date.split(".")
                datetime = datetime[0].split("T")
                day = datetime[0].split("-")
                time = datetime[1]
                $('#tablehum > tbody').append(`
                    <tr>
                        <th>${hum.id}</th>
                        <th>${hum.value + " %"}</th>
                        <th>${day[0]+'/'+day[1]+'/'+day[2]} ${time+'s'}</th>
                        <th class="status">${hum.status}</th>
                    </tr>
                `)

            }
            $('#tablehum').DataTable();

        }
    })

    $("#left-menu > li > a").click(function () {
        $('ul.sub-menu').not($(this).siblings()).slideUp();
        $(this).siblings("ul.sub-menu").slideToggle();
    });
})