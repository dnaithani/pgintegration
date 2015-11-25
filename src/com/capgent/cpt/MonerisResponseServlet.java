package com.capgent.cpt;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MonerisResponseServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/plain");
        response.getWriter().println("DOGET: Moneris Response Receiver");
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/plain");
        response.getWriter().println("DOPOST: Moneris Response Receiver");
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        Enumeration en = request.getParameterNames();
        StringBuilder cmd = new StringBuilder("");
        String paramName;
        String paramValue;
        String charset = request.getParameter("charset");
        while (en.hasMoreElements())
        {
            paramName = (String) en.nextElement();
            paramValue = request.getParameter(paramName);
            cmd.append("&").append(paramName).append("=");
            if (charset == null || charset.length() == 0)
            {
                cmd.append(paramValue);
            }
            else
            {
                cmd.append(URLEncoder.encode(paramValue, charset));
            }
        }
        response.getWriter().println(cmd.toString());
    }
}
