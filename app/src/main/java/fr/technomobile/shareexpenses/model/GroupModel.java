package fr.technomobile.shareexpenses.model;

import java.util.ArrayList;
import java.util.List;

public class GroupModel
{
    private String name;
    private List<ContactModel> contacts = new ArrayList<ContactModel>();
    private List<DepenseModel> depense = new ArrayList<DepenseModel>();

    public GroupModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    public List<DepenseModel> getDepense() {
        return depense;
    }

    public void setDepense(List<DepenseModel> depense) {
        this.depense = depense;
    }

    public void displayGroupContacts()
    {
        for(int i=0; i<this.getContacts().size(); i++)
        {
            System.out.println(this.getContacts().get(i).getName()+"\t");
        }
    }

    public double calculContactCredit(long contact_id)
    {
        double sum_credit = 0;

        for(int i = 0; i<this.getDepense().size(); i++)
        {
            sum_credit+= this.getDepense().get(i).calculContactCredit(contact_id);
        }

        return sum_credit;
    }

    public double calculContactMoney(long contact_id)
    {
        double sum_credit = 0;

        for(int i = 0; i<this.getDepense().size(); i++)
        {
            sum_credit+= this.getDepense().get(i).calculContactMoney(contact_id);
        }

        return sum_credit;
    }

    public double getBalance(long contact_id)
    {
        double balance = this.calculContactCredit(contact_id) - this.calculContactMoney(contact_id);
        return balance;
    }

}