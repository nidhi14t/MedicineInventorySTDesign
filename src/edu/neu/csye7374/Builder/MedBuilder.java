package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Factory.MedicineFactory;
import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.MedicineCategory;

public class MedBuilder implements BuilderAPI<Medicine> {
	public int medId;
	public String medName;
	public double medPrice;

	public MedicineCategory medCategory;

	public String medManufacturer;

	public String getMedManufacturer() {
		return medManufacturer;
	}

	public void setMedManufacturer(String medManufacturer) {
		this.medManufacturer = medManufacturer;
	}

	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public double getMedPrice() {
		return medPrice;
	}

	public void setMedPrice(double medPrice) {
		this.medPrice = medPrice;
	}

	public MedicineCategory getMedCategory() {
		return medCategory;
	}

	public void setMedCategory(MedicineCategory medCategory) {
		this.medCategory = medCategory;
	}

	public MedBuilder(int medId, String medName, double medPrice, MedicineCategory medCategory,
			String medManufacturer) {
		super();
		this.medId = medId;
		this.medName = medName;
		this.medManufacturer = medManufacturer;
		this.medPrice = medPrice;
		this.medCategory = medCategory;
	}

	@Override
	public Medicine buildObject() {
		return MedicineFactory.getInstance().getObject(this);
	}
}
