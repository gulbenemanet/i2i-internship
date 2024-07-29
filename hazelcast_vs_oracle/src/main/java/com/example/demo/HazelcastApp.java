package com.example.demo;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Map;
import java.util.Random;

public class HazelcastApp {
	public static void main(String[] args) {

		ClientConfig clientConfig = new ClientConfig();
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

		IMap<Integer, Integer> map = client.getMap("data");
		Random random = new Random();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			map.put(i, random.nextInt(20000));
		}
		long endTime = System.currentTimeMillis();
		System.out.println("20.000 put süresi: " + (endTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			map.get(random.nextInt(20000));
		}
		endTime = System.currentTimeMillis();
		System.out.println("20.000 get süresi: " + (endTime - startTime) + " ms");
	}
}
