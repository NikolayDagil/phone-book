package org.nikolay.phonebook.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nikolay.phonebook.api.dao.IPhoneDAO;
import org.nikolay.phonebook.api.dao.IUserDAO;
import org.nikolay.phonebook.api.dao.factory.IDAOFactory;
import org.nikolay.phonebook.api.entity.Phone;
import org.nikolay.phonebook.api.entity.User;
import org.nikolay.phonebook.dpl.dao.PhoneDAO;
import org.nikolay.phonebook.dpl.dao.factory.DAOFactory;
import org.nikolay.phonebook.dpl.entity.PhoneEntity;
import org.nikolay.phonebook.web.constant.PageConstant;

/**
 * @author Nikolay Dagil
 * @version 1.0.0
 */
@WebServlet(name = "phoneRegistration", urlPatterns = {"/phoneRegistration"})
public class PhoneRegistrationServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Enumeration parameterNames = request.getParameterNames();

    String resultPage = null;
    if (parameterNames.hasMoreElements() && !request.getParameter("userId").isEmpty()) {
      request.setAttribute("userId", request.getParameter("userId"));
      resultPage = PageConstant.PHONE_REGISTRATION;
    } else {
      resultPage = PageConstant.USER;
    }

    RequestDispatcher requestDispatcher = request.getRequestDispatcher(resultPage);
    requestDispatcher.forward(request, response);

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String number = request.getParameter("number");
    String type = request.getParameter("type");
    String userId = request.getParameter("userId");

    if (!number.isEmpty() && !type.isEmpty() && !userId.isEmpty()) {

      IDAOFactory daoFactory = new DAOFactory();
      Object daoObjectForUser = daoFactory.getDAO("UserDAO");
      IUserDAO userDAO = (IUserDAO) daoObjectForUser;

      User user = userDAO.getId(Long.parseLong(userId));

      IPhoneDAO phoneDAO = new PhoneDAO();
      Phone phone = new PhoneEntity();
      phone.setType(type);
      phone.setUser(user);
      phone.setNumber(number);
      
      phoneDAO.save(phone);

      RequestDispatcher requestDispatcher = request.getRequestDispatcher(PageConstant.USER);
      requestDispatcher.forward(request, response);
    } else {
      RequestDispatcher requestDispatcher =
          request.getRequestDispatcher(PageConstant.PHONE_REGISTRATION);
      requestDispatcher.forward(request, response);

    }
  }
}
