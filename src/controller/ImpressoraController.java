package controller;

import br.edu.fateczl.filaobj.Fila;

public class ImpressoraController {

    public void insereDocumento(Fila f, String documento) {
        f.insert(documento);
    }

    public void imprime(Fila f) throws Exception {
        if (f.isEmpty()) {
            throw new Exception("Não há documentos na fila de impressão.");
        }

        String documento = (String) f.remove();
        String[] parts = documento.split(";");
        String id_pc = parts[0];
        String nome_arquivo = parts[1];

        int tempo = (int) (Math.random() * 1000) + 1000;
        Thread.sleep(tempo);

        System.out.println("[#PC: " + id_pc + " - Arquivo: " + nome_arquivo + "]");
    }
}