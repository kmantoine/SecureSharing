package FileShare;

import java.io.InputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientConnect {

    static DataOutputStream out;
    static DataInputStream in;

    public void Connect() {
        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket client = new Socket(host.getHostName(), 5432);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            InputStream inFromServer = client.getInputStream();
            in = new DataInputStream(inFromServer);
            in.readUTF();

            if (client.getKeepAlive() == true) {
                out.flush();
                out.writeUTF("Keeping connection alive....");
            } else {
                out.writeUTF("Attempting to keep connection alive");
                client.setKeepAlive(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientConnect.class.getName()).log(Level.SEVERE, "Server Connection Error", ex);
        }
    }

    public static void MessageService(String number, String key) {
        try {
            out.writeBoolean(true);
            out.writeUTF(number);
            out.writeUTF(key);
        } catch (IOException ex) {
            Logger.getLogger(ClientConnect.class.getName()).log(Level.SEVERE, "Error from SMS server", ex);
        }
    }
    public static void EmailService(String to, String from, String file){
        try {
            out.writeInt(1);
            out.writeUTF(to);
            out.writeUTF(from);
            out.writeUTF(file);
        } catch (IOException ex) {
            Logger.getLogger(ClientConnect.class.getName()).log(Level.SEVERE, "Error from Email Server", ex);
        }
    }

}
