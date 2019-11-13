package com.example.javabasic.guava.eventbus.example3;

import com.google.common.eventbus.EventBus;
import org.junit.Test;

/**
 * @author：Cheng.
 * @date：Created in 14:45 2019/11/7
 */
public class TestEventsFromSubclass {

    @Test
    public void testEventsFromSubclass() throws Exception {

        EventBus eventBus = new EventBus("test event 继承");
        IntegerListener integerListener = new IntegerListener();
        NumberListener numberListener = new NumberListener();
        eventBus.register(integerListener);
        eventBus.register(numberListener);

        eventBus.post(new Integer(100));

        System.out.println("integerListener message:"+integerListener.getLastMessage());
        System.out.println("numberListener message:"+numberListener.getLastMessage());

        eventBus.post(new Long(200L));

        System.out.println("integerListener message:"+integerListener.getLastMessage());
        System.out.println("numberListener message:"+numberListener.getLastMessage());
    }
}