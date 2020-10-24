/**
 * DECLARACION DE CONSTANTES
 */
const botonPostProduct = document.getElementById("postProduct");
const botonGetProduct = document.getElementById("getProduct");
const botonUpdateProduct = document.getElementById("updateProduct");
const listado = document.getElementById("listar");
/**
 * 
 * FUNCION PARA LISTAR LOS PRODUCTOS RECIBIENDO UN JSON DE LA PETICION A BACKEND
 * @param {*} res 
 */
const listarProductos = (res) =>{

    let tabla = document.getElementById("productos");

    let cuerpoAntiguo = document.getElementById("cuerpo");

    let cuerpoTabla = document.createElement("tbody");
    cuerpoTabla.setAttribute("id","cuerpo");

    for(p of res){
        /**
         * CREACION DE LOS NUEVOS ELEMENTOS PARA AÑADIRLOS A LA TABLA
         */
        let fila = document.createElement("tr");
        let colid = document.createElement("td");
        let colnombre = document.createElement("td");
        let coldes = document.createElement("td");
        let colrent = document.createElement("td");
        let colcat = document.createElement("td");
        /**
         * OBTENIENDO INFORMACION DEL JSON
         */
        let idtext = document.createTextNode(p.id);
        let nombretext = document.createTextNode(p.name);
        let destext = document.createTextNode(p.description);
        let renttext = document.createTextNode(p.rent);
        let cattext = document.createTextNode(p.cat);

        colid.appendChild(idtext);
        colnombre.appendChild(nombretext);
        coldes.appendChild(destext);
        colrent.appendChild(renttext);
        colcat.appendChild(cattext);

        fila.appendChild(colid);
        fila.appendChild(colnombre);
        fila.appendChild(coldes);
        fila.appendChild(colrent);
        fila.appendChild(colcat);

        cuerpoTabla.appendChild(fila);
    }
    /**
     * REEMPLAZAMOS EL QUE YA TENEMOS EN EL HTML PARA QUE NO SE ACUMULEN OBJETOS REPETIDOS EN LA TABLA
     */
    tabla.replaceChild(cuerpoTabla,cuerpoAntiguo);
    }
/**
 * FUNCION QUE RELLENA LOS CAMPOS DEL FORMULARIO SEGUN EL ID INTRODUCIDO.
 * RECIBIENDO UN JSON CON EL OBJETO EN FORMATO JSON DESDE LA PETICION POR EL CAMPO ID. 
 * @param {*} res 
 */
const rellenarForm = (res) =>{
    let productname = document.getElementById("name");
    let productdescription = document.getElementById("description");
    let seleccionRent = document.getElementById("sub");
    let seleccionCat = document.getElementById("category");

    
        productname.value = res.name;
        productdescription.value = res.description;
        seleccionRent.value = res.rent;
        seleccionCat.value = res.cat;
    

}
/**
 * BOTON PARA REALIZAR LA PETICION POST AL BACKEND. RECOGE LOS CAMPOS DEL FORMULARIO Y LO PASAMOS A LA PETICION EN FORMATO JSON
 */
botonPostProduct.addEventListener("click", () =>{

    let productid = document.getElementById("id").value;
    let productname = document.getElementById("name").value;
    let productdescription = document.getElementById("description").value;
    let seleccionRent = document.getElementById("sub").value;
    let seleccionCat = document.getElementById("category").value;
    const product ={

        id: parseInt(productid,10),
        name: productname,
        description: productdescription,
        rent: seleccionRent,
        cat: seleccionCat
    }

    fetch('http://localhost:8080/jacalix/products', {
        method: 'POST',
        body: JSON.stringify(product),
        headers: {
            "Content-type": "application/json"
        }
        })
        .then(response => response.json())
        .then(json => console.log(json))
})
/**
 * BOTON PARA REALIZAR LA PETICION GET AL BACKEND. NOS DEVUELVE TODOS LOS RESULTADOS EN FORMATO JSON.
 */
botonGetProduct.addEventListener("click", () => {


    fetch('http://localhost:8080/jacalix/products')
    .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
    .then(res => res.json())
    .then(res => listarProductos(res))
    //.then(res => console.log(res))
    .catch(err => console.log(err))
        
    
})
/**
 * BOTON PARA REALIZAR LA PETICION GET POR EL CAMPO ID AL BACKEND. NOS DEVUELVE UN RESULTADO EN FORMATO JSON.
 */
botonUpdateProduct.addEventListener("click", () =>{

    let productid = document.getElementById("id").value;

    fetch('http://localhost:8080/jacalix/products/?id='+parseInt(productid,10))
    .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
    .then(res => res.json())
    .then(res => rellenarForm(res))
})