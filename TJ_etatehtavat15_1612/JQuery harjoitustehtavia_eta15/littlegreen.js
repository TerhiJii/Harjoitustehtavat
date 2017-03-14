$(document).ready(function(){

var littleGreenObject = {
    font: "small",
    backgroundColor: "yellow",
    width: 120, 
    height: 120,
    textColor: "green"
};



//console.log(littleGreenObject);

 $("#lg1").text("font: "+littleGreenObject.font);
 $("#lg2").text("backgroundColor: "+littleGreenObject.backgroundColor);
 $("#lg3").text("textColor: "+littleGreenObject.textColor);
 $("#lg4").text("size: "+littleGreenObject.width+" ,"+littleGreenObject.height);

var newProperties = {
    font: "large",
    text: "Dynamic green object"
};
    
$.extend( littleGreenObject, newProperties );

//console.log(littleGreenObject);

    
$.each(littleGreenObject, function(index, font, backgrounColor, width, height, textColor, text) {
    var font = $("#f").text("font: "+littleGreenObject.font);
    var bgcolor =  $("#bg").text("backgroundColor: "+littleGreenObject.backgroundColor);
    var tcolor = $("#tc").text("textColor: "+littleGreenObject.textColor);
    var width = $("#w").text("...width: "+littleGreenObject.width);
    var height = $("#h").text("...height: "+littleGreenObject.height);
    var size = $("#s").text("size: ");
    var text = $("#t").text("text: "+littleGreenObject.text);
});

$("#staticArea").text("Static Area");

littleGreenObject.backgroundColor = "green";
littleGreenObject.textColor = "black";

console.log(littleGreenObject);

$("#output").css("background-color", littleGreenObject.backgroundColor);
$("#output").css("color", littleGreenObject.textColor);
$("#output").css("width", littleGreenObject.width);
$("#output").css("height", littleGreenObject.height);
$("#output").text(littleGreenObject.text);
    
});