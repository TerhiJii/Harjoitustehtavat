$(document).ready(function(){
        var counter = 0;
        $(".draggable").draggable({stack:"div"});
        $("#target").droppable({
            drop: function(event, ui){
                counter = counter + 1;
                $("#counter").text("Dropped: "+counter);
            }
        });
});