import java.util.Scanner;

public class ContadorA {

    public static void main(String[] args) {
        // Entrada da string a ser verificada
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String entrada = scanner.nextLine();
        scanner.close();
        
        // Contador para a letra 'a'
        int contador = 0;

        // Verifica cada caractere da string
        for (char letra : entrada.toCharArray()) {
            if (letra == 'a' || letra == 'A') {
                contador++;
            }
        }

        // Imprime o resultado
        if (contador > 0) {
            System.out.println("A letra 'a' ocorre " + contador + " vezes na string.");
        } else {
            System.out.println("A letra 'a' não está presente na string.");
        }
    }
}
