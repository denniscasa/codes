<?php
	require('connect.php');

	$query = "SELECT * FROM blogpost ORDER BY dateposted DESC";

	$statement = $db->prepare($query);

	$statement->execute();
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
		<h1><a href="index.php">My Amazing Blog</a></h1>
		</div> <!-- END div id="header" -->
	
	<ul id="menu">
		<li><a href="index.php" class='active'>Home</a></li>
		<li><a href="create.php">New Post</a></li>
	</ul> <!-- END ul id="menu" -->
	<div id="all_blogs">
		<?php while($row = $statement->fetch()): ?>
			<div class="blog_post">
				<h2><a href = "show.php?id=<?=$row['id']?>"><?=$row['title']?></a></h2>
				<p>
					<small>
						<?=date('F d,Y  h:i A', strtotime($row['dateposted']))?> <a href = "edit.php?id=<?=$row['id']?>">edit</a>
					</small>
				</p>
				<div class="blog_content">
					<?php if (strlen($row['content']) < 200):?>
						<?=$row['content']?>
					<?php else: ?>
						<?=substr($row['content'], 0, 75) . (strlen($row['content']) > 200 ? "..." : '')?>
						<a href = "show.php?id=<?=$row['id']?>">Read more</a>
					<?php endif?>
				</div>
			</div>
		<?php endwhile ?>
	</div>
	<div id="footer">
		Copywrong 2021 - No Rights Reserved
	</div>
	</div> <!-- END div id="wrapper" -->
</body>
</html>