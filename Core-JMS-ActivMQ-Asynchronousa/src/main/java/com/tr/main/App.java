package com.tr.main;

import javax.jms.JMSException;

import com.tr.consumer.QueueConsumer;
import com.tr.producer.QueueProducer;

public class App {
	public static void main(String[] args) throws JMSException {
		QueueProducer.main(null);
		QueueConsumer.main(null);
	}
}
