package com.biller.itemtran.translators;

import com.biller.itemtran.model.domain.Transaction;
import com.biller.itemtran.model.dtos.TransactionDto;
import org.springframework.stereotype.Component;

@Component
public class TransactionTranslator {
    public TransactionDto toDto(Transaction transaction){
        return TransactionDto.newBuilder()
                .withId(transaction.getId())
                .withTotalAmount(transaction.getTotalAmount())
                .build();
    }
}
