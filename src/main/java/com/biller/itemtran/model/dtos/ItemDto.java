package com.biller.itemtran.model.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonDeserialize(builder = ItemDto.Builder.class)
public class ItemDto {
    private final Long barCode;

    private final String name;

    private final String shortName;

    private final Integer quantity;

    private final Double amount;

    public Long getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getAmount() {
        return amount;
    }

    private ItemDto(Builder builder){
        barCode = builder.barCode;
        name = builder.name;
        shortName = builder.shortName;
        quantity = builder.quantity;
        amount = builder.amount;

    }

    public static Builder newBuilder(){return new Builder();}

    public static Builder newBuilder(ItemDto copy){
        Builder builder = new Builder();
        builder.barCode = copy.getBarCode();
        builder.name = copy.getName();
        builder.shortName = copy.getShortName();
        builder.quantity = copy.getQuantity();
        builder.amount = copy.getAmount();
        return builder;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this)
                .append("barCode", barCode.toString())
                .append("name",name)
                .append("shortName",shortName)
                .append("quantity", quantity.toString())
                .append("amount", amount.toString())
                .build();}

    @JsonPOJOBuilder
    public static final class Builder{
        private Long barCode;

        private String name;

        private String shortName;

        private int quantity;

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

        public Builder withQuantity(int quantity){
            this.quantity = quantity;
            return this;
        }

        public Builder withAmount(Double amount){
            this.amount = amount;
            return this;
        }

        public ItemDto build(){return new ItemDto(this);}
    }
}
