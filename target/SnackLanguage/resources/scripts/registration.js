function registration(){
    var name = document.getElementById("name_input").value;
    var secondName = document.getElementById("second_name_input").value;
    var email = document.getElementById("email_input").value;
    var password = document.getElementById("password_input").value;

    var year = document.getElementById("year");
    var day = document.getElementById("day");
    var month = document.getElementById("month");

    var year_option = year.options[year.selectedIndex].value;
    var day_option = day.options[day.selectedIndex].value;
    var month_option = month.options[month.selectedIndex].value;
    var birthDay = day_option + " " + month_option + " " + year_option;

    if(name = null || secondName == null || email == null || password == null || year_option == "Выберите год" || day_option == "Выберите день" || month_option == "Выберите день"){
            document.getElementById("not_full_registration").style.display='block';
    }else{
        var xhr = new XMLHttpRequest();
        var user = {
            "id":"",
            "name":name,
            "secondName":secondName,
                "birthDay":birthDay,
            "password":password,
            "user_email":email
        };
        var userJSON = JSON.stringify(user);
        xhr.open('POST', "http://localhost:8080/SnackLanguage/api/registration", true);
        xhr.send(userJSON);
        alert(userJSON);

        xhr.onload = function(){
            alert(xhr.responseText);
        }
    }
}