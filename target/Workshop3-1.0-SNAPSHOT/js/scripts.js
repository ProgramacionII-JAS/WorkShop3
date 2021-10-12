var rowId = 0;
var table;
let tr;
document.getElementById("btnMostrar").onclick = function (){
        fetch("img-servlet")
            .then(response => response.json())
            .then(data => {
                    rowId += 1;
                    data.map((element) =>{
                            console.log(data)
                            rowId += 1;
                            table = document.getElementById("body-table")
                            tr = document.createElement("tr");
                            tr.setAttribute("id", "row" + rowId);
                            let tdPetName = document.createElement("td");
                            let tdMail = document.createElement("td");
                            let tdDate = document.createElement("td");
                            let tdImage = document.createElement("img");
                            tdPetName.innerHTML = element.petName;
                            tdMail.innerHTML = element.correo;
                            tdDate.innerHTML = element.dateR;

                            tdImage.setAttribute("src", "charged_img/"+element.urlImg)
                            tdImage.setAttribute("width", "150px")

                            tr.appendChild(tdPetName);
                            tr.appendChild(tdMail);
                            tr.appendChild(tdDate);
                            tr.appendChild(tdImage);
                            table.appendChild(tr);
                    });
            });
}