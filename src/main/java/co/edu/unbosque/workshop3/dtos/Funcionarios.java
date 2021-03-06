package co.edu.unbosque.workshop3.dtos;

public class Funcionarios {

    private String user;
    private String password;
    private String typeUser;
    private String correo;

    public Funcionarios(String user, String password, String typeUser, String correo) {
        this.user = user;
        this.password = password;
        this.typeUser = typeUser;
        this.correo = correo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
