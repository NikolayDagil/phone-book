package org.nikolay.phonebook.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nikolay.phonebook.api.dao.IUserDAO;
import org.nikolay.phonebook.api.dao.factory.IDAOFactory;
import org.nikolay.phonebook.api.entity.User;
import org.nikolay.phonebook.dpl.dao.factory.DAOFactory;
import org.nikolay.phonebook.dpl.entity.UserEntity;
import org.nikolay.phonebook.web.constant.PageConstant;
import org.nikolay.phonebook.web.util.EmailValidationUtil;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
@WebServlet(name = "userRegistration", urlPatterns = {"/userRegistration"})
public class UserRegistrationServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    RequestDispatcher requestDispatcher =
        request.getRequestDispatcher(PageConstant.USER_REGISTRATION);
    requestDispatcher.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    if (!username.isEmpty() && !password.isEmpty() && !email.isEmpty() && !firstName.isEmpty()
        && !lastName.isEmpty()) {

      IDAOFactory daoFactory = new DAOFactory();
      Object daoObjectForUser = daoFactory.getDAO("UserDAO");

      IUserDAO userDAO = (IUserDAO) daoObjectForUser;

      EmailValidationUtil emailValidation = new EmailValidationUtil();

      if (!userDAO.isExistsByEmail(email) && !userDAO.isExistsByUsername(username)
          && emailValidation.isNormalEmail(email)) {

        User user = new UserEntity();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        userDAO.save(user);

        Long userId = user.getId();

        @SuppressWarnings("rawtypes")
        Map param_map = request.getParameterMap();

        if (param_map == null) {
          throw new ServletException("getParameterMap returned null in " + getClass().getName());
        }

        @SuppressWarnings("rawtypes")
        Iterator iterator = param_map.entrySet().iterator();
        while (iterator.hasNext()) {
          @SuppressWarnings("rawtypes")
          Map.Entry me = (Map.Entry) iterator.next();

          String[] arr = (String[]) me.getValue();
          for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (i > 0 && i != arr.length - 1) {
              System.out.println(", ");
            }
          }
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PageConstant.USER);
        request.setAttribute("userId", userId);
        requestDispatcher.forward(request, response);

      } else {
        RequestDispatcher requestDispatcher =
            request.getRequestDispatcher(PageConstant.PHONE_REGISTRATION);
        requestDispatcher.forward(request, response);
      }

    } else {
      RequestDispatcher requestDispatcher =
          request.getRequestDispatcher(PageConstant.PHONE_REGISTRATION);
      requestDispatcher.forward(request, response);
    }

  }
}
