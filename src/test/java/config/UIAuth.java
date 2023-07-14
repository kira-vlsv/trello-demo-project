package config;

import org.aeonbits.owner.ConfigFactory;

public class UIAuth {

    public static UIAuthConfig config = ConfigFactory.create(UIAuthConfig.class, System.getProperties());

}
