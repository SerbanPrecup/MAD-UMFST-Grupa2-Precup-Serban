import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
	System.out.println("Server Pornit.");
        final int portNumber = 1234; // Portul pe care va asculta serverul

        try (
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("Astept conexiuni pe portul " + portNumber + "...");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Mesaj primit de la client: " + inputLine);
                out.println("Am primit: " + inputLine); // Trimite un răspuns înapoi la client
            }
        } catch (IOException e) {
            System.out.println("Eroare la crearea sau manipularea socketului: " + e.getMessage());
        }
    }
}