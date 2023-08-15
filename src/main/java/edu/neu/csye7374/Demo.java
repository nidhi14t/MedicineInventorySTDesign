package edu.neu.csye7374;

import edu.neu.csye7374.Adapter.MedManufacturer;
import edu.neu.csye7374.Adapter.MedManufacturerAdapterObject;
import edu.neu.csye7374.Bridge.GeneralMedDispenser;
import edu.neu.csye7374.Bridge.MedicalService;
import edu.neu.csye7374.Bridge.NamedMedDispenser;
import edu.neu.csye7374.Builder.MedBuilder;
import edu.neu.csye7374.Builder.PharmacistBuilder;
import edu.neu.csye7374.Command.Invoker;
import edu.neu.csye7374.Decorator.GiftcardDecorator;
import edu.neu.csye7374.Decorator.HealthKitDecorator;
import edu.neu.csye7374.Facade.DeliveryType;
import edu.neu.csye7374.Facade.PharmacyFacade;
import edu.neu.csye7374.Factory.MedicineFactory;
import edu.neu.csye7374.Flyweight.MedicineFlyweight;
import edu.neu.csye7374.Flyweight.SharedMedicine;
import edu.neu.csye7374.Observer.Order;
import edu.neu.csye7374.Prototype.HomeStoreDelivery;
import edu.neu.csye7374.Prototype.StorePickUp;
import edu.neu.csye7374.Strategy.DiscountStrategy;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main() {

        //Test for builder pattern - using factory and singleton
        System.out.println("******************* Builder design pattern******************* ");
        Pharmacy pharmacy = new Pharmacy("My Pharmacy");
        // Add some medicines
        Medicine paracetamol = new MedBuilder(1, "Paracetamol",
                10.0, MedicineCategory.OverTheCounter, "ABC Pharma")
                .buildObject();
        Medicine amoxicillin = new MedBuilder(2,"Amoxicillin", 20.0,
                MedicineCategory.Prescription, "XYZ Pharma")
                .buildObject();
        Medicine nyquil = new MedBuilder(2,"Nyquil", 20.0,
                MedicineCategory.Prescription, "ABC Pharma")
                .buildObject();
        pharmacy.itemList.add(paracetamol);
        pharmacy.itemList.add(amoxicillin);

        // Add some employees
        Pharmacist pharmacist1 = new PharmacistBuilder(1,  "Nidhi", "Tiwari",30, 5000.0);
        Pharmacist pharmacist2 = new PharmacistBuilder(2,  "Sakshi", "Nayak",25, 15000.0);
        Pharmacist pharmacist3 = new PharmacistBuilder(3,  "Prasanth", "Dwadasi",27, 25000.0);
        pharmacy.personList.add(pharmacist1);
        pharmacy.personList.add(pharmacist2);
        pharmacy.personList.add(pharmacist3);

        // Print out pharmacy details
        System.out.println("Pharmacy Name: " + pharmacy.name);
        System.out.println("Medicines:");
        for (Medicine medicine : pharmacy.itemList) {
            System.out.println(medicine.medicineName + " (" + medicine.medicineCategory + ")");
        }
        System.out.println("Employees:");
        for (Person person : pharmacy.personList) {
            if (person instanceof Pharmacist) {
                Pharmacist pharmacist = (Pharmacist) person;
                System.out.println(pharmacist.getFirstName() + " " + pharmacist.getLastName() + " (Pharmacist)");
            }
        }

        //Facade design pattern
        System.out.println("******************* Facade design pattern******************* ");
        PharmacyFacade pharmacyFacade = new PharmacyFacade("My Pharmacy");
        MedBuilder medicineBuilder = new MedBuilder(1, "Paracetamol",
                10.0, MedicineCategory.OverTheCounter, "ABC Pharma");
        pharmacyFacade.addMedicine(medicineBuilder);

        MedBuilder medicineBuilder1 = new MedBuilder(2,"Amoxicillin", 20.0,
                MedicineCategory.Prescription, "XYZ Pharma");
        pharmacyFacade.addMedicine(medicineBuilder1);

        PharmacistBuilder pharmacistBuilder = new PharmacistBuilder(1, "Nidhi",
                "Tiwari", 25, 50000);
        pharmacyFacade.addPharmacist(pharmacistBuilder);
        PharmacistBuilder pharmacistBuilder1 = new PharmacistBuilder(2, "Sakshi",
                "Nayak", 27, 100000);
        pharmacyFacade.addPharmacist(pharmacistBuilder1);
        //Sorting the added medicines and employees
        pharmacyFacade.sortMedicines(pharmacyFacade.pharmacy);
        pharmacyFacade.sortEmployees();

        // Decorator Design Pattern
        System.out.println("******************* Decorator Design Pattern *******************");
        MedicineAPI decoratorMedicine;
        decoratorMedicine= new GiftcardDecorator(paracetamol);
        System.out.println("Gift card has been added :\n"+decoratorMedicine.medDescription());
        decoratorMedicine= new HealthKitDecorator(decoratorMedicine);
        System.out.println("Health Kit has been added:"+decoratorMedicine.medDescription());

        //Test for command pattern
        System.out.println("******************* Command Design Pattern *******************");
        List<Medicine> medicinelist = new ArrayList<>();
        //creating medicine list before testing

        medicinelist.add(paracetamol);
        medicinelist.add(nyquil);
        medicinelist.add(amoxicillin);

        Invoker invoker = new Invoker();
        invoker.placeOrder(medicinelist);
        invoker.subscribeOrder(medicinelist);

        //Bridge design pattern
        System.out.println("******************* Bridge design pattern******************* ");
        Pharmacist pharmacist = new Pharmacist();
        MedicalService brandedDispenser = new NamedMedDispenser(paracetamol, pharmacist);
        brandedDispenser.deliverMedicine();
        MedicalService genericDispenser = new GeneralMedDispenser(amoxicillin, pharmacist);
        genericDispenser.deliverMedicine();

        //Test for prototype pattern
        System.out.println("******************* Prototype Design Pattern *******************");
        Order orderForPrototype = new Order();
        orderForPrototype.setDeliveryType(DeliveryType.Delivery);
        HomeStoreDelivery homeDelivery = new HomeStoreDelivery(1, "Home Delivery", 10.0, orderForPrototype);
        System.out.println(homeDelivery.toString());
        HomeStoreDelivery homeDelivery2 = homeDelivery.clone();
        homeDelivery2.setDeliveryType("Home Delivery 2");
        homeDelivery2.setDeliveryCost(40.0);
        System.out.println(homeDelivery2.toString());

        StorePickUp storePickUp = new StorePickUp(1, "Store Pick Up", 0.0, orderForPrototype);
        System.out.println(storePickUp.toString());
        StorePickUp storePickUp2 = storePickUp.clone();
        storePickUp2.setDeliveryType("Store Pickup 2");
        storePickUp2.setDeliveryCost(0.0);
        System.out.println(storePickUp2.toString());

        //Test observer and state design pattern
        System.out.println("******************* Observer Design Pattern *******************");
        // Create a new Order
        Order order = new Order();
        order.setDeliveryType(DeliveryType.Delivery);
        // Add Medicine to the Order
        System.out.println("Adding Medicine1 to the order...");
        order.addMedicine(paracetamol);
        System.out.println(order);
        // Add Medicine2 to the Order
        System.out.println("\nAdding Medicine2 to the order...");
        order.addMedicine(amoxicillin);
        System.out.println(order);
        // Add Medicine3 to the Order
        System.out.println("\nAdding Medicine3 to the order...");
        order.addMedicine(nyquil);
        System.out.println("******************* State Design Pattern *******************");

        System.out.println(order);
        order.orderConfirmed();
        order.orderDelivered();
        order.orderDispatched();
        order.orderDelivered();
        order.closeOrder();

        //Test for strategy design pattern
        System.out.println("******************* Strategy Design Pattern *******************");
        System.out.println("Medicine \""+paracetamol.getMedicineName()+"\" price before discount "+paracetamol.getMedicinePrice());
        double price;
        for(DiscountStrategy strategy : Pharmacy.getStrategyAPIMap().keySet()){
            pharmacy.setStrategy(strategy);
            price= paracetamol.runStrategy();
            System.out.println("Price of \""+paracetamol.getMedicineName()+"\" after "+strategy+" :"+price);
        }

        //Test for adapter pattern
        System.out.println("******************* Adapter Design Pattern *******************");
        MedBuilder medicineBuilder2 = new MedBuilder(1, "Dolo", 10, MedicineCategory.OverTheCounter, "abc labs");
        MedicineAPI medicine= MedicineFactory.getInstance().getObject(medicineBuilder2);
        System.out.println(medicine);
        MedManufacturer manufacturer = MedManufacturer.getInstance().clone();
        manufacturer.setMedmanufacturerName("abc labs")
                .setTotalyearsOfManufacturing(52)
                .setAllproductsManufactured(10);
        MedManufacturerAdapterObject manufacturerAdapter = new MedManufacturerAdapterObject(medicine,manufacturer);
        System.out.println(medicine);
        System.out.println("***Demonstrating of Adapter pattern to adapt manufacturer legacy class with Medicine Interface and printing their object***");
        System.out.println(manufacturerAdapter);
        
        System.out.println("******************* Flyweight Design Pattern *******************");
        
        // Create and display multiple medicine instances
        MedicineFlyweight med1 = new SharedMedicine("Dry", "Yes");
        med1.displayInfo();

        System.out.println("===========");

        MedicineFlyweight med2 = new SharedMedicine("Cool", "No");
        med2.displayInfo();

        System.out.println("===========");

        // Reuse the shared instance
        MedicineFlyweight med3 = new SharedMedicine("Dry", "Yes");
        med3.displayInfo();
	}
}
