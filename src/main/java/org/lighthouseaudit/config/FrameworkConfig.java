package org.lighthouseaudit.config;

import org.aeonbits.owner.Config;

/**
 * Configuration interface to provide method name for framework configuration keys.
 * Mar 27, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see Config
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ 
	"system:properties", 
	"system:env",
	"file:${user.dir}/src/test/resources/config.properties"
	})
public interface FrameworkConfig extends Config {
	
	@DefaultValue("dev")
	String environment();
	
	@Key("lighthouseappurl")
	String lighthouseappurl();	
	
}
