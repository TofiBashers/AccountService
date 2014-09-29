package com.tofibashers.dao;

import com.tofibashers.entity.Amount;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by TofixXx on 27.09.2014.
 */
@Transactional
@Repository
public class AmountDAO {

    @PersistenceContext
    EntityManager entityManager;

    //@CachePut("cache")
    public void addAmount(Integer id, Long value){
        Amount amount = new Amount();
        amount.setId(id);
        amount.setValue(value);
        entityManager.persist(amount);
    }

    //@Cacheable("cache")
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
