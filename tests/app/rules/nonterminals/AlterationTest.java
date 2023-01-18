package app.rules.nonterminals;

import org.junit.jupiter.api.Test;

import static app.rules.Rules.alt;
import static app.rules.Rules.lit;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlterationTest {

	@Test
	public void testMatches() {
		var rule = alt(lit("abc"), lit("123"));
		assertTrue(rule.matches("abc"));
		assertTrue(rule.matches("123"));
		assertTrue(rule.matches(" abc "));
		assertTrue(rule.matches(" 123 "));
	}

	@Test
	public void testFails() {
		var rule = alt(lit("abc"), lit("123"));
		assertFalse(rule.matches("xyz"));
		assertFalse(rule.matches("abcabc"));
		assertFalse(rule.matches("abc123"));
		assertFalse(rule.matches(""));
	}

}
