function enviar(){
//Validación: nombre
    if (nombre.value === ''){
        alert("¡Tiene que introducir un nombre!");
        return;
    }

//Validación: apellido 
    if (apellido.value === ''){
        alert("¡Tiene que introducir un apellido!");
        return;
    }
//Validación: nombre usuario
    if (nombreUsuario.value === ''){
        alert("¡Tiene que introducir un nombre de usuario!");
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

