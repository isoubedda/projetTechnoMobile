package fr.technomobile.shareexpenses.model;

public class ContactModel {
    private long id_contact;
    private String name;
    private int benefit;
    private int money;


    public ContactModel(long id_contact, String name)
    {
        this.id_contact = id_contact;
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

}
