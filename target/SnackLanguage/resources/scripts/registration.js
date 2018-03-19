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
    alert(userJSON);
    xhr.open('POST', "http://localhost:8080/SnackLanguage/api/authorization/check", userJSON, true);
    xhr.send(userJSON);
    xhr.onload = function(){
        alert(xhr.responseText);
    }
}