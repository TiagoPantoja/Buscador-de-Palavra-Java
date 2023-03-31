    package org.example;

    import java.io.IOException;
    import java.net.URL;

    public class HtmlAnalyzer {

        public static void main(String[] args) throws IOException {
            try {
                // Cria uma nova URL com o endereço da página HTML
                URL url = new URL("http://hiring.axreng.com/internship/example1.html");

                // Cria um novo objeto com a URL como parâmetro
                BuscadorDeTextoMaisProfundo buscador = new BuscadorDeTextoMaisProfundo(url);

                // Busca o texto mais profundo
                buscador.encontrarTextoMaisProfundo();

                // Imprime o resultado da busca
                System.out.println(buscador.getTextoMaisProfundo());
            } catch (IOException e) {
                // Caso ocorra uma falha de conexão, imprime um erro
                System.out.println("URL connection error");
            }
        }
    }