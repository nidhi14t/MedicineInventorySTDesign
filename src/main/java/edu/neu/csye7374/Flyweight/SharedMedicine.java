package edu.neu.csye7374.Flyweight;


public class SharedMedicine implements MedicineFlyweight {
	private String storageCondition;
	private String prescriptionRequired;
	// Other shared attributes

	public SharedMedicine(String storageCondition, String prescriptionRequired) {
		this.storageCondition = storageCondition;
		this.prescriptionRequired = prescriptionRequired;
	}

	@Override
	public void displayInfo() {
		System.out.println("Is Medicine Prescription Required: " + prescriptionRequired);
		System.out.println("What is Medicine Storage Condition: " + storageCondition);
		// can add other share data
	}
}
