package de.kryptikk.codekatas.roman;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RomanNumbers {

	private enum L {
		IV("IV", 4), 
		IX("IX", 9), 
		XL("XL", 40), 
		XC("XC", 90), 
		CD("CD", 400), 
		CM("CM", 900), 
		I("I", 1), 
		V("V", 5),
		X("X", 10), 
		L("L", 50), 
		C("C", 100), 
		D("D", 500), 
		M("M", 1000);

		private String n;
		private int v;

		private L(String n, int v) {
			this.n = n;
			this.v = v;
		}

		public int val() {
			return v;
		}
	}

	public static int romanToArab(String i) {
		int a = 0;
		for (L r : L.values()) {
			int n = i.split(r.n, -1).length - 1;
			a += n * r.v;
			i = i.replaceAll(r.n, "");
		}
		return a;
	}

	public static String arabToRoman(int arab) {
		String roman = "";
		int i = 0;
		L[] ls = L.values();
		Arrays.sort(ls, Comparator.comparing(L::val));
		Collections.reverse(Arrays.asList(ls));
		while (arab > 0 && i < ls.length) {
			L c = ls[i];
			if (c.v <= arab) {
				arab -= c.v;
				roman += c;
			} else {
				i++;
			}
		}
		return roman;
	}

}