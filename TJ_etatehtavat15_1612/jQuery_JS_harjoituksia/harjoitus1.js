$(document).ready(function () {
function Person() {
    this._age = 30; // "_age tässä private-muuttujan kaltainen ominaisuus"
    
    Person.prototype.birthday = function() { 
        /* TEHTÄVÄ: Lisää ikää yhdellä */
        this.age = this.age +1;
    }
 
    // TEHTÄVÄ: Toteuta setAge-metodi
    Person.prototype.setAge = function(age) {
        // TEHTÄVÄ: tarkasta, että ikä välillä 0-100
        // muita arvoja ei hyväksytä
        if (age > 0 && age <100){
            this.age = age;
            console.log("setAge funktio"+this.age);
            }
        else
            console.log("Not valid age, must be 0-100");
    }

    Person.prototype.getAge = function() {
        console.log("getAge funktio"+this.age);
        return this.age;
    }
 Person.prototype.age = this.getAge;
}
    


function writeResults() {
    var bill = new Person();
    bill.setAge(31);
    bill._age = 32; // "illegal access" to private property, which is still possible!
    var jill = new Person();
    jill.setAge(27);
    var div = document.getElementById("results");
    // TEHTÄVÄ: aseta bill ja jill olioiden ikä yo. div-elementtiin
    $("#age").text("Bill's age: "+bill.getAge()+" Jill's age: "+jill.getAge());
    jill.birthday();
    jill.birthday();
     $("#age2").text("Jill's age: "+jill.age);
    $("#age3").text("Bill's prototype is  "+ (Object.getPrototypeOf(bill)));
    $("#age4").text("jill's prototype is Person? "+(Object.getPrototypeOf(jill) === Person.prototype));
    
}
    
writeResults();
});