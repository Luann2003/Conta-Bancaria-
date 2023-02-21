package Application;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Account;
import entities.Pessoa;

public class Program {
	
	static Scanner sc = new Scanner (System.in);
	static ArrayList<Account> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Account>();
		operacoes();
	}
	
	public static void operacoes() {
		
		System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Ag�ncia---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma opera��o que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Op��o 1 - Criar conta   |");
        System.out.println("|   Op��o 2 - Depositar     |");
        System.out.println("|   Op��o 3 - Sacar         |");
        System.out.println("|   Op��o 4 - Transferir    |");
        System.out.println("|   Op��o 5 - Listar        |");
        System.out.println("|   Op��o 6 - Sair          |");
        
        int opera��o = sc.nextInt();
        
        switch(opera��o){
        	case 1: 
        		criarConta();
        		break;
        	case 2: 
        		depositar();
        		break;
        	case 3: 
        		sacar();
        		break;
        	case 4: 
        		transferir();
        		break;
        	case 5: 
        		listarContas();
        		break;
        	case 6: 
        		System.out.println("vlw, flw");
        		System.exit(opera��o);
        		
        		default: System.out.println("Op��o inv�lida! ");
        		operacoes();
        		break;
        }
        
	}
	
	public static void criarConta() {
		
		System.out.println("\nNome: ");
		String name = sc.next();
		
		System.out.println("\nCPF: ");
		String cpf = sc.next();
		
		System.out.println("\nEmail: ");
		String email = sc.next();
		
		Pessoa pessoa = new Pessoa(name, cpf, email);
		
		Account conta = new Account(pessoa);
		
		contasBancarias.add(conta);
		
		System.out.println("Conta criada com sucesso!");
		
		operacoes();
	}
	
	private static Account encontrarConta(int numeroC) {
		Account conta = null;
		if(contasBancarias.size() > 0) {
			for(Account c : contasBancarias) {
				if(c.getNumber() == numeroC) {
					conta = c;
				}
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("N�mero da conta: ");
		int numero = sc.nextInt();
		
		Account conta = encontrarConta(numero);
		
		if(conta != null) {
			System.out.println("Quantos voc� deseja depositar? ");
			double valorDeposito = sc.nextDouble();
			conta.deposit(valorDeposito);
			System.out.println(" Valor depositado com sucesso! ");
		}else {
			System.out.println(" Conta n�o encontrada ");
		}
		operacoes();
	}
	
	public static void sacar() {
		System.out.println("N�mero da conta: ");
		int numero = sc.nextInt();
		
		Account conta = encontrarConta(numero);
		
		if(conta != null) {
			System.out.println("Quantos voc� deseja sacar ");
			double valorsaque = sc.nextDouble();
			conta.sacar(valorsaque);
			//System.out.println(" Valor sacado com sucesso! ");
		}else {
			System.out.println(" Conta n�o encontrada ");
		}
		operacoes();	
	}
	
	public static void transferir() {
		System.out.println("N�mero da conta do remetente:  ");
		int numeroContaR = sc.nextInt();
		
		Account contaRemetente = encontrarConta(numeroContaR);
		
		if(contaRemetente != null) {
			System.out.println("N�mero da conta do destinat�rio: ");
			int numeroContaD = sc.nextInt();
			
			Account contaDestinatario = encontrarConta(numeroContaD);
			
			if(contaDestinatario != null) {
				System.out.println("Valor da transf�rencia: ");
				double valor = sc.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}else {
				System.out.println("A conta para deposito n�o foi encontrada");
			}
		}else {
			System.out.println("Conta para transf�rencia n�o encontrada");
		}
		operacoes();
	}
	
	public static void listarContas() {
		if(contasBancarias.size() > 0) {
			for(Account conta: contasBancarias) {
				System.out.println(conta);
			}
			}else{
				System.out.println("N�o h� contas cadastradas!");
		}
		operacoes();
	}
}
