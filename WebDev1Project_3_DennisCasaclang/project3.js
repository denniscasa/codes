/******w***********
    
    Project 3 Javascript
    Name: Dennis Casaclang
    Date: March 21, 2021
    Description: Project 3 Home Page Javascript

******************/

document.addEventListener("DOMContentLoaded", load);

function load()
{
	alertLists();
}

//about us and contact number alerts
function alertLists()
{
	let aboutUs = document.getElementsByClassName("aboutUs");
	let contactNumber = document.getElementsByClassName("contactNumber");

	for(let i=0; i<aboutUs.length; i++)
	{
		aboutUs[i].addEventListener("click",
		function(){
			window.alert("We are a brand-new company in Winnipeg, specializing in video game sales and repairs. Established in 2021, our company started in Red River College Downtown campus, from a small web dev class, to now a new startup company in Winnipeg.");
		});
	}
	for(let j =0; j<contactNumber.length; j++)
	{
		contactNumber[j].addEventListener("click",
			function(){
				window.alert("Nairn Branch: 204-222-2224\nDowntown Branch: 204-222-2223");
			});
	}
}