/**
 * 
 */
package org.nikolay.phonebook.web.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
public class EmailValidationUtil {

  public boolean isNormalEmail(String email) {
    Pattern pat;
    Matcher mat;
    boolean found;

    pat =
        Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    mat = pat.matcher(email);
    found = mat.matches();
    return found;
  }
}
