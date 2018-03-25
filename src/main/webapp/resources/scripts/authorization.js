function checkValidation(){
    var xhr = new XMLHttpRequest();
    var userName = document.getElementById("name_autorization").value;
    var userPassword = document.getElementById("password_autorization").value;
    var user = {
        "id":"",
        "name":"null",
        "secondName":"null",
        "birthDay":"null",
        "password":userPassword,
        "user_email":userName
    };
    var userJSON = JSON.stringify(user);
    xhr.open('POST', "http://localhost:8080/SnackLanguage/api/authorization/check", true);
    xhr.send(userJSON);
    xhr.onload = function(){
        if(xhr.responseText == "invalid"){
            document.getElementById("wrong_authorization").style.display='block';
        }
        if(xhr.responseText == "valid"){
            document.location.href = "http://localhost:8080/SnackLanguage/account";
            setAuthorizationCookie(userName, userPassword);
        }
    }
}
function setAuthorizationCookie(login, password){

}