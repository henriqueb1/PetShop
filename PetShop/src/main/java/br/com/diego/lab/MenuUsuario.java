package br.com.diego.lab;

import java.util.Scanner;

public class MenuUsuario {

    private Servico servico = new Servico();

    public void exibir(Scanner sc) {
        boolean voltar = false;

        do {
            System.out.println("\n==========================");
            System.out.println("    AREA DO USUARIO       ");
            System.out.println("==========================");
            System.out.println("1 - Consultar precos dos servicos");
            System.out.println("2 - Voltar");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    consultarPrecos(sc);
                    break;
                case 2:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (!voltar);
    }

    private void consultarPrecos(Scanner sc) {
        System.out.println("\n--- Consulta de Precos ---");
        System.out.println("Informe os dados do seu pet para calcular o preco:");
        System.out.print("Idade do pet (anos): ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Peso do pet (kg): ");
        double peso = sc.nextDouble();
        sc.nextLine();

        System.out.println("\nServicos disponiveis para pet com " + idade + " anos e " + peso + " kg:");
        servico.exibirTabelaPrecos(peso, idade);

        System.out.println("\nDeseja ver o preco de um servico especifico?");
        System.out.println("1 - Banho e Tosa");
        System.out.println("2 - Banho");
        System.out.println("3 - Tosa");
        System.out.println("4 - Tosa Higienica");
        System.out.println("5 - Voltar");
        System.out.print("Escolha: ");
        int servEscolhido = sc.nextInt();
        sc.nextLine();

        if (servEscolhido >= 1 && servEscolhido <= 4) {
            System.out.println("\nDeseja incluir busca/frete? (1-Sim / 2-Nao)");
            System.out.print("Escolha: ");
            int frete = sc.nextInt();
            sc.nextLine();
            boolean comBusca = (frete == 1);

            double preco = 0;
            String nomeServico = "";

            switch (servEscolhido) {
                case 1:
                    preco = servico.calcularBanhoTosa(peso, idade, comBusca);
                    nomeServico = "Banho e Tosa";
                    break;
                case 2:
                    preco = servico.calcularBanho(peso, idade, comBusca);
                    nomeServico = "Banho";
                    break;
                case 3:
                    preco = servico.calcularTosa(peso, idade, comBusca);
                    nomeServico = "Tosa";
                    break;
                case 4:
                    preco = servico.calcularTosaHigienica(peso, idade, comBusca);
                    nomeServico = "Tosa Higienica";
                    break;
            }

            System.out.println("\n>>> " + nomeServico + (comBusca ? " com busca" : " sem busca") + ": R$ " + String.format("%.2f", preco));
        }
    }
}
