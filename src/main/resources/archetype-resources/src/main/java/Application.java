#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.Arrays;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application entry.
 */
public class Application {
    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        try {
            log.info("Started application");

            if (!CommandLineOptions.helpRequested(args)) {
                Application app = new Application();
                Config config = Config.load();
                CommandLineOptions options = CommandLineOptions.parse(args);
                int exitStatus = app.execute(config, options);

                log.info("Finished application successfully");
                System.exit(exitStatus);
            } else {
                HelpFormatter formatter = new HelpFormatter();
                Options options = CommandLineOptions.createOptions();
                formatter.printHelp("${artifactId}", options, true);

                log.info("Finished application successfully");
            }
        } catch (ParseException e) {
            log.error("Aborted application because of invalid command line arguments - {}", e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            log.error("Application failed", e);
            System.exit(1);
        }
    }

    public int execute(Config config, CommandLineOptions options) throws Exception {
        System.out.println("Chief name: " + config.chiefName.toString());
        System.out.println("Chief age: " + config.chiefAge.toString());
        System.out.println("Chief married: " + config.chiefMarried.toString());
        System.out.println("Variables file: " + config.variables.toString());

        for (int i = 0; i < options.repetitions; i++) {
            if (options.verbose) {
                System.out.println("Print the message:");
            }

            System.out.println(Arrays.toString(options.args));
        }

        return 0;
    }
}
