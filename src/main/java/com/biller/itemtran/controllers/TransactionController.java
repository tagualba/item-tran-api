package com.biller.itemtran.controllers;

import com.biller.itemtran.adapter.TransactionAdapter;
import com.biller.itemtran.model.domain.Transaction;
import com.biller.itemtran.model.dtos.TransactionDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/biller/transactions")
public class TransactionController {

    private final TransactionAdapter transactionAdapter;

    public TransactionController(TransactionAdapter transactionAdapter){
        this.transactionAdapter = transactionAdapter;
    }

    @PostMapping
    public TransactionDto create(@RequestBody TransactionDto request){
        return transactionAdapter.createTransaction(request);
    }

    @GetMapping("/{transactionId}")
    public HttpEntity<Transaction> get(@PathVariable(value="transactionId") Long id){
        Transaction response = transactionAdapter.get(id);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/report")
    public HttpEntity<List<Transaction>> transactionReport(@RequestParam(value="dateFrom") String dateFrom,
                                                              @RequestParam(value="dateTo") String dateTo){
        List<Transaction> response = transactionAdapter.getFromToDate(dateFrom, dateTo);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response);
    }



}
