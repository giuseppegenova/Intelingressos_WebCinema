package br.com.cinema.util;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.cinema.entity.Estado;
import br.com.cinema.facade.EstadoFacade;
import br.com.cinema.facade.local.EstadoFacadeLocal;


public class CarregaTabelas implements Serializable{

	private static final long serialVersionUID = -8346863918709218324L;

		public CarregaTabelas(){}
		
		public static void main(String[] args) throws Exception{			
			
				 String linha = null;				
				 File file = new File("tabelas.csv");  
			        Scanner sc = new Scanner(file);
			                
			        
			        while (sc.hasNextLine()) {
			           linha = sc.nextLine();
			           String linha2 = linha + ';';
			           List<String> texto = quebraParametro(linha2);
			           criaObjeto(texto); 
					   System.out.println(texto);  
					   sc.close();
			        } 
			        JOptionPane.showMessageDialog(null, "Fim da Inserção!");
			 }

			
			/**
			 * Método que tem a função de separar a string 
			 * em parametros e posicionar estes parametros 
			 * em uma lista
			 * @param str
			 * @return
			 */
			private static List<String> quebraParametro(String str){
				String texto = "" ;
				List<String> lista = new ArrayList<String>();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) != ';') 
						texto += str.charAt(i);
					else {
						lista.add(texto);
						texto = "" ;
					}
				}
				return lista;
		    }

			private static void criaObjeto(List<String> texto) throws Exception{
				
				String nome = texto.get(0).toString();
				String sigla = texto.get(1).toString();	
				
				Estado e = new Estado();
				e.setNome(nome);
				e.setSigla(sigla);
				
				EstadoFacadeLocal estadoFacade = new EstadoFacade();
				
				estadoFacade.save(e);		
		  
		    }
}
		 		
		




