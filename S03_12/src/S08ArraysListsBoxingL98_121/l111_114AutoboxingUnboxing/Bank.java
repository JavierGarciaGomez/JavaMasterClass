package S08ArraysListsBoxingL98_121.l111_114AutoboxingUnboxing;

import java.util.ArrayList;

public class Bank {
    // FIELDS
    private String name;
    private ArrayList<Branch> branchArrayList;

    // CONSTRUCTOR
    public Bank(String name) {
        System.out.println("BANK created: "+name);
        this.name = name;
        branchArrayList = new ArrayList<Branch>();
    }

    // GETTERS AND SETTERS

    // METHODS
    public boolean addBranch(String branchName){
        if (findBranch(branchName)==null){
            this.branchArrayList.add(new Branch(branchName));
            return true;
        }
        else return false;
    }

    public boolean addCustomer(String branchname, String customerName, double initialAmount){
        Branch branch = findBranch(branchname);
        return branch.newCustomer(customerName, initialAmount); // This method retunrs a boolean
    }

    public boolean addCustomerTransaction(String branchname, String customerName, double amount){
        Branch branch = findBranch(branchname);
        if(branch!=null){
            return branch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for(Branch b: branchArrayList){
            if(b.getName().equals(branchName)){
                return b;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch!=null){
            System.out.println("Customers for branch "+branch.getName()+":");
            if (showTransactions==true){
                branch.listCustomersWithTransactions();
            } else{
                branch.listCustomer();
            }
            return true;
        }
        return false;
    }
}
