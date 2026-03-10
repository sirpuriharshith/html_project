let rockets=[

{
name:"Saturn V",
agency:"NASA",
year:1967,
payload:140000,
image:"images/rockets/saturn-v.jpg"
},

{
name:"Space Shuttle",
agency:"NASA",
year:1981,
payload:27500,
image:"images/rockets/space-shuttle.jpg"
},

{
name:"SLS",
agency:"NASA",
year:2022,
payload:95000,
image:"images/rockets/sls.jpg"
},

{
name:"PSLV",
agency:"ISRO",
year:1993,
payload:3800,
image:"images/rockets/pslv.jpg"
},

{
name:"GSLV",
agency:"ISRO",
year:2001,
payload:5000,
image:"images/rockets/gslv.jpg"
},

{
name:"LVM3",
agency:"ISRO",
year:2014,
payload:10000,
image:"images/rockets/lvm3.webp"
},

{
name:"Falcon 1",
agency:"SpaceX",
year:2006,
payload:670,
image:"images/rockets/falcon1.jpg"
},

{
name:"Falcon 9",
agency:"SpaceX",
year:2010,
payload:22800,
image:"images/rockets/falcon9.jpg"
},

{
name:"Falcon Heavy",
agency:"SpaceX",
year:2018,
payload:63800,
image:"images/rockets/falcon-heavy.jpg"
},

{
name:"Starship",
agency:"SpaceX",
year:2023,
payload:150000,
image:"images/rockets/starship.jpg"
}

]

function displayRockets(data){

let container=document.getElementById("rocketContainer")

if(!container) return

container.innerHTML=""

for(let r of data){

let card=`

<div class="card">

<img src="${r.image}">

<h3>${r.name}</h3>

<p>Agency: ${r.agency}</p>

<p>First Launch: ${r.year}</p>

<p>Payload: ${r.payload} kg</p>

</div>

`

container.innerHTML+=card

}

}

window.onload=function(){

displayRockets(rockets)

}

function searchRocket(){

let key=document.getElementById("searchBox").value.toLowerCase()

let result=rockets.filter(r=>r.name.toLowerCase().includes(key))

displayRockets(result)

}

function sortPayload(){

rockets.sort((a,b)=>a.payload-b.payload)

displayRockets(rockets)

}