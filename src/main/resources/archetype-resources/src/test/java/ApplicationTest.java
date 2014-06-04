#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.File;
import org.junit.Test;
import static org.junit.Assert.*;

public class ApplicationTest
{
    @Test
    public void testExecution() throws Exception
    {
        Application app = new Application();
        Config config = new Config("Frank", 42, false, new File("."));
        CommandLineOptions options = new CommandLineOptions(true, 1, new String[] { "hello", "world" });
        int exitStatus = app.execute(config, options);

        assertEquals(0, exitStatus);
    }
}
