<?php
	require('connect.php');
	require('authenticate.php');

	$query = "SELECT * FROM blogpost WHERE id = :id LIMIT 1";
	$statement = $db->prepare($query);

	$id = filter_input(INPUT_GET, 'id', FILTER_SANITIZE_NUMBER_INT);

	$statement->bindValue('id', $id, PDO::PARAM_INT);
	$statement->execute();

	$row = $statement->fetch();
?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>My Blog - Home Page</title>
	<link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
		<h1><a href="index.php">My Amazing Blog - Edit Post</a></h1>
		</div> <!-- END div id="header" -->
	
	<ul id="menu">
		<li><a href="index.php">Home</a></li>
		<li><a href="create.php">New Post</a></li>
	</ul> <!-- END ul id="menu" -->
	<div id="all_blogs">
		<form action="insert.php" method="post">
			<fieldset>
				<legend>Edit Blog Post</legend>
				<p>
					<label for="title">Title</label>
					<input name="title" id="title" 
					value="<?=$row['title']?>"/>
				</p>
				<p>
					<label for="content">Content</label>
					<textarea name="content" id="content"><?=$row['content']?></textarea>
				</p>
				<p>
					<input type="hidden" name="id" value=<?=$row['id']?> />
					<input type="submit" name="command" value="Update" />
					<input type="submit" name="command" value="Delete" onclick="return confirm('Are you sure you wish to delete this post?')" />
				</p>
			</fieldset>
		</form>
	</div>
	<div id="footer">
		Copywrong 2021 - No Rights Reserved
	</div>
	</div> <!-- END div id="wrapper" -->
</body>
</html>