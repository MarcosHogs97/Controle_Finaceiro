package Aplication;
/*
 * 	@autor
 *	Marcos Henrique o. g. da Silva
 *	Pablo Rodrigues de Oliveira
 * **/
import java.util.Scanner;

import Util.Controle_Financeiro2;

public class Start_FinanceiroJOptionPane {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controle_Financeiro2 controle = new Controle_Financeiro2(null,0,0);
		
		controle.startAplication(sc);
		sc.close();
	}
	
	

}
