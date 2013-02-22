package org.nikolay.phonebook.web.servlet;

import java.io.IOException;
import java.util.List;

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
import org.nikolay.phonebook.web.constant.PageConstant;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
@WebServlet(name = "users", urlPatterns = {"/users"})
public class UsersServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    IDAOFactory daoFactory = new DAOFactory();
    Object daoObjectForUser = daoFactory.getDAO("UserDAO");

    IUserDAO userDAO = (IUserDAO) daoObjectForUser;

    List<User> users = userDAO.getAll();

    request.setAttribute("users", users);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(PageConstant.USERS);
    requestDispatcher.forward(request, response);
  }
}
