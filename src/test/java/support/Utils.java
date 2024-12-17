package support;

import java.util.Random;

public class Utils {

    public static String getRamdomEmail() {
        // Gerando E-mail eleatório
        String email_init = "qualquer_";
        String email_final = "@hotmail.com.br";
        // Gerando número aleatório
        Random ResultAleatorio = new Random();
        int minimo = 1;
        int maximo = 999999999;
        int resultado = ResultAleatorio.nextInt(maximo - minimo) + minimo;

        return email_init + resultado + email_final;
    }

    public static String NumerosCPFAleatorio() {
        //Gerando 5 números aleatórios
        int qtMaximoNumeros = 11;
        String[] Numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
                "9"};

        StringBuilder numero = new StringBuilder();

        for (int i = 0; i < qtMaximoNumeros; i++) {
            int posicao = (int) (Math.random() * Numeros.length);
            numero.append(Numeros[posicao]);
        }
        return numero.toString();
    }

    public static String getNomeAleatorio() {
        int qtdeMaximaNomes = 1;
        String[] NomeAleatorio = {"José ", "João ", "Miguel ", "Arthur ", "Gael ", "Rosana ",
                "Fernanda ", "Josefa ", "Severina ", "Helena ", "Maria ", "Ludmilla ", "Renata ",
                "Heitor ", "Alice ", "Laura ", "Theo ", "Joana ", "Fabricio ", "Raphael ", "Elaine ",
                "Camilla ", "Rogerio ", "Lara ", "Rafaela ", "Cristiano ", "Carol ", "Karoline ",
                "Caroline ", "Karol ", "Junior ", "Ronaldo ", "Ronildo ", "Rodina ", "Roberto "};

        StringBuilder nome = new StringBuilder();

        for (int i = 0; i < qtdeMaximaNomes; i++) {
            int posicao = (int) (Math.random() * NomeAleatorio.length);
            nome.append(NomeAleatorio[posicao]);
        }

        return nome.toString();
    }

    public static String getSobreNomeAleatorio() {
        int qtdeMaximaSobrNomes = 1;
        String[] SobreNomeAleatorio = {"Araujo", "Nogueira", "Silva", "Almeida",
                "Alves", "Andrade", "Barbosa", "Barros", "Baptista", "Batista", "Borges",
                "Pereira", "Campos", "Cardoso", "Carvalho", "Castro", "Costa", "Dias", "Duarte",
                "Freitas", "Fernandes", "Ferreira", "Garcia", "Gomes", "Gonçalves", "Lima",
                "Lopes", "Machado", "Marques", "Martins", "Medeiros", "Melo", "Mendes", "Miranda"};

        StringBuilder Sobrnome = new StringBuilder();

        for (int i = 0; i < qtdeMaximaSobrNomes; i++) {
            int posicao = (int) (Math.random() * SobreNomeAleatorio.length);
            Sobrnome.append(SobreNomeAleatorio[posicao]);
        }
        return Sobrnome.toString();
    }
}
