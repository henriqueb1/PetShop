package br.com.diego.lab;

public class Servico {

    // Preços base por serviço
    private static final double PRECO_BANHO_TOSA = 80.0;
    private static final double PRECO_BANHO = 50.0;
    private static final double PRECO_TOSA = 45.0;
    private static final double PRECO_TOSA_HIGIENICA = 35.0;
    private static final double TAXA_FRETE = 20.0;

    // Ajuste por peso do pet
    private double calcularAjustePeso(double peso) {
        if (peso <= 5) {
            return 0.0;
        } else if (peso <= 10) {
            return 10.0;
        } else if (peso <= 20) {
            return 20.0;
        } else {
            return 35.0;
        }
    }

    // Ajuste por idade do pet
    private double calcularAjusteIdade(int idade) {
        if (idade <= 1) {
            return 10.0; // filhote precisa de mais cuidado
        } else if (idade >= 10) {
            return 10.0; // pet idoso precisa de mais cuidado
        } else {
            return 0.0;
        }
    }

    public double calcularBanhoTosa(double peso, int idade, boolean comBusca) {
        double total = PRECO_BANHO_TOSA + calcularAjustePeso(peso) + calcularAjusteIdade(idade);
        if (comBusca) total += TAXA_FRETE;
        return total;
    }

    public double calcularBanho(double peso, int idade, boolean comBusca) {
        double total = PRECO_BANHO + calcularAjustePeso(peso) + calcularAjusteIdade(idade);
        if (comBusca) total += TAXA_FRETE;
        return total;
    }

    public double calcularTosa(double peso, int idade, boolean comBusca) {
        double total = PRECO_TOSA + calcularAjustePeso(peso) + calcularAjusteIdade(idade);
        if (comBusca) total += TAXA_FRETE;
        return total;
    }

    public double calcularTosaHigienica(double peso, int idade, boolean comBusca) {
        double total = PRECO_TOSA_HIGIENICA + calcularAjustePeso(peso) + calcularAjusteIdade(idade);
        if (comBusca) total += TAXA_FRETE;
        return total;
    }

    public void exibirTabelaPrecos(double peso, int idade) {
        System.out.println("--------------------------------------------");
        System.out.printf("%-20s | %-12s | %-12s%n", "Servico", "Sem Busca", "Com Busca");
        System.out.println("--------------------------------------------");
        System.out.printf("%-20s | R$ %-9.2f | R$ %-9.2f%n", "Banho e Tosa",
                calcularBanhoTosa(peso, idade, false), calcularBanhoTosa(peso, idade, true));
        System.out.printf("%-20s | R$ %-9.2f | R$ %-9.2f%n", "Banho",
                calcularBanho(peso, idade, false), calcularBanho(peso, idade, true));
        System.out.printf("%-20s | R$ %-9.2f | R$ %-9.2f%n", "Tosa",
                calcularTosa(peso, idade, false), calcularTosa(peso, idade, true));
        System.out.printf("%-20s | R$ %-9.2f | R$ %-9.2f%n", "Tosa Higienica",
                calcularTosaHigienica(peso, idade, false), calcularTosaHigienica(peso, idade, true));
        System.out.println("--------------------------------------------");
        System.out.println("* Taxa de busca/frete: R$ " + TAXA_FRETE);
    }
}
