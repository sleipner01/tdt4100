package of7.kode.pushnotifications;

import java.util.ArrayList;
import java.util.List;

public class Phone implements PushNotificationListener {

    private String name;
    private List<String> notificationFeed = new ArrayList<>();
    private List<PushNotificationSender> installedApps = new ArrayList<>();

    public Phone(String name) {
        this.name = name;
    }

    public void install(PushNotificationSender app) {
        if (!installedApps.contains(app)) {
            app.subscribe(this);
            installedApps.add(app);
        }
    }

    public void uninstall(PushNotificationSender app) {
        if (installedApps.contains(app)) {
            app.unsubscribe(this);
            installedApps.remove(app);
        }
    }

    @Override
    public void receivePushNotification(String notification) {
        notificationFeed.add(notification);
    }

    public String printPushNotifications() {
        return name + ":\n" + String.join("\n", notificationFeed);
    }

    public static void main(String[] args) {
        Phone iPhone11Pro = new Phone("Magnus sin iPhone");
        Phone SamsungGalaxy = new Phone("Kjetils Android");
        App OOPmini = new App();
        App OOPbank = new App();
        OfficialApp SlowTime = new OfficialApp();
        iPhone11Pro.install(OOPmini);
        iPhone11Pro.install(OOPbank);
        iPhone11Pro.install(SlowTime);
        SamsungGalaxy.install(OOPmini);

        SlowTime.sendPushNotification("Mamma ringer...");
        SlowTime.sendPushNotification("5x tapte anrop fra Sjef McSjefete");

        OOPmini.sendPushNotification("Nå har vi 40% rabatt på Hummus!");
        System.out.println(iPhone11Pro.printPushNotifications());
        System.out.println();
        System.out.println(SamsungGalaxy.printPushNotifications());
        System.out.println();
        OOPbank.sendPushNotification("Søk om høyere kredittgrense idag!");
        System.out.println(iPhone11Pro.printPushNotifications());
        System.out.println();
        System.out.println(SamsungGalaxy.printPushNotifications());
        OOPbank.sendPushNotification("VÆR SÅ VENNLIG, SØK OM FORBRUKSLÅN");
    }

}
