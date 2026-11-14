import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Gerenciador simples de tarefas pelo terminal.
 *
 * Uso:
 *   java Tarefas.java listar
 *   java Tarefas.java adicionar "Minha nova tarefa"
 *   java Tarefas.java concluir 3
 */
public class Tarefas {

    private static final Path ARQUIVO = Paths.get("tarefas.txt");

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            mostrarAjuda();
            return;
        }

        List<String> linhas = carregar();

        switch (args[0]) {
            case "listar":
                listar(linhas);
                break;
            case "adicionar":
                if (args.length < 2) {
                    System.out.println("Informe o texto da tarefa.");
                    return;
                }
                linhas.add("0;" + args[1]);
                salvar(linhas);
                System.out.println("Tarefa adicionada: " + args[1]);
                break;
            case "concluir":
                if (args.length < 2) {
                    System.out.println("Informe o número da tarefa.");
                    return;
                }
                int numero = Integer.parseInt(args[1]);
                if (numero < 1 || numero > linhas.size()) {
                    System.out.println("Tarefa não encontrada.");
                    return;
                }
                String texto = linhas.get(numero - 1).split(";", 2)[1];
                linhas.set(numero - 1, "1;" + texto);
                salvar(linhas);
                System.out.println("Tarefa concluída: " + texto);
                break;
            default:
                mostrarAjuda();
        }
    }

    private static List<String> carregar() throws IOException {
        List<String> linhas = new ArrayList<>();
        if (Files.exists(ARQUIVO)) {
            for (String linha : Files.readAllLines(ARQUIVO, StandardCharsets.UTF_8)) {
                if (!linha.isBlank()) {
                    linhas.add(linha);
                }
            }
        }
        return linhas;
    }

    private static void salvar(List<String> linhas) throws IOException {
        Files.write(ARQUIVO, linhas, StandardCharsets.UTF_8);
    }

    private static void listar(List<String> linhas) {
        if (linhas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }
        for (int i = 0; i < linhas.size(); i++) {
            String[] partes = linhas.get(i).split(";", 2);
            String marca = partes[0].equals("1") ? "[x]" : "[ ]";
            System.out.println((i + 1) + ". " + marca + " " + partes[1]);
        }
    }

    private static void mostrarAjuda() {
        System.out.println("Comandos disponíveis:");
        System.out.println("  listar                 mostra todas as tarefas");
        System.out.println("  adicionar \"texto\"      adiciona uma nova tarefa");
        System.out.println("  concluir <número>      marca uma tarefa como concluída");
    }
}
