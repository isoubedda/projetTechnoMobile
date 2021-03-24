package fr.technomobile.shareexpenses.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ContactModel implements Parcelable {
    private long id_contact;
    private String name;
    private int benefit;
    private int money;


    public ContactModel(long id_contact, String name)
    {
        this.id_contact = id_contact;
        this.name = name;
    }

    public ContactModel(String name)
    {
        this.name = name;
    }

    public ContactModel(long id_contact, String name, int percent) {
        this.id_contact = id_contact;
        this.name = name;
        this.benefit = percent;
    }

    public ContactModel(ContactModel contact)
    {
        this.id_contact = contact.id_contact;
        this.name = contact.name;
        this.benefit = contact.benefit;
        this.money = contact.money;
    }

    protected ContactModel(Parcel in) {
        name = in.readString();
    }

    public static final Creator<ContactModel> CREATOR = new Creator<ContactModel>() {
        @Override
        public ContactModel createFromParcel(Parcel in) {
            return new ContactModel(in);
        }

        @Override
        public ContactModel[] newArray(int size) {
            return new ContactModel[size];
        }
    };

    public long getId_contact() {
        return id_contact;
    }

    public void setId_contact(long id_contact) {
        this.id_contact = id_contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int nombre) {
        this.benefit = nombre;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
    }
}
