package com.biller.itemtran.repositories;

import com.biller.itemtran.model.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i from Item i WHERE i.name LIKE %:name% ")
    Optional<List<Item>> findByNameContaining(@Param("name")String name);
}
