package com.maitrongnghia.mailproject.jms;

import javax.jms.JMSException;

public class MainComsumer {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        try {
            consumer.create("ITLAB-HOMEWORK");
            while(true){
                System.out.println(consumer.getGreeting(1000));
                Thread.sleep(1000);
            }

        } catch (JMSException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
