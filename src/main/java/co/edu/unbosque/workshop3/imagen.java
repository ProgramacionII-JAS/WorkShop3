package co.edu.unbosque.workshop3;

import co.edu.unbosque.workshop3.dtos.Usuarios;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "img-servlet", value = "/img-servlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class imagen extends HttpServlet {

    private String UPLOAD_DIRECTORY = "charged_img";
    private String fileName = "";
    private Usuarios users = new Usuarios("SFlorezS", "123456@", "Propietario", "sflorezs05@gmail.com", "");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        ArrayList<Usuarios> dataUser = new ArrayList<>();
        users = new Usuarios("SFlorezS", "123456@", "Propietario", "sflorezs05@gmail.com", fileName);
        dataUser.add(users);

        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(dataUser));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }

        try {
            for (Part part : request.getParts()) {
                fileName = part.getSubmittedFileName();
                part.write(uploadPath + File.separator + fileName);
            }
            System.out.println(fileName);
            response.sendRedirect(request.getContextPath() + "/propietario.html");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
