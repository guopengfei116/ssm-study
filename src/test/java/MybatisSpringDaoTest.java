import cn.me.dao.AccountDao;
import cn.me.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * 集成Spring与Mybatis，使用Spring容器管理Mybatis-Mapper，并对Dao层进行测试，使用springJUnit测试引擎
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class MybatisSpringDaoTest {

    @Autowired
    private AccountDao accountDao;

    // 获取账户列表测试
    @Test
    public void findAllAccount() throws IOException {
        List<Account> list = accountDao.findAllAccount();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    // 模糊搜索账户
    @Test
    public void findAccountByName() throws IOException {
        List<Account> list = accountDao.findAccountByName("小");
        for (Account account : list) {
            System.out.println(account);
        }

        System.out.println("------------------------------------------");

        List<Account> list2 = accountDao.findAccountByName("花");
        for (Account account : list2) {
            System.out.println(account);
        }
    }

}
