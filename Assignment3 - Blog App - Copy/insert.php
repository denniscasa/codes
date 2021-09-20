<?php
	require('connect.php');

	$errorMessage = "";

	if (($_POST && !empty($_POST['title'])) && ($_POST && !empty($_POST['content'])) && $_POST['command'] == 'Create')
	{
		//Sanitize input
		$title = filter_input(INPUT_POST, 'title', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
		$content = filter_input(INPUT_POST, 'content', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
		$dateposted = date('Y-m-d H:i:s');
		

		//Build query
		$query = "INSERT INTO blogpost (title, content, dateposted) VALUES (:title, :content, :dateposted)";
		$statement = $db->prepare($query);

		//Bind values to parameters
		$statement->bindValue(':title', $title);
		$statement->bindValue(':content', $content);
		$statement->bindValue(':dateposted', $dateposted);

		//execute insert. move back to index.php if no errors.
		//If there are errors, display it
		$statement->execute();
        header('Location: index.php');
        exit();
	}
	else if (($_POST && !empty($_POST['title'])) && ($_POST && !empty($_POST['content'])) && $_POST['command'] == 'Update')
	{
		$id = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_NUMBER_INT);
		$title = filter_input(INPUT_POST, 'title', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
		$content = filter_input(INPUT_POST, 'content', FILTER_SANITIZE_FULL_SPECIAL_CHARS);
		$dateposted = date('Y-m-d H:i:s');


		$query = "UPDATE blogpost SET title = :title, content = :content, dateposted = :dateposted WHERE id = :id";
		$statement = $db->prepare($query);
		$statement->bindValue(':title', $title);
		$statement->bindValue(':content', $content);
		$statement->bindValue(':dateposted', $dateposted);
  	    $statement->bindValue(':id', $id, PDO::PARAM_INT);

        $statement->execute();
        header('Location: index.php');
        exit();
	}
	else if (($_POST && !empty($_POST['title'])) && ($_POST && !empty($_POST['content'])) && $_POST['command'] == 'Delete')
	{
		
		$query = "DELETE FROM blogpost WHERE id = :id";
		$statement = $db->prepare($query);
		$id = filter_input(INPUT_POST, 'id', FILTER_SANITIZE_NUMBER_INT);

		$statement->bindValue(':id', $id, PDO::PARAM_INT);
		$statement->execute();
		header('Location: index.php');
        exit();
	}
	else
	{
		if (($_POST && empty($_POST['title'])) && ($_POST && empty($_POST['content'])))
		{
			$errorMessage = "Both the title and content must be at least one character.";
		}
		else if (($_POST && empty($_POST['title'])) && ($_POST && !empty($_POST['content'])))
		{
			$errorMessage = "Title must have at least one character.";
		}
		else
		{
			$errorMessage = "Content must have at least one character.";
		}
	}

?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>My Blog - Error</title>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1><a href="index.php"></a></h1>
		</div>
		<h1>An error occurred while processing your post.</h1>
		<p><?=$errorMessage?></p>
		<a href="index.php">Return Home</a>
		<div id="footer">
			Copywrong 2021 - No Rights Reserved
		</div>
	</div>
</body>
</html>