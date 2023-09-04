package fes.aragon.lista.t;
/** 
 * Las listas enlazadas  genericas son un tipo de estructura de datos similar a los arrays
 * con la diferencia de que por defecto no tenemos por qu� saber la cantidad de elementos 
 * que va a contener. Estas listas se componen de nodos los cuales tienen dos atributos: 
 * el primero es el item o elemento que va a contener este nodo y el segundo atributo es 
 * una referencia al siguiente elemento de la lista.
 * 
 * *@author Julio Cesar Morales sierra
 * @version  15/10/2019/0.2
 * @param <T> es el tipo de dato generico<T> que se use.
 */
public class TDAListaSimple<T>{
	private Nodo<T> cabeza;
	private Nodo<T> cola;
	private int longitud;
	/**
	 * se crea el constructor que  y se asigna  cabeza y cola como null.
	 */
	public TDAListaSimple() {
		// TODO Auto-generated constructor stub
		cabeza=cola=null;
	}
	/**
	 * Se crea el m�todo insertar cola para ir insertando un elemento detr�s del otro en la lista.
	 * @param dato recibe un dato de tipo generico(T)
	 */
	public void insertarCola(T dato){
		if(cabeza==null){
			cabeza= new Nodo<T>(dato);//se crea un nodo y va a cabeza
			cola=cabeza;
		}else{
			Nodo<T> tmp= new Nodo<T>(dato);
			cola.setSiguiente(tmp);
			cola=tmp;//automaticamnete nodo se cambia a nueva cola tmp
		}
		longitud++;
	}
	/**
	 * Se crea el m�todo de insertar cabeza para agregar un elemento  al inicio de la  lista.
	 * @param dato recibe como parametro un elemto de generico(T)
	 */
	
	public void insertarCabeza(T dato){
		if(cabeza==null){
			cabeza= new Nodo<T>(dato);
			cola=cabeza;
		}else {
			Nodo<T> tmp = new Nodo<T>(dato);
            cabeza.setSiguiente(tmp);
            cabeza = tmp;
		}
		longitud++;
	}
	/**
	 * M�todo p�blico getLongitud  que regresa (un entero) la longitud de la lista.
	 * @return
	 */
	public int getLongitud() {
		return longitud;
	}
	/**
	 * Revisa si la lista est� vac�a 
	 * @return
	 */
	public boolean esVacia(){
		return cabeza==null;
		
	}
	/**
	 * M�todo de tipo void  mostrarDatos()  que muestre la lista  creada o que se est� creando.

	 */
	public void mostrarDatos(){
		for(Nodo<T> tmp= cabeza; tmp != null;
				tmp =tmp.getSiguiente()){
					System.out.println(tmp.toString());
				}
	}
	/**
	 * Se crea el m�todo p�blico de tipo gen�rico (T) obtenerDato. 
	 * @param indice recibe como par�metro un n�mero de tipo entero.  
	 * @return regresa el dato o null.
	 */
	public T obtenerDato(int indice){
		boolean error= false;
		if(indice<0 || indice>= longitud){
			error= true;
		}
		Nodo<T> tmp=null;
		if(!error){
			int i=0;
			for(tmp= cabeza; i !=indice; tmp=tmp.getSiguiente(), i++);
		}
		if(tmp != null){
			return tmp.getDato();
		}else{
			return null;
		}
	}
	/**
	 * Se crea el m�todo p�blico de tipo gen�rico (T) eliminarIndice.
	 * @param indice que recibe como par�metro un n�mero de tipo entero y 
	 * elimina el dato que est� en esa posici�n o  �ndice.
	 */
	public void eliminarIndice(int indice){
		boolean error=false;
		if(indice< 0|| indice>= longitud){
			error=true;
		}
		if(!error){
			if(indice == longitud -1){
				eliminarCola();
			}else if (indice==0){
				eliminarCabeza();
			}else{
				int i=0;
				Nodo<T> tmp= cabeza.getSiguiente();
				Nodo<T> previo= cabeza;
				
				for(; tmp !=null && i != indice-1; previo =tmp, tmp= tmp.getSiguiente(), i++);
				previo.setSiguiente(tmp.getSiguiente());
				tmp.setSiguiente(null);
				longitud --;
			}
		}
	}
	/**
	 * Se crea el m�todo  de tipo (T) generico eliminarCabeza que
	 *  elimina el dato que est� al inicio de la lista. 
	 * @return retorna el dato que se esta eliminado.
	 */
	public T eliminarCabeza(){
		Nodo<T> dato= null;
		if (this.cabeza==this.cola){
			dato=cabeza;
			this.cabeza = this.cola = null;
		}
		else{
			dato=cabeza;
			Nodo<T> tmp=cabeza.getSiguiente();
			cabeza=tmp;
		}
		longitud--;
		return dato.getDato();
	}
	/**
	 * Se crea el m�todo  de tipo (T) generico eliminarCola que elimina el dato
	 *  que est� en la cola de  la lista
	 * retorna el dato que se est� eliminando.

	 * 
	 */
	public T eliminarCola(){
		Nodo<T> dato = null;
		if(this.cabeza==this.cola){
			dato=cabeza;
			this.cabeza=this.cola=null;
		}else{
			Nodo<T> tmp = cabeza.getSiguiente();
			Nodo<T> previo = cabeza;
			for(; tmp.getSiguiente() != null; previo=tmp, tmp=tmp.getSiguiente());
			this.cola=previo;
			dato=tmp;
			this.cola.setSiguiente(null);
		}
		longitud --;
		
		return dato.getDato();

    }
	/**
	 * Se crea el m�todo  de tipo boolean eliminarDato..
	 * @param dato recibe un dato de tipo gen�rico (T dato) elimina el dato que se le env�a
	 * 
	 * @return borrar la elmiminacion del dato.
	 */
	public boolean eliminarDato(T dato) {
		boolean borrar= false;
		
		if(this.cabeza != null) {
			if((this.cabeza==this.cola)&&(dato.equals(this.cabeza.getDato()))) {
				this.cabeza = this.cola = null;
				longitud --;
				
				borrar = true;
			}else if((dato.equals(this.cabeza.getDato()))) {
				this.cabeza = cabeza.getSiguiente();
				longitud --;
				borrar = true;
			}else {
				Nodo<T> tmp= cabeza.getSiguiente();
				Nodo<T> previo = cabeza;
				
				for (; tmp != null && !(tmp.getDato().equals(dato));
						previo = previo.getSiguiente(), tmp = tmp.getSiguiente());
				
				if(tmp != null) {
					previo.setSiguiente(tmp.getSiguiente());
					if(tmp == this.cola) {
						this.cola =previo;
						cola.setSiguiente(null);
					}
					longitud--;
					borrar = true;
				}
			}
			
		}
		return borrar;
	}

/**
 * Se crea el m�todo obtenerNodo() que obtine el nodo que buscas. 
 * @param indice que recibe el �ndice de tipo entero de la posici�n del nodo que se desea  obtener
 * @return retorna el nodo cuando se haya encontrado, si eso no pasa retorna(Null = nada) 
 *  que no se encontr� el nodo
 */
public Nodo<T> obtenerNodo(int indice){
	boolean error= false;
	if(indice<0 || indice>= longitud){
		error= true;
	}
	Nodo<T> tmp=null;
	if(!error){
		int i=0;
		for(tmp= cabeza; i !=indice; tmp=tmp.getSiguiente(), i++);
	}
	if(tmp != null){
		return tmp;
	}else{
		return null;
	}
}
}
