package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);

		System.out.print("Nome do departamento: ");
		String dptName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();

		

		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();

		Address address = new Address (email, phone);
		
		Department dpt = new Department (dptName, payDay, address);

		System.out.print("Quantos funcionários tem o departamento? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i =0; i < n; i++){
			System.out.println("Dados do funcionário " +(1+i)+":");
			
			System.out.print("Nome:");
			String name = sc.nextLine();
			System.out.print("Salário: ");
			Double salary = sc.nextDouble();
			sc.nextLine();
			Employee emp = new Employee(name, salary);
			dpt.addEmployee(emp);
		}
		
		
		showReport(dpt);
		
		sc.close();

	}
	
	
	
	private static void showReport (Department dpt){
		
		System.out.println();
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.println("Departamento Vendas = " + dpt.payroll());
		System.out.println("Pagamento realizado no dia " + dpt.getPayDay());
		System.out.println("Funcionários:");
		for (Employee x : dpt.getEmployees()) {
			System.out.println(x.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dpt.getAddress().getEmail());
		
	}

}
