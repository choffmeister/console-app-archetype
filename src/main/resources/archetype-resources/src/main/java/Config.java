#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.File;

public class Config {
    public final String chiefName;
    public final Integer chiefAge;
    public final Boolean chiefMarried;
    public final File variables;

    public Config(String chiefName, int chiefAge, boolean chiefMarried, File variables) {
        this.chiefName = chiefName;
        this.chiefAge = chiefAge;
        this.chiefMarried = chiefMarried;
        this.variables = variables;
    }

    public static Config load() {
        com.typesafe.config.Config raw = com.typesafe.config.ConfigFactory.load();

        return new Config(
                raw.getString("myapplication.chief.name"),
                raw.getInt("myapplication.chief.age"),
                raw.getBoolean("myapplication.chief.married"),
                new File(raw.getString("myapplication.variables")));
    }
}
