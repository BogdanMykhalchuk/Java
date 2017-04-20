package JavaRush.MultiThreading.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Dreawalker on 17.04.2017.
 */
public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("The user %s added to chat.", userName));
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(String.format("The user %s left the chat.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized(Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while(true) {
                Message message = Client.this.connection.receive();
                if(message.getType() == MessageType.NAME_REQUEST) {
                    Message userNameMessage = new Message(MessageType.USER_NAME, getUserName());
                    Client.this.connection.send(userNameMessage);
                } else if(message.getType() == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true); return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }

            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while(true) {
                Message message = Client.this.connection.receive();
                if(message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if(message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if(message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run() {
            try {
                String serverAddress = Client.this.getServerAddress();
                int serverPort = Client.this.getServerPort();
                Socket socket = new Socket(serverAddress, serverPort);
                Client.this.connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch(IOException e) {
                notifyConnectionStatusChanged(false);
                e.printStackTrace();
            } catch(ClassNotFoundException j) {
                notifyConnectionStatusChanged(false);
                j.printStackTrace();
            }
        }
    }

    protected String getServerAddress() throws IOException {
        System.out.println("Enter server address, please.");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        System.out.println("Enter server port, please.");
        return ConsoleHelper.readInt();
     }

    protected String getUserName() {
        System.out.println("Enter your name, please.");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch(IOException e) {
            ConsoleHelper.writeMessage("Error has been occurred!");
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        synchronized (this) {
            try {
                this.wait();
                if(clientConnected) {
                    ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
                } else {
                    ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
                }
                while(clientConnected) {
                    String text = ConsoleHelper.readString();
                    if(text.equals("exit")) {
                        clientConnected = false;
                    } else {
                        if(shouldSendTextFromConsole()) {
                            this.sendTextMessage(text);
                        }
                    }
                }
            } catch(InterruptedException e) {
                ConsoleHelper.writeMessage("Exception during wait session!");
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
       new Client().run();
    }
}
