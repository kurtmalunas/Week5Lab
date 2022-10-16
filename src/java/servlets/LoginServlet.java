
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kurtm
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("incorrectLogin", "");
        
        if(session.getAttribute("username") != null) {
            String action = request.getParameter("action");
            if(action != null && action.equals("Log out")) {
                session.invalidate();
                request.setAttribute("incorrectLogin", "Successful Logout");
                session = request.getSession();
            } else {
                response.sendRedirect("home");
                return;
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");  
        String password = request.getParameter("password");
        
        if(username == null || password == null || username == "" || password == "") {
            request.setAttribute("incorrectLogin", "Please Fill in Username and Password");
            
        }
        
        AccountService account = new AccountService();
        AccountService validate = account.login(username, password);
        
        if (validate == null) {
            request.setAttribute("incorrectLogin", "Incorrect Username and Password");
            request.setAttribute("username", username);
        } else {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    public class AccountService {
        private String username;
                
        public AccountService() {
        
        }
        public AccountService(String username, String password) {
            this.username = username;
        }
        String[] usernames = {"abe", "barb"};
        String[] passwords = {"password", "password"};
        
        public AccountService login(String username, String password) {
            for(int index = 0; index < usernames.length; index++) {
                if(usernames[index].equals(username)) {
                    if(passwords[index].equals(password)) {
                        AccountService account = new AccountService(username, null);
                        return account;
                    }
                }
            }
            
            return null;
        }
        public String getUsername() {
            return this.username;
        }
    }
}
