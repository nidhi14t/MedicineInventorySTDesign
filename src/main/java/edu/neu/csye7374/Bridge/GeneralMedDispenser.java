package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.Pharmacist;

public class GeneralMedDispenser implements MedicalService {
	private Medicine medicine;
	private Pharmacist pharmacist;

	public GeneralMedDispenser(Medicine medicine, Pharmacist pharmacist) {

		this.medicine = medicine;
		this.pharmacist = pharmacist;
	}

	public void deliverMedicine() {
		System.out.println("Delivering general medicine " + medicine.getMedicineName());
		pharmacist.dispense(medicine);
	}
}
