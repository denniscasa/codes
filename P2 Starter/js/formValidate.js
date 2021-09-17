/******************
    
    Assignment 2 Javascript
    Name: Dennis Casaclang
    Date: September 10, 2021
    Description: Assignment 2

******************/

const itemDescription = ["MacBook", "The Razer", "WD My Passport", "Nexus 7", "DD-45 Drums"];
const itemPrice = [1899.99, 79.99, 179.99, 249.99, 119.99];
const itemImage = ["mac.png", "mouse.png", "wdehd.png", "nexus.png", "drums.png"];
let numberOfItemsInCart = 0;
let orderTotal = 0;

/*
 * Handles the submit event of the survey form
 *
 * param e  A reference to the event object
 * return   True if no validation errors; False if the form has
 *          validation errors
 */
function validate(e){
	hideErrors();

	if(formHasErrors()){
		e.preventDefault();

		return false;
	}
	return true;
}

/*
 * Handles the reset event for the form.
 *
 * param e  A reference to the event object
 * return   True allows the reset to happen; False prevents
 *          the browser from resetting the form.
 */
function resetForm(e){
	// Confirm that the user wants to reset the form.
	if ( confirm('Clear order?') ){
		// Ensure all error fields are hidden
		hideErrors();
		
		// Set focus to the first text field on the page
		document.getElementById("qty1").focus();
		
		// When using onReset="resetForm()" in markup, returning true will allow
		// the form to reset
		return true;
	}

	// Prevents the form from resetting
	e.preventDefault();
	
	// When using onReset="resetForm()" in markup, returning false would prevent
	// the form from resetting
	return false;	
}

function formfieldHasInput(fieldElement)
{
	if(fieldElement.value == null || trim(fieldElement.value) == "")
	{
		return false;
	}

	return true;
}
/*
 * Does all the error checking for the form.
 *
 * return   True if an error was found; False if no errors were found
 */
function formHasErrors(){
	
	let errorFlag = false;

	let checkingFactors = "432765432";
	let requiredShippingFields = ["fullname", "address", "city", "postal", "email"];

	//shipping info checks
	for(let i=0; i<requiredShippingFields.length; i++){
		let textField = document.getElementById(requiredShippingFields[i]);
		if(!formfieldHasInput(textField)){
			document.getElementById(requiredShippingFields[i] + "_error").style.display = "block";

			if(!errorFlag){
				textField.focus();
				textField.select();
			}

			errorFlag = true;
		}
	}

	//regex checks
	let emailRegex = new RegExp(/^\w+@[a-zA-Z_]+?\.[a-zA-Z_]{2,3}$/); //email
	let postalRegex = new RegExp(/^[A-Za-z]\d[A-Za-z][ -]?\d[A-Za-z]\d$/); //postal
	let cardRegex = new RegExp(/^\d{10}$/); //10 digit number

	let emailValue = document.getElementById("email").value;
	let postalValue = document.getElementById("postal").value;

	if(!emailRegex.test(emailValue))
	{
		document.getElementById("emailformat_error").style.display = "block";

		if(!errorFlag){
			document.getElementById("email").focus();
			document.getElementById("email").select();
		}

		errorFlag = true;
	}

	if(!postalRegex.test(postalValue))
	{
		document.getElementById("postalformat_error").style.display = "block";

		if(!errorFlag){
			document.getElementById("postal").focus();
			document.getElementById("postal").select();
		}

		errorFlag = true;
	}
	
	//shopping card validation
	if(numberOfItemsInCart == 0)
	{
		window.alert("You have no items in your cart.");

		if(!errorFlag){
			document.getElementById("qty1").focus();
			document.getElementById("qty1").select();
		}

		errorFlag = true;
	}

	//card type check
	let cardType = ["visa", "amex", "mastercard"];
	let cardChecked = false;
	
	for(let i=0; i<cardType.length && !cardChecked; i++){
		if(document.getElementById(cardType[i]).checked){
			cardChecked = true;
		}
	}

	if(!cardChecked)
	{
		document.getElementById("cardtype_error").style.display = "block";
		
		errorFlag = true;
	}

	//check payment fields
	let requiredPaymentFields = ["cardname", "cardnumber"];

	for(let i=0; i<requiredPaymentFields.length; i++){
		let textField = document.getElementById(requiredPaymentFields[i]);
		if(!formfieldHasInput(textField)){
			document.getElementById(requiredPaymentFields[i] + "_error").style.display = "block";

			if(!errorFlag){
				textField.focus();
				textField.select();
			}

			errorFlag = true;
		}
	}

	//cardNumber regex check
	let cardValue = document.getElementById("cardnumber").value;
	let validCard = true;

	if(!cardRegex.test(cardValue))
	{
		document.getElementById("invalidcard_error").style.display = "block";
		validCard = false;
		
		if(!errorFlag){
			document.getElementById("cardnumber").focus();
			document.getElementById("cardnumber").select();
		}

		errorFlag = true;
	}

	//card number check
	if(validCard)
	{
		let cardField = document.getElementById("cardnumber").value;
		let total = 0;
		let divide = 0;
		let checkDigit = 0;

		for(let i = 0; i< cardField.length-1; i++)
		{
			total += Number(cardField[i])*Number(checkingFactors[i]);
		}

		divide = total%11;
		checkDigit = 11-divide;
		
		if(checkDigit != Number(cardField[cardField.length-1]))
		{
			document.getElementById("invalidcard_error").style.display = "block";

			if(!errorFlag){
				document.getElementById("cardnumber").focus();
				document.getElementById("cardnumber").select();
			}

			errorFlag = true;
		}
	}
	//date check
	var today = new Date();
	var currentMonth = today.getMonth() + 1;
	var currentYear = today.getFullYear();
	var selectMonth = document.getElementById("month").value;
	var selectYear = document.getElementById("year").value;

	if(selectMonth == "- Month -")
	{
		document.getElementById("month_error").style.display = "block";

		if(!errorFlag){
			document.getElementById("month").focus();
			document.getElementById("month").select();
		}

		errorFlag = true;
	}

	if(selectYear < currentYear)
	{
		document.getElementById("expiry_error").style.display = "block";

		errorFlag = true;
	}
	else if(selectYear == currentYear)
	{
		if(selectMonth < currentMonth)
		{
			document.getElementById("expiry_error").style.display = "block";

			errorFlag = true;
		}
	}

	return errorFlag;
}

