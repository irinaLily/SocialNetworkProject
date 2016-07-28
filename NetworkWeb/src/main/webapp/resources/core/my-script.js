$(document).ready(function(){


    $("#submit-post").click(function () {
        //1) send to server
        //2)  по положительному ответуЖ
        // a) дорисовать новый пост сверху
        // b) очистить форму ввода


        var title = $("#postTitle").val();
        var content = $("#postcontent").val();
        $.ajax({
            type: "PUT",
            url: "./newPost",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: '{"content": "' + content + '", "title": "' + title + '"}',
            success: function () {
                $("#postconteiner").prepend(
                    '<div class="row">'+
                    '<div class="col-sm-3">' +
                   ' <div class="well">'+
               ' <p>UserName</p>'+
                ' <img src="bird.jpg" class="img-circle" height="55" width="55" alt="Avatar">'+
                   '</div>'+
                    '</div>'+
                    '<div class="col-sm-9">'+
                    '<div class="well">'+
                   '<p><b>' + title + ': </b>' + content + '</p>'+
                '</div>'+
                '</div>'+
               '</div>'
                );
                $("#postcontent").val("");
                $("#postTitle").val("");
            },
            error: function(data, sttus, ex) {
                console.log(ex);
            }
        });
    });

    $(".glyphicon-heart").click(function(event){
        $(event.target).hide();

    });

    $(".friend-info,.NikName").click(function(event){
        var friendId=$(event.currentTarget).attr("id");
        window.location="friend?friendID="+friendId;
    });
    //$(".messNikName").click(function(event){
    //    var friendId=$(event.currentTarget).attr("id");
    //    window.location="friend?friendID="+friendId;
    //});

    $(".img-circle").click(function(event){
        $(event.target).animate({
            left: '250px',
            height: '300px',
            width: '300px'
        });
    });

    $("#bootpink").click(function(){
        $("p").toggleClass("white");
     //   $("p").css("background-color", "#cc8fc0");
    });

    $("#myH1").mouseenter(function(event){
        $(event.target).animate({left: '100px'}, "slow");
        $(event.target).animate({fontSize: '7em'}, "slow");
    });
    $(".img-circle").hover(function(event){
            $(event.target).animate({
                left: '250px',
                height: '300px',
                width: '300px'
            });
        },
        function(event){
            $(event.target).animate({
                left: '150px',
                height: '50px',
                width: '50px'
            });
        });
});

