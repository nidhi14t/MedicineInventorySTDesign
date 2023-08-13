package edu.neu.csye7374.Adapter;

import java.io.Serializable;

public class MedManufacturer implements Serializable, Cloneable {

	private static MedManufacturer instance;

	private String medmanufacturerName;
	private int totalyearsOfManufacturing;
	private int allproductsManufactured;

	public MedManufacturer() {
		super();
	}

	public static synchronized MedManufacturer getInstance() {
		if (instance == null) {
			instance = new MedManufacturer();
		}
		return instance;
	}

	private MedManufacturer(String medmanufacturerName, int totalyearsOfManufacturing, int allproductsManufactured) {
		super();
		medmanufacturerName = medmanufacturerName;
		this.totalyearsOfManufacturing = totalyearsOfManufacturing;
		this.allproductsManufactured = allproductsManufactured;
	}

	public String getMedmanufacturerName() {
		return medmanufacturerName;
	}

	public void setMedmanufacturerName(String medmanufacturerName) {
		this.medmanufacturerName = medmanufacturerName;
	}

	public int getTotalyearsOfManufacturing() {
		return totalyearsOfManufacturing;
	}

	public void setTotalyearsOfManufacturing(int totalyearsOfManufacturing) {
		this.totalyearsOfManufacturing = totalyearsOfManufacturing;
	}

	public int getAllproductsManufactured() {
		return allproductsManufactured;
	}

	public void setAllproductsManufactured(int allproductsManufactured) {
		this.allproductsManufactured = allproductsManufactured;
	}

	@Override
	public String toString() {
		return "MedManufacturer{" + "Medicine Manufacturer Name='" + medmanufacturerName + '\''
				+ ", totalyearsOfManufacturing=" + totalyearsOfManufacturing + ", allproductsManufactured="
				+ allproductsManufactured
				+ '}';
	}

	@Override
	public MedManufacturer clone() {
		try {
			return (MedManufacturer) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError("Clone should be supported for singleton.");
		}
	}
}
