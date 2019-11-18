package com.example.javabasic;

import com.example.javabasic.interview.interview20191117.TransactionAopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author：Cheng.
 * @date：Created in 23:47 2019/11/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {

    @Autowired
    TransactionAopService transactionAopService;

    @Test
    public void test(){
        transactionAopService.addOrder();
    }

}