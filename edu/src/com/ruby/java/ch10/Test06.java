package com.ruby.java.ch10;

import java.util.HashMap;
import java.util.Iterator;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word[] = {"BUMBLEBEE", "HEAVEN", "ALTHOUGH", "WONDER"};
		String meaning[] = {"꿀벌과에 속하는 호박벌", "천국", "그럼에도 불구하고", "호기심이 들다"};
		
		HashMap<String, String> dic = new HashMap<>();
		for(int i =0; i < word.length; i++) {
			dic.put(word[i], meaning[i]);
		}
		System.out.println(dic);
		System.out.println(dic.size());
		System.out.println(dic.keySet());
		System.out.println(dic.values());
		
		Iterator<String> keys = dic.keySet().iterator();
		while(keys.hasNext()) {
			String  key = keys.next();
			System.out.println(dic.get(key));
		}
	}

}
