package com.biller.itemtran.controllers;

import com.biller.itemtran.adapter.ItemAdapter;
import com.biller.itemtran.model.dtos.ItemDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/biller/items")
public class ItemController {

    private final ItemAdapter itemAdapter;
    public ItemController(ItemAdapter itemAdapter){
        this.itemAdapter = itemAdapter;
    }

    @PostMapping
    public ItemDto create(@RequestBody ItemDto request){
        return itemAdapter.createItem(request);
    }

    @GetMapping("/{itemId}")
    public HttpEntity<ItemDto> get(@PathVariable(value="itemId") Long id){
        ItemDto response = itemAdapter.get(id);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public HttpEntity<List<ItemDto>> searchByName(@RequestParam(value="name") String name){
        List<ItemDto> response = itemAdapter.searchByName(name);
        if(response == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(response);
    }
}
