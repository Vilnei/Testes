import dao.ClienteMapDAO;
import dao.IClienteDAO;
import javax.swing.*;

public class App {
    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();


    }
}
