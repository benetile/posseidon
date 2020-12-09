package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface TradeRepository extends JpaRepository<Trade, Integer> {
    @Transactional
    @Modifying
    @Query("update Trade t set t.account=:account,t.buyQuantity=:buyQuantity where t.tradeId=:id")
    void updateTrade(@Param("id")int id, @Param("buyQuantity")double buyQuantity);
}
