package com.biller.itemtran.repositories;

import com.biller.itemtran.model.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT t FROM Transaction t WHERE t.creationDate BETWEEN :dateFrom AND :dateTo")
    Optional<List<Transaction>> findDateBetween(@Param("dateFrom") LocalDateTime dateFrom,
                                                @Param("dateTo") LocalDateTime dateTo);
}