/*
 * Adds an item to the cart and hides the quantity and add button for the product being ordered.
 *
 * param itemNumber The number used in the id of the quantity, item and remove button elements.
 */
function addItemToCart(itemNumber){
	// Get the value of the quantity field for the add button that was clicked 
	let quantityValue = trim(document.getElementById("qty" + itemNumber).value);

	// Determine if the quantity value is valid
	if ( !isNaN(quantityValue) && quantityValue != "" && quantityValue != null && quantityValue != 0 && !document.getElementById("cartItem" + itemNumber) ){
		// Hide the parent of the quantity field being evaluated
		document.getElementById("qty" + itemNumber).parentNode.style.visibility = "hidden";

		// Determine if there are no items in the car
		if ( numberOfItemsInCart == 0 ){
			// Hide the no items in cart list item 
			document.getElementById("noItems").style.display = "none";
		}

		// Create the image for the cart item
		let cartItemImage = document.createElement("img");
		cartItemImage.src = "images/" + itemImage[itemNumber - 1];
		cartItemImage.alt = itemDescription[itemNumber - 1];

		// Create the span element containing the item description
		let cartItemDescription = document.createElement("span");
		cartItemDescription.innerHTML = itemDescription[itemNumber - 1];

		// Create the span element containing the quanitity to order
		let cartItemQuanity = document.createElement("span");
		cartItemQuanity.innerHTML = quantityValue;

		// Calculate the subtotal of the item ordered
		let itemTotal = quantityValue * itemPrice[itemNumber - 1];

		// Create the span element containing the subtotal of the item ordered
		let cartItemTotal = document.createElement("span");
		cartItemTotal.innerHTML = formatCurrency(itemTotal);

		// Create the remove button for the cart item
		let cartItemRemoveButton = document.createElement("button");
		cartItemRemoveButton.setAttribute("id", "removeItem" + itemNumber);
		cartItemRemoveButton.setAttribute("type", "button");
		cartItemRemoveButton.innerHTML = "Remove";
		cartItemRemoveButton.addEventListener("click",
			// Annonymous function for the click event of a cart item remove button
			function(){
				// Removes the buttons grandparent (li) from the cart list
				this.parentNode.parentNode.removeChild(this.parentNode);

				// Deteremine the quantity field id for the item being removed from the cart by
				// getting the number at the end of the remove button's id
				let itemQuantityFieldId = "qty" + this.id.charAt(this.id.length - 1);

				// Get a reference to quanitity field of the item being removed form the cart
				let itemQuantityField = document.getElementById(itemQuantityFieldId);
				
				// Set the visibility of the quantity field's parent (div) to visible
				itemQuantityField.parentNode.style.visibility = "visible";

				// Initialize the quantity field value
				itemQuantityField.value = "";

				// Decrement the number of items in the cart
				numberOfItemsInCart--;

				// Decrement the order total
				orderTotal -= itemTotal;

				// Update the total purchase in the cart
				document.getElementById("cartTotal").innerHTML = formatCurrency(orderTotal);

				// Determine if there are no items in the car
				if ( numberOfItemsInCart == 0 ){
					// Show the no items in cart list item 
					document.getElementById("noItems").style.display = "block";
				}				
			},
			false
		);

		// Create a div used to clear the floats
		let cartClearDiv = document.createElement("div");
		cartClearDiv.setAttribute("class", "clear");

		// Create the paragraph which contains the cart item summary elements
		let cartItemParagraph = document.createElement("p");
		cartItemParagraph.appendChild(cartItemImage);
		cartItemParagraph.appendChild(cartItemDescription);
		cartItemParagraph.appendChild(document.createElement("br"));
		cartItemParagraph.appendChild(document.createTextNode("Quantity: "));
		cartItemParagraph.appendChild(cartItemQuanity);
		cartItemParagraph.appendChild(document.createElement("br"));
		cartItemParagraph.appendChild(document.createTextNode("Total: "));
		cartItemParagraph.appendChild(cartItemTotal);		

		// Create the cart list item and add the elements within it
		let cartItem = document.createElement("li");
		cartItem.setAttribute("id", "cartItem" + itemNumber);
		cartItem.appendChild(cartItemParagraph);
		cartItem.appendChild(cartItemRemoveButton);
		cartItem.appendChild(cartClearDiv);

		// Add the cart list item to the top of the list
		let cart = document.getElementById("cart");
		cart.insertBefore(cartItem, cart.childNodes[0]);

		// Increment the number of items in the cart
		numberOfItemsInCart++;

		// Increment the total purchase amount
		orderTotal += itemTotal;

		// Update the total puchase amount in the cart
		document.getElementById("cartTotal").innerHTML = formatCurrency(orderTotal);
	}		
}

