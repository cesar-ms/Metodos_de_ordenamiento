package fes.aragon.orden;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.SliderUI;

import fes.aragon.lista.t.Nodo;
import fes.aragon.lista.t.TDAListaSimple;

/**
 * Para poder ordenar una cantidad determinada de números almacenadas en una lista, vector o matriz,
 * existen distintos métodos (algoritmos) con distintas características y complejidad.
 * En esta clase se emplean los metodos burbuja,seleción directa,Inserción directa,mezcla,shell y quicksort.
 * 
 *@author Julio Cesar Morales sierra
 * @version  15/10/2019/0.2
 * @param <T> es el tipo de dato.
 */
public class Metodosdeordenamiento<T> implements Runnable{
	private PropertyChangeSupport soporte  =  new PropertyChangeSupport(this);
	 
	private TDAListaSimple<T> lista;
	private int metodo;
	
	/**
	 * Este metodo sirve para hacer llama automáticamente siempre que se declara un 
	 * objeto de esa clase.Su función es inicializar el objeto y sirve para asegurarnos que los objetos
	 * siempre contengan valores válidos. 
	 
	 * @param lista recibe la lista creada. 
	 * @param met recibe el metodo que se decea  llamar.
	 */
	
	public Metodosdeordenamiento(TDAListaSimple<T> lista,int met) {
		// TODO Auto-generated constructor stub
		this.lista =(TDAListaSimple<T>) lista;
		this.metodo= met; 
	}
	/**
	 *  Funciona revisando cada elemento de la lista que va a ser ordenada con el siguiente,
	 *  intercambiándolos de posición si están en el orden equivocado.
	 *  Es necesario revisar varias veces toda la lista hasta 
	 *  que no se necesiten más intercambios,
	 *  lo cual significa que la lista está ordenada. 
	 * 
	 * @param lista recibe una lista dimanica.
	 * @param izq recibe un elemento de tipo entero (el cominezo de la lista a ordenar) 
	 * @param der recibe un elemento de tipo entero (el final de la lista a ordenar)
	 */
	public <T> void burbuja(TDAListaSimple<T> lista,int izq,int der){
		if(izq==0 && der ==0) {// 
			for (int i = 0; i < lista.getLongitud()-1; i++){
				for (int j = lista.getLongitud()-1; j > i; j--) {
					
					if(lista.obtenerNodo(j).comparaMenor(lista.obtenerNodo(j-1).getDato())){
						T tmp= lista.obtenerNodo(j).getDato();
						lista.obtenerNodo(j).setDato(lista.obtenerNodo(j-1).getDato());
						lista.obtenerNodo(j-1).setDato(tmp);
						this.soporte.firePropertyChange("ordenar1",null,this.lista);
						// this.soporte.firePropertyChange("ordenar2",null,lista);
						try {
							Thread.sleep(60);
						}catch(InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
		}else{
		for (int i = izq; i < lista.getLongitud()-der; i++){
			for (int j = lista.getLongitud()-der; j > i; j--) {
				
				if(lista.obtenerNodo(j).comparaMenor(lista.obtenerNodo(j-1).getDato())){
					T tmp= lista.obtenerNodo(j).getDato();
					lista.obtenerNodo(j).setDato(lista.obtenerNodo(j-1).getDato());
					lista.obtenerNodo(j-1).setDato(tmp);
							
				}
				
			}
		}
	}
}
/**
 * Consiste en encontrar el menor de todos los elementos del vector e intercambiarlo con el
 * que está en la primera posición. Luego el segundo mas pequeño, y así sucesivamente hasta ordenarlo todo.
 * 
 * @param lista  recibe una lista dimanica.
 * @param izq recibe un elemento de tipo entero (el cominezo de la lista a ordenar) 
 * @param der recibe un elemento de tipo entero (el final de la lista a ordenar)
 */
public <T> void SelecionDirecta(TDAListaSimple<T> lista,int izq, int der){
	if(izq ==0 && der ==0){
		for (int i = 0; i < lista.getLongitud()-1; i++){
			T menor = lista.obtenerDato(i);
			int k=i;
		    //lista.obtenerNodo(k).setDato(lista.obtenerNodo(i).getDato());
            for (int j = i+1; j < lista.getLongitud(); j++) {
            	if(lista.obtenerNodo(j).comparaMenor(menor)){
            		menor = lista.obtenerNodo(j).getDato();
            		k=j;
            	}
			}	
			 lista.obtenerNodo(k).setDato(lista.obtenerNodo(i).getDato());
			 lista.obtenerNodo(i).setDato(menor);
			 this.soporte.firePropertyChange("ordenar2",null, this.lista);
			 try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}else{
		for (int i = izq; i < lista.getLongitud()-1; i++){
			T menor = lista.obtenerDato(i);
			int k=i;
		    //lista.obtenerNodo(k).setDato(lista.obtenerNodo(i).getDato());
            for (int j = i+1; j < lista.getLongitud(); j++) {
            	if(lista.obtenerNodo(j).comparaMenor(menor)){
            		menor = lista.obtenerNodo(j).getDato();
            		k=j;
            	}
			}	
			 lista.obtenerNodo(k).setDato(lista.obtenerNodo(i).getDato());
			 lista.obtenerNodo(i).setDato(menor);
		  }
		}
	}
/**
 * La idea de este algoritmo de ordenación consiste en ir insertando un elementode la lista ó 
 * un arreglo en la parte ordenada de la misma, asumiendo que el primer elemento
 * es la parte ordenada, el algoritmo ira comparando un elemento de la parte desordenada de la
 * lista con los elementos de la parte ordenada, insertando el elemento en la posición correcta 
 * dentro de la parte ordenada,y así sucesivamente hasta obtener la lista ordenada.
 * 
 * @param lista recibe una lista dimanica.
 */
public <T> void InsercionDirecta(TDAListaSimple<T> lista){	
		for (int i = 1; i < lista.getLongitud(); i++) {
	       T aux= lista.obtenerNodo(i).getDato();
	         int k = i-1;
	     // para ordenarlos de manera decendente  solo es  poner ! en el while. (!lista.ObtrenerNodo)
		while(k>-1 && !lista.obtenerNodo(k).comparaMenor(aux)){
			  lista.obtenerNodo(k+1).setDato(lista.obtenerDato(k));
			  k = k -1;
		  }
		  lista.obtenerNodo(k+1).setDato(aux);
		  this.soporte.firePropertyChange("ordenar3",null,this.lista);
		  try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/**
 * El metodo de ordenacion por mezcla hace la llamana a los metodos burbuja y seleccion directa,
 * para que  cada metodo ordene la mitad de la lista que le corresponde o que se le envie. 
 * En este proceso se  tomaa las dos listas ordenadas más pequeñas y las combina en una sola lista 
 * nueva y ordenada.
 * 
 * @param lista recibe una lista dimanica.
 * @param li recibe un elemento de tipo entero (el cominezo de la lista a ordenar).
 * @param ls recibe un elemento de tipo entero (el final de la lista a ordenar).
 */

  public <T> void OrdenacionPorMezcla(TDAListaSimple<T> lista,int li, int ls){
    	int n1 = ls/2;
    	int n2 = ls;
    	burbuja(lista, 0, n1);
    	SelecionDirecta(lista, n1, lista.getLongitud()-1);
    	int i,j,k;
    	int low=li;
    	i=0;
    	j= n1;
    	k = n1;
    	while(i<=j && k<n2){
    		if (lista.obtenerNodo(low).comparaMenor(lista.obtenerNodo(k).getDato())){	
    		low++;
    	  }else{
    		T temp= lista.obtenerNodo(k).getDato();
    		for (int aux = k-1; aux >= low; aux--) {
    			lista.obtenerNodo(aux+1).setDato(lista.obtenerNodo(aux).getDato());
    	    }
    		lista.obtenerNodo(low).setDato(temp);
    		low++;
    		j++;
    		k++;
		    
    	}
    		this.soporte.firePropertyChange("ordenar4",null,this.lista);
  		  try{
  		    Thread.sleep(60);
  		  }catch (InterruptedException e) {
  		  // TODO Auto-generated catch block
  		  e.printStackTrace();
  		     }
     }
  }
/**
 * Este método utiliza una segmentación entre los datos. Funciona comparando elementos 
 * que estén distantes; la distancia entre comparaciones decrece conforme el algoritmo 
 * se ejecuta hasta la ultima fase, en la cual se comparan los elementos adyacentes,
 * por esta razón se le llama ordenación por disminución de incrementos.
 * 
 * @param lista recibe una lista dimanica.
 */
    public <T> void OrdenacionPorShell(TDAListaSimple<T> lista){
    	   int salto=0,i=0;
    	   boolean cambios; // Verifica si hay cambios de posicion
    	   T aux = lista.obtenerNodo(i).getDato();  
    	   for(salto=lista.getLongitud()/2; salto!=0; salto/=2){
    	           cambios=true;
    	           while(cambios){ 
    	                 cambios=false;
    	                  for(i=salto; i < lista.getLongitud(); i++) 
    	                      if(lista.obtenerNodo(i).comparaMenor(lista.obtenerNodo(i-salto).getDato())){  // se compara y se hace el cambio de posicion
    	                        aux=lista.obtenerNodo(i).getDato(); 
    	                        lista.obtenerNodo(i).setDato(lista.obtenerNodo(i-salto).getDato());
    	                        lista.obtenerNodo(i-salto).setDato(aux);
    	                        cambios=true; 
    	                        
    	                        this.soporte.firePropertyChange("ordenar5",null, this.lista);
    	                        try {
    	                        Thread.sleep(60);
    	                        }catch (InterruptedException e) {
    	                        // TODO Auto-generated catch block
    	                        e.printStackTrace();
    	                        }
                  			}      
    	                }
    	       }
  }
   /**
    *El metodo funciona tomando un elemento de la lista de elementos a ordenar, al que llamaremos pivote.
    *Resituar los demás elementos de la lista a cada lado del pivote, de manera que a
    *un lado queden todos los menores que él, y al otro los mayores. En este momento,
    *el pivote ocupa exactamente el lugar que le corresponderá en la lista ordenada.
    *La lista queda separada en dos sublistas, una formada por los elementos a la
    *izquierda del pivote, y otra por los elementos a su derecha.
    *Repetir este proceso de forma recursiva para cada sublista mientras éstas 
    *contengan más de un elemento. Una vez terminado este proceso 
    *todos los elementos estarán ordenados.
    *
    * @param lista recibe una lista dimanica.
    * @param li recibe un elemento de tipo entero (el cominezo de la lista a ordenar).
    * @param ls recibe un elemento de tipo entero (el final de la lista a ordenar).
    */
    
  public <T> void Rapido(TDAListaSimple<T> lista, int li, int ls){
    if(li >= ls){
	    return;
    }
   T pivote = lista.obtenerNodo(li).getDato();
   int izq = li+1;
   int der = ls ;
   while(izq <= der){
	   while(izq <= ls && lista.obtenerNodo(izq).comparaMenor(pivote)){
		   izq++;
	   }
	   while(der > li && !lista.obtenerNodo(der).comparaMenor(pivote)){
		   der--;
	   }
	   if (izq < der){
		   T temp = lista.obtenerNodo(izq).getDato();
		   lista.obtenerNodo(izq).setDato(lista.obtenerNodo(der).getDato());
		   lista.obtenerNodo(der).setDato(temp);
	   }
   }
   if(der > li){
	   T temp = lista.obtenerNodo(li).getDato();
	   lista.obtenerNodo(li).setDato(lista.obtenerNodo(der).getDato());
	   lista.obtenerNodo(der).setDato(temp);
	   
   }
   Rapido(lista, li, der-1);
   Rapido(lista, der+1, ls);
   
   this.soporte.firePropertyChange("ordenar6", null,this.lista);
	   try {
		Thread.sleep(60);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} 
/**
 * El metodo agregar oyentes es el que se encarga de 
 * escuchar o recibier el metodo que se desea ejcutar.
 * @param oyentes recibe el metodo que se va a ordenar.
 */
  public void agregarOyentes(PropertyChangeListener oyentes){	
    	soporte.addPropertyChangeListener(oyentes);
  	  
    }
/**
 * Este metodo(Run)se encarga de ejecutar o correr cada metodo de ordenacion,
 * cuando la signacion de esta se igual al numero que le corresponde a cada metodo de ordenacion.
 * 
 * A cada metodo se le asigna los parametros para la ordenacion de cada  lista. 
 *  
 */
	@Override
	public void run() {
		
		if (this.metodo==1) {
			this.burbuja(lista,0,0); 
		}
		if (this.metodo==2) {
			this.SelecionDirecta(lista,0,0);
		}
		if(this.metodo==3){
			this.InsercionDirecta(lista);
		}
		if (this.metodo == 4){
		    this.OrdenacionPorMezcla(lista, 0,70);
		}
		if (this.metodo==5){
			this.OrdenacionPorShell(lista);
		}
		if(this.metodo==6){
			this.Rapido(lista,0,69);
	    }
	
    }
		
}
