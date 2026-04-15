package br.com.diego.lab;

public class Administrador {
    private String login;
    private String senha;

    public Administrador(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean autenticar(String loginDigitado, String senhaDigitada) {
        return this.login.equals(loginDigitado) && this.senha.equals(senhaDigitada);
    }

    public String getLogin() {
        return login;
    }
}
