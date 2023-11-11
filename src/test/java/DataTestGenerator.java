import org.apache.commons.lang3.RandomStringUtils;

public class DataTestGenerator {
    String name = RandomStringUtils.randomAlphanumeric(2, 10);
    String email = RandomStringUtils.randomAlphanumeric(2, 10) + "@gmail.com";
    String password = RandomStringUtils.randomAlphanumeric(7, 10);
    String wrongPassword = RandomStringUtils.randomAlphanumeric(1, 6);
}
