#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.Arrays;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

/**
 * Application entry.
 */
public class Application
{
    public static void main(String[] args)
    {
        try {
            if (!CommandLineOptions.helpRequested(args)) {
                Application app = new Application();
                CommandLineOptions options = CommandLineOptions.parse(args);
                int exitStatus = app.run(options);

                System.exit(exitStatus);
            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("${artifactId}", CommandLineOptions.createOptions(), true);
            }
        } catch (ParseException e) {
            System.err.println("Parsing failed. Reason: " + e.getMessage());

            System.exit(1);
        } catch (Throwable e) {
            System.err.println(e.toString());

            System.exit(1);
        }
    }

    public int run(CommandLineOptions options) {
        for (int i = 0; i < options.repetitions; i++) {
            if (options.verbose) {
                System.out.println("Print the message:");
            }

            System.out.println(Arrays.toString(options.args));
        }


        return 0;
    }
}
