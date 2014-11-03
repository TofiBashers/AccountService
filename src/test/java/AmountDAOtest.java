import com.tofibashers.dao.AmountDAO;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by TofixXx on 18.10.2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/HttpInvoker-servlet.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
public class AmountDAOtest {

    static {
        System.out.println(System.getProperty("user.dir"));
    }

    @Autowired
    AmountDAO amountDAO;

    @Autowired
    EhCacheCacheManager cacheManager;

    @Test
    public void addAmountTest(){
        amountDAO.addAmount(1, (long) 2);
        amountDAO.addAmount(2, (long) 3);
        amountDAO.getAmount(1);
        //CacheManager cacheManager = CacheManager.getInstance();
        /*List<Object> keys = cacheManager.getCacheManager().getCache("cache").getKeys();
        for(Object o : keys){
            System.out.println((Integer)o);
        }*/
        System.out.println(cacheManager.getCacheManager().getCache("cache").getSize());
        Element element = cacheManager.getCacheManager().getCache("cache").get(1);
        System.out.println((Long)element.getObjectValue());
        amountDAO.addAmount(1, (long) 4);
        System.out.println(amountDAO.getAmount(1));
        System.out.println(cacheManager.getCacheManager().getCache("cache").getSize());
        Element element1 = cacheManager.getCacheManager().getCache("cache").get(1);
        System.out.println((Long)element.getObjectValue());
    }
}
