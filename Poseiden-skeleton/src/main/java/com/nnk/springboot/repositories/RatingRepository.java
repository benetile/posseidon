package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


public interface RatingRepository extends JpaRepository<Rating, Integer> {
    @Transactional
    @Modifying
    @Query("update Rating r set r.moodysRating=:moodysRating,r.sandPRating=:sandPRating,r.fitchRating=:fitchRating,r.orderNumber=:orderNumber where r.id=:id")
    void updateRating(@Param("id")int id,@Param("moodysRating") String moodysRating,@Param("sandPRating")String sandPRating,
                      @Param("fitchRating")String fitchRating,@Param("orderNumber") int orderNumber);

}
