package aplicacao;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.Enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print(" Digite o nome do Departamento: ");
		String departamento = sc.nextLine();
		
		System.out.printf("\n Digite a informação do Funcionario: ");
		
		System.out.printf("\n Nome: ");
		String nameF = sc.nextLine();
		
		System.out.print("\n Nivel: ");
		String LevelF = sc.nextLine();
		
		System.out.printf("\n Salário Base: ");
		double salarioBase = sc.nextDouble();
		sc.nextLine();
		
		System.out.print("\n Quantidade de contratos: ");
		int quantidadeContratos = sc.nextInt();
		sc.nextLine();
		
		Worker trabalhador = new Worker(nameF, WorkerLevel.valueOf(LevelF.toUpperCase()), salarioBase, new Department(departamento));
		
		for(int i=0; i<quantidadeContratos; i++) {
			int nc = i + 1;
			System.out.printf("\n Preencha o contrato #%d:", nc);
			System.out.printf("\n Data (DD/MM/YYYY): ");
			Date dataDoContrato = sdf.parse(sc.next());
			sc.nextLine();
			System.out.printf("\n Valor por hora: ");
			Double ValorPH = sc.nextDouble();
			sc.nextLine();
			System.out.printf("\n Duração (Horas): ");
			int horas = sc.nextInt();
			HourContract contrato = new HourContract(dataDoContrato, ValorPH, horas);
			trabalhador.addContract(contrato);
		}
		
		
		System.out.print("\n Digite o mês e ano para calcular a renda (MM/YYYY): ");
		String mesAno = sc.next();
		sc.nextLine();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.printf("\n Nome: %s", trabalhador.getNome());
		System.out.printf("\n Departamento: %s", trabalhador.getDepartment().getNome());
		System.out.printf("\n Renda para o mês %s: %.2f", mesAno, trabalhador.income(ano, mes));
		
		sc.close();

	}

}
