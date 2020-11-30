
package com.mycompany.proyecto2b;




public class Player {
    private String name ;
    private String lastName;
    private int  identificationCard;
    private String user;
    private int victories;

    public Player(String name, String lastName, int identificationCard, String user,int victories) {
        this.name = name;
        this.lastName = lastName;
        this.identificationCard = identificationCard;
        this.user = user;
        this.victories=victories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(int identificationCard) {
        this.identificationCard = identificationCard;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }
    
    public void addVictories(){
        this.victories+=1;
    }

    
    
}
