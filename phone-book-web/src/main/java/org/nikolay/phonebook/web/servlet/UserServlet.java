package org.nikolay.phonebook.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

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

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
@WebServlet(name = "user", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    Enumeration parameterNames = request.getParameterNames();

    String resultPage = null;
    if (parameterNames.hasMoreElements() && !request.getParameter("userId").isEmpty()) {

      String userId = request.getParameter("userId");

      IDAOFactory daoFactory = new DAOFactory();
      Object daoObjectForUser = daoFactory.getDAO("UserDAO");
      IUserDAO userDAO = (IUserDAO) daoObjectForUser;

      User user = new UserEntity();
      user.getPhones();
      user = userDAO.getId(Long.parseLong(userId));
      request.setAttribute("user", user);
      resultPage = PageConstant.USER;
    } else {
      resultPage = PageConstant.USER_REGISTRATION;
    }

    RequestDispatcher requestDispatcher = request.getRequestDispatcher(resultPage);
    requestDispatcher.forward(request, response);
  }
}
