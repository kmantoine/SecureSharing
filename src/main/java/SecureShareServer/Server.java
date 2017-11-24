package SecureShareServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arkane
 */

public class Server {

    private static ServerSocket connSocket;
    private static final int PORT = 5432;
    DataInputStream in;
    DataOutputStream out;

    public void connServer() {
        AtomicInteger numOfThreads = new AtomicInteger(0);
        ArrayList<Thread> threadList = new ArrayList<>();

        try {
            connSocket = new ServerSocket(PORT);
            //connSocket.setSoTimeout(15000);
            System.out.println("Waiting for client on port " + connSocket.getLocalPort() + "....");

            Socket server = connSocket.accept();
            while (server.isConnected ()) {
     
                in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                out = new DataOutputStream(server.getOutputStream());

                out.writeUTF("Connection Established with " + server.getLocalSocketAddress());
                server.setKeepAlive(true);

                Thread newThread = new Thread(new ServerThread(server));
                threadList.add(newThread);
                newThread.start();
                numOfThreads.incrementAndGet();
                server.setKeepAlive(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, "Error starting server", ex);
        }

        Logger.getLogger(Server.class.getName()).log(Level.INFO, "Threads Opened:", threadList);

        try {
            if (in.readBoolean() == true) {
                while (true) {
                    String read1 = in.readUTF();
                    String read2 = in.readUTF();
                    MessageService(read1, read2);
                }
            }
        }
        catch (IOException | NullPointerException ex) {
            Logger.getLogger (Server.class.getName()).log (Level.SEVERE, "SMS Error", ex);
        }

        try {
            if (in.readInt() == 1) {
                while (true) {
                    String read1 = in.readUTF();
                    String read2 = in.readUTF();
                    String read3 = in.readUTF();
                    EmailService(read1, read2, read3);
                }
            }
        }
        catch (IOException | NullPointerException ex) {
            Logger.getLogger (Server.class.getName()).log (Level.SEVERE, "Email Error", ex);
        }

    }


    public void MessageService(String number, String key) {
        SMS.SendPassword(number, key);
    }

    public void EmailService(String to, String from, String file) {
        SendEmailAttachment.ConstructEmail(to, from, file);
    }

}
