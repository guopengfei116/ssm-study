package cn.me.service.impl;

import cn.me.dao.AccountDao;
import cn.me.model.Account;
import cn.me.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    /**
     * 获取指定账户
     *
     * @param id
     */
    @Override
    public Account findAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    /**
     * 模糊搜索账户
     *
     * @param name
     */
    @Override
    public List<Account> findAccountByName(String name) {
        return accountDao.findAccountByName(name);
    }

}
