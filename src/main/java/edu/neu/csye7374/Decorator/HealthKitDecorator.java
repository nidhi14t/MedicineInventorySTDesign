package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.MedicineAPI;

public class HealthKitDecorator extends MedicineDecorator {
    public HealthKitDecorator(MedicineAPI decoratorMedicine) {
        super(decoratorMedicine);
    }
    @Override
    public String medDescription() {
    return super.medDescription() + " + Free HealthKit Subscription for a month";
    }
    

    @Override
    public String medManufacturer() {
         return decoratorMedicine.medManufacturer();
    }

    @Override
    public int totalMedicinesManufactured() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double medPrice() {
         Medicine b = Medicine.class.cast(decoratorMedicine);
        return b.getMedicinePrice()+10;
    }
    
     @Override
    public MedicineAPI getDecoratorMedicine() {
        return super.getDecoratorMedicine();
    }
      @Override
    public String toString() {
        return super.toString();
    }
}
