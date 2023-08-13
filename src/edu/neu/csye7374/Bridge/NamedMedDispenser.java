package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.Pharmacist;

public class NamedMedDispenser implements MedicalService {

	private Medicine medicine;
	private Pharmacist pharmacist;

	public NamedMedDispenser(Medicine medicine, Pharmacist pharmacist) {
		this.medicine = medicine;
		this.pharmacist = pharmacist;
	}

	public void deliverMedicine() {
		pharmacist.dispense(medicine);
	}
}
