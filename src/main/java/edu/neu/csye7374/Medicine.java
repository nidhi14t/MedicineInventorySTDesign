package edu.neu.csye7374;

import edu.neu.csye7374.Builder.MedBuilder;
import java.time.LocalDate;
import edu.neu.csye7374.Strategy.DiscountStrategy;

import edu.neu.csye7374.Flyweight.MedicineFlyweight;

public class Medicine implements MedicineAPI {
	public int medicineId;
	public String medicineName;
	public int quantity;
	public double medicinePrice;
	public MedicineCategory medicineCategory;
	public String medicineManufacturer;
	public LocalDate expirationDate;

	// Using Flyweight Design Pattern
	private MedicineFlyweight sharedInfo;

	// Constructor
	public Medicine(int medicineId, String medicineName, int quantity, LocalDate expirationDate) {
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
	}

	public Medicine(int id, MedicineFlyweight sharedInfo, LocalDate expirationDate, int quantity) {
		this.medicineId = id;
		this.sharedInfo = sharedInfo;
		this.expirationDate = expirationDate;
		this.quantity = quantity;
		// Initialize other non-shared attributes
	}

	// Getters and setters for the properties

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
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

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public MedicineCategory getMedicineCategory() {
		return medicineCategory;
	}

	public void setMedicineCategory(MedicineCategory medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	public String getMedicineManufacturer() {
		return medicineManufacturer;
	}

	public void setMedicineManufacturer(String medicineManufacturer) {
		this.medicineManufacturer = medicineManufacturer;
	}

	// Display Medicine Info using Flyweight Design Pattern (Shared Info + Med Info)
	public void displayInfo() {
		System.out.println("Medicine ID: " + medicineId);
		sharedInfo.displayInfo(); // Display shared attributes
		System.out.println("Expiration Date: " + expirationDate);
		System.out.println("Quantity: " + quantity);
		System.out.println("Quantity: " + medicinePrice);
		// Display other non-shared attributes
	}

    @Override
    public String medDescription() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String medManufacturer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int totalMedicinesManufactured() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double medPrice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    //Command Pattern
    public String buyMedicine(){
        return this.medicineName+" has been purchased"; //+"\n Price now ="+this.medicinePrice;
    }
    //Command Pattern
    //5% discount on subscribing to a medicine
    public String subscribeMedicine(){
        this.medicinePrice= this.medicinePrice * 0.95;
        return this.medicineName+ " has been added to your subscription list and you will get 5% discount on it from now onwards.";//+"\n Price now ="+this.medicinePrice;
    }

    public Medicine(MedBuilder medicineBuilder){
        super();
        this.medicineId = medicineBuilder.medId;
        this.medicineName = medicineBuilder.medName;
        this.medicinePrice = medicineBuilder.medPrice;
        this.medicineManufacturer = medicineBuilder.medManufacturer;
        this.medicineCategory = medicineBuilder.medCategory;
    }
    public Medicine(int medicineId, String medicineName,
                    double medicinePrice, String medicineManufacturer, MedicineCategory medicineCategory) {
        super();
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.medicineManufacturer = medicineManufacturer;
        this.medicineCategory = medicineCategory;
    }

    public double runStrategy() {
        double value = 0;
        switch (Pharmacy.getStrategy()) {
            case EMPLOYEE_DISCOUNT -> {
                value = Pharmacy.getStrategyAPIMap().get(DiscountStrategy.EMPLOYEE_DISCOUNT).calculatePrice(this);
                break;
            }
            case STUDENT_DISCOUNT -> {
                value = Pharmacy.getStrategyAPIMap().get(DiscountStrategy.STUDENT_DISCOUNT).calculatePrice(this);
                break;
            }
            case MEMBERSHIP_DISCOUNT -> {
                value = Pharmacy.getStrategyAPIMap().get(DiscountStrategy.MEMBERSHIP_DISCOUNT).calculatePrice(this);
                break;
            }
            default -> {
                value = medicinePrice;
            }
        }
        return value;
    }
    @Override
    public String toString() {
        return "Medicine{" +
                "medicineName='" + medicineName + '\'' +
                ", medicinePrice=" + medicinePrice +
                '}';
    }
}
