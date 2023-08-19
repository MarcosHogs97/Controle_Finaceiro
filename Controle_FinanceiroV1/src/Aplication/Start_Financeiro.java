package Aplication;

import java.util.Scanner;

import Util.Controle_Financeiro;

public class Start_Financeiro {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controle_Financeiro controle = new Controle_Financeiro(null,0,0);
		
		controle.startAplication(sc);
		sc.close();
	}
	
	//Marcos Henrique o. g. da Silva
	//Pablo Rodrigues de Oliveira

}
