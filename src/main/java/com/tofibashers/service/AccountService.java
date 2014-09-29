package com.tofibashers.service;

import java.io.Serializable;

/**
 * Created by TofixXx on 26.09.2014.
 */
public interface AccountService extends Serializable{
    Long getAmount(Integer id);
    void addAmount(Integer id, Long value);
}
