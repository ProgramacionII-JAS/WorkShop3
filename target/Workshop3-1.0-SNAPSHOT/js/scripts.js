fetch("hello-servlet",{
    method:"POST"
})
    .then(response => response.json())
    .then(data => console.log(data))