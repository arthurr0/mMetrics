package pl.minecodes.mmetrics.user;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UserJwtService {

  private final String secret_key;
  private final JwtParser jwtParser;

  private String TOKEN_HEADER = "Authorization";
  private String TOKEN_PREFIX = "Bearer ";

  private long accessTokenValidity = 60 * 60 * 1000;

  public UserJwtService(@Value("${security.bcrypt.secret}") String secretKey) {
    this.secret_key = secretKey;
    System.out.println("Secret key: " + secret_key);
    this.jwtParser = Jwts.parser().setSigningKey(secret_key);
  }

  public String createToken(User user) {
    Claims claims = Jwts.claims().setSubject(user.getUsername());

    claims.put("username", user.getUsername());
    claims.put("email", user.getEmail());
    claims.put("role", user.getRole());

    Date tokenCreateTime = new Date();
    Date tokenValidity = new Date(
        tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
    return Jwts.builder().setClaims(claims).setExpiration(tokenValidity)
        .signWith(SignatureAlgorithm.HS256, secret_key).compact();
  }

  private Claims parseJwtClaims(String token) {
    return jwtParser.parseClaimsJws(token).getBody();
  }

  public Claims resolveClaims(HttpServletRequest req) {
    try {
      String token = resolveToken(req);
      if (token != null) {
        return parseJwtClaims(token);
      }
      return null;
    } catch (ExpiredJwtException ex) {
      req.setAttribute("expired", ex.getMessage());
      throw ex;
    } catch (Exception ex) {
      req.setAttribute("invalid", ex.getMessage());
      throw ex;
    }
  }

  public String resolveToken(HttpServletRequest request) {

    String bearerToken = request.getHeader(TOKEN_HEADER);
    if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
      return bearerToken.substring(TOKEN_PREFIX.length());
    }
    return null;
  }

  public boolean validateClaims(Claims claims) throws AuthenticationException {
    try {
      return claims.getExpiration().after(new Date());
    } catch (Exception e) {
      throw e;
    }
  }

  public String getEmail(Claims claims) {
    return claims.getSubject();
  }

  private List<String> getRoles(Claims claims) {
    return (List<String>) claims.get("roles");
  }


}