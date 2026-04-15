package br.com.diego.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pet> listaPets = new ArrayList<Pet>();
        Scanner sc = new Scanner(System.in);
        Administrador admin = new Administrador("admin", "1234");
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuUsuario menuUsuario = new MenuUsuario();

        boolean encerrar = false;

        System.out.println("==========================");
        System.out.println("  Seja bem vindo ao Petshop ");
        System.out.println("==========================");

        do {
            System.out.println("\n-- Menu Principal --");
            System.out.println("1 - Administrador");
            System.out.println("2 - Usuario");
            System.out.println("3 - Encerrar");
            System.out.print("Escolha: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    if (fazerLogin(sc, admin)) {
                        menuAdmin.exibir(sc, listaPets);
                    } else {
                        System.out.println("Login ou senha incorretos. Acesso negado.");
                    }
                    break;
                case 2:
                    menuUsuario.exibir(sc);
                    break;
                case 3:
                    encerrar = true;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (!encerrar);

        sc.close();
    }

    private static boolean fazerLogin(Scanner sc, Administrador admin) {
        System.out.println("\n--- Login Administrador ---");
        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        return admin.autenticar(login, senha);
    }
}
