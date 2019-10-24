package com.maitrongnghia.mailproject.jms;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.jms.JMSException;

import static org.junit.Assert.assertEquals;

public class Main {
    private static Producer producer;
    private static Consumer consumer;

    public static void main(String[] args) {
        Producer producer = new Producer();
        try {
            producer.create("ITLAB-HOMEWORK");
            for(int i=0;i<100;i++){
                producer.sendName("tao","nghia         :" + i);
                System.out.println("tao" + "nghia         :" + i);
                Thread.sleep(2000);
            }

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    @BeforeClass
//    public static void setUpBeforeClass() throws JMSException {
//        producer = new Producer();
//        producer.create("helloworld.q");
//
//        consumer = new Consumer();
//        consumer.create("helloworld.q");
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws JMSException {
//        producer.close();
//        consumer.close();
//    }
//
//    @Test
//    public void testGetGreeting() {
//        try {
//            producer.sendName("John", "Doe");
//
//            String greeting = consumer.getGreeting(1000);
//            assertEquals("Hello John Doe!", greeting);
//
//        } catch (JMSException e) {
//
//        }
//    }
//
//    @Test
//    public void testNoGreeting() {
//        try {
//            String greeting = consumer.getGreeting(1000);
//            assertEquals("no greeting", greeting);
//
//        } catch (JMSException e) {
//
//        }
//    }
}