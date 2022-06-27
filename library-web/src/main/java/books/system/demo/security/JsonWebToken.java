package books.system.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.experimental.UtilityClass;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@UtilityClass
public class JsonWebToken {
    private static final String SECRET = "fYs88uTraQADQI52wFYNUbzGbRV7iqJfdG85ierkdZBi5QBvkKyGF5BfJPpQUMjB";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    //subject - unique identifier of customer
    public static String buildJWT(final String subject) {
        assert subject != null && !subject.isEmpty() : "Subject cannot be null or empty!";

        final Instant currentTime = Instant.now();
        final int expirationMinutes = 15;

        return Jwts
                .builder()
                .setSubject(subject)
                .setIssuedAt(Date.from(currentTime))
                .setExpiration(Date.from(currentTime.plus(expirationMinutes, ChronoUnit.MINUTES)))
                .signWith(KEY)
                .compact();
    }

    public static Claims decodeJWT(final String jwt) {
        assert jwt != null && !jwt.isEmpty() : "Token should not be empty!";

        return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(jwt).getBody();
    }

}
