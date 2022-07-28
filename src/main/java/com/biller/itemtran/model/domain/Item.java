package com.biller.itemtran.model.domain;

import org.springframework.core.style.ToStringCreator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @Column(name = "id")
    private Long barCode;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "amount")
    private Double amount;

    public Item(){}

    public Item(Builder builder){
        barCode = builder.barCode;
        name = builder.name;
        shortName = builder.shortName;
        quantity = builder.quantity;
        amount = builder.amount;
    }

    public Long getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public static Builder newBuilder(){return new Builder();}

    @Override
    public String toString(){
        return new ToStringCreator(this)
                .append("barCode", barCode.toString())
                .append("name", name)
                .append("shortName", shortName)
                .append("quantity", quantity.toString())
                .append("amount", amount.toString())
                .toString();
    }

    public static final class Builder{
        private Long barCode;
        private String name;
        private String shortName;
        private Integer quantity;
        private Double amount;

        private Builder(){}

        public Builder withBarCode(Long barCode){
            this.barCode = barCode;
            return this;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withShortName(String shortName){
            this.shortName = shortName;
            return this;
        }

        public Builder withQuantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder withAmount(Double amount){
            this.amount = amount;
            return this;
        }

        public Item build(){return new Item(this);}
    }

}
