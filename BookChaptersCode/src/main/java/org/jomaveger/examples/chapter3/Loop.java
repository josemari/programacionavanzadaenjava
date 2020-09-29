package org.jomaveger.examples.chapter3;

import org.apache.commons.lang3.ArrayUtils;
import org.jomaveger.lang.dbc.Contract;

public class Loop {

	public static boolean isSorted(int[] v) {
		Contract.require(v != null);
		
		int i = 0;
		boolean isSorted = true; 
		while (i < v.length - 1 && isSorted) {
			
			Contract.check(v.length - 1 - i >= 0); 
			
			isSorted = v[i] <= v[i+1];
			i++;
			
			Contract.check(i >= 0 && (i < v.length) && (isSorted || (v[i-1] > v[i])));
		}
		
		
		Contract.ensure(isSorted == ArrayUtils.isSorted(v));
		return isSorted;
	}
}
