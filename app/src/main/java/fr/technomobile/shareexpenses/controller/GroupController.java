package fr.technomobile.shareexpenses.controller;

import fr.technomobile.shareexpenses.model.ContactModel;
import fr.technomobile.shareexpenses.model.DepenseModel;
import fr.technomobile.shareexpenses.model.GroupModel;

public class GroupController
{
    private GroupModel group;

    public GroupController()
    {

    }

    public GroupModel createGroup(String name)
    {
        this.group = new GroupModel(name);
        return this.group;
    }

    public GroupModel addFriendToGroup(ContactModel friend)
    {
        this.group.getContacts().add(friend);
        return this.group;
    }


    public GroupModel addDepenseToGroup(DepenseModel depense)
    {
        this.group.getDepense().add(depense);
        return this.group;
    }

}
