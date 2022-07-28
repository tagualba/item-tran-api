package com.biller.itemtran.model.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;

@JsonDeserialize(builder = TransactionDto.Builder.class)
public class TransactionDto {
    private final Long id;

    private final Double totalAmount;

    private final List<ItemDto> transactionItems;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public List<ItemDto> getTransactionItems() {
        return transactionItems;
    }

    public Long getId() {
        return id;
    }

    private TransactionDto(Builder builder){
        id = builder.id;
        totalAmount = builder.totalAmount;
        transactionItems = builder.transactionItems;
    }

    public static Builder newBuilder(){return new Builder();}

    public static Builder newBuilder(TransactionDto copy){
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.totalAmount = copy.getTotalAmount();
        builder.transactionItems = copy.getTransactionItems();
        return builder;
    }

    @JsonPOJOBuilder
    public static final class Builder{
        private Long id;

        private Double totalAmount;

        private List<ItemDto> transactionItems;

        private Builder(){}

        public Builder withId(Long id){
            this.id = id;
            return this;
        }

        public Builder withTotalAmount(Double totalAmount){
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder withTransactionItems(List<ItemDto> transactionItems){
            this.transactionItems = transactionItems;
            return this;
        }

        public TransactionDto build(){return new TransactionDto(this);}
    }
}
