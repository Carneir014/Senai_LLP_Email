package Senai_LLP_Email;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Emails {

    public static String normalizar(String email) {
        String[] partes   = email.split("@");
        String nomeLocal  = partes[0];
        String dominio    = partes[1];

        if (nomeLocal.contains("+")) {
            nomeLocal = nomeLocal.substring(0, nomeLocal.indexOf("+"));
        }

        nomeLocal = nomeLocal.replace(".", "");

        return nomeLocal + "@" + dominio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> unicos = new HashSet<>();

        System.out.println("Digite os e-mails (deixe em branco para encerrar):");

        while (true) {
            System.out.print(">> E-mail: ");
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) break;

            unicos.add(normalizar(entrada));
        }

        System.out.println("\nEndereços únicos que receberam e-mail: " + unicos.size());
    }
}