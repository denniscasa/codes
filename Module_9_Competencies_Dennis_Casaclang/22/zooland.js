/*******w***********

    Competency 22
    Name: Dennis Casaclang
    Date: March 30, 2021
    Description: Competency 22

*******************/
 
//adds an event listener to execute onLoad method when page finished loading
document.addEventListener("DOMContentLoaded", load);

/*
	createZooland function
	This function will retrieve the data for the animal you created specifically
	You will then add the code required to meet the specifications
 */
function createZooland(zoolandData) {
    let content = document.getElementById("content");
    let h2 = document.createElement("h2");
    let h3 = document.createElement("h3");
    let blockquote = document.createElement("blockquote");

    for(let i=0; i<zoolandData.length; i++)
    {
        if(zoolandData[i].common_name == "Philippine Tarsier")
        {
            h2.innerHTML = `${zoolandData[i].common_name}`;
            h3.innerHTML = `${zoolandData[i].scientific_name}`;
            blockquote.innerHTML = `${zoolandData[i].description}`;
            content.appendChild(h2);
            content.appendChild(h3);
            content.appendChild(blockquote);

            for(let j=0; j<zoolandData[i].images.image.length; j++)
            {
                var img = document.createElement("img");
                let values = Object.values(zoolandData[i].images.image);
                img.src = "images/" + values[j];
                content.appendChild(img);
            }
        }
    }
}

/*
	load function
  	loading the json file - run when the page loads
 */
function load() {


    fetch('zooland.json')
        .then(function(result){
            return result.json();
        })
        .then(function(data){
            createZooland(data);
        });
}

