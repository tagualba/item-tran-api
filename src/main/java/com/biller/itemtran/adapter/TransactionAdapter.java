package com.biller.itemtran.adapter;

import com.biller.itemtran.model.domain.Transaction;
import com.biller.itemtran.model.dtos.TransactionDto;
import com.biller.itemtran.services.TransactionService;
import com.biller.itemtran.translators.TransactionTranslator;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionAdapter {

    private final TransactionService transactionService;
    private final TransactionTranslator transactionTranslator;

    public TransactionAdapter(TransactionService transactionService,
                              TransactionTranslator transactionTranslator){
        this.transactionService = transactionService;
        this.transactionTranslator = transactionTranslator;
    }
    public TransactionDto createTransaction(TransactionDto request) {
        return transactionTranslator.toDto(transactionService.createTransaction(request));
    }
    public Transaction get(Long id) {
        return transactionService.get(id);
    }

    public List<Transaction> getFromToDate(String dateFrom, String dateTo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return transactionService.getFromToDate(LocalDateTime.parse(dateFrom, formatter), LocalDateTime.parse(dateTo, formatter));
    }
}
