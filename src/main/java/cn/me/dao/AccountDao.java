package cn.me.dao;

import cn.me.model.Account;

import java.util.List;

public interface AccountDao {
    /*
    * 获取账户列表
    * */
    List<Account> findAllAccount();

    /**
     * 获取指定账户
     * */
    Account findAccountById(int id);

    /**
     * 模糊搜索账户
     * */
    List<Account> findAccountByName(String name);
}
