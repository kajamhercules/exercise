package com.dealer.polindrome.test;

import org.junit.Assert;
import org.junit.Test;

import com.dealer.polindrome.Phrase;

public class PolindromeTest {
	
	@Test
	public void polindromeTest1(){
		Phrase phrase;
		try {
			phrase = new Phrase("Did I draw Della too tall, Edward?  did?");
			Assert.assertFalse(phrase.isPolendrome());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void polindromeTest2(){
		Phrase phrase;
		try {
			phrase = new Phrase("Did I draw Della too tall, Edward? I did?");
			Assert.assertTrue(phrase.isPolendrome());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void polindromeTest3(){
		Phrase phrase;
		try {
			phrase = new Phrase("lepers repel");
			Assert.assertTrue(phrase.isPolendrome());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void polindromeTest4 (){
		Phrase phrase;
		try {
			phrase = new Phrase("aibo");
			Assert.assertFalse(phrase.isPolendrome());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void polindromeTest5 (){
		Phrase phrase;
		try {
			phrase = new Phrase(" ");
			Assert.assertFalse(phrase.isPolendrome());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void polindromeTest6 (){
		Phrase phrase;
		try {
			phrase = new Phrase("aibohphobia");
			Assert.assertTrue(phrase.isPolendrome());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	@Test(expected=Exception.class)
	public void polindromeTest7 () throws Exception{
		Phrase phrase;

			phrase = new Phrase(null);
		
	}
}
