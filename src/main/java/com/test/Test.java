package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static class MyThread extends Thread implements Runnable{
		public void run() {
			while (true) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		try{
			List list = new ArrayList();
			while (true) {
				//list.add(new Test());
				new MyThread().start();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			long e = System.currentTimeMillis();
			System.out.println(e-s);
		}
	
	}
}
