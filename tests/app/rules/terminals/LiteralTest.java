package app.rules.terminals;


import org.junit.jupiter.api.Test;

import static app.rules.Rules.lit;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LiteralTest {

	@Test
	public void testMatches() {
		var rule = lit("abc");
		assertTrue(rule.matches("abc"));
		assertTrue(rule.matches(" abc "));
	}

	@Test
	public void testFails() {
		var rule = lit("123");
		assertFalse(rule.matches("xyz"));
	}

}
