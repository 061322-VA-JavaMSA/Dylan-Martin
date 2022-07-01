// document.getElementById('getData').onclick = getData;
document.getElementById('getData').addEventListener("click", getData);

/*
    - When button is clicked, send http request to API for a specific id
    - get the id value from input box
    - send request to PokeAPI
        - Method: GET
        - Headers: None
        - Body: None
        - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
    - might have to convert JSON to JS object
    - populate the data in Section
*/
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

async function getData() {
    console.log('Button was clicked!');
    let id = document.getElementById('data-input').value;
    console.log(`id = ${id}`);

    let httpResponse = await fetch(`${baseApiURL}/${id}`);

    if (httpResponse.status >= 200 && httpResponse.status < 300) {
        let data = await httpResponse.json();

        populateData(data);

    } else {
        console.log('Invalid request.');
    }
}

function populateData(response) {

    var tr = document.createElement('tr');
    tr.innerHTML = "<td>" + response.id + "</td>";
    tr.innerHTML += "<td>" + response.name + "</td>";
    tr.innerHTML += "<td> <img src = " + response.sprites.front_default + "></td>";
    tr.innerHTML += "<td> <img src = " + response.sprites.front_shiny + "></td>";
    document.getElementById('pokemon-table').appendChild(tr);
}