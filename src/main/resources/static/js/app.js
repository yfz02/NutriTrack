const listaUsuarios = document.getElementById('listaUsuarios');

function agregarUsuario(nombre, calorias) {
    // Crear el contenedor del usuario
    const userDiv = document.createElement('div');
    userDiv.style.border = '1px solid #999';
    userDiv.style.marginBottom = '8px';
    userDiv.style.padding = '8px';
    userDiv.style.display = 'flex';
    userDiv.style.justifyContent = 'space-between';
    userDiv.style.alignItems = 'center';

    // Crear el texto con nombre y calorías
    const texto = document.createElement('span');
    texto.textContent = `${nombre} - Calorías: ${calorias}`;

    // Crear el botón eliminar
    const btnEliminar = document.createElement('button');
    btnEliminar.textContent = 'Eliminar';
    btnEliminar.style.background = '#e74c3c';
    btnEliminar.style.color = 'white';
    btnEliminar.style.border = 'none';
    btnEliminar.style.padding = '4px 8px';
    btnEliminar.style.cursor = 'pointer';

    btnEliminar.onclick = () => {
        // Aquí podrías hacer llamada a backend para eliminar si tienes endpoint
        listaUsuarios.removeChild(userDiv);
    };

    userDiv.appendChild(texto);
    userDiv.appendChild(btnEliminar);

    listaUsuarios.appendChild(userDiv);
}

document.getElementById('form').addEventListener('submit', async function (e) {
    e.preventDefault();
    const formData = new FormData(this);
    const data = Object.fromEntries(formData.entries());
    data.peso = parseFloat(data.peso);

    const res = await fetch('http://localhost:8080/api/v1/saveuser', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    });

    const result = await res.json();
    //alert(`Usuario guardado: ${result.nombre}, Calorías: ${result.calorias}`);


    agregarUsuario(result.nombre, result.calorias);


    this.reset();
});