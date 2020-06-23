package S08ArraysListsBoxingL98_121.l111_114AutoboxingUnboxing;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customerArrayList;

    public Branch(String nombre) {
        this.name = nombre;
        this.customerArrayList = new ArrayList<Customer>();
    }

    // GETTERs
    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }


    // METHODS

    public boolean newCustomer(String customerName, double initialAmmount) {
        if (findCustomer(customerName) == null) { // Check if there is a previous customer with that name
            this.customerArrayList.add(new Customer(customerName, initialAmmount));
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        if (findCustomer(customerName) != null) { // Check if there is a previous customer with that name
            Customer existingCustomer = findCustomer(customerName);
            existingCustomer.addTransaction(amount);
            return true;
        } else {
            return false;
        }
    }

    private Customer findCustomer(String customerName) {
        for (Customer c : customerArrayList) {
            if(c.getName().equals(customerName)){
                return c;
            }
        }
        return null;
    }

    public void addCustomer(Customer c) {
        customerArrayList.add(c);
    }

    public void listCustomer() {
        for (Customer c : customerArrayList
        ) {
            System.out.println(c.getName());

        }
    }

    public void listCustomersWithTransactions(){
        for (Customer c:customerArrayList) {
            System.out.println(c.getName());
            c.listTransactions();
        }

    }
}
