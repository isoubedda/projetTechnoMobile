package fr.technomobile.shareexpenses.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class GroupModel implements Parcelable
{
    private String name;
    private ArrayList<ContactModel> contacts = new ArrayList<ContactModel>();
    private ArrayList<DepenseModel> depense = new ArrayList<DepenseModel>();

    public GroupModel(String name) {
        this.name = name;
    }

    protected GroupModel(Parcel in) {
        name = in.readString();
        in.readTypedList(contacts, ContactModel.CREATOR);
    }

    public static final Creator<GroupModel> CREATOR = new Creator<GroupModel>() {
        @Override
        public GroupModel createFromParcel(Parcel in) {
            return new GroupModel(in);
        }

        @Override
        public GroupModel[] newArray(int size) {
            return new GroupModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ContactModel> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<ContactModel> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<DepenseModel> getDepense() {
        return depense;
    }

    public void setDepense(ArrayList<DepenseModel> depense) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeTypedList(contacts);
    }
}