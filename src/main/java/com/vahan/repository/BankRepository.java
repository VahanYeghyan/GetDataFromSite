package com.vahan.repository;

import com.vahan.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vahan on 12/20/16.
 */
@Repository
public interface BankRepository extends JpaRepository<Bank,Integer>{

    Bank getBankById(Long id);

}
