package parser.app.rules.nonterminals;

import parser.app.rules.abstractions.NonTerminal;
import parser.app.rules.abstractions.Rule;
import parser.app.tokens.Token;
import parser.app.tokens.monads.TerminalToken;
import helper.util.types.Nat;

public class Optional extends NonTerminal {

	private final Rule rule;

	public Optional(Rule rule) {
		super(Nat.ZERO, rule.maxLen);
		this.rule = rule;
	}

	@Override
	public Token tokenize(String input) {
		if (input.isBlank())
			return new TerminalToken(this, input);
		return rule.tokenize(input);
	}

	@Override
	public boolean matches(String input) {
		if (input.isBlank())
			return true;
		return rule.matches(input);
	}

	@Override
	public int maxMatchLength(String input) {
		if (input.isBlank())
			return input.length();
		return rule.maxMatchLength(input);
	}

	@Override
	public int firstMatch(String input) {
		return 0;
	}

	@Override
	public String toString() {
		return rule + "?";
	}

}
