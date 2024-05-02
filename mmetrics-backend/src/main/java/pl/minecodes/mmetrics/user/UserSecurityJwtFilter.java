package pl.minecodes.mmetrics.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
class UserSecurityJwtFilter extends OncePerRequestFilter {

  private final ObjectMapper mapper;
  private final UserJwtService userJwtService;

  public UserSecurityJwtFilter(ObjectMapper mapper, UserJwtService userJwtService) {
    this.mapper = mapper;
    this.userJwtService = userJwtService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    Map<String, Object> errorDetails = new HashMap<>();

    try {
      String accessToken = this.userJwtService.resolveToken(request);
      if (accessToken == null ) {
        filterChain.doFilter(request, response);
        return;
      }

      Claims claims = this.userJwtService.resolveClaims(request);

      if(claims != null & this.userJwtService.validateClaims(claims)){
        String username = claims.getSubject();

        Authentication authentication = new UsernamePasswordAuthenticationToken(username,"",new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }

    }catch (Exception e){
      errorDetails.put("message", "Authentication Error");
      errorDetails.put("details",e.getMessage());

      response.setStatus(HttpStatus.FORBIDDEN.value());
      response.setContentType(MediaType.APPLICATION_JSON_VALUE);

      this.mapper.writeValue(response.getWriter(), errorDetails);
    }

    filterChain.doFilter(request, response);
  }
}
