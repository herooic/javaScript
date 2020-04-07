var score = 10;
function myFunc(){
        var score =20;
        console.log("local:" + score);        
}
myFunc();
console.log("global:" + score);

function newFunc() {
    console.log("global function");
}

function outerFunc() {
    function newFunc() {
        console.log("local function");
    }
    newFunc();
}
newFunc();
outerFunc();

// function returnFnc() {
//     console.log("return Fnc");
// }
// returnFnc();

//한번만 실행하는 함수, 실행구문을 바로 실행
(function() {
    console.log("return Fnc");
})();


