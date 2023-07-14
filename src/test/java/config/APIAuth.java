package config;

import org.aeonbits.owner.ConfigFactory;

public class APIAuth {

    public static APIAuthConfig config = ConfigFactory.create(APIAuthConfig.class, System.getProperties());

}
