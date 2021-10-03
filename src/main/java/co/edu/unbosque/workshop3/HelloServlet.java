package co.edu.unbosque.workshop3;

import co.edu.unbosque.workshop3.dtos.Funcionarios;
import co.edu.unbosque.workshop3.dtos.Usuarios;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")

public class HelloServlet extends HttpServlet {

    private Usuarios infoUser;
    private Funcionarios infoFunctionary;
    private ArrayList<Usuarios> dataUser = new ArrayList<>();
    private ArrayList<Funcionarios> dataFuntionary = new ArrayList<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json");
        infoUser = new Usuarios("SFlorezS", "123456@", "Propietario", "sflorezs05@gmail.com");
        dataUser.add(infoUser);
        infoFunctionary = new Funcionarios("Deivid05", "1234567@", "Funcionario", "deivid05@hotmail.com");
        dataFuntionary.add(infoFunctionary);

        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(dataUser));
        try{
            if (infoUser.getUser().equals(request.getParameter("userName")) && infoUser.getPassword().equals(request.getParameter("password"))){
                String correo = infoUser.getCorreo();
                Cookie cookieCorreo = new Cookie("Correo", correo);
                String rol = infoUser.getTypeUser();
                Cookie cookieRol = new Cookie("Rol", rol);
                response.addCookie(cookieCorreo);
                response.addCookie(cookieRol);
                response.sendRedirect(request.getContextPath() + "/propietario.html");
            }else if(infoFunctionary.getUser().equals(request.getParameter("userName")) && infoFunctionary.getPassword().equals(request.getParameter("password"))){
                Cookie cookieCorreo = new Cookie("Correo", "deivid05@hotmail.com");
                response.addCookie(cookieCorreo);
                response.sendRedirect(request.getContextPath() + "/funcionario.html");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}