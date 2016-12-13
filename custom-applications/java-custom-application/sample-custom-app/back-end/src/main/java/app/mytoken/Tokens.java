package app.mytoken;

import java.util.concurrent.ThreadLocalRandom;

public class Tokens {

    private static final long secret = ThreadLocalRandom.current().nextLong();

    public static String generate(String username) {
        long timeout = System.currentTimeMillis() + 60 * 60 * 1000;
        int hash = String.format("%s:%s:%s", username, timeout, secret).hashCode();
        return String.format("%s:%s:%s", username, timeout, hash);
    }

    private static boolean validate(String token) {
        String[] split = token.split(":");

        if (split.length != 3) {
            return false;
        }

        String username = split[0];
        long timeout = Long.valueOf(split[1]);
        Integer hash = Integer.valueOf(split[2]);

        String value = String.format("%s:%s:%s", username, timeout, secret);
        return timeout > System.currentTimeMillis() && hash == value.hashCode();
    }

    public static void authorize(String token) {

        if (token == null) {
            throw new IllegalArgumentException("Missing authentication token.");
        }

        if (!validate(token)) {
            throw new IllegalArgumentException("Invalid authentication token.");
        }
    }
}
