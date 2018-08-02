package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Comment;
import entities.CompanyPayer;
import entities.Department;
import entities.HourContract;
import entities.ImportedProduct;
import entities.IndividualPayer;
import entities.Order;
import entities.Order1;
import entities.OrderItem;
import entities.Payer;
import entities.Post;
import entities.Product;
import entities.UsedProduct;
import entities.Worker;
import entities.enums.OrderStatus;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		List<Payer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double income = sc.nextDouble();
			
			if (c == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				list.add(new IndividualPayer(name, income, healthExpenditures));
			}
			
			if (c == 'c') {
				System.out.print("Number of employees: ");
				Integer numberEmployees = sc.nextInt();
				list.add(new CompanyPayer(name, income, numberEmployees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		Double sum = 0.0;
		for(Payer p : list) {
			System.out.println(p);
			sum += p.tax();
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + sum);
		sc.close();
	}

	public static void exercicioHeranca1() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		List<Product> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			char c;
			do {
				System.out.print("Common, used or imported (c/u/i)? ");
				c = sc.next().charAt(0);
				if (c != 'c' && c != 'u' && c != 'i') {
					System.out.println("Enter the correct character (c/u/i)");
				}
			} while (c != 'c' && c != 'u' && c != 'i');
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			if (c == 'c') {
				list.add(new Product(name, price));
			} else if (c == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			} else if (c == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS");
		for (Product p : list) {
			System.out.println(p.priceTag());
		}

		sc.close();
	}

	public static void aprendendoStringBuilder() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("Wow that's awesome!");
		Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"), "Traveling to the New Zealand",
				"I'm going to visit this wonderful country!", 12);
		p1.addComment(c1);
		p1.addComment(c2);

		Comment c3 = new Comment("Good night");
		Comment c4 = new Comment("May the Force be with you");
		Post p2 = new Post(sdf.parse("28/07/2018 23:14:19"), "Good night guys", "See you tomorrow", 5);
		p2.addComment(c3);
		p2.addComment(c4);

		System.out.println(p1);

		System.out.println(p2);
	}

	public static void composicao2() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		Date moment = new Date();
		Order1 order = new Order1(moment, OrderStatus.valueOf(status), new Client(name, email, birthDate));

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			order.addItem(new OrderItem(productQuantity, productPrice, new Product(productName, productPrice)));
		}

		System.out.println();
		System.out.println(order);
		sc.close();
	}

	public static void resolvido1() throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
				new Department(departmentName));

		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();
	}

	public static void exemploComposicao1() {
		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);

		System.out.println(order);

		OrderStatus os1 = OrderStatus.DELIVERED;

		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

		System.out.println(os1);
		System.out.println(os2);
	}
}
