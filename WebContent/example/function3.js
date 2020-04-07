function CheckWeight(name, height, weight) {
    this.myName = name;
    this.myHeight = height;
    this.myWeight = weight;
    this.minWeight;
    this.maxWeight;

    // this.getInfo = function() {
    //     var str = "";
    //     str += "이름: " + this.myName + ", ";
    //     str += "키: " + this.myHeight + ", ";
    //     str += "몸무게: " +this.myWeight;
    //     return str;
    // }
    // this.getResult = function() {
    //     this.minWeight = (this.myHeight - 100) *  0.9 - 5;
    //     this.maxWeight = (this.myHeight - 100) *  0.9 + 5;

    //     if(this.myWeight < this.minWeight){
    //         return "정상 몸무게 미달입니다.";
    //     } else if (this.myWeight > this.maxWeight) {
    //         return "정상 몸무게보다 초과입니다.";s
    //     } else {
    //         return "정상 몸무게";
    //     }
    // }
}
//생성자 함수에 함수를 생성하지 않고 프로토타입을 이용해서 함수정의.
//getinfo, getResult가 안나옴.
CheckWeight.prototype.getInfo = function() {
    var str = "";
    str += "이름: " + this.myName + ", ";
    str += "키: " + this.myHeight + ", ";
    str += "몸무게: " +this.myWeight;
    return str;
}

CheckWeight.prototype.getResult = function() {
    this.minWeight = (this.myHeight - 100) *  0.9 - 5;
    this.maxWeight = (this.myHeight - 100) *  0.9 + 5;

    if(this.myWeight < this.minWeight){
        return "정상 몸무게 미달입니다.";
    } else if (this.myWeight > this.maxWeight) {
        return "정상 몸무게보다 초과입니다.";
    } else {
        return "정상 몸무게";
    }
}

var person = new CheckWeight("Hong", 170, 65);
var person1 = new CheckWeight("Hwang", 160, 70);
console.log(person);
console.log(person1);

console.log(person.getInfo());
console.log(person.getResult());

console.log(person1.getInfo());
console.log(person1.getResult());

// for (f in person) {
//     console.log(f, person[f]);
// }