package com.tofibashers.statistics;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by TofixXx on 27.09.2014.
 */

@Aspect
public class StatisticAddAmountManager {

    long callingAddAmount;
    //добавить!
    long callsPerMinuteAddAmount;


    public long getCallsPerMinuteAddAmount() {
        return callsPerMinuteAddAmount;
    }


    public long getCallingAddAmount() {
        return callingAddAmount;
    }

    @Before("execution(* com.tofibashers.service.AccountServiceImpl.addAmount(..))")
    public void addCallsNum()
    {
        callingAddAmount ++;
    }



    public void resetCallsNum(){
        callingAddAmount = 0;
    }


    public void resetCallsPerMinuteNum(){
        callsPerMinuteAddAmount = 0;
    }



}
