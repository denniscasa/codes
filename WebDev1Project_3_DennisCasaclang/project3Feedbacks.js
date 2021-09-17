/******w***********
    
    Project 3 Javascript
    Name: Dennis Casaclang
    Date: March 21, 2021
    Description: Project 3 Feedback Page Javascript

******************/

document.addEventListener("DOMContentLoaded", load);

function load()
{
	alertLists();
	hideErrors();

	document.getElementById("feedbackForm").addEventListener("submit", validate);
	document.getElementById("feedbackForm").reset();
	document.getElementById("feedbackForm").addEventListener("reset", resetForm);
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

//hide errors in form
function hideErrors(){
	let error = document.getElementsByClassName("error");

	for ( let i = 0; i < error.length; i++ ){
		error[i].style.display = "none";
	}
}

//reset form
function resetForm(e){
	if (confirm('Clear form?')){
		hideErrors();
		document.getElementById("fullname").focus();
		
		return true;
	}

	e.preventDefault();

	return false;	
}

//validate form
function validate(e){
	hideErrors();

	if(formHasErrors()){
		e.preventDefault();

		return false;
	}
	return true;
}

//check if field has input
function formfieldHasInput(fieldElement)
{
	if(fieldElement.value == null || trim(fieldElement.value) == "")
	{
		return false;
	}

	return true;
}

//trim string
function trim(str) 
{
	return str.replace(/^\s+|\s+$/g,"");
}

//check if form has errors
function formHasErrors(){
	let errorFlag = false;
	let requiredFields = ["fullname", "phone", "email", "comments"];

	//required fields check
	for(let i=0; i<requiredFields.length; i++){
		let textField = document.getElementById(requiredFields[i]);
		if(!formfieldHasInput(textField)){
			document.getElementById(requiredFields[i] + "_error").style.display = "block";

			if(!errorFlag){
				textField.focus();
				textField.select();
			}

			errorFlag = true;
		}
	}


	//regex checks
	let phoneRegex = new RegExp(/^\d{10}$/); //10 digit number
	let emailRegex = new RegExp(/^\w+@[a-zA-Z_]+?\.[a-zA-Z_]{2,3}$/); //email

	let phoneValue = document.getElementById("phone").value;
	let emailValue = document.getElementById("email").value;

	if(!phoneRegex.test(phoneValue))
	{
		document.getElementById("phoneformat_error").style.display = "block";

		if(!errorFlag){
			document.getElementById("phone").focus();
			document.getElementById("phone").select();
		}

		errorFlag = true;
	}
	if(!emailRegex.test(emailValue))
	{
		document.getElementById("emailformat_error").style.display = "block";

		if(!errorFlag){
			document.getElementById("email").focus();
			document.getElementById("email").select();
		}

		errorFlag = true;
	}

	return errorFlag;
}