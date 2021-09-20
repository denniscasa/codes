<?php
	require('connect.php');

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
		<h1><a href="index.php">My Amazing Blog - Show Post</a></h1>
		</div> <!-- END div id="header" -->
	
	<ul id="menu">
		<li><a href="index.php">Home</a></li>
		<li><a href="create.php">New Post</a></li>
	</ul> <!-- END ul id="menu" -->
	<div id="all_blogs">
		<div class=blog_post>
			<h2><?=$row['title']?></h2>
			<p>
				<small>
					<?=$row['dateposted']?> <a href = "edit.php?id=<?=$row['id']?>">edit</a>
				</small>
			</p>
			<div class='blog content'>
				<?=substr($row['content'], 0, 75)?>
				<?=substr($row['content'], 75, -75)?>
			</div>
		</div>
	</div>
	<div id="footer">
		Copywrong 2021 - No Rights Reserved
	</div>
	</div> <!-- END div id="wrapper" -->
</body>
</html>