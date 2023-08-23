package Util;
/*
 * 	@autor
 *	Marcos Henrique o. g. da Silva
 *	Pablo Rodrigues de Oliveira
 * **/
import java.util.Scanner;
import javax.swing.JOptionPane;;

public class Controle_Financeiro2 {
	private double saldo;
	private String despesas;
	private double valorDespesas;
	
	//construtor.
	public Controle_Financeiro2(String produto, double valorProduto, double saldo) {
			this.despesas = produto;
			this.valorDespesas = valorProduto;
			this.saldo = saldo;
	}
	
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
	public double getValorDespesas() {
		return valorDespesas;
	}
	public void setValorDespesas(double valorProduto) {
		this.valorDespesas = valorProduto;
	}
	
	//adicionar saldo
	public void addSaldo(double saldo) {
		this.saldo += saldo;
	}
	
	public void startAplication(Scanner sc) {
	    String[] options = {"Cadastrar Saldo", "Cadastrar Despesas", "Visualizar Saldo", "Sair"};
	    int choice = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION,JOptionPane.DEFAULT_OPTION, null, options, null);
		switch (choice) {
		case 0:		
			double saldo = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja Adicionar",0));	
			addSaldo(saldo);
			String infrmacaoSaldo = toString();
			JOptionPane.showMessageDialog(null,"Saldo inserido com sucesso\n" + infrmacaoSaldo);
			startAplication(sc);
			break;
			
		case 1:
			cadastrarDespesa(sc);			
			break;
			
		case 2:
			infrmacaoSaldo = toString();
			JOptionPane.showMessageDialog(null,infrmacaoSaldo);
			startAplication(sc);
			break;
			
		case 3:
			JOptionPane.showMessageDialog(null, "Agradecemos por usar nossa aplicação!!");
			break;
			
		default:
			System.out.println("\nInforme um valor valido!!");
			startAplication(sc);
		}

	}
	public void novaCompra(Scanner sc) {
		String[] options = {"Sim", "Nao"};
	    int escolha = JOptionPane.showOptionDialog(null, "Deseja fazer uma nova compra?", "Nova Compra", JOptionPane.DEFAULT_OPTION,JOptionPane.DEFAULT_OPTION, null, options, null);
		switch (escolha) {
		case 0:
			cadastrarDespesa(sc);
			break;
		case 1:
			startAplication(sc);
			break;
		default:
			break;
		}
	}
	
	public void cadastrarDespesa(Scanner sc) {
		
		String despesa = JOptionPane.showInputDialog("Informe a descrição da despesa que deseja Adicionar"); ;
		setProduto(despesa);
		
		var saldoString = JOptionPane.showInputDialog("Informe o valor que deseja Adicionar");
		double valorDespesa = Double.parseDouble(saldoString);
		setValorDespesas(valorDespesa);
		validacao(sc);
	}
	
	public void validacao(Scanner sc) {
		if(getSaldo() >= getValorDespesas()) {
			saldo = saldo - valorDespesas;
			String infrmacaoSaldo = toString();
			JOptionPane.showMessageDialog(null,"Despesar realizada com suscesso\n" + infrmacaoSaldo);
			novaCompra(sc);
		}else {
			double diferenca =  valorDespesas - saldo;
			String informar= "Saldo insuficiente deposite R$ " + diferenca + " para realizar a compra";
			JOptionPane.showMessageDialog(null, informar);
			String infrmacaoSaldo = toString();
			JOptionPane.showMessageDialog(null,infrmacaoSaldo);
			startAplication(sc);
		}
	}
			
		public String toString(){
			return "======================================\nSaldo na conta: R$ " + getSaldo() + "\n======================================\n";
		}
}
