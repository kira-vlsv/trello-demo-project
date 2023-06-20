package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {

    public static ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return projectConfig.remoteDriverUrl() != null && !projectConfig.remoteDriverUrl().isEmpty();
    }

    public static boolean isVideoOn() {
        return !projectConfig.videoStorage().equals("");
    }
}
