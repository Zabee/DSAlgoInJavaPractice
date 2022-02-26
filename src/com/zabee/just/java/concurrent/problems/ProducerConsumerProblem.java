package com.zabee.just.java.concurrent;

import java.util.Arrays;
import java.util.List;

class MessageResource{
	private String message;
	private boolean isEmpty = true;
	
	public synchronized void putMessage(String argMessage){
		if(!isEmpty){
			try{
				wait();
			}catch(InterruptedException e){
				//do nothing
			}
		}
		message = argMessage;
		isEmpty = false;
		notifyAll();
	}
	
	public synchronized String getMessage(){
		if(isEmpty){
			try{
				wait();
			}catch(InterruptedException e){
				//do nothing
			}
		}
		isEmpty = true;
		notifyAll();
		return message;
	}	
}

public class ProducerConsumerProblem{
	
	public static void main(String ...args){
		MessageResource msgResource = new MessageResource();
		Producer producer = new Producer(msgResource);
		Consumer consumer = new Consumer(msgResource, producer);
		producer.start();
		consumer.start();
		
	}
}

class Producer extends Thread{
	MessageResource msgResource;
	public Producer(MessageResource argMessageResource){
		this.msgResource = argMessageResource;
	}
	List<String> messages = Arrays.asList("Threads","often","have","to","coordinate","their","actions.","The","most","common","coordination","idiom","is","the","guarded","block.","Such","a","block","begins","by","polling","a","condition","that","must","be","true","before","the","block","can","proceed.","There","are","a","number","of","steps","to","follow","in","order","to","do","this","correctly.");
	@Override
	public void run(){
		for(String msg : messages){
			msgResource.putMessage(msg);
			try{
				Thread.sleep(1000);				 
			}catch(InterruptedException e){
				//Do nothing
			}
		}
	}
}

class Consumer extends Thread{
	private MessageResource msgResource;
	private Producer producer;
	public Consumer(MessageResource argMessageResource, Producer argProducer){
		this.msgResource = argMessageResource;
		this.producer = argProducer;
	}
	
	@Override
	public void run(){
		while(producer.isAlive()){
			System.out.println("Consuming : " + msgResource.getMessage());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				//
			}
		}
	}
}
