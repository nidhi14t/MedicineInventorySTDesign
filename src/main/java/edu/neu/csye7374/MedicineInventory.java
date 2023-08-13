package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class MedicineInventory {
	private static MedicineInventory instance;

	private List<Medicine> medicines; // List to store the medicines

	// Private constructor to prevent external instantiation
	private MedicineInventory() {
		medicines = new ArrayList<>();

	}

	// Method to provide the global point of access to the instance
	public static synchronized MedicineInventory getInstance() {
		if (instance == null) {
			instance = new MedicineInventory();
		}
		return instance;
	}

	public void addMedicine(Medicine medicine) {
		medicines.add(medicine);
	}

	public void updateMedicine(Medicine medicine) {
		// Update medicine in the inventory
	}

	public void removeMedicine(String medicineId) {
		// Remove medicine from the inventory
	}

	public void showMedicine() {
		System.out.println("Medicine Inventory:");

		for (Medicine medi : medicines) {
			System.out.println("Medicine ID: " + medi.getMedicineId());
			System.out.println("Medicine Name: " + medi.getMedicineName());
			System.out.println("Quantity: " + medi.getQuantity());
			System.out.println("Expiration Date: " + medi.getExpirationDate());
			System.out.println("------------------------");
		}
	}
}
