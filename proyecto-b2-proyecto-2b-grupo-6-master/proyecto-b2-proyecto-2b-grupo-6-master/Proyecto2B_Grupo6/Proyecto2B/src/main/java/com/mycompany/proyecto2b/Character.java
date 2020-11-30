package com.mycompany.proyecto2b;

public class Character {

    public Character() {
    }

    private String name;
    private String attack;
    private String finalAttack;
    private int life;
    private int stamina;
    private String kind;
    private int count;
    private int percentAttack;
    private int percentFinalAttack;
    private int percentDefense;
    private int percentHeal;
    private int knock;

    public Character(String name, String attack, String finalAttack, int life, int stamina, String kind) {
        this.name = name;
        this.attack = attack;
        this.finalAttack = finalAttack;
        this.life = life;
        this.stamina = stamina;
        this.kind = kind;
        this.count=0;
        this.percentAttack = (5 * this.stamina) / 100;
        this.percentFinalAttack = (50 * this.stamina) / 100;
        this.percentDefense = (25 * this.stamina) / 100;
        this.percentHeal = (20 * this.stamina) / 100;
        this.knock=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getFinalAttack() {
        return finalAttack;
    }

    public void setFinalAttack(String finalAttack) {
        this.finalAttack = finalAttack;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getPercentAttack() {
        return percentAttack;
    }

    public int getPercentFinalAttack() {
        return percentFinalAttack;
    }

    public int getPercentDefense() {
        return percentDefense;
    }

    public int getPercentHeal() {
        return percentHeal;
    }

    public int getKnock() {
        return knock;
    }
    

    public void decreaseLife(int percent,boolean option) {
        System.out.println("boolean"+option);
        knock=this.life*percent/100;
        
//        if(option){
//            count++;
//            this.vida-=knock*75/100;
//            
//            if(count==3){
//                option=false;
//            }
//            
//        }
        
        this.life -= knock;
    }

    public void atacarNormal() {

        this.stamina -= this.percentAttack;

    }

    public void atacarFuerte() {

        this.stamina -= (50 * this.stamina) / 100;
    }

    public void curar() {

        this.life += (20 * this.life) / 100;
        this.stamina -= (20 * this.stamina) / 100;

    }

    public void defender() {

        count ++;
        this.stamina -= (25 * this.stamina) / 100;

    }

    public void increaseStamina() {

        this.stamina += (10 * this.stamina) / 100;

    }

}
