
$(document).ready(function(){
    function readData (data){
        if(data == 1){
            return true;
        }else{
            return false;
        }
    }

    for(var i =0 ; i<1;i++){
        // $(location).attr('href')+
        $.get("http://kienvt.herokuapp.com/remote/api/getLed", function(data, status){

            $(".switch > input")[0].checked = readData(data.led1);

            $(".switch > input")[1].checked = readData(data.led2);

            $(".switch > input")[2].checked = readData(data.led3);

            $(".switch > input")[3].checked = readData(data.led4);

        });
    }


    var led1,led2,led3,led4;

    $(".send").click(function(){
        if($(".switch > input")[0].checked){
            led1 =1;
        }else{
            led1 =0;
        }
        if($(".switch > input")[1].checked){
            led2 =1;
        }else{
            led2 =0;
        }
        if($(".switch > input")[2].checked){
            led3 =1;
        }else{
            led3 =0;
        }
        if($(".switch > input")[3].checked){
            led4 =1;
        }else{
            led4 =0;
        }
        var linkPost = "http://kienvt.herokuapp.com/remote/api/doLed";
        var status = {};
        status.led = [];
        status.led[0]= led1;
        status.led[1]= led2;
        status.led[2]= led3;
        status.led[3]= led4;

        $.post(linkPost, status , function(data, status){


            if(data.success === true) {
                swal(
                    'Good job!',
                    data.message,
                    'success'
                ).then(function() {
                    location.reload();
                });
            } else {
                swal(
                    'Error',
                    data.message,
                    'error'
                );
            }
        });
    });


    $(".remove").click(function(){
        swal({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            type: 'warning',
            showCancelButton: true
        }).then(function(result){
            if(result.value){
                $.post("http://kienvt.herokuapp.com/remote/api/remove",
                    {
                        "remove":true
                    },
                    function(data,status){
                        if(data.success === true) {
                            swal(
                                'Good job!',
                                data.message,
                                'success'
                            ).then(function() {
                                location.reload();
                            });
                        } else {
                            swal(
                                'Error',
                                data.message,
                                'error'
                            );
                        }
                    });
            }
        });

    });



});