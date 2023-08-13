package edu.neu.csye7374.Adapter;

import edu.neu.csye7374.MedicineAPI;

public class MedManufacturerAdapterObject implements MedicineAPI {

	private final MedManufacturer medmanufacturer;
	private final MedicineAPI medicine;

	public MedManufacturerAdapterObject(MedicineAPI medicine, MedManufacturer medmanufacturer) {
        this.medicine = medicine;
        this.medmanufacturer = medmanufacturer;
    }

	@Override
	public String medDescription() {
		return medicine.medDescription();
	}

	@Override
	public String medManufacturer() {
		return medmanufacturer.getMedmanufacturerName();
	}

	@Override
	public int totalMedicinesManufactured() {
		return medmanufacturer.getAllproductsManufactured();
	}

	@Override
	public double medPrice() {
		return medicine.medPrice();
	}

	@Override
	public String toString() {
		return "ManufacturerObjectAdapter{" + "medicine manufacturer=" + medmanufacturer + ", medicine=" + medicine
				+ '}';
	}
}

