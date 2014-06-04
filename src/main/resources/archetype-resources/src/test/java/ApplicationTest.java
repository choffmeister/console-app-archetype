#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.junit.Test;
import static org.junit.Assert.*;

public class ApplicationTest
{
    @Test
    public void testApp()
    {
        Application app = new Application();
        int exitStatus = app.run(new CommandLineOptions(true, 1, new String[] { "hello", "world" }));

        assertEquals(0, exitStatus);
    }
}
