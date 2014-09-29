package com.tofibashers.statistics;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * Created by TofixXx on 27.09.2014.
 */
@ManagedResource
@Aspect
public class StatisticAddAmountManager {

    long callingAddAmount;
    //добавить!
    long callsPerMinuteAddAmount;

    @ManagedOperation
    public long getCallsPerMinuteAddAmount() {
        return callsPerMinuteAddAmount;
    }

    @ManagedOperation
    public long getCallingAddAmount() {
        return callingAddAmount;
    }

    @Before("execution(* com.tofibashers.service.AccountServiceImpl.addAmount(..))")
    public void addCallsNum()
    {
        callingAddAmount ++;
    }

    //Если статистика за всё время - не нужен
    public void substractCallsNum(){
        callingAddAmount --;
    }

    @ManagedOperation
    public void resetCallsNum(){
        callingAddAmount = 0;
    }

    @ManagedOperation
    public void resetCallsPerMinuteNum(){
        callsPerMinuteAddAmount = 0;
    }



}
