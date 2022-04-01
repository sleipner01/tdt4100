package of7.kode.pushnotifications;

import java.util.ArrayList;
import java.util.List;

public abstract class PushNotificationSender {

    private List<PushNotificationListener> clients = new ArrayList<>();
    private List<String> sentPushNotifications = new ArrayList<>();

    public void sendPushNotification(String notification) {
        sentPushNotifications.add(notification);
        firePushNotification(notification);
    }

    public void subscribe(PushNotificationListener listener) {
        if (!clients.contains(listener)) {
            clients.add(listener);
        }
    }

    public void unsubscribe(PushNotificationListener listener) {
        if (clients.contains(listener)) {
            clients.remove(listener);
        }
    }

    private void firePushNotification(String notification) {
        for (PushNotificationListener listener : clients) {
            listener.receivePushNotification(notification);
        }
    }

}
