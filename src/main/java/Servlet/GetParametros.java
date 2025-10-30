package Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//Anotacion-> es una llave para cponectarse desde cualwquier parte de
//mi programa al servlet
@WebServlet("/parametros")
public class GetParametros extends HttpServlet {
    @Override
    protected void  doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        //Capturo el parametro ID
        //String id = req.getParameter("id");
        //int ide = Integer.parseInt(id);
        //float valor = Float.parseFloat(id);
        int id = Integer.parseInt(req.getParameter("id"));
        //Creamos el objeto printWritter
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Saludos desde el Servlet</h1>");
        out.println("<br>");
        out.println("<h2> ID: "+id+"</h2>");
        out.println("</body>");
        out.print("<!html>");

    }

}
