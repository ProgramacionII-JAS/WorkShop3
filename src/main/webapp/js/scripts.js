fetch("img-servlet")
    .then(response => response.json())
    .then(data => console.log(data))