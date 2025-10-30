package Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

//Anotacion-> es una llave para cponectarse desde cualwquier parte de
// mi programa al servlet
@WebServlet("/holaServlet")
public class Servlet extends HttpServlet {


    @Override
    protected void  doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Tipo de documento o acrthivo que me va adevolver el se3rvlet
        resp.setContentType("text/html");
        //creamos el objeto get parametros
        GetParametros getParametros = new GetParametros();
        //Capturo el parametro nombre
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String direccion = req.getParameter("direccion");
        Integer num_de_cedula = Integer.valueOf(req.getParameter("num_de_cedula"));
        //Inicializamos el objeto PrintWitter
        // Capturar la fecha de nacimiento
        String fechaNacimientoStr = req.getParameter("fecha_nacimiento");
        // Variables para guardar la edad
        int anos = 0;
        int meses = 0;
        int dias = 0;

        // 2. Calcular la edad (solo si la fecha no es nula o vacía)
        if (fechaNacimientoStr != null && !fechaNacimientoStr.isEmpty()) {
            // 3. Convertir el String a un objeto LocalDate
            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);

            // 4. Obtener la fecha actual
            LocalDate fechaActual = LocalDate.now();

            // 5. Calcular el período entre las dos fechas
            Period periodo = Period.between(fechaNacimiento, fechaActual);

            // 6. Obtener los componentes de la edad
            anos = periodo.getYears();
            meses = periodo.getMonths();
            dias = periodo.getDays();
        }
        // Paara escribir en panatalla
        PrintWriter out = resp.getWriter();
        /*
         *Escribimos la repsuesta del servidor
         * */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<br>");
        out.println("<h2> Nombre: " + nombre + "</h2>");
        out.println("<br>");
        out.println("<h2> Apellido: " + apellido + "</h2>");
        out.println("<br>");
        out.println("<h2> Direccion: " + direccion + "</h2>");
        out.println("<br>");
        out.println("<h2> Numero de cedula: " + num_de_cedula + "</h2>");
        out.println("<br>");
        out.println("<h2> Fecha de Nacimiento: " + fechaNacimientoStr + "</h2>");
        out.println("<br>");
        out.println("<h2> Tu edad es: " + anos + " años, " + meses + " meses y " + dias + " días</h2>");
        out.println("</body>");
        out.print("<!html>");
    }
}
