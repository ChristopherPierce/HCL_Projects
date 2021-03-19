let populateFeedbackTable = () => {
	document.addEventListener("DOMContentLoaded", function(event) { 
		fetch('http://localhost:8090/feedback')
		  .then(response => {
				return response.text().then(text => {
					text = JSON.parse(text);
					console.log(text);
					let table = document.querySelector("table");
					generateTableHead(table, Object.keys(text[0]));
					generateTable(table, text);
				});
		  }).catch(error => {});
	});
};

populateFeedbackTable();

function generateTableHead(table, data) {
  let thead = table.createTHead();
  let row = thead.insertRow();
  for (let key of data) {
    let th = document.createElement("th");
    let text = document.createTextNode(key);
    th.appendChild(text);
    row.appendChild(th);
  }
}

function generateTable(table, data) {
  for (let element of data) {
    let row = table.insertRow();
    for (key in element) {
      let cell = row.insertCell();
      let text = document.createTextNode(element[key]);
      cell.appendChild(text);
    }
  }
}
