package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:apiAuth.properties"
})

public interface APIAuthConfig extends Config {
    @Key("uri")
    String uri();

    @Key("key")
    String key();

    @Key("token")
    String token();
}
