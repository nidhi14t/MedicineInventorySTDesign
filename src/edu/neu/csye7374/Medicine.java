package edu.neu.csye7374;

import java.time.LocalDate;

public class Medicine {
	private String medicineId;
	private String medicineName;
	private int quantity;
	public double medicinePrice;
//    public MedicineCategory medicineCategory;
	public String medicineManufacturer;
	private LocalDate expirationDate;

	// Constructor
	public Medicine(String medicineId, String medicineName, int quantity, LocalDate expirationDate) {
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
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

}
