package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reserva;
import exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.print("Room: ");
			int quarto = sc.nextInt();
			System.out.print("Data check-in: ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Data check-out: ");
			Date checkout = sdf.parse(sc.next());
			
			
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
			
			reserva.atualizaData(checkin, checkout);
			System.out.println("Reserva: "+reserva);
			
			sc.close();
		}
		catch (ParseException e){
			System.out.println("Data invalida");
			
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: "+e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado: "+e.getCause());
		}

	}

}
