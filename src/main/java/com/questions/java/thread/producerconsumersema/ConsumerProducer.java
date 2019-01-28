package com.questions.java.thread.producerconsumersema;

import java.util.concurrent.Semaphore;

/**
 * Created by jitendra on 09 Mar, 2018
 */
public class ConsumerProducer {
    public static void main(String[] args) {

        Semaphore semaphoreProducer = new Semaphore(1);
        Semaphore semaphoreConsumer = new Semaphore(0);
        System.out.println("semaphoreProducer permit=1 | semaphoreConsumer permit=0");

        Producer producer = new Producer(semaphoreProducer, semaphoreConsumer);
        Consumer consumer = new Consumer(semaphoreConsumer, semaphoreProducer);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");

        producerThread.start();
        consumerThread.start();

    }
}