$(document).ready(function () {

    function Employees(init) {
        var that = {};
        that.employees = [];
        return {
            add: function(e) {
            that.employees.push(e);
        },
        get: function(i) {
            return that.employees[i];
        },
        len: function() {
            return that.employees.length;
        },
        sortByName: function() {
        that.employees.sort(function(a, b){
            if (a.name.toLowerCase()<b.name.toLowerCase()) return -1;
            if (a.name.toLowerCase()>b.name.toLowerCase()) return 1;
            return 0;
        })
        },

    sortByAge: function() {
        // TEHTÄVÄ: Toteuta sorttaus iän perusteella, vanhin ensin
        that.employees.sort(function(a, b){
            if (a.age < b.age) return 1;
            if (a.age > b.age) return -1;
            return 0;
        })
        }

    } /* end of return block */
}

var empl = new Employees();
empl.add({name:"John", age:32, startdate :"March 12, 2010"});
empl.add({name:"Jill", age:24, startdate:"June 6, 2012"});
empl.add({name:"Bill", age:53, startdate:"December 2, 1987"});
empl.add({name:"Sara", age:45, startdate:"April 1, 2000"});
empl.add({name:"Julia",age:47, startdate:"January 10, 1989"});
empl.add({name:"Rob",age:51, startdate:"January 12, 1991"});
var str = "";
var len = empl.len();
function sortEmployees(){
                for (var i=0; i<len; i++) {
                var employee = empl.get(i);
                str += "{" + employee.name + "," + employee.age + "," + employee.startdate +"} ";
                }
        return str;
    };
console.log("original: " +sortEmployees());
 str = "";
empl.sortByName();
// Tulosta empl-taulukon sisältö. Sorttaus nimen mukaan.
console.log("sortByName: " +sortEmployees());
str = "";
empl.sortByAge();
// Tulosta empl-taulukon sisältö. Sorttaus iän mukaan.
console.log("sortByAge: " +sortEmployees());
});