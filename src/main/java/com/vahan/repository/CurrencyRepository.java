package com.vahan.repository;

import com.vahan.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vahan on 12/21/16.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer>{
}
