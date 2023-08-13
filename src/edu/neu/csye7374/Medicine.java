package edu.neu.csye7374;

import java.time.LocalDate;

import edu.neu.csye7374.Flyweight.MedicineFlyweight;

public class Medicine {
	private String medicineId;
	private String medicineName;
	private int quantity;
	public double medicinePrice;
	public MedicineCategory medicineCategory;
	public String medicineManufacturer;
	private LocalDate expirationDate;

	// Using Flyweight Design Pattern
	private MedicineFlyweight sharedInfo;

	// Constructor
	public Medicine(String medicineId, String medicineName, int quantity, LocalDate expirationDate) {
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
	}

	public Medicine(String id, MedicineFlyweight sharedInfo, LocalDate expirationDate, int quantity) {
		this.medicineId = id;
		this.sharedInfo = sharedInfo;
		this.expirationDate = expirationDate;
		this.quantity = quantity;
		// Initialize other non-shared attributes
	}

	// Getters and setters for the properties

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public MedicineCategory getMedicineCategory() {
		return medicineCategory;
	}

	public void setMedicineCategory(MedicineCategory medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	public String getMedicineManufacturer() {
		return medicineManufacturer;
	}

	public void setMedicineManufacturer(String medicineManufacturer) {
		this.medicineManufacturer = medicineManufacturer;
	}

	// Display Medicine Info using Flyweight Design Pattern (Shared Info + Med Info)
	public void displayInfo() {
		System.out.println("Medicine ID: " + medicineId);
		sharedInfo.displayInfo(); // Display shared attributes
		System.out.println("Expiration Date: " + expirationDate);
		System.out.println("Quantity: " + quantity);
		System.out.println("Quantity: " + medicinePrice);
		// Display other non-shared attributes
	}

}
