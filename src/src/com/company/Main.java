/*
Project: Team Project Design
Purpose Details: Car Dealership Create the Java Classes
Course: IST 242
Author: Team 5 all members
Date Developed: 4/29/2019
Last Date Changed: 4/29/2019
Revision: Final
*/

package com.company;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    int custcount = 0;
    int carCount = 0;
    int partCount = 0;
    int leadCount = 0;

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sale = new Scanner(System.in);
        ArrayList<Cars> carList = new ArrayList<>();
        ArrayList<Parts> partList = new ArrayList<>();
        ArrayList<Customers> custList = new ArrayList<>();
        ArrayList<SalesLeads> salesList = new ArrayList<>();

        Scanner menuChoice = new Scanner(System.in);
        int mainMenu;
        try {
            do {

                System.out.println("\nWhat would you like to do within the dealership?\n1: Add Car to Inventory\n2: Add Part to Inventory\n3: Enter New Customer\n4: See Customers\n5: See Inventory\n6: New Sales Lead\n7: View Sales Leads\n8: Make Sale\n9: Leave Application");
                mainMenu = menuChoice.nextInt();

                switch (mainMenu) {
                    case 1:
                        System.out.println("Enter New Car:\n");
                        carList.add(main.addCar());
                        System.out.println("New Car Added to Inventory");
                        break;
                    case 2:
                        System.out.println("Add New Part:\n");
                        partList.add(main.addPart());
                        break;
                    case 3:
                        System.out.println("Add New Customer:\n");
                        Customers.listCustomers(custList);
                        System.out.println();
                        custList.add(main.addCustomer());
                        break;
                    case 4:
                        System.out.println("See Customers:\n");
                        Customers.listCustomers(custList);
                    case 5:
                        System.out.println("See Inventory\n");
                        System.out.println("Cars:\n");
                        Cars.listCars(carList);
                        System.out.println("\nParts:\n");
                        Parts.listParts(partList);
                        break;
                    case 6:
                        System.out.println("Add New Sales Lead\n");
                        salesList.add(main.addSalesLead());
                        System.out.println("New Sales Lead Added");
                        break;
                    case 7:
                        System.out.println("Sales Leads:\n");
                        SalesLeads.listSalesLeads(salesList);
                        break;
                    case 8:
                        System.out.println("Make Sale:\n");
                        System.out.println("Choose the Sales Lead ID Number to be Fulfilled:");
                        SalesLeads.listSalesLeads(salesList);
                        System.out.println();
                        System.out.print("ID: ");
                        int saleNum = sale.nextInt();
                        salesList.get(saleNum).setSalesLeadActive(false);
                        System.out.println("Choose the car ID of the car that was sold:");
                        Cars.listCars(carList);
                        System.out.print("\nCar ID: ");
                        int carNum = sale.nextInt();
                        carList.remove(carNum);
                        System.out.println("Car " + saleNum + " sold and removed from inventory");
                        break;
                    case 9:
                        System.out.println("Exited Application");
                        break;
                    default:
                        System.out.println("Invalid Input, Please Try Again!");
                        break;
                }
            } while (mainMenu != 9);
        }
        catch (InputMismatchException ime) {
            System.out.println("Invalid Input, Please Try Again!");
        }
        catch (NullPointerException npe) {
            System.out.println("Option is invalid or dealership entry does not exist.");
        }
        catch (Exception e) {
            System.out.println("Dealership Application can not execute command");
        }
    }

    /**
     * @author IST 242: Team 5
     * @since Spring 2019
     * @version 3.0
     * @return car - New Car
     * @throws InputMismatchException
     */

    public Cars addCar() throws InputMismatchException{
        try {
            Cars car;
            Scanner scnr = new Scanner(System.in);
            System.out.println("Please enter the make:");
            String make = scnr.nextLine();
            System.out.println("Please enter the model:");
            String model = scnr.nextLine();
            System.out.println("Please enter the year:");
            int year = scnr.nextInt();
            System.out.println("Please enter the color:");
            String color = scnr.next();
            System.out.println("Please enter the MPG:");
            int MPG = scnr.nextInt();
            System.out.println("Please enter the horsePower:");
            int hp = scnr.nextInt();
            System.out.println("Please enter the Vin:");
            int vin = scnr.nextInt();
            System.out.println("Please enter the MSRP:");
            double MSRP = scnr.nextDouble();
            System.out.println("Please enter the Dealer Price:");
            double dealPrice = scnr.nextDouble();
            car = new Cars(carCount++, make, model, year, color, MPG, hp, vin, MSRP, dealPrice);
            return car;
        }
        catch(InputMismatchException ime) {
            System.out.println("Invalid Input! Please Try Again and Enter the Appropriate Value!");
            return null;
        }
    }

    /**
     * @author IST 242: Team 5
     * @since Spring 2019
     * @version 3.0
     * @return part - New Part
     * @throws InputMismatchException
     */

    public Parts addPart() throws InputMismatchException{
        try {
            Parts part;
            Scanner scnr = new Scanner(System.in);
            System.out.println("Please enter the part name:");
            String partName = scnr.nextLine();
            System.out.println("Please enter the part type:");
            String partType = scnr.nextLine();
            part = new Parts(partCount++, partName, partType);
            return part;
        }
        catch(InputMismatchException ime) {
            System.out.println("Invalid Input! Please Try Again and Enter the Appropriate Value!");
            return null;
        }
    }

    /**
     * @author IST 242: Team5
     * @since Spring 2019
     * @version 3.0
     * @return cust - New Customer
     * @throws InputMismatchException
     */

    public Customers addCustomer() throws InputMismatchException{
        try {
            Scanner scnr = new Scanner(System.in);
            Customers cust;
            System.out.println("Enter Customer First Name");
            String firstName = scnr.nextLine();
            System.out.println("Enter Customer Last name");
            String lastName = scnr.nextLine();
            System.out.println("Enter Customer Address:");
            String address = scnr.nextLine();
            System.out.println("Enter Customer Phone:");
            String phone = scnr.nextLine();
            System.out.println("Enter Customer Email:");
            String email = scnr.nextLine();
            System.out.println("Enter Customer SSN:");
            String ssn = scnr.nextLine();
            cust = new Customers(custcount++, firstName, lastName, address, phone, email, ssn);
            return cust;
        }
        catch(InputMismatchException ime) {
            System.out.println("Invalid Input! Please Try Again and Enter the Appropriate Value!");
            return null;
        }
    }

    /**
     * @author IST 242: Team 5
     * @since Spring 2019
     * @version 3.0
     * @return newLead - New Sales Lead
     * @throws InputMismatchException
     */

    public SalesLeads addSalesLead() throws InputMismatchException{
        try {
            Scanner scnr = new Scanner(System.in);
            SalesLeads newLead;

            System.out.println("Please enter the employee ID:");
            int empID = scnr.nextInt();
            System.out.println("Please enter the employee's first name:");
            String empFirst = scnr.next();
            System.out.println("Please enter the employee's last name:");
            String empLast = scnr.next();
            System.out.println("Please enter the customer's first name:");
            String custFirst = scnr.next();
            System.out.println("Please enter the customer's last name:");
            String custLast = scnr.next();
            System.out.println("Please enter the commission being gained:");
            double commission = scnr.nextDouble();
            System.out.println("Please enter the Sales Date:");
            String saleDate = scnr.next();
            System.out.println("Please enter the MSRP:");
            double msrp = scnr.nextDouble();
            System.out.println("Sales Lead Active? ('true' or 'false'):");
            boolean leadActive = scnr.nextBoolean();
            newLead = new SalesLeads(leadCount++, empID, empFirst, empLast, custFirst, custLast, commission, saleDate, msrp, leadActive);
            return newLead;
        } catch (InputMismatchException ime) {
            System.out.println("Invalid Input! Please Try Again and Enter the Appropriate Value!");
            return null;
        }
    }
}