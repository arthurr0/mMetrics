package pl.minecodes.mmetrics.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.minecodes.mmetrics.user.rest.UserRegisterRequest;
import pl.minecodes.mmetrics.user.rest.UserLoginRequest;
import pl.minecodes.mmetrics.user.rest.UserLoginResponse;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  private final UserFactory userFactory;
  private final UserService userService;
  private final UserJwtService userJwtService;
  private final UserDataValidation userDataValidation;
  private final AuthenticationManager authenticationManager;

  public UserController(
      UserFactory userFactory,
      UserService userService,
      UserJwtService userJwtService,
      UserDataValidation userDataValidation,
      AuthenticationManager authenticationManager
  ) {
    this.userFactory = userFactory;
    this.userService = userService;
    this.userJwtService = userJwtService;
    this.userDataValidation = userDataValidation;
    this.authenticationManager = authenticationManager;
  }

  @PutMapping("/register")
  public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
    if (request.getUsername() == null || request.getPassword() == null || request.getEmail() == null) {
      throw new UserCreationException("Username, password and email cannot be null.");
    }

    if (this.userService.findByUsername(request.getUsername()).isPresent()) {
      throw new UserCreationException("User with this username already exists.");
    }

    if (this.userService.findByEmail(request.getEmail()).isPresent()) {
      throw new UserCreationException("User with this email already exists.");
    }

    if (request.getUsername().length() < 3 || request.getUsername().length() > 64) {
      throw new UserCreationException("Username must be between 3 and 64 characters.");
    }

    if (!this.userDataValidation.passwordRestrictionsValid(request.getPassword())) {
      throw new UserCreationException("Password must be at least 8 characters long, contain at least one digit, one lowercase letter and one uppercase letter.");
    }

    if (!this.userDataValidation.emailValid(request.getEmail())) {
      throw new UserCreationException("Email is not valid.");
    }

    User user = this.userFactory.createUser(request.getUsername(), request.getPassword(), request.getEmail());

    return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(user));
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody UserLoginRequest request)  {
    try {
      Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
      String username = authentication.getName();

      User user = this.userService.findByUsername(username)
          .orElseThrow(() -> new UserNotFoundException("User not found."));

      String token = this.userJwtService.createToken(user);

      return ResponseEntity.ok(new UserLoginResponse(username, token));
    } catch (BadCredentialsException exception){
      throw new UserLoginException("Invalid username or password.");
    }catch (Exception e){
      throw new UserLoginException("Error during login.", e);
    }
  }
}
