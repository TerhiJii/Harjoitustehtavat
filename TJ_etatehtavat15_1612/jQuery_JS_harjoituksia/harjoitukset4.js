//document is ready
$(document).ready(function () {
    //start loading json with AJAX
    $.ajax({
        url:"records_3009.json",
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
    $("#myTable").append("<tr><td>Description</td><td>Type</td><td>Date</td><td>Attendance</td><td>Match</td></tr>")
    for (var rec of data.recordsTeam.record){
        //console.log(link);
        $("#myTable")
        .append("<tr><td>"+rec.description+"</td><td>"+rec.type+"</td><td>"+rec.match.date+"</td><td>"+rec.match.attendance+"</td><td>"+rec.match.homeTeam+" - "+rec.match.awayTeam+"("+rec.match.homeTeamScore+" - "+rec.match.awayTeamScore+")</td></tr>");
    };
};