package de.kryptikk.codekatas.roman;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RomanNumbers {

	private enum RomanLiteral {
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

		private String name;
		private int value;

		private RomanLiteral(String n, int v) {
			this.name = n;
			this.value = v;
		}

		public int val() {
			return value;
		}
	}

	public static int romanToArab(String i) {
		int arab = 0;
		for (RomanLiteral r : RomanLiteral.values()) {
			int occurences = i.split(r.name, -1).length - 1;
			arab += occurences * r.value;
			i = i.replaceAll(r.name, "");
		}
		return arab;
	}

	public static String arabToRoman(int arab) {
		StringBuilder roman = new StringBuilder();
		int i = 0;
		RomanLiteral[] literals = RomanLiteral.values();
		Arrays.sort(literals, Comparator.comparing(RomanLiteral::val));
		Collections.reverse(Arrays.asList(literals));
		while (arab > 0 && i < literals.length) {
			RomanLiteral l = literals[i];
			if (l.value <= arab) {
				arab -= l.value;
				roman.append(l);
			} else {
				i++;
			}
		}
		return roman.toString();
	}

}