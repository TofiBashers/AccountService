package com.tofibashers.dao;

import com.tofibashers.entity.Amount;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by TofixXx on 27.09.2014.
 */
@Repository
@Transactional
public class AmountDAO {

    @PersistenceContext
    EntityManager entityManager;

    @CacheEvict(value = "cache", key = "#id")
    public void addAmount(Integer id, Long value){
        Amount amount = new Amount();
        amount.setId(id);
        amount.setValue(value);
        entityManager.merge(amount);
    }

    @Cacheable("cache")
    public Long getAmount(Integer id){
        Amount amount =  entityManager.find(Amount.class, id);
        if(amount != null){
            return amount.getValue();
        }
        else{
            return new Long(0);
        }
    }
}
