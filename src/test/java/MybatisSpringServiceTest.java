import cn.me.model.Account;
import cn.me.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 在Mybatis与Spring集成的基础上，测试业务层运作
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class MybatisSpringServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void findAllAccount() {
        List<Account> list = accountService.findAllAccount();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    // 模糊搜索账户
    @Test
    public void findAccountByName() {
        List<Account> list = accountService.findAccountByName("小");
        for (Account account : list) {
            System.out.println(account);
        }
    }

}
