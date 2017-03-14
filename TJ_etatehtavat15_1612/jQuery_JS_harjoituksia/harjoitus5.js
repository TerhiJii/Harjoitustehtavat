//document is ready
$(document).ready(function () {
    //start loading json with AJAX
    $.ajax({
        url:"teams_3009.json",
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

function createTable(data){
    //loop through all data
    $("#myTable").append("<tr><td>Id</td><td>Name</td><td>Shortcut</td><td>Logo</td></tr>")
    for (var rec of data.teams){
        //console.log(link);
        //"<img src='theImg.png' height='50' width='42'/>"
        $("#myTable")
        .append("<tr><td>"+rec.id+"</td><td>"+rec.name+"</td><td>"+rec.shortName+"</td><td><img src='"+rec.crestUrl+"' height='50' width='50'/></td></tr>");
    };
};