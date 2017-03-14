//document is ready
$(document).ready(function () {
    //start loading json with AJAX
    $.ajax({
        url:"linksTable.json",
        cache: false,
        dataType: "json"
    }).done(function(data){
        //console.log(data);
        createLinks(data);
    }).fail(function(jqXHR,textStatus,errorThrown){
        console.log("error");
        console.log(textStatus);
        console.log(errorThrown);
    }).always(function(){
              console.log("always called");
    });
    
    
});

function createLinks(data){
    //loop through all links
    for (var link of data.links){
        //console.log(link);
        $("#myLinks")
        .append("<tr><td>"+link.text+"</td><td><a href='"+link.address+"' target='myIframe'>"+link.text+"</a></td><td>"+link.address+"</td></tr>");
    };
};
