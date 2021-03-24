package fr.technomobile.shareexpenses.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepenseModel
{
    private long id_depense;
    private Date date;
    private List<ContactModel> destinaires = new ArrayList<ContactModel>();
    private List<ContactModel> emetteurs = new ArrayList<ContactModel>();;
    private String titre;

    public DepenseModel(long id_depense, Date date, List<ContactModel> destinaires, List<ContactModel> emetteurs, String titre)
    {
        this.id_depense = id_depense;
        this.date = date;
        this.destinaires = destinaires;
        this.emetteurs = emetteurs;
        this.titre = titre;
    }

    public DepenseModel(long id_depense, Date date, String titre)
    {
        this.id_depense = id_depense;
        this.date = date;
        this.titre = titre;
    }

    public long getId_depense() {
        return id_depense;
    }

    public void setId_depense(long id_depense) {
        this.id_depense = id_depense;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ContactModel> getDestinaires() {
        return destinaires;
    }

    public void setDestinaires(List<ContactModel> destinaires) {
        this.destinaires = destinaires;
    }

    public List<ContactModel> getEmetteurs() {
        return emetteurs;
    }

    public void setEmetteurs(List<ContactModel> emetteurs) {
        this.emetteurs = emetteurs;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void addDestinataire(ContactModel Destinataire, int somme)
    {
        Destinataire.setBenefit(somme);
        ContactModel ds = new ContactModel(Destinataire);
        this.getDestinaires().add(ds);
    };

    public void addEmeteur(ContactModel Emetteur, int somme)
    {
        Emetteur.setMoney(somme);
        ContactModel em = new ContactModel(Emetteur);
        this.getEmetteurs().add(em);
    };

    public double calculContactCredit(String contact)
    {
        for(int i = 0; i<this.getDestinaires().size(); i++)
        {
            if(this.getDestinaires().get(i).getName().equalsIgnoreCase(contact))
            {
                return this.getDestinaires().get(i).getBenefit();
            }
        }
        return 0;
    };

    public double calculContactMoney(String contact)
    {
        for(int i = 0; i<this.getEmetteurs().size(); i++)
        {
            if(this.getEmetteurs().get(i).getName().equalsIgnoreCase(contact))
            {
                return this.getEmetteurs().get(i).getMoney();
            }
        }
        return 0;
    };

    public String calculTotal()
    {
        int s = 0;
        for(int i = 0; i<this.getEmetteurs().size(); i++)
        {
            s = this.getEmetteurs().get(i).getMoney() + s;
        }
        return " "+s+" Euro";
    };
}