/******w***********
    
    Project 3 Javascript
    Name: Dennis Casaclang
    Date: March 21, 2021
    Description: Project 3 Products Page Javascript

******************/
let orderTotal = 0;
const itemPrice = [799, 1599, 599, 20, 20];
const itemsForSale = ["PS5", "Alienwear Laptop", "GL TV", "PC Repairs", "PC Upgrades"];

document.addEventListener("DOMContentLoaded", load);

function load()
{
	alertLists();

	document.getElementById("purchaseForm").addEventListener("submit", validate);
	document.getElementById("addPS5").addEventListener("click",
		function(){
			addItemToCart("1");
		})
	document.getElementById("addLaptop").addEventListener("click",
		function(){
			addItemToCart("2");
		})
	document.getElementById("addTV").addEventListener("click",
		function(){
			addItemToCart("3");
		})
	document.getElementById("addRepairs").addEventListener("click",
		function(){
			addItemToCart("4");
		})
	document.getElementById("addUpgrades").addEventListener("click",
		function(){
			addItemToCart("5");
		})
}

//calculate total
function addItemToCart(itemNumber)
{
	let quantityValue = trim(document.getElementById("qty" + itemNumber).value);
	let cartItemTotal = document.getElementById("cartTotal");

	if ( !isNaN(quantityValue) && quantityValue != "" && quantityValue != null && quantityValue != 0 && !document.getElementById("cartItem" + itemNumber) ){
		let itemTotal = quantityValue * itemPrice[itemNumber -1];
		orderTotal += itemTotal;
		let currentItem = document.getElementById("item" + itemNumber);
		currentItem.style.visibility = "hidden";
		alert(`${itemsForSale[itemNumber -1]} added to cart.`);
	}

	cartItemTotal.innerHTML = `$${orderTotal}`;
}

//validate form
function validate(e){

	var check = confirm(`The total is $${orderTotal}. Are you ready to purchase?`)
	if(!check)
	{
		e.preventDefault();
		return false;
	}
	return false;
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

//trim string
function trim(str) 
{
	return str.replace(/^\s+|\s+$/g,"");
}