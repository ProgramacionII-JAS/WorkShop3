package co.edu.unbosque.workshop3.dtos;

public class Usuarios {

    private String username;
    private String dateR;
    private String petName;
    private String passWord;
    private String typeUser;
    private String correo;
    private String urlImg;

    public Usuarios(String dateR, String petName, String correo, String urlImg) {
        this.dateR = dateR;
        this.petName = petName;
        this.correo = correo;
        this.urlImg = urlImg;
    }

    public Usuarios(String username, String correo, String password, String typeUser, String urlImg) {
        this.username = username;
        this.correo = correo;
        this.passWord = password;
        this.typeUser = typeUser;
        this.urlImg = urlImg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDateR() {
        return dateR;
    }

    public void setDateR(String dateR) {
        this.dateR = dateR;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
