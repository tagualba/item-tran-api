package com.biller.itemtran.model.domain;

import com.biller.itemtran.model.dtos.ItemDto;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "creation_date")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
    private List<TransactionItem> transactionItems;

    public Transaction(){}

    public Transaction(Builder builder){
        id = builder.id;
        creationDate = builder.creationDate;
        totalAmount = builder.totalAmount;
    }

    public Long getId() {
        return id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public List<TransactionItem> getTransactionItems() {
        return transactionItems;
    }
    public static Transaction.Builder newBuilder(Transaction copy){
        Transaction.Builder builder = new Transaction.Builder();
        builder.id = copy.getId();
        builder.totalAmount = copy.getTotalAmount();
        builder.transactionItems = copy.getTransactionItems();
        builder.creationDate = copy.creationDate;
        return builder;
    }

    public static Builder newBuilder(){return new Builder();}

    @Override
    public String toString(){
        return new ToStringCreator(this)
                .append("id", id.toString())
                .append("creationDate", creationDate.toString())
                .append("totalAmount", totalAmount.toString())
                .toString();
    }

    public static final class Builder{
        private Long id;
        private LocalDateTime creationDate;
        private Double totalAmount;
        private List<TransactionItem> transactionItems;

        private Builder(){}

        public Builder withId(Long id){
            this.id = id;
            return this;
        }

        public Builder withCreationDate(LocalDateTime creationDate){
            this.creationDate = creationDate;
            return this;
        }

        public Builder withTotalAmount(Double totalAmount){
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder withTransactionItems(List<TransactionItem> transactionItems){
            this.transactionItems = transactionItems;
            return this;
        }

        public Transaction build(){return new Transaction(this);}
    }
}
