<?php

	$total = 0;
	$quantities = ["qty1" => ["desc" => "Macbook", "price" => 1899.99], "qty2" => ["desc" => "The Razer", "price" => 79.99], "qty3" => ["desc" => "WD My Passport", "price" => 179.99], "qty4" => ["desc" => "Nexus 7", "price" => 249.99], "qty5" => ["desc" =>"DD-45 Drums", "price" => 119.99]];

	if(isset($_POST['fullname'])){
		$content = "Thank you for your order {$_POST['fullname']}.";
	}	

	function filterinput(){
		$minMonth = 1;
		$maxMonth = 12;
		$minQty = 0;
		$minYear = 2021;
		$maxYear = 2026;
		$cardType = false;
		$cardTypes = ["VISA", "AmEx", "MasterCard"];
		$provinces = ["AB", "BC", "MB", "NB", "NL", "NS", "ON", "PE", "QC", "SK", "NT", "NU", "YT"];
		$provinceValid = false;
		$infoFilled = true;

		//validate input
		$emailValid = filter_input(INPUT_POST, 'email' , FILTER_VALIDATE_REGEXP, array("options"=>array("regexp"=>"/^\w+@[a-zA-Z_]+?\.[a-zA-Z_]{2,3}$/"))) ;
		$postalValid = filter_input(INPUT_POST, 'postal' , FILTER_VALIDATE_REGEXP, array("options"=>array("regexp"=>"/^[ABCEGHJKLMNPRSTVXYabceghj-nprstvxy]\d[ABCEGHJKLMNPRSTVWXYZabceghj-nprstv-z][ -]?\d[ABCEGHJKLMNPRSTVWXYZabceghj-nprstv-z]\d$/"))) ;
		$credNumberValid = filter_input(INPUT_POST, 'cardnumber' , FILTER_VALIDATE_REGEXP, array("options"=>array("regexp"=>"/^\d{10}$/"))) &&
			filter_input(INPUT_POST, 'cardnumber' , FILTER_VALIDATE_INT);
		$monthValid = filter_input(INPUT_POST, 'month' , FILTER_VALIDATE_INT, array("options"=>array("min_range"=>$minMonth, "max_range"=>$maxMonth))) ;
		$yearValid = filter_input(INPUT_POST, 'year' , FILTER_VALIDATE_INT, array("options"=>array("min_range"=>$minYear, "max_range"=>$maxYear))) ;

		//validate quantities
		$qty1Valid = filter_input(INPUT_POST, 'qty1' , FILTER_VALIDATE_INT, array("options"=>array("min_range"=>$minQty)));
		$qty2Valid = filter_input(INPUT_POST, 'qty2' , FILTER_VALIDATE_INT, array("options"=>array("min_range"=>$minQty)));
		$qty3Valid = filter_input(INPUT_POST, 'qty3' , FILTER_VALIDATE_INT, array("options"=>array("min_range"=>$minQty)));
		$qty4Valid = filter_input(INPUT_POST, 'qty4' , FILTER_VALIDATE_INT, array("options"=>array("min_range"=>$minQty)));
		$qty5Valid = filter_input(INPUT_POST, 'qty5' , FILTER_VALIDATE_INT, array("options"=>array("min_range"=>$minQty)));

		if(empty($_POST['qty1']))
			$qty1Valid = true;
		if(empty($_POST['qty2']))
			$qty2Valid = true;
		if(empty($_POST['qty3']))
			$qty3Valid = true;
		if(empty($_POST['qty4']))
			$qty4Valid = true;
		if(empty($_POST['qty5']))
			$qty5Valid = true;

		//validate cardType
		foreach($cardTypes as $cards)
		{
			if(strcasecmp($cards, $_POST['cardType']) == 0)
			{
				$cardType = true;
			}
		}

		//fullname, card name, address, and city filled
		if(empty($_POST['fullname']) || empty($_POST['cardname']) || empty($_POST['address']) || empty($_POST['city']))
		{
			$infoFilled = false;
		}

		//validate province
		foreach($provinces as $province)
		{
			if(strcasecmp($province, $_POST['province']) == 0)
			{
				$provinceValid = true;
			}
		}

		$errorFlag = ($emailValid && $postalValid && $credNumberValid
		 	 	      && $monthValid && $yearValid && $cardType && $infoFilled && $provinceValid && $qty1Valid && $qty2Valid && $qty3Valid && $qty4Valid && $qty5Valid);

		return $errorFlag;
	}
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Thank you for your submission</title>
	<link rel="stylesheet" type="text/css" href="a2formstyles.css">
</head>
<body>
	<div id="wrapper">
		<?php if(filterinput()): ?>
		<h4><?= $content ?></h4>
		<h4>Here's a summary of your order:</h4>

		<h5>Address Information</h5>
		<table>
			<tr>
				<td>Address:</td>
				<td><?= $_POST['address'] ?></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><?= $_POST['city'] ?></td>
			</tr>
			<tr>
				<td>Province:</td>
				<td><?= $_POST['province'] ?></td>
			</tr>
			<tr>
				<td>Postal Code:</td>
				<td><?= $_POST['postal'] ?></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><?= $_POST['email'] ?></td>
			</tr>
		</table>

		<h5>Order Information</h5>
		<table>
				<tr>
					<th>Quantity</th>
					<th>Description</th>
					<th>Cost</th>
					<th>Total</th>
				</tr>
				<?php foreach($quantities as $quantity => $info): ?>
				<?php if($_POST[$quantity] > 0): ?>
				<tr>
					<td><?= $_POST[$quantity] ?></td>
					<td><?=$info['desc']?></td>
					<td><?=$info['price'] * $_POST[$quantity]?></td>
					<td></td>
				</tr>
				<?php $total+=$info['price'] * $_POST[$quantity]?>
				<?php endif?>
				<?php endforeach ?>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td>$<?=$total?></td>
				</tr>
		</table>
		<?php else: ?>
			<h4>Form could not be processed.</h4>
		<?php endif ?>

	</div>
</body>
</html>

















