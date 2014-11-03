package com.tofibashers.statistics;

/**
 * Created by TofixXx on 01.10.2014.
 */
public interface IStatisticAddAmountManager {
    public long getCallsPerMinuteAddAmount();
    public long getCallingAddAmount();
    public void resetCallsNum();
    public void resetCallsPerMinuteNum();

}
