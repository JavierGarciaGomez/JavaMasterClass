package S08ArraysListsBoxingL98_121.l111_114AutoboxingUnboxing;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;
    private double balance;

    public Customer (String name, double initialAmount){
        this.name=name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }

    // Getters

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }


    // Methods

    public void addTransaction(double amount){
        this.transactions.add(amount);
    }

    public void listTransactions(){
        for(Double transaction: transactions){
            System.out.println("Transacción: "+transaction);
        }
    }


}
