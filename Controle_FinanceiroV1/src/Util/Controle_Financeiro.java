package Util;

import java.util.Scanner;

public class Controle_Financeiro {
	private double saldo;
	private String produto;
	private double valorProduto;
	
	//get e set
	public double getSaldo() {
		return saldo;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getValor() {
		return valorProduto;
	}
	public void setValor(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	//adicionar saldo
	public void addSaldo(double saldo) {
		this.saldo += saldo;
	}
	
	//construtor.
	public Controle_Financeiro(String produto, double valorProduto, double saldo) {
		this.produto = produto;
		this.valorProduto = valorProduto;
		this.saldo = saldo;
	}
	
	public void startAplication(Scanner sc) {
		int escolhaMenu;		
		System.out.printf("--------- MENU ---------%n1 - Cadastrar Saldo%n2 - Cadastrar Despesas%n3 - Visualizar Saldo%n4 - Sair%nR= ");
		escolhaMenu = sc.nextInt();
		switch (escolhaMenu) {
		case 1:
			System.out.print("Informe o valor que deseja Adicionar: ");
			double saldo = sc.nextDouble();
			addSaldo(saldo);
			informacaoSaldo();
			startAplication(sc);
			break;
			
		case 2:
			cadastrarDespesa(sc);
			novaCompra(sc);
			break;
			
		case 3:
			
			informacaoSaldo();
			startAplication(sc);
			break;
			
		case 4:
			System.out.println("Agradecemos por usar nossa aplicação!!");
			break;
			
		default:
			System.out.println("Informe um valor valido!!");
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
		String despesa = sc.nextLine();
		setProduto(despesa);
		
		System.out.print("\nInforme o valor da dispesa: ");
		double valorDespesa = sc.nextDouble();
		setValor(valorDespesa);
		validacao(sc);
	}
	
	public void validacao(Scanner sc) {
		if(getSaldo() >= getValor()) {
			saldo = saldo - valorProduto;
			informacaoSaldo();
			novaCompra(sc);
		}else {
			double diferenca =  valorProduto - saldo;
			System.out.println("Saldo insuficiente deposite R$ " + diferenca + " para realizar a compra");
			informacaoSaldo();
			startAplication(sc);
		}
	}
	
	
	//metodo para exibir as informaçoes da conta.
		public void informacaoSaldo() {
			System.out.println("========= Dados Financeiros ==============");
			System.out.println(toString());
			System.out.println("*===========================================*\n");
		}
		
		public String toString(){
			return "Saldo na conta: R$ " + getSaldo();
		}
}