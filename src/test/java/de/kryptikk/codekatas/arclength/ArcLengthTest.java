package de.kryptikk.codekatas.arclength;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;


public class ArcLengthTest implements ArgumentsProvider {
	
	@ParameterizedTest
	@ArgumentsSource(ArcLengthTest.class)
	void testArcLength(double expected, int n) {
		double result = ArcLength.lenCurve(n);
		Assertions.assertThat(expected).isEqualTo(result, Assertions.within(1e-9));
	}
	
	@ParameterizedTest
	@ArgumentsSource(ArcLengthTest.class)
	void testParameterizedArcLength(double expected, int n) {
		ArcLength a = new ArcLength(new MathFunction("x^2"));
		double result = a.lenCurve(n, 0, 1);
		Assertions.assertThat(expected).isEqualTo(result, Assertions.within(1e-9));
	}

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
		return Stream.of(
			Arguments.of(1.414213562, 1), 
			Arguments.of(1.478197397, 10),
			Arguments.of(1.478935403, 100),
			Arguments.of(1.478942783, 1000),
			Arguments.of(1.478942856, 10000)
		);
	}
}
