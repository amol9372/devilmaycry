package com.practice.LuceneSearch.practice;

import java.util.Arrays;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ThreadDemo extends Thread 
{
   public static void main(String args[]) throws JSONException{
//	   Thread t = new Thread(new ThreadDemo());
//	   t.start();
//	   System.out.println("main thread executing");
	   JSONObject jsonObject = new JSONObject();
	   jsonObject.put("Amol", "sdnf");
	   jsonObject.put("Amol", "sdnf1");
	   jsonObject.put("A1mol", "sdn1f1");
	   jsonObject.put("amol", Arrays.asList("Amol","Robin","Shanu"));
	   System.out.println(jsonObject.get("amol").toString());
   }
   
	public void run() {
		System.out.println("Thread execution starts");
		try {
			System.out.println("Thread is sleeping ....");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread is awake now");
	}
}
