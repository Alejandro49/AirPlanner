function enviar(){
//Validación: nombre
    if (nombre.value === ''){
        alert("¡Tiene que introducir un nombre!");
        return;
    }

//Validación: apellidos 
    if (apellido_1.value === ''){
        alert("¡Tiene que introducir su 1º apellido!");
        return;
    }
    if (apellido_2.value === ''){
        alert("¡Tiene que introducir su 2º apellido!");
        return;
    }
//Validación: nombre usuario
    if (nombreUsuario.value === ''){
        alert("¡Tiene que introducir un nombre de usuario!");
        return;
    }
//Validación: nacionalidad 
    if (nacionalidad.value === ''){
        alert("¡Tiene que introducir su nacionalidad!");
        return;
    }
//Validación: Fecha de nacimiento
    if (fecha.value === ''){
        alert("¡Tiene que introducir su fecha de nacimiento!");
        return;
    }
//Validación: DNI
    let estructuraDNI = /^[0-9]{8}[A-Za-z]$/;  
    if (dni.value === ''){
        alert("¡Tiene que introducir SU DNI!");
        return;
    }else if(!estructuraDNI.test(dni.value)){
        alert("Su DNI no es valido")
        return;
    }
//email con formato válido
    let estructuraCorreo = /^(.+\@.+\..+)$/;
    if (email.value === ''){
        alert("¡Tiene que introducir un correo!");
        return;
    }else if (!estructuraCorreo.test(email.value)){
        alert("El correo introducido no es válido");
        return;
    }
//solo números, sin espacios
    let estructuraNumeros = /^[0-9]{9,}$/;  
    if (telefono.value === ''){
        alert("¡Tiene que introducir un teléfono!");
        return;
    }else if (!estructuraNumeros.test(telefono.value)){
        alert("El teléfono introducido no es válido");
        return;
    }
//Contraseña con al menos 8 caracteres, al menos una mayúscula, una minúscula y un número
    let estructuraContraseña = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(.+){8,}$/;  
    if (contraseña.value === ''){
        alert("¡Tiene que introducir una contraseña!");
        return;
    }else if (!estructuraContraseña.test(contraseña.value)){
        alert("La contraseña introducida no es válida, es necesario que tenga 8 caracteres: al menos 1 mayúscula, 1 minúscula y 1 número");
        return;
    }
}

