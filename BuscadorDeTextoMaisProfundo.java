package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Stack;

public class BuscadorDeTextoMaisProfundo {
    //Atributos da Classe
    private URL url;
    private String textoMaisProfundo;
    private int nivelMaisProfundo;
    private Stack<String> pilhaDeTags;
    private boolean contemHtmlMalformado;

    // Construtor da Classe
    public BuscadorDeTextoMaisProfundo(URL url) {
        this.url = url;
        this.textoMaisProfundo = null;
        this.nivelMaisProfundo = -1;
        this.pilhaDeTags = new Stack<>();
    }

    // Método que retorna o texto mais profundo
    public String getTextoMaisProfundo() {
        return textoMaisProfundo;
    }

    // Método que faz a busca do texto mais profundo
    public void encontrarTextoMaisProfundo() throws IOException {
        try {
            // Abre a conexão com a URL
            URLConnection conn = url.openConnection();
            BufferedReader leitor = new BufferedReader(new InputStreamReader(url.openStream()));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Verifica se a linha começa com uma tag HTML
                String linhaSemEspacos = linha.trim();
                if (linhaSemEspacos.startsWith("<")) {
                    if (linhaSemEspacos.startsWith("</")) {
                        // Remove a última tag da pilha
                        pilhaDeTags.pop();
                    } else {
                        // Adiciona a tag na pilha
                        String novaTag = linhaSemEspacos.substring(1, linhaSemEspacos.indexOf(">"));
                        if (novaTag.contains("<")) {
                            // Verifica se a tag HTML está mal-formada
                            contemHtmlMalformado = true;
                            throw new IOException("malformed HTML");
                        }
                        pilhaDeTags.push(novaTag);
                    }
                } else if (!pilhaDeTags.isEmpty() && pilhaDeTags.size() >= nivelMaisProfundo) {
                    // Salva o texto mais profundo
                    textoMaisProfundo = linhaSemEspacos;
                    nivelMaisProfundo = pilhaDeTags.size();
                }
            }
            leitor.close();
        } catch (IOException e) {
            // Verifica se houve falha na conexão com a URL
            textoMaisProfundo = "URL connection error";
        }
    }
}