package of6.observable.lf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Phone implements AppListener {

    private String name;
    private List<String> notificationFeed = new ArrayList<>();
    private List<App> installedApps = new ArrayList<>();

    public Phone(String name) {
        this.name = name;
    }

    public void install(App app) {
        if (!installedApps.contains(app)) {
            app.subscribe(this);
            installedApps.add(app);
        }
    }

    public void uninstall(App app) {
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
        iPhone11Pro.install(OOPmini);
        iPhone11Pro.install(OOPbank);
        SamsungGalaxy.install(OOPmini);

        OOPmini.sendPushNotification("Nå har vi 40% rabatt på Hummus!");
        System.out.println(iPhone11Pro.printPushNotifications());
        System.out.println();
        System.out.println(SamsungGalaxy.printPushNotifications());
        System.out.println();
        OOPbank.sendPushNotification("Søk om høyere kredittgrense idag!");
        System.out.println(iPhone11Pro.printPushNotifications());
        System.out.println();
        System.out.println(SamsungGalaxy.printPushNotifications());
    }

}
