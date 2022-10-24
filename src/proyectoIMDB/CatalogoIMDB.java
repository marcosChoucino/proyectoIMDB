package proyectoIMDB;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CatalogoIMDB {

	final String menor = String.valueOf(1900);
	final String mayor = String.valueOf(2030);
	
	ListaPeliculas IListaPeliculas = new ListaPeliculas;
	ListaPeliculas IListaInterpretes = new ListaPeliculas;
	
	
	//patron singleton creo
	private static CatalogoIMDB cat;
	public static CatalogoIMDB getInstance() {
		if(cat== null) {
			cat = new CatalogoIMDB();
		}
		return cat;
	}
	CatalogoIMDB(){		
	}
	
	//esto es una prueba de INTELI J

	//Esta hecho, no provado
	public void cargarPeliculas(String nomF) {
		Scanner entrada = new Scanner(new FileReader(nomF));
		String[] linea;
		while (entrada.hasNext()) {
			linea = entrada.nextLine().split("\t");
			Pelicula auxi = new Pelicula(linea[0]);
			auxi.setAno(Integer.valueOf(linea[1]));
			auxi.setRating(Integer.valueOf(linea[2]));
			auxi.setVotos(Integer.valueOf(linea[3]));
			IListaPeliculas.anadirPelicula(auxi);
		
		}}
	
	
	
	
	
	
	//hecho, no provado
	/**
	* Carga los intérpretes del catálogo desde el fichero indicado
	* POST: se han cargado los intérpretes y se han calculado sus ratings
	* @param nomF Nombre del fichero que contiene los intérpretes
	*/

	public void cargarInterpretes(String nomF) {
		Scanner entrada = new Scanner(new FileReader(nomF));
		while (entrada.hasNext()) {
			String linea = entrada.nextLine();
			String split1[] = linea.split("->");
			String split2 [] = linea.split("||");
			Interprete auxi = new Interprete(linea[0]));
		
		
			for(int i = 1; 1 != linea.lenght;i++) {
				auxi.AnadirPelicula(IListaInterpretes.buscarPelicula(split2[i]));
			}
		}
		IListaInterpretes.anadirInterprete(auxi);
		}
		
	
	}
	
	
	/**		HECHO, NO PROBADO
	* Imprime por pantalla el nº de intérpretes de una película y sus nombres
	* @param titulo Título de la película
	*/
	public void imprimirInfoPelicula(String titulo) {
	Pelicula auxi = IListaPeliculas.buscarPelicula();
	System.out.println("Numero de interpretes" + auxi.getNumeroInterpretes + "y los interpretes son:"));
		auxi.listaPeliculas.forEach((n))->System.out.println(n.getNombre);
	}
	
	
	
	
	
	
	
	
	/** Hecho, no provado
	* Imprime por pantalla el nombre del intérprete, su rating y los títulos
	* de sus películas.
	* @param nombre Nombre del intérprete
	*/
	public void imprimirInfoInterprete(String nombre) {
		Interprete auxi = IListaInterpretes.buscarInterprete(nombre);
		System.out.prinln("El interprete se llama" + auxi.getNombre);
		System.out.prinln("Y ha salido en las siguientes peliculas;");
		Auxi.ListaDeInterpretes.forEach((n) ->System.out.println(n.GetTitulo)) <;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	/** Hecho, no provado
	* Añade un nuevo voto a una película
	* PRE: el valor del voto está entre 0.0 y 10.0.
	* @param titulo Título de la película
	* @param voto Valor del voto
	*/
	public void anadirVoto(String titulo, float voto) {
		Pelicula auxi = IlistaPeliculas.buscarPelicula(titulo);
		if(auxi.getVoto == 0) {
			auxi.setValoracion(voto);
		}else {
			auxi.setValoracion((auxi.getValoracion*auxi.getNumeroDeVotos + voto)/(auxi.getNumeroDeVotos)+1);
		}
	}
		
}

	
	
	
	
	