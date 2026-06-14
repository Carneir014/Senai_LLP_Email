package Senai_LLP_Email;
import java.util.HashSet;
import java.util.Set;

public class Emails {

    public static int numEmailsUnicos(String[] emails) {
        Set<String> unicos = new HashSet<>();

        for (String email : emails) {
            String[] partes = email.split("@");
            String nomeLocal = partes[0];
            String dominio   = partes[1];

            // Ignora tudo depois do primeiro '+'
            if (nomeLocal.contains("+")) {
                nomeLocal = nomeLocal.substring(0, nomeLocal.indexOf("+"));
            }

            // Remove todos os pontos do nome local
            nomeLocal = nomeLocal.replace(".", "");

            unicos.add(nomeLocal + "@" + dominio);
        }

        return unicos.size();
    }

    public static void main(String[] args) {
        String[] emails1 = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };
        System.out.println(numEmailsUnicos(emails1)); // 2

        String[] emails2 = {
            "a@leetcode.com",
            "b@leetcode.com",
            "c@leetcode.com"
        };
        System.out.println(numEmailsUnicos(emails2)); // 3
    }
}