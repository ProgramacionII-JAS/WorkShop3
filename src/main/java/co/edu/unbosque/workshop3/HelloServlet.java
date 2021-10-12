package co.edu.unbosque.workshop3;

import co.edu.unbosque.workshop3.dtos.Funcionarios;
import co.edu.unbosque.workshop3.dtos.Usuarios;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "hello-servlet", value = "/hello-servlet")

public class HelloServlet extends HttpServlet {

    private Usuarios infoUser;
    private Cookie cookieCorreo;
    private Cookie cookieCorreoF;
    private Cookie cookieRol;
    private Cookie cookieRolF;
    private Funcionarios infoFunctionary;
    private ArrayList<Usuarios> dataUser = new ArrayList<>();
    private ArrayList<Funcionarios> dataFuntionary = new ArrayList<>();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        infoUser = new Usuarios("SFlorezS05","sflorezs05@gmail.com", "123456@", "Propietario", "");
        dataUser.add(infoUser);
        infoFunctionary = new Funcionarios("Deivid05", "1234567@", "Funcionario", "deivid05@hotmail.com");
        dataFuntionary.add(infoFunctionary);

        try{
            if (infoUser.getUsername().equals(request.getParameter("userName")) && infoUser.getPassWord().equals(request.getParameter("password"))){
                String correo = infoUser.getCorreo();
                cookieCorreo = new Cookie("Correo_usuario", correo);
                String rol = infoUser.getTypeUser();
                cookieRol = new Cookie("Rol_usuario", rol);
                response.addCookie(cookieCorreo);
                response.addCookie(cookieRol);
                cookieCorreo.setMaxAge(3600);
                cookieRol.setMaxAge(3600);
                response.sendRedirect(request.getContextPath() + "/propietario.html");
            }else if(infoFunctionary.getUser().equals(request.getParameter("userName")) && infoFunctionary.getPassword().equals(request.getParameter("password"))){
                String correoF = infoFunctionary.getCorreo();
                cookieCorreoF = new Cookie("Correo_Usuario", correoF);
                String rolF = infoFunctionary.getTypeUser();
                cookieRolF = new Cookie("Rol_Usuario", rolF);
                response.addCookie(cookieCorreoF);
                response.addCookie(cookieRolF);
                cookieCorreoF.setMaxAge(3600);
                cookieRolF.setMaxAge(3600);
                response.sendRedirect(request.getContextPath() + "/funcionario.html");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Cookie getCookieCorreo() {
        return cookieCorreo;
    }

    public void setCookieCorreo(Cookie cookieCorreo) {
        this.cookieCorreo = cookieCorreo;
    }

    public Cookie getCookieCorreoF() {
        return cookieCorreoF;
    }

    public void setCookieCorreoF(Cookie cookieCorreoF) {
        this.cookieCorreoF = cookieCorreoF;
    }

    public Cookie getCookieRol() {
        return cookieRol;
    }

    public void setCookieRol(Cookie cookieRol) {
        this.cookieRol = cookieRol;
    }

    public Cookie getCookieRolF() {
        return cookieRolF;
    }

    public void setCookieRolF(Cookie cookieRolF) {
        this.cookieRolF = cookieRolF;
    }
}