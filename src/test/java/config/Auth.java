package config;

import org.aeonbits.owner.ConfigFactory;

public class Auth {

    public static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

}
