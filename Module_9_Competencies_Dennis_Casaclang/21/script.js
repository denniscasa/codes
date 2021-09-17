/*******w***********

    Competency 21
    Name: Dennis Casaclang
    Date: March 30, 2021
    Description: Competency 21

*******************/


/*
	Load function
	Using the fetch API, get your chosen dataset from the Dog API

 */
function load() {

    fetch('https://dog.ceo/api/breed/hound/images/random')
        .then(function(result){
            return result.json();
        })
        .then(function(data){
        	createHTML(data);
        });
    
}

/*
	createHTML function
	Using your chosen Dog dataset, create at least 2 HTML elements 
	and add them to the provided HTML
*/
function createHTML(data){
	let body = document.getElementById("wrapper");

	let keys = Object.keys(data);
	let values = Object.values(data);

	let label = document.createElement("label");
	var img = document.createElement("img");

	img.src = values[0];
	label.innerHTML = `${keys[0]} :`;

	body.appendChild(label);
	body.appendChild(img);
}

//adds an event listener to execute onLoad method when page finished loading
document.addEventListener("DOMContentLoaded", load);