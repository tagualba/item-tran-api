package com.biller.itemtran.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class TransactionItem{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction")
    @JsonIgnore
    private Transaction transaction;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "amount")
    private Double amount;

    public TransactionItem(){}

    public TransactionItem(Builder builder){
        id = builder.id;
        item = builder.item;
        transaction = builder.transaction;
        quantity = builder.quantity;
        amount = builder.amount;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public static Builder newBuilder(){return new Builder();}

    public static final class Builder{
        private Long id;
        private Item item;
        private Transaction transaction;
        private Integer quantity;
        private Double amount;

        private Builder(){}

        public Builder withId(Long id){
            this.id = id;
            return this;
        }

        public Builder withItem(Item item){
            this.item = item;
            return this;
        }

        public Builder withTransaction(Transaction transaction){
            this.transaction = transaction;
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

        public TransactionItem build(){return new TransactionItem(this);}
    }

}
