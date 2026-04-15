package br.com.diego.lab;

import java.util.List;
import java.util.Scanner;

public class MenuAdmin {

    private static final int CAPACIDADE_MAXIMA = 10;

    public void exibir(Scanner sc, List<Pet> listaPets) {
        boolean voltar = false;

        do {
            System.out.println("\n==========================");
            System.out.println("     PAINEL DO ADMIN      ");
            System.out.println("==========================");
            System.out.println("1 - Incluir Pet");
            System.out.println("2 - Consultar Pets");
            System.out.println("3 - Excluir Pet");
            System.out.println("4 - Voltar");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    incluirPet(sc, listaPets);
                    break;
                case 2:
                    consultarPets(listaPets);
                    break;
                case 3:
                    excluirPet(sc, listaPets);
                    break;
                case 4:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (!voltar);
    }

    private void incluirPet(Scanner sc, List<Pet> listaPets) {
        if (listaPets.size() >= CAPACIDADE_MAXIMA) {
            System.out.println("Capacidade maxima atingida! Nao e possivel cadastrar mais pets.");
            System.out.println("Limite: " + CAPACIDADE_MAXIMA + " pets.");
            return;
        }

        System.out.println("\n--- Cadastro de Pet ---");
        System.out.print("Nome do pet: ");
        String nome = sc.nextLine();
        System.out.print("Idade do pet: ");
        int idade = sc.nextInt();
        sc.nextLine();
        System.out.print("Peso do pet (kg): ");
        double peso = sc.nextDouble();
        sc.nextLine();

        Pet pet = new Pet(nome, idade, peso);
        listaPets.add(pet);

        System.out.println("Pet cadastrado com sucesso!");
        System.out.println("Vagas restantes: " + (CAPACIDADE_MAXIMA - listaPets.size()));
    }

    private void consultarPets(List<Pet> listaPets) {
        if (listaPets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Pets ---");
        for (int i = 0; i < listaPets.size(); i++) {
            Pet pet = listaPets.get(i);
            System.out.println("__________________________");
            System.out.println("[" + (i + 1) + "] Nome: " + pet.getNome());
            System.out.println("    Idade: " + pet.getIdade() + " anos");
            System.out.println("    Peso:  " + pet.getPeso() + " kg");
        }
        System.out.println("__________________________");
        System.out.println("Total: " + listaPets.size() + "/" + CAPACIDADE_MAXIMA + " pets");
    }

    private void excluirPet(Scanner sc, List<Pet> listaPets) {
        if (listaPets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado para excluir.");
            return;
        }

        consultarPets(listaPets);

        System.out.print("\nDigite o numero do pet para excluir (0 para cancelar): ");
        int numero = sc.nextInt();
        sc.nextLine();

        if (numero == 0) {
            System.out.println("Operacao cancelada.");
            return;
        }

        if (numero < 1 || numero > listaPets.size()) {
            System.out.println("Numero invalido!");
            return;
        }

        Pet petRemovido = listaPets.remove(numero - 1);
        System.out.println("Pet '" + petRemovido.getNome() + "' removido com sucesso!");
    }
}
