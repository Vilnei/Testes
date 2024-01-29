import dao.ClienteMapDAO;
import dao.IClienteDAO;
import domain.Cliente;
import javax.swing.*;

/**
 *
 * @author Vilnei
 */
public class App {
    
    private static IClienteDAO iClienteDAO;
    
    public static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao)|| "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showConfirmDialog(null, "Falow", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    
    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        //validar se todos os campos estão preenchidos
        Cliente cliente = new Cliente(
                dadosSeparados[0],
                dadosSeparados[1],
                dadosSeparados[2],
                dadosSeparados[3],
                dadosSeparados[4],
                dadosSeparados[5],
                dadosSeparados[6]
        );
        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if (isCadastrado) {
            JOptionPane.showInputDialog(null,
                    "Cliente cadastrado com sucesso",
                    " Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }else {
            JOptionPane.showInputDialog(null,
                    "Cliente já cadastrado",
                    " Já Cadastrado",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    private static void consultar(String dados) {
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
        if (cliente !=null) {
            JOptionPane.showMessageDialog(null,
                    "Cliente encontrado: " + cliente,
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }else {
            JOptionPane.showMessageDialog(null,
                    "Cliente NÃO encontrado: ",
                    "Erro",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

    }

    public static void main (String[] args) {
        
        iClienteDAO = new ClienteMapDAO();
        
        String opcao = JOptionPane.showInputDialog( null,
                "Digite 1 para cadastro, " +
                        "2 para consultar, " +
                        "3 para exclusão, " +
                        "4 para alteração ou " +
                        "5 para sair",
                "Cadastro",
                JOptionPane.INFORMATION_MESSAGE

        );
        
        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }

            opcao = JOptionPane.showInputDialog( null,
                    "Opção inválida, " +
                            "digite 1 para cadastro, " +
                            "2 para consulta " +
                            "3 para cadastro, " +
                            "4 para alteração ou " +
                            "5 para sair",
                    "Opção Errada",
                    JOptionPane.INFORMATION_MESSAGE

            );

        }
        
        while (isOpcaoValida(opcao)) {
            
            if (isOpcaoSair(opcao)) {
                sair();
            }else if (isCadastro(opcao)){
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: " +
                                "Nome, CPF,Telefone,Endereço,Numero,Cidade,Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE
                );
                cadastrar(dados);
            }else if (isConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF",
                        "Consultar", JOptionPane.INFORMATION_MESSAGE
                );
                consultar(dados);
            }

            opcao = JOptionPane.showInputDialog( null,
                    "Digite 1 para cadastro, " +
                            "2 para consultar, " +
                            "3 para exclusão, " +
                            "4 para alteração ou " +
                            "5 para sair",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }
        
    }




}
