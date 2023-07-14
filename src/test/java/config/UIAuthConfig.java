package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:uiAuth.properties"
})

public interface UIAuthConfig extends Config {
    @Config.Key("userLogin")
    String userLogin();

    @Config.Key("userPassword")
    String userPassword();
}
