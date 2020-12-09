package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface BidListRepository extends JpaRepository<BidList, Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update BidList u set u.bidQuantity = :bidQuantity where u.BidListId = :id")
    void updateBidList(@Param("id") int id, @Param("bidQuantity") double bidQuantity);

}
