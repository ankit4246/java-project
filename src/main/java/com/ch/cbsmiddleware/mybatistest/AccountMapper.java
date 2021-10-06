package com.ch.cbsmiddleware.mybatistest;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author bimal on 10/5/21
 * @project cbs-middleware
 */
@Mapper
public interface AccountMapper {

    @Select("select id, accnumber as accountNumber from account")
    List<Account> getAccounts();

    List<Account> getAccountsXml();

}
