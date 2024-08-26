window.addEventListener("load", function () {

    document.querySelectorAll('.gestion').forEach(function (element) {
        element.addEventListener('mouseover', function () {
            this.classList.add('active');
        });

        element.addEventListener('mouseout', function () {
            this.classList.remove('active');
        });
    });

    logicaAgregarOdontologo();

});


//funciones
    function formAgregarOdontologo(){
        document.querySelector('main').innerHTML = `
                <div class="card">
                    <h1>Agregar Odontólogo</h1>
                    <form id="agregar-odontologo-form">
                        <div>
                            <label for="apellido">Apellido:</label>
                            <input type="text" id="apellido" name="apellido" required>
                        </div>
                        <div>
                            <label for="nombre">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" required>
                        </div>
                        <div>
                            <label for="matricula">Matrícula:</label>
                            <input type="text" id="matricula" name="matricula" required>
                        </div>
                        <div>
                            <button type="submit">Agregar</button>
                        </div>
                    </form>
                    <div id="response" style="display:none; margin-top:10px"></div>
                </div>
            `;
    }

    function formAgregarPaciente(){
        document.querySelector('main').innerHTML = `
                <div class="card">
                    <h1>Agregar Paciente</h1>
                    <form id="agregar-paciente-form">
                        <div>
                            <label for="nombre">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" required>
                        </div>
                        <div>
                            <label for="apellido">Apellido:</label>
                            <input type="text" id="apellido" name="apellido" required>
                        </div>
                        <div>
                            <label for="domicilio">Domicilio:</label>
                            <input type="text" id="domicilio" name="domicilio" required>
                        </div>
                        <div>
                            <label for="dni">DNI:</label>
                            <input type="text" id="dni" name="dni" required>
                        </div>
                        <div>
                            <label for="fecha-alta">Fecha de Alta:</label>
                            <input type="date" id="fecha-alta" name="fecha-alta" required>
                        </div>
                        <div>
                            <button type="submit">Agregar</button>
                        </div>
                    </form>
                </div>
            `;

    }

    function logicaAgregarOdontologo(){
    document.getElementById('agregar-odontologo').addEventListener('click', function () {
            formAgregarOdontologo();

            document.getElementById("agregar-odontologo-form").onsubmit = function (e) {
                e.preventDefault();
                agregarOdontologo();
            };

            function agregarOdontologo() {
                const formData = {
                    nombre: document.querySelector('#nombre').value,
                    apellido: document.querySelector('#apellido').value,
                    matricula: document.querySelector('#matricula').value,
                };

                const url = '/odontologos';
                const settings = {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(formData)
                }

                fetch(url, settings)
                        .then(response => response.json())
                        .then(data => {
                            let successAlert = '<div class="alert alert-success alert-dismissible" style="background:rgba(0, 255, 0, 0.2);padding:.5em 1em;color: green; margin: .5em 0; padding: 10px; border-radius: 5px;">' +
                                    '<p>Odontólogo agregado</p></div>';

                            document.querySelector('#response').innerHTML = successAlert;
                            document.querySelector('#response').style.display = "block";
                            resetUploadForm();

                            setTimeout(() => {
                                document.querySelector('#response').style.display = "none";
                            }, 4000);
                        })
                        .catch(error => {
                            let errorAlert = '<div class="alert alert-danger alert-dismissible" style="background:rgba(255, 0, 0, 0.2);padding:.5em 1em;color: red;margin: .5em 0">' +
                                '<p>Error, intente nuevamente</p></div>';

                            document.querySelector('#response').innerHTML = errorAlert;
                            document.querySelector('#response').style.display = "block";
                            resetUploadForm();

                            // Ocultar el mensaje después de 3 segundos
                            setTimeout(() => {
                                document.querySelector('#response').style.display = "none";
                            }, 4000);
                        });
            }

            function resetUploadForm() {
                document.querySelector('#nombre').value = "";
                document.querySelector('#apellido').value = "";
                document.querySelector('#matricula').value = "";
            }
        });
    }
