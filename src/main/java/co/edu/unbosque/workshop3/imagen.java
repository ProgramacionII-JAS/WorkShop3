package co.edu.unbosque.workshop3;

import co.edu.unbosque.workshop3.dtos.Usuarios;
import com.google.gson.Gson;
import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
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
    private String petName = "";
    private Usuarios infoUser = new Usuarios("SflorezS05","sflorezs05@gmail.com", "123456@", "Propietario", "");
    private Usuarios users = new Usuarios("", petName, "sflorezs05@gmail.com", "");

    private ArrayList<Usuarios> dataUser = new ArrayList<>();
    private Date date;
    private String dateS = "";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
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
        try{
            petName = request.getParameter("PetName");

            infoUser.setPetName(petName);

            for (Part part : request.getParts()) {
                fileName = part.getSubmittedFileName();
                Random rnd = new Random();
                int newName = rnd.nextInt(100000);
                fileName = String.valueOf(newName)+ "." + FilenameUtils.getExtension(fileName);
                part.write(uploadPath + File.separator + fileName);
            }
            infoUser.setUrlImg(fileName);
            date = new Date();
            dateS = String.valueOf(date);
            users = new Usuarios(dateS, petName, "sflorezs05@gmail.com", fileName);
            dataUser.add(users);
            response.sendRedirect(request.getContextPath() + "/propietario.html");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
