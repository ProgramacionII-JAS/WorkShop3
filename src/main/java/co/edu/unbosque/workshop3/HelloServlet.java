package co.edu.unbosque.workshop3;

import co.edu.unbosque.workshop3.dtos.Funcionarios;
import co.edu.unbosque.workshop3.dtos.Usuarios;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private Usuarios infoUser;
    private Funcionarios infoFunctionary;
    private ArrayList<Usuarios> dataUser = new ArrayList<>();
    private ArrayList<Funcionarios> dataFuntionary = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        infoUser = new Usuarios("SFlorezS", "123456@", "Propietario", "sflorezs05@gmail.com");
        dataUser.add(infoUser);
        infoFunctionary = new Funcionarios("Deivid05", "1234567@", "Funcionario", "deivid05@hotmail.com");
        dataFuntionary.add(infoFunctionary);

        //PrintWriter out = response.getWriter();
        //out.println(new Gson().toJson(dataUser));
        response.sendRedirect(request.getContextPath() + "/propietario.html");
        for (int i = 0; i < dataUser.size(); i++){
            if (dataUser.get(i).equals(request.getParameter("userName"))){
                String correo = dataUser.get(3).toString();
                response.sendRedirect(request.getContextPath() + "/propietario.html");
                Cookie cookieCorreo = new Cookie("Correo", correo);
                Cookie cookieRol = new Cookie("Rol", "Propietario");
                response.addCookie(cookieCorreo);
            }else if(dataUser.get(i).equals("Deivid05")){
                response.sendRedirect(request.getContextPath() + "/funcionario.html");
                Cookie cookieCorreo = new Cookie("Correo", "deivid05@hotmail.com");
                response.addCookie(cookieCorreo);
            }
        }
    }
}