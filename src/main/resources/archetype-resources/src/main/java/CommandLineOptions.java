#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.apache.commons.cli.*;

public class CommandLineOptions {
    public final boolean verbose;
    public final int repetitions;
    public final String[] args;

    public CommandLineOptions(boolean verbose, int repetitions, String[] args) {
        this.verbose = verbose;
        this.repetitions = repetitions;
        this.args = args;
    }

    public static CommandLineOptions parse(String... allArgs) throws ParseException {
        Options options = createOptions();
        CommandLineParser parser = new GnuParser();
        CommandLine line = parser.parse(options, allArgs);

        return new CommandLineOptions(
                line.hasOption("v"),
                Integer.valueOf(line.getOptionValue("n", "1")),
                line.getArgs());
    }

    public static Options createOptions() {
        Options opts = new Options();
        opts.addOption("v", "verbose", false, "be extra verbose");
        opts.addOption("n", "repetitions", true, "the number of repetitions");

        return opts;
    }

    public static boolean helpRequested(String[] allArgs) {
        return allArgs.length == 1 && "--help".equals(allArgs[0]);
    }
}
