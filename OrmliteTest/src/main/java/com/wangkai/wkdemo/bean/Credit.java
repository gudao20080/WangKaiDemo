package com.wangkai.wkdemo.bean;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "credit_t")
public class Credit {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(width = 20, unique = true, canBeNull = false)
    private String creditCard;
    @DatabaseField(width = 20)
    private String creditCardPasswordT;
    @DatabaseField(width = 20)
    private String getCreditCardPasswordQ;
    @DatabaseField(width = 20)
    private String creditAccountsCard;

    public Credit() {
    }

    public Credit(int id, String creditCard, String creditCardPasswordT, String getCreditCardPasswordQ, String creditAccountsCard) {
        this.id = id;
        this.creditCard = creditCard;
        this.creditCardPasswordT = creditCardPasswordT;
        this.getCreditCardPasswordQ = getCreditCardPasswordQ;
        this.creditAccountsCard = creditAccountsCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCreditCardPasswordT() {
        return creditCardPasswordT;
    }

    public void setCreditCardPasswordT(String creditCardPasswordT) {
        this.creditCardPasswordT = creditCardPasswordT;
    }

    public String getGetCreditCardPasswordQ() {
        return getCreditCardPasswordQ;
    }

    public void setGetCreditCardPasswordQ(String getCreditCardPasswordQ) {
        this.getCreditCardPasswordQ = getCreditCardPasswordQ;
    }

    public String getCreditAccountsCard() {
        return creditAccountsCard;
    }

    public void setCreditAccountsCard(String creditAccountsCard) {
        this.creditAccountsCard = creditAccountsCard;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "id=" + id +
                ", creditCard='" + creditCard + '\'' +
                ", creditCardPasswordT='" + creditCardPasswordT + '\'' +
                ", getCreditCardPasswordQ='" + getCreditCardPasswordQ + '\'' +
                ", creditAccountsCard='" + creditAccountsCard + '\'' +
                '}';
    }
}
