package model.entities;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {

	private int roomNumber;
	LocalDate checkIn, checkOut;

	public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException{
		LocalDate now = LocalDate.now();
		if (checkIn.isAfter(checkOut)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public int duration() {
		return Period.between(checkIn, checkOut).getDays();
	}

	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		LocalDate now = LocalDate.now();
		if (checkIn.isAfter(checkOut)) {
			throw new DomainException("Check-out date must be after check-in date.");
		}
		if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates.");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Reservation: Room " + roomNumber + ", check-in: "
				+ checkIn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", check-out: "
				+ checkOut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ", " + duration() + " nights";
	}

}

