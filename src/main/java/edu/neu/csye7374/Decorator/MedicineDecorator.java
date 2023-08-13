package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.MedicineAPI;

public abstract class MedicineDecorator implements MedicineAPI {

    protected MedicineAPI decoratorMedicine;

    public MedicineDecorator(MedicineAPI decoratorMedicine) {
        this.decoratorMedicine = decoratorMedicine;
    }

 
    public MedicineAPI getDecoratorMedicine() {
        return this.decoratorMedicine;
    }


    @Override
    public String medDescription() {
        return decoratorMedicine.medDescription(); }
    


    @Override
    public int totalMedicinesManufactured() {
        return decoratorMedicine.totalMedicinesManufactured();
    }

  
     @Override
    public String toString() {
        return "MedicineDecorator{" +
                "decoratorMedicine=" + decoratorMedicine +
                '}';
    }
}
