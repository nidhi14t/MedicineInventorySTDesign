package edu.neu.csye7374;

import java.time.LocalDate;

public class Demo {
	public static void main() {

		// Calling the getInstance() method to get the singleton instance of
		// MedicineInventory
		MedicineInventory inventorySystem = MedicineInventory.getInstance();

		// Using inventorySystem instance to call other methods of the singleton,
		// addMedicine, updateMedicine.
		inventorySystem.addMedicine(new Medicine("Med-001", "Paracetamol", 100, LocalDate.of(2024, 8, 1)));

		inventorySystem.showMedicine();

	}
}
