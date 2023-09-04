package fes.aragon.oyentes;
import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fes.aragon.lista.t.TDAListaSimple;
/** 
 *En esta clase emplea las funciones para captar o escuchar que metodo de ordenamiento
 *se esta solicitando para la ordenacion de la lista, para ello se utiliza
 * la implementacion de la clase PropertyChangeListener.  
 *
 * @author Julio Cesar Morales sierra
 * @version  15/10/2019/0.2
 * @param <T> es el tipo de dato. 
 */
public class Oyente <T> extends JPanel implements PropertyChangeListener {
	
	  private TDAListaSimple<T> datos = new TDAListaSimple<>();
	  private String ordenar ="";
	
	/** 
	 * Constructor
	 * 
	 * @param ordenar resibe un dato de tipo string .
	 */
	public Oyente(String ordenar){
		super();
		this.ordenar = ordenar;
	}
	@Override
	/**
     * Esta función se encarga de recibir un evento de ordenar (burbuja, insercion...) y cuando hay cambio de propiedad
	 * este vuelve a pintarlo. En otras palabras este metodo hace la animacion de todos los metodos cuando se estan ordenando las listas.
	 * 
	 * 
	 */
	 public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getPropertyName().equals(this.ordenar)){
	      TDAListaSimple<T> lista = (TDAListaSimple<T>) evt.getNewValue();
	      this.datos = lista;
	      this.repaint();// pinta de nuevo
		}
	}
	/**
	 * Se encarga de pintar los datos de las listas. 
	 * 
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int x = 0;// se posisciona en el centro de la lamina
		int y = 100;
		for (int i = 0; i < this.datos.getLongitud(); i++) {
			Integer dato = (Integer) this.datos.obtenerDato(i);
			int width = 5;
			int height = dato;
			g.setColor(Color.MAGENTA);
			g.drawRect(x, y- height, width, height);
			g.drawRect(x,y,width, height);
		    x +=5;
		}
	}
	/**
	 * obtione el dato que esta en la lista 
	 * @return resgresa el dato
	 */
	public TDAListaSimple<T> getDatos() {
		return datos;
	}
	/**
	 * Asigna los datos que esta en la lista a una variable. 
	 * @param datos recibe el o los datos que se decea asignar.
	 */
	public void setDatos(TDAListaSimple<T> datos) {
		this.datos = datos;
	}
}
	  