/*
 * Hides all of the error elements.
 */
function hideErrors(){
	// Get an array of error elements
	let error = document.getElementsByClassName("error");

	// Loop through each element in the error array
	for ( let i = 0; i < error.length; i++ ){
		// Hide the error element by setting it's display style to "none"
		error[i].style.display = "none";
	}
}

/*
 * Handles the load event of the document.
 */
function load(){
	//	Populate the year select with up to date values
	let year = document.getElementById("year");
	let currentDate = new Date();
	for(let i = 0; i < 7; i++){
		let newYearOption = document.createElement("option");
		newYearOption.value = currentDate.getFullYear() + i;
		newYearOption.innerHTML = currentDate.getFullYear() + i;
		year.appendChild(newYearOption);
	}

	hideErrors();
	
	document.getElementById("orderform").addEventListener("submit", validate);
	document.getElementById("orderform").reset();
	document.getElementById("orderform").addEventListener("reset", resetForm);

	document.getElementById("addMac").addEventListener("click", 
		function(){
			addItemToCart("1");
		});
	document.getElementById("addMouse").addEventListener("click", 
		function(){
			addItemToCart("2");
		});
	document.getElementById("addWD").addEventListener("click", 
		function(){
			addItemToCart("3");
		});
	document.getElementById("addNexus").addEventListener("click", 
		function(){
			addItemToCart("4");
		});
	document.getElementById("addDrums").addEventListener("click", 
		function(){
			addItemToCart("5");
		});

}

// Add document load event listener
document.addEventListener("DOMContentLoaded", load);












