import cn.me.dao.AccountDao;
import cn.me.model.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 纯Mybatis使用测试，无spring无关，使用原始junit测试引擎
 * */
public class MybatisOriginalDaoTest {

    // 获取账户列表测试
    @Test
    public void findAllAccount() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis/mybatis-original.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<Account> list = accountDao.findAllAccount();
        for (Account account : list) {
            System.out.println(account);
        }
    }

    // 模糊搜索账户
    @Test
    public void findAccountByName() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis/mybatis-original.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

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
