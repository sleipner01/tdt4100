package of7.kode.pushnotifications;

import java.time.LocalDate;

public class App extends PushNotificationSender {

    private int lastNotificationSent = 0;

    @Override
    public void sendPushNotification(String notification) {
        if (lastNotificationSent == LocalDate.now().toEpochDay()) {
            throw new IllegalArgumentException("Daily notification already sent!");
        }

        super.sendPushNotification(notification);
        lastNotificationSent = (int) LocalDate.now().toEpochDay();
    }

}
