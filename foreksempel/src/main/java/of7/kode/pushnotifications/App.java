package of7.kode.pushnotifications;

import java.util.ArrayList;
import java.util.List;

public class App {

    private List<AppListener> clients = new ArrayList<>();
    private List<String> sentPushNotifications = new ArrayList<>();

    public void sendPushNotification(String notification) {
        sentPushNotifications.add(notification);
        firePushNotification(notification);
    }

    public void subscribe(AppListener listener) {
        if (!clients.contains(listener)) {
            clients.add(listener);
        }
    }

    public void unsubscribe(AppListener listener) {
        if (clients.contains(listener)) {
            clients.remove(listener);
        }
    }

    private void firePushNotification(String notification) {
        for (AppListener appListener : clients) {
            appListener.receivePushNotification(notification);
        }
    }

}
