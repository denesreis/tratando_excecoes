package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.DomainException;

public class Reserva {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reserva() {
		
	}
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  //ATENÇÃO DECLARANDO COMO STATIC PARA NÃO INSTANCIAR UM SDF A CADA INSTANCIAÇÃO DA CLASSE

	public Reserva(Integer roomNumber, Date checkin, Date checkout) {
		if(! checkout.after(checkin)) 
		{
			throw new DomainException("Check-out precisa ser posterior a check-in");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}


	public Long duracao() {
		
		long diferenca = checkout.getTime() - checkin.getTime();  //Descobrindo a diferença das datas em milisegundos
		return TimeUnit.DAYS.convert(diferenca,TimeUnit.MILLISECONDS); //Convertendo de milisegundos em dias
	}
	
	public void atualizaData(Date checkin, Date checkout) {
		
		if (checkin.before(new Date()) || checkout.before(new Date())){
			throw new DomainException("Data da reserva precisa data futura");
		}

		this.checkin = checkin;
		this.checkout = checkout;
				
	}
	
	public String toString() {
		
		return "Quarto: "+roomNumber+", checkin: "+sdf.format(checkin)
		+", checkout: "+sdf.format(checkout)
		+","+duracao()
		+" noites";
		
	}


	
	

}
