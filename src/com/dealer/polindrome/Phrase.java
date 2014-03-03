package com.dealer.polindrome;



public class Phrase {
	
	private String phrase;
	
	
	public Phrase(String phrase) throws Exception{
		if(phrase == null){
			throw new Exception("Phrase class constructor argument could not be null");
		}
		this.phrase = phrase;
	}
	
	public boolean isPolendrome(){
		String	phraseString = this.phrase.replaceAll("[^\\p{L}\\p{Nd}]", "");
		phraseString = phraseString.toLowerCase();
		StringBuffer polendrome = new StringBuffer(phraseString);
		polendrome = polendrome.reverse();
		String polendromeString = polendrome.toString();
		if(!polendromeString.isEmpty() && polendromeString.equals(phraseString)){
			return true;
		}
		return false;
	}

}
