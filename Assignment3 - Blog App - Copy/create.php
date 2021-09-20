<?php
	require('connect.php');
	require('authenticate.php');
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
		<h1><a href="index.php">My Amazing Blog - New Post</a></h1>
		</div> <!-- END div id="header" -->
	
	<ul id="menu">
		<li><a href="index.php">Home</a></li>
		<li><a href="create.php" class="active">New Post</a></li>
	</ul> <!-- END ul id="menu" -->
	<div id="all_blogs">
		<form method="post" action="insert.php">
			<fieldset>
				<legend>New Blog Post</legend>
				<p>
					<label for="title">Title</label>
					<input name="title" id="title"/>
				</p>
				<p>
					<label for="content">Content</label>
					<textarea name="content" id="content"></textarea>
				</p>
				<p>
					<input type="submit" name="command" value="Create" />
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