package service;

import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Horacio Perez
 */
@WebServlet(name = "HttpService", urlPatterns = {"/HttpService"})
public abstract class HttpService extends HttpServlet {

    protected User user;
    protected HttpServletRequest request;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        this.user = (User) request.getSession().getAttribute("user");
        String serverResponse = this.start(request, user);
        this.printResponse(printWriter, serverResponse);
    }

    private String start(HttpServletRequest request, User user) {
        if (user != null) {
            return this.execute(this.getParameters(request), user);
        } else {
            return null;
        }
    }

    private void printResponse(PrintWriter printWriter, String serverResponse) {
        try {
            printWriter.println(serverResponse);
        } finally {
            printWriter.close();
        }
    }

    protected ArrayList<String> getParameters(HttpServletRequest request) {
        this.request=request;
        ArrayList<String> parameters = new ArrayList<>();
        Enumeration<String> parametersNames = request.getParameterNames();
        while (parametersNames.hasMoreElements()) {
            String parameterName = (String) parametersNames.nextElement();
            parameters.add(request.getParameter(parameterName));
        }
        return parameters;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public abstract String execute(ArrayList<String> parameters, User user);

}
