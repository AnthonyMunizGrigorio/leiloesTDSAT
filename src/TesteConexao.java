/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author antho
 */
public class TesteConexao {
    public static void main(String[] args) {
        conectaDAO dao = new conectaDAO();

        if (dao.connectDB() != null) {
            System.out.println("Conectou com sucesso!");
        } else {
            System.out.println("Falha na conexão!");
        }
    }
}
