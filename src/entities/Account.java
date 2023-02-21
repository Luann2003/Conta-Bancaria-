package entities;

import utilitarios.Utils;

public class Account {
	
	private static int counter = 1;
	
	private int number;
	private Pessoa pessoa;
	private Double balance = 0.0;
	
	public Account() {
	}

	public Account( Pessoa pessoa) {
		this.number = counter;
		this.pessoa = pessoa;
		counter += 1;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		
		return "\nNumero da Conta: " + this.getNumber() +
			"\nNome: " + this.pessoa.getName() +
			"\nCPF: : " + this.pessoa.getCpf() +
			"\nEmail: " + this.pessoa.getEmail() +
			"\nSaldo: " + Utils.doubleTostring(this.getBalance()) +
			"\n";
	}
	
	public void deposit(Double valor) {
		balance += valor;
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getBalance() >= valor ) {
			setBalance(getBalance() - valor);
			System.out.println("Seu saque foi realizado com sucesso! ");
		}else {
			System.out.println("Não foi possivel realizar o saque! ");
		}
	}
	
	public void transferir(Account conta, double valor) {
		
		if(valor > 0 && this.getBalance() >= valor) {
			setBalance(getBalance() - valor);
			
			conta.balance = conta.getBalance() + valor;
			System.out.println("Transfêrencia realizada com sucesso!");
		}else {
			System.out.println("Não foi possivel realizar a transfêrencia! ");
		}
		
	}
	
}
