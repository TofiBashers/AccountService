package com.tofibashers.service;

import com.tofibashers.dao.AmountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

/**
 * Created by TofixXx on 26.09.2014.
 */
public class AccountServiceImpl implements AccountService{

    @Autowired
    AmountDAO amountDAO;

    @Override
    public Long getAmount(Integer id) {
        try{
            return amountDAO.getAmount(id);
        }
        catch (DataAccessException ex)
        {
            return null;
        }
    }

    @Override
    public void addAmount(Integer id, Long value) {
        try{
            amountDAO.addAmount(id, value);
        }
        catch (DataAccessException ex)
        {}

    }
}
