package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room: ");
		int quarto = sc.nextInt();
		System.out.print("Data check-in: ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Data check-out: ");
		Date checkout = sdf.parse(sc.next());
		
		
		if (! checkout.after(checkin)) {
			System.out.println("Check-out precisa ser posterior a check-in");
		}
		else {
			Reserva reserva = new Reserva(quarto, checkin, checkout);
			System.out.println("Reserva:"+reserva.toString());
			
			System.out.println("--------");
			System.out.println("Entre com a atualização das reservas, novas datas.....");
			System.out.print("Room: ");
			quarto = sc.nextInt();
			System.out.print("Data check-in: ");
			checkin = sdf.parse(sc.next());
			System.out.print("Data check-out: ");
			checkout = sdf.parse(sc.next());
			
			if (checkin.before(new Date()) || checkout.before(new Date())){
				System.out.println("Data da reserva precisa data futura");
			}
			else {
				if (! checkout.after(checkin)) {
					System.out.println("Check-out precisa ser posterior a check-in");
				}
				else {
					
					reserva.atualizaData(checkin, checkout);
					System.out.println("Reserva: "+reserva.toString());
					
				}
				
			}
			
		}
		
		sc.close();

	}

}
