public class Style {
	protected static final String RESET = "\u001B[0m";

	protected static final String BLACK = "\u001B[30m";
	protected static final String RED = "\u001B[31m";
	protected static final String GREEN = "\u001B[32m";
	protected static final String YELLOW = "\u001B[33m";
	protected static final String BLUE = "\u001B[34m";
	protected static final String PURPLE = "\u001B[35m";
	protected static final String CYAN = "\u001B[36m";
	protected static final String WHITE = "\u001B[37m";

	protected static final String BOLD = "\u001B[1m";
	protected static final String UNDERLINE = "\u001B[4m";

	protected String colorize(String _text, String _color) {
		return _color + _text + RESET;
	}

	protected String bold(String _text) {
		return BOLD + _text + RESET;
	}
}
