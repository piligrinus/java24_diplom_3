package user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public User genericRandom() {
        return new User(RandomStringUtils.randomAlphanumeric(5, 10) + "@gmail.com", RandomStringUtils.randomAlphanumeric(8, 10), RandomStringUtils.randomAlphabetic(2, 10));
    }
}
