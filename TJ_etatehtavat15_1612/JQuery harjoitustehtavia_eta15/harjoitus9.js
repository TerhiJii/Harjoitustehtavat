//document is ready
$(document).ready(function () {
    $("#loadButton").click(function(){
        //start loading json with AJAX
        $.ajax({
            url:"products.json",
            cache: false,
            dataType: "json"
        }).done(function(data){
            //console.log(data);
            createTable(data);
        }).fail(function(jqXHR,textStatus,errorThrown){
            console.log("error");
            console.log(textStatus);
            console.log(errorThrown);
        }).always(function(){
                  console.log("always called");
        });

    });
    
});

function createTable(data){
    //loop through all links
    for (var p of data.products){
        //console.log(link);
        $("#myTable")
        .append("<tr><td>"+p.id+
                "</td><td>"+p.device+
                 "</td><td>"+p.manufacturer+
                "</td><td>"+p.purchaseDate+
                "</td><td>"+p.price+
                "</td></tr>");
    };
};