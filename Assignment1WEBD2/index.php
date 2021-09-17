<!-----------------

    Assignment 1
    Name: Dennis Casaclang
    Date: September 5, 2021
    Description: Intro to PHP

------------------>

<?php
	$config = [
	   'gallery_name' => 'Animals & Nature Gallery',
	   'unsplash_categories' => ['Cat','Dog','Owl','Turtle'],
	   'local_images' => [
	   	'Tim Swaan'=> ['site' => 'https://unsplash.com/@timswaanphotography', 'link' => 'images/nature_bridge.jfif'],
	   	'Andreas Gücklhorn' => ['site' =>'https://unsplash.com/@draufsicht', 'link' => 'images/forest_coastline.jfif'] ,
	   	'Kalen Emsley' => ['site' =>
	   	'https://unsplash.com/@kalenemsley', 'link' => 'images/valley.jfif'],
	   	'Damian Markutt' => ['site' =>'https://unsplash.com/@wildandfree_photography', 'link' => 'images/sunrise.jfif']]
	 ];

?>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title><?= $config['gallery_name'] ?></title>
	<link href="https://fonts.googleapis.com/css?family=Alegreya" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
	<!-- Name of gallery -->
	<h1><?= $config['gallery_name'] ?></h1> 
	
	<!-- Random Images -->
	<div id="gallery">
		<?php foreach ($config['unsplash_categories'] as $categories): ?>
		<div>
		<h2><?= $categories ?></h2>
		<img src=<?="https://source.unsplash.com/300x200/?". $categories?>>
		</div>
		<?php endforeach ?>
	</div>

	<!-- 4 Large Images -->
	<h1><?= count($config['local_images']) . " Large Images"?></h1>
	<div id="large-images">
		<?php foreach ($config['local_images'] as $name => $images): ?>
		<img src=<?=$images['link']?>, alt=<?=$name?>>
		<h3 class = "photographer">
			<a href=<?=$images['site']?>><?=$name?></a>
		</h3>
		<?php endforeach ?>
	</div>
</body>
</html>