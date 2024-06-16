package bibliotecaServidor;

import java.io.*;
import java.net.*;

class ClienteHandler implements Runnable {
    private Socket clientSocket;

    ClienteHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String request;
            while ((request = in.readLine()) != null) {
                String[] parts = request.split(" ", 2);
                String command = parts[0];

                switch (command) {
                    case "LISTAR":
                        break;
                    case "CADASTRAR":
                        break;
                    case "ALUGAR":
                        break;
                    case "DEVOLVER":
                        break;
                    default:
                        out.println("Comando não reconhecido");
                }
            }
        }  catch (IOException e) {
            System.out.println("Cliente desconectado: " + clientSocket.getInetAddress());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Erro ao fechar o socket do cliente: " + e.getMessage());
            }
        }
    }
}