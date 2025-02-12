package com.starLife.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.starLife.in.Entity.Transaction_History;

@Repository
public interface Trans_historyRepository  extends JpaRepository<Transaction_History,Integer>{

  @Query("select t from  Transaction_History t WHERE  t.cust.Cid = :Cid")
  public Transaction_History findTransaction_HistorybyuserId(@Param("Cid") String Cid );
  
} 