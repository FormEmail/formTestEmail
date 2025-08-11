document.getElementById("contactForm").addEventListener("submit", function (e) {
  e.preventDefault();

  const formData = {
    nombre: document.getElementById("nombre").value,
    email: document.getElementById("email").value,
    mensaje: document.getElementById("mensaje").value
  };

  fetch("/api/contacto", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(formData)
  })
    .then(response => {
      if (response.ok) {
        alert("Formulario enviado correctamente");
        document.getElementById("contactForm").reset();
      } else {
        alert("Error al enviar el formulario");
      }
    })
    .catch(error => {
      console.error("Error:", error);
    });
});