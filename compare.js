function loadDropdown(){

let r1=document.getElementById("rocket1")
let r2=document.getElementById("rocket2")

for(let r of rockets){

let option=`<option>${r.name}</option>`

r1.innerHTML+=option
r2.innerHTML+=option

}

}

window.onload=loadDropdown

function compare(){

let name1=document.getElementById("rocket1").value
let name2=document.getElementById("rocket2").value

let rocketA=rockets.find(r=>r.name===name1)
let rocketB=rockets.find(r=>r.name===name2)

let result=`

<table border="1">

<tr>
<th>Feature</th>
<th>${rocketA.name}</th>
<th>${rocketB.name}</th>
</tr>

<tr>
<td>Agency</td>
<td>${rocketA.agency}</td>
<td>${rocketB.agency}</td>
</tr>

<tr>
<td>First Launch</td>
<td>${rocketA.year}</td>
<td>${rocketB.year}</td>
</tr>

<tr>
<td>Payload</td>
<td>${rocketA.payload}</td>
<td>${rocketB.payload}</td>
</tr>

</table>

`

document.getElementById("result").innerHTML=result

}