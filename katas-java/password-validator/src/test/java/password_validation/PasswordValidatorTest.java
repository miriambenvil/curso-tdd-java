package password_validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;


public class PasswordValidatorTest {

  public Set<String> checkPassword(String password) {
    var response = new HashSet<String>();

    if (password.length() <= 8) {
      response.add("moreThan8");
    }
    if (!password.contains("_")) {
      response.add("hasUnderscore");
    }
    if (!password.matches(".*\\d.*")) {
      response.add("hasNumber");
    }
    if (!password.matches(".*[A-Z].*")) {
      response.add("hasCapitalLetter");
    }
    if (!password.matches(".*[a-z].*")) {
      response.add("hasLowerCase");
    }
    return response;
  }

  @Test
  public void check_length_more_than_8() {
    assertTrue(checkPassword("hi").contains("moreThan8"));
  }

  @Test
  public void check_has_underscore() {
    assertTrue(checkPassword("juanymiriam").contains("hasUnderscore"));
  }

  @Test
  public void check_has_number() {
    assertTrue(checkPassword("hi").contains("hasNumber"));
  }

  @Test
  public void check_has_capital_letter() {
    assertTrue(checkPassword("hi").contains("hasCapitalLetter"));
  }

  @Test
  public void check_has_lower_case() {
    assertTrue(checkPassword("57U").contains("hasLowerCase"));
  }

}

// - Try with a password with lest than 9 characters
// - Try with a password without an underscore
// - Try with a password without a number
// - Try with a password without a capital letter
// - Try with a password without lowercase