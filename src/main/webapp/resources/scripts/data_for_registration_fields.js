var year = document.getElementById('year');
var day = document.getElementById('day');
var month = document.getElementById('month');
var arr_monthes = ["Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
				"Июль", "Август", "Сентябрь", "Октябрь", "Ноябырь", "Декабырь"];
var z = 1;
var c = 1;
var m = 1;
year.options[0] = new Option("Выберите год");
day.options[0] = new Option("Выберите день");
month.options[0] = new Option("Выберите месяц");
for(var i = 2018; i > 1965; i--){
    year.options[z] = new Option(i);
    z++;
}
for(var x = 1; x < 32; x++){
    day.options[c] = new Option(x);
	c++;
}
for(var b = 1; b < arr_monthes.length; b++){
    month.options[m] = new Option(arr_monthes[b]);
	m++;
}