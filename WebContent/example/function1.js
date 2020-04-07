var num = 1;
//변수값이 null, 0 -> 거짓(false)
//변수값이 있거나, "값" -> 참(true)
function gallery(direct) {
    if(direct) { //증가
        if(num==7) {
         num = 0;
         return num;
        } 
        num++;
    } else{ //감소
        if(num == 1){
            num = 8;
         return num;
        }
        num--;
    }
    var photo = document.getElementById('photo');
    photo.setAttribute("src", "../images/a" + num + ".jpg");
}