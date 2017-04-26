package JavaRush.MultiThreading.task3008.client;

import JavaRush.MultiThreading.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Dreawalker on 19.04.2017.
 */
public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. " +
                    "Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if(message.contains(":")) {
                String[] array = message.split(": ");
                String userName = array[0];
                String userMessage = array[1];
                Calendar calendar = new GregorianCalendar();
                Date date = calendar.getTime();
                StringBuilder sb = new StringBuilder("Информация для ");
                sb.append(userName).append(": ");
                SimpleDateFormat sdf = null;
                switch (userMessage) {
                    case ("дата"):
                        sdf = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case ("день"):
                        sdf = new SimpleDateFormat("d");
                        break;
                    case ("месяц"):
                        sdf = new SimpleDateFormat("MMMM");
                        break;
                    case ("год"):
                        sdf = new SimpleDateFormat("YYYY");
                        break;
                    case ("время"):
                        sdf = new SimpleDateFormat("H:mm:ss");
                        break;
                    case ("час"):
                        sdf = new SimpleDateFormat("H");
                        break;
                    case ("минуты"):
                        sdf = new SimpleDateFormat("m");
                        break;
                    case ("секунды"):
                        sdf = new SimpleDateFormat("s");
                        break;
                }
                if(sdf != null) {
                    sb.append(sdf.format(date));
                    sendTextMessage(sb.toString());
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}