import java.util.Scanner;

public class FibonacciCheck {

    public static void main(String[] args) {
        // Entrada do número a ser verificado
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para verificar se pertence à sequência de Fibonacci: ");
        int numero = scanner.nextInt();
        scanner.close();
        
        // Variáveis iniciais da sequência de Fibonacci
        int a = 0, b = 1;
        
        // Caso o número seja 0 ou 1, já pertence à sequência
        if (numero == a || numero == b) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
            return;
        }
        
        // Loop para calcular a sequência de Fibonacci e verificar se o número informado pertence
        int proximo = a + b;
        while (proximo <= numero) {
            if (proximo == numero) {
                System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
                return;
            }
            a = b;
            b = proximo;
            proximo = a + b;
        }
        
        // Se sair do loop, o número não pertence à sequência
        System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
    }
}
