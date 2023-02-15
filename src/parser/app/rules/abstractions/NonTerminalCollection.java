package parser.app.rules.abstractions;

import helper.util.types.Nat;
import parser.app.rules.nonterminals.Multiple;
import parser.app.tokens.collection.TokenCollection;

import java.util.function.BiFunction;

/**
 * A non-terminal for which tokenFactory outputs a {@link TokenCollection}.
 *
 * @param <self> The type of the class extending this class.
 * @param <C>    The collection-type that T is based on.
 * @param <T>    The type of the {@link TokenCollection} that tokenFactory outputs.
 */
public abstract sealed class NonTerminalCollection
		<self, C, T extends TokenCollection<?>>
		extends Rule permits MultiNonTerminalCollection, Multiple {

	protected final BiFunction<self, C, T> tokenFactory;

	public NonTerminalCollection(Nat minLen, Nat maxLen, BiFunction<self, C, T> tokenFactory) {
		super(minLen, maxLen);
		this.tokenFactory = tokenFactory;
	}

	@Override
	public abstract T tokenize(String input);

}
