package com.biller.itemtran.repositories;

import com.biller.itemtran.model.domain.TransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionItemRepository extends JpaRepository<TransactionItem, Long> {
}
