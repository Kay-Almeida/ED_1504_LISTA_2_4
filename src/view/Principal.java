package view;

import controller.ImpressoraController;
import br.edu.fateczl.filaobj.Fila;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        Fila filaImpressao = new Fila();
        ImpressoraController impressoraController = new ImpressoraController();

        while (true) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n1. Inserir documento na fila de impressão\n2. Imprimir documento\n3. Sair"));

            switch (opcao) {
                case 1:
                    String documento = JOptionPane.showInputDialog("Digite o documento no formato ID_PC;Nome_Arquivo:");
                    try {
                        String[] parts = documento.split(";");
                        if (parts.length != 2) {
                            JOptionPane.showMessageDialog(null, "Documento inválido. Formato correto: ID_PC;Nome_Arquivo");
                            continue;
                        }
                        impressoraController.insereDocumento(filaImpressao, documento);
                        JOptionPane.showMessageDialog(null, "Documento adicionado à fila de impressão com sucesso.");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro ao inserir documento: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        impressoraController.imprime(filaImpressao);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Encerrando Programa...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}