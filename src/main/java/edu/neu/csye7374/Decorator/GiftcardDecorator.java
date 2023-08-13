package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Decorator.MedicineDecorator;
import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.MedicineAPI;

public class GiftcardDecorator extends MedicineDecorator {

    public GiftcardDecorator(MedicineAPI decoratedMedicine) {
        super(decoratedMedicine);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String medDescription() {
        // TODO Auto-generated method stub
        return decoratorMedicine.medDescription()+ " + Free Gift Card of $10";
    }

    @Override
    public String medManufacturer() {
        return decoratorMedicine.medManufacturer(); }
    

    @Override
    public double medPrice() {
        Medicine b = Medicine.class.cast(decoratorMedicine);
        return b.getMedicinePrice()+10; }
    
}
