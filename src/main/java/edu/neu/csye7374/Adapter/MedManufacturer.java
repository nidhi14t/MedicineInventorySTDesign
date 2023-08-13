package edu.neu.csye7374.Adapter;

import java.io.Serializable;

public class MedManufacturer implements Cloneable {

	private static MedManufacturer instance;

	private String medmanufacturerName;
	private int totalyearsOfManufacturing;
	private int allproductsManufactured;

    public static void setInstance(MedManufacturer instance) {
        MedManufacturer.instance = instance;
    }
     


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

	public MedManufacturer setMedmanufacturerName(String medmanufacturerName) {
		this.medmanufacturerName = medmanufacturerName;
	 return this;
        }

	public int getTotalyearsOfManufacturing() {
		return totalyearsOfManufacturing;
	}
        public MedManufacturer setTotalyearsOfManufacturing(int yearsOfManufacturing) {
        this.totalyearsOfManufacturing = yearsOfManufacturing;
        return this;
    }

//	public void setTotalyearsOfManufacturing(int totalyearsOfManufacturing) {
//		this.totalyearsOfManufacturing = totalyearsOfManufacturing;
//	}

	public int getAllproductsManufactured() {
		return allproductsManufactured;
	}

	public MedManufacturer setAllproductsManufactured(int allproductsManufactured) {
		this.allproductsManufactured = allproductsManufactured;
                return this;
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
