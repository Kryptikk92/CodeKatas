package de.kryptikk.codekatas.roman;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class RomanNumberConverterTest implements ArgumentsProvider {

	@ParameterizedTest
	@ArgumentsSource(RomanNumberConverterTest.class)
	void testRomanToArab(String roman, int arab) {
		int result = RomanNumbers.romanToArab(roman);
		Assertions.assertThat(result).isEqualTo(arab);
	}

	@ParameterizedTest
	@ArgumentsSource(RomanNumberConverterTest.class)
	void testArabToRoman(String roman, int arab) {
		String result = RomanNumbers.arabToRoman(arab);
		Assertions.assertThat(result).isEqualTo(roman);
	}

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
		return Stream.of(Arguments.of("I", 1), Arguments.of("IX", 9), Arguments.of("MCM", 1900),
				Arguments.of("MDCLXVI", 1666), Arguments.of("MMMCDXLIV", 3444), Arguments.of("MMMCMXCIX", 3999));
	}

}