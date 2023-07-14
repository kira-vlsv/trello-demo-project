package utils;

import com.github.javafaker.Faker;

public class RandomGenerator {

    protected static final Faker faker = new Faker();

    public static String randomString(String prefix) {
        return prefix + " " + faker.lorem().word() + faker.random().nextInt(100, 1000);
    }
}
