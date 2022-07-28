package com.biller.itemtran.services;

import com.biller.itemtran.model.domain.Item;
import com.biller.itemtran.model.domain.Transaction;
import com.biller.itemtran.model.domain.TransactionItem;
import com.biller.itemtran.model.dtos.TransactionDto;
import com.biller.itemtran.repositories.TransactionItemRepository;
import com.biller.itemtran.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionItemRepository transactionItemRepository;
    private final ItemService itemService;

    public TransactionService(TransactionRepository transactionRepository, TransactionItemRepository transactionItemRepository, ItemService itemService){
        this.transactionRepository = transactionRepository;
        this.transactionItemRepository = transactionItemRepository;
        this.itemService = itemService;
    }

    public Transaction createTransaction(TransactionDto request){
        Transaction transaction = transactionRepository.save(Transaction.newBuilder().withTotalAmount(request.getTotalAmount()).build());
        Map<Long, Item> items = request.getTransactionItems().stream().map(item -> itemService.find(item.getBarCode())).collect(Collectors.toMap(Item::getBarCode, Function.identity()));

        return transactionRepository.save(Transaction.newBuilder(transaction).withTransactionItems(transactionItemRepository.saveAll(
                request.getTransactionItems().stream().map(item -> TransactionItem.newBuilder().withTransaction(transaction).withItem(items.get(item.getBarCode())).withQuantity(item.getQuantity()).withAmount(item.getAmount()).build()).collect(Collectors.toList())
        )).build());
    }

    public Transaction get(Long id){
        return transactionRepository.findById(id).orElse(null);
    }

    public List<Transaction> getFromToDate(LocalDateTime dateFrom, LocalDateTime dateTo){
        return transactionRepository.findDateBetween(dateFrom, dateTo).orElse(null);
    }
}
