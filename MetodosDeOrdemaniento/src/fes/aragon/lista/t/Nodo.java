package fes.aragon.lista.t;

/**
 * Esta clase sirve para poder generar un Nodo, el cual es indispensable para poder trabajar en una Lista Simple.
 *@author Julio Cesar Morales sierra
 * @version  15/10/2019/0.2
 * @param <T> Sirve para que sea una lista de tipo genérica, es decir, que el usuario pueda ingresar el tipo de dato que el requiera.
 */
public class Nodo<T> {

private T dato;
private Nodo<T> siguiente; // Cuando se mete el valor en "T", le vas a indicar que tipo de dato es.

/**
* En el constructor se indica que los Nodos tienen dos atributos, los cuales son: dato y siguiente.
* @param dato: Este es un dato de tipo generico, es decir, el usuario puede definir de que tipo de dato es posteriormente.
*/
public Nodo(T dato) {
super();
this.dato = dato;
this.siguiente = null;
}
/**
 * Metodo de tipo boolean comparar menor sirve para comparar distintos tipos de datos, como los
 * integer,float, doubble cuando se nos presente un signos de comparacion. 
 * 
 * @param obj recibe un objeto, 
 * 
 * @return el resultado de la comparacion 
 */
public boolean comparaMenor(Object obj){
	boolean resultado = false;
	if(dato instanceof Integer){
		Integer dat1 = (Integer)dato;
		Integer dat2  = (Integer)obj;
		resultado = dat1<dat2;
	}else if(dato instanceof Float){
		Float dat1 = (Float)dato;
		Float dat2  = (Float)obj;
		resultado = dat1<dat2; 
	}else if(dato instanceof Double){
		Double dat1 = (Double)dato;
		Double dat2  = (Double)obj;
		resultado = dat1<dat2; 
	}	
	return resultado;
}



/**
* Este método sirve para obtener el dato deseado de la lista.
* @return Retorna un dato de tipo T(genérico).
*/
public T getDato() {
return dato;
}

/**
* Este metodo sirve para establecer un dato.
* @param dato: Este es un dato de tipo generico, es decir, el usuario puede definir de que tipo de dato es posteriormente.
*/
public void setDato(T dato) {
this.dato = dato;
}

/**
* Este método sirve para obtener el dato siguiente a la posición actual.
* @return Retorna un Nodo, el cual es un objeto, donde se guardan posteriormente los datos.
*/
public Nodo<T> getSiguiente() {
return siguiente;
}

/**
* Este método sirve para establecer un dato posterior a una dato seleccionado.
* @param siguiente: Este es un dato de tipo generico, es decir, el usuario puede definir de que tipo de dato es posteriormente.
*/
public void setSiguiente(Nodo<T> siguiente) {
this.siguiente = siguiente;
}
/**
 * metodo para convertir una dato en String
 */
public String toString() {
return this.dato + " ";
}
}