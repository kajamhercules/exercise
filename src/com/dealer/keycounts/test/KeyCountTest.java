package com.dealer.keycounts.test;

import java.io.IOException;

import org.junit.Test;

import com.dealer.keycounts.KeyCount;

public class KeyCountTest {
	@Test
	public void test(){
		KeyCount count = new KeyCount();
		count.setFilePath("C:/WorkDir/eclipseworkspace/DealerTest/src/com/dealer/keycounts/test/testset.txt");
		try {
			count.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
