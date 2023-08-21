package Util;

import java.util.Scanner;

public class Controle_Financeiro {
	private double saldo;
	private String despesas;
	private double valorDespesas;
	
	//get e set
	public double getSaldo() {
		return saldo;
	}
	public String getProduto() {
		return despesas;
	}
	public void setProduto(String produto) {
		this.despesas = produto;
	}
	public double getValor() {
		return valorDespesas;
	}
	public void setValor(double valorProduto) {
		this.valorDespesas = valorProduto;
	}
	
	//adicionar saldo
	public void addSaldo(double saldo) {
		this.saldo += saldo;
	}
	
	//construtor.
	public Controle_Financeiro(String produto, double valorProduto, double saldo) {
		this.despesas = produto;
		this.valorDespesas = valorProduto;
		this.saldo = saldo;
	}
	
	public void startAplication(Scanner sc) {
		int escolhaMenu;		
		System.out.printf("--------- MENU ---------%n1 - Cadastrar Saldo%n2 - Cadastrar Despesas%n3 - Visualizar Saldo%n4 - Sair%nR= ");
		escolhaMenu = sc.nextInt();
		switch (escolhaMenu) {
		case 1:
			System.out.print("\nInforme o valor que deseja Adicionar: ");
			double saldo = sc.nextDouble();
			addSaldo(saldo);
			informacaoSaldo();
			startAplication(sc);
			break;
			
		case 2:
			cadastrarDespesa(sc);			
			break;
			
		case 3:
			
			informacaoSaldo();
			startAplication(sc);
			break;
			
		case 4:
			System.out.println("\nAgradecemos por usar nossa aplicação!!");
			break;
			
		default:
			System.out.println("\nInforme um valor valido!!");
			startAplication(sc);
		}

	}
	public void novaCompra(Scanner sc) {
		System.out.println("Deseja fazer uma nova compra? ( S / N )");
		char escolha = sc.next().charAt(0);
		switch (escolha) {
		case 's','S':
			cadastrarDespesa(sc);
			break;
		case 'n','N':
			startAplication(sc);
			break;
		default:
			break;
		}
	}
	
	public void cadastrarDespesa(Scanner sc) {
		System.out.print("Informe a descrição da dispesa: ");
		String despesa = sc.next();
		setProduto(despesa);
		
		System.out.print("\nInforme o valor da dispesa: ");
		double valorDespesa = sc.nextDouble();
		setValor(valorDespesa);
		validacao(sc);
	}
	
	public void validacao(Scanner sc) {
		if(getSaldo() >= getValor()) {
			saldo = saldo - valorDespesas;
			informacaoSaldo();
			novaCompra(sc);
		}else {
			double diferenca =  valorDespesas - saldo;
			System.out.println("Saldo insuficiente deposite R$ " + diferenca + " para realizar a compra");
			informacaoSaldo();
			startAplication(sc);
		}
	}
	
	
	//metodo para exibir as informaçoes da conta.
		public void informacaoSaldo() {
			System.out.println("\n========= Dados Financeiros ==============");
			System.out.println(toString());
			System.out.println("*===========================================*\n");
		}
		
		public String toString(){
			return "Saldo na conta: R$ " + getSaldo();
		}
}