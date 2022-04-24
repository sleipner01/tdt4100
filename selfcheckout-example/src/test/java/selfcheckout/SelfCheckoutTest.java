package selfcheckout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelfCheckoutTest {

    private SelfCheckout selfCheckout;
    private String adminPassword = "test123";
    private String day = "mon";

    @BeforeEach
    public void setup() {
        List<Campaign> discounts = List.of(
                new Campaign("Helgerabatt på taco", 0.3, "taco", true, List.of("fri", "sat")),
                new Campaign("Mandagsmat til under 200-lappen", 0.25, "dinner", false, List.of("mon")),
                new Campaign("Tilbuds-Torsdag", 0.1, null, true, List.of("thu")),
                new Campaign("Medlemsrabatt", 0.02, null, true,
                        List.of("mon", "tue", "wed", "thu", "fri", "sat", "sun")));
        selfCheckout = new SelfCheckout(day, adminPassword, discounts);
    }

    @Test
    @DisplayName("Test å registrere mobilnummer og logge inn som kunde")
    public void testRegisterPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            selfCheckout.registerPhoneNumber("+4711234567");
        }, "IllegalArgument skal utløses når mobilnummer ikke starter på +479, +474, 00474, eller 00479");
        selfCheckout.registerPhoneNumber("+4741234567");
        assertEquals("+4741234567", selfCheckout.getPhoneNumber());
        assertThrows(IllegalStateException.class, () -> {
            selfCheckout.registerPhoneNumber("+4741234567");
        }, "IllegalState skal utløses når telefonnummer allerede er registrert.");
        setup();
        selfCheckout.registerPhoneNumber("+4791234567");
        setup();
        selfCheckout.registerPhoneNumber("004741234567");
        setup();
        selfCheckout.registerPhoneNumber("004791234567");
        assertTrue(selfCheckout.isMember());
        setup();
        assertFalse(selfCheckout.isMember());
    }

    @Test
    @DisplayName("Test å logge inn og ut som admin")
    public void testActivateAndDeactivateAdminMde() {
        assertThrows(IllegalArgumentException.class, () -> {
            selfCheckout.activateAdminMode("foo");
        }, "IllegalArgument skal utløses når adminpassord er feil");
        selfCheckout.activateAdminMode(adminPassword);
        assertThrows(IllegalStateException.class, () -> {
            selfCheckout.activateAdminMode(adminPassword);
        }, "IllegalState skal utløses når adminmodus allerede er aktivert.");

        selfCheckout.deactivateAdminMode();
        assertThrows(IllegalStateException.class, () -> {
            selfCheckout.deactivateAdminMode();
        }, "IllegalState skal utløses når adminmoud allerede er deaktivert.");

    }

    @Test
    @DisplayName("Test å slette en vare fra handlekurven i forskjellige tilstander")
    public void testRemoveFromCart() {
        assertThrows(IllegalStateException.class, () -> {
            selfCheckout.removeFromCart(0);
        }, "IllegalState skal utløses når man prøver å fjerne et element fra handlekurven når admin-modus ikke er aktivert.");
        selfCheckout.activateAdminMode("test123");
        assertThrows(IllegalStateException.class, () -> {
            selfCheckout.removeFromCart(0);
        }, "IllegalState skal utløses når man prøver å fjerne et element fra handlekurven når den er tom.");
        selfCheckout.scanItem(new Item("Tomat", 5, "fruit"));
        selfCheckout.removeFromCart(0);
    }
}
