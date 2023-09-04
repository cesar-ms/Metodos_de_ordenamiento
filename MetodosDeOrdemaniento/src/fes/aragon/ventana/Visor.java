package fes.aragon.ventana;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fes.aragon.lista.t.TDAListaSimple;
import fes.aragon.orden.Metodosdeordenamiento;
import fes.aragon.oyentes.Oyente;

import java.awt.GridLayout;
import java.util.Random;
import java.util.function.IntConsumer;
import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * En esta clase se crea la vantana donde todos los metodos se van a mostrar de 
 * forma grafica para poder observar la manera en como se ordenan y la tiempo que tarda en ordenar.
 * 
 * @author Julio Cesar Morales sierra
 * @version  15/10/2019/0.2
 *
 */

public class Visor extends JFrame {
	
	private JPanel contentPane;
	private Oyente<Integer> burbuja = new Oyente<>("ordenar1"); 
	private Oyente<Integer> seleccionDirecta = new Oyente<>("ordenar2"); 
	private Oyente<Integer> insercionDirecta = new Oyente<>("ordenar3");
	private Oyente<Integer> mezcla = new Oyente<>("ordenar4");
	private Oyente<Integer> shell= new Oyente<>("ordenar5");
	private Oyente<Integer> Rapido= new Oyente<>("ordenar6");
	
	private final JLabel lblMettodoDeBurbuja = new JLabel("MÉTODO BURBUJA");
	private final JLabel lblNewLabel = new JLabel("MÉTODO DE SELECCIÓN DIRECTA");
	private final JLabel lblNewLabel_1 = new JLabel("MÉTODO INSERCIÓN DIRECTA");
	private final JLabel lblNewLabel_2 = new JLabel("MÉTODO SHELL");
	private final JLabel lblMtodoDeMezcla = new JLabel("MÉTODO DE MEZCLA ");
	private final JLabel lblNewLabel_3 = new JLabel("MÉTODO DE QUICKSORT");
	
	Metodosdeordenamiento<Integer> met;
	Metodosdeordenamiento<Integer> met2;
	Metodosdeordenamiento<Integer> met3;
	Metodosdeordenamiento<Integer> met4;
	Metodosdeordenamiento<Integer> met5;
	Metodosdeordenamiento<Integer> met6;
	
	
	
	/**
	 * Inicia la aplicacion.
	 */
	public static void main(String[] args) {
		Visor frame = new Visor();
		frame.setVisible(true);
	    frame.previo();
	}
	/**
	 * Se crea el marco.
	 */
	public Visor() {
		
		setForeground(Color.BLACK);
		setBackground(Color.MAGENTA);
		setTitle("M\u00C9TODOS DE ORDENAMIENTO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2,3));

		
		JPanel panel = burbuja;
		burbuja.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(panel);
		burbuja.setLayout(null);
		lblMettodoDeBurbuja.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblMettodoDeBurbuja.setBounds(104, 213, 120, 14);
		burbuja.add(lblMettodoDeBurbuja);
		
		
		JPanel panel_4 = shell;
		contentPane.add(panel_4);
		shell.setLayout(null);
		lblNewLabel_2.setBounds(140, 232, 104, 14);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		shell.add(lblNewLabel_2);

		
		JPanel panel_1 = seleccionDirecta;
		contentPane.add(panel_1);
		seleccionDirecta.setLayout(null);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblNewLabel.setBounds(92, 210, 228, 14);
		
		seleccionDirecta.add(lblNewLabel);
		
		JPanel panel_2 = insercionDirecta;
		contentPane.add(panel_2);
		insercionDirecta.setLayout(null);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblNewLabel_1.setBounds(92, 208, 205, 14);
		
		insercionDirecta.add(lblNewLabel_1);
		
		JPanel panel_3 = mezcla;
		contentPane.add(panel_3);
		mezcla.setLayout(null);
		lblMtodoDeMezcla.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblMtodoDeMezcla.setBounds(171, 228, 138, 14);
		
		mezcla.add(lblMtodoDeMezcla);

		
		JButton btnNewButton = new JButton("SALIR");
		mezcla.add(btnNewButton);
		btnNewButton.setBounds(210, 281, 89, 23);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 105, 180));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.setBounds(90, 281, 89, 23);
		mezcla.add(btnIniciar);
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setBackground(new Color(255, 105, 180));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Thread hilo= new Thread(met);
				hilo.start();
				Thread hilo2= new Thread(met2);
				hilo2.start();
				Thread hilo3 = new Thread(met3);
				hilo3.start();
				Thread hilo4 = new Thread(met4);
				hilo4.start();
				Thread hilo5 = new Thread(met5);
				hilo5.start();
				Thread hilo6 = new Thread(met6);
				hilo6.start();
			}
		});
		
		JPanel panel_5 = Rapido;
		contentPane.add(panel_5);
		Rapido.setLayout(null);
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblNewLabel_3.setBounds(100, 230, 167, 14);
		
		Rapido.add(lblNewLabel_3);
	}
	/**
	 * En este metodo (previo) se crean las listas random y a cada respectivo 
	 * metodo se le asignara una lista para ordenar y se agregan los oyentes. 
	 */
	private void previo(){
		
		TDAListaSimple<Integer> lista = new TDAListaSimple<>();
		
		Random rd = new Random();
		for (int i = 0; i < 70; i++) {
			lista.insertarCola(rd.nextInt(100));
		}
		burbuja.setDatos(lista);
		TDAListaSimple<Integer> lista2 = new TDAListaSimple<>();
		for (int i = 0; i < 70; i++) {
			lista2.insertarCola(rd.nextInt(100));
		}
		seleccionDirecta.setDatos(lista2);
		TDAListaSimple<Integer> lista3 = new TDAListaSimple<>();
		for (int i = 0; i < 70; i++) {
			lista3.insertarCola(rd.nextInt(100));
		}
		insercionDirecta.setDatos(lista3);
		TDAListaSimple<Integer> lista4 = new TDAListaSimple<>();
		for (int i = 0; i < 70; i++) {
			lista4.insertarCola(rd.nextInt(100));
		}
		mezcla.setDatos(lista4);
		TDAListaSimple<Integer> lista5 = new TDAListaSimple<>();
		for (int i = 0; i < 70; i++) {
			lista5.insertarCola(rd.nextInt(100));
		}
		shell.setDatos(lista5);
		TDAListaSimple<Integer> lista6 = new TDAListaSimple<>();
		for (int i = 0; i < 70; i++) {
			lista6.insertarCola(rd.nextInt(100));
		}
		Rapido.setDatos(lista6);
		
		met = new Metodosdeordenamiento(lista,1);
		met2 = new Metodosdeordenamiento(lista2,2);
		met3 = new Metodosdeordenamiento(lista3,3);
		met4 = new Metodosdeordenamiento(lista4,4);
		met5 = new Metodosdeordenamiento(lista5,5);
		met6 = new Metodosdeordenamiento(lista6,6);
		
		met.agregarOyentes(burbuja);
		met2.agregarOyentes(seleccionDirecta);
		met3.agregarOyentes(insercionDirecta);
		met4.agregarOyentes(mezcla);
		met5.agregarOyentes(shell);
		met6.agregarOyentes(Rapido);
		
	}

}
