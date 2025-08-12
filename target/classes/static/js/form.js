document.getElementById("contact-form").addEventListener("submit", function (e) {
  e.preventDefault();

  const formData = {
    name: document.getElementById("full-name").value,
    phone: document.getElementById("phone").value,
    email: document.getElementById("email").value,
    proyectNumber: document.getElementById("order-number").value,
    reason: document.getElementById("dropdownOptions").value,
    message: document.getElementById("message").value
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