package mystash;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();

        // Check if the inventory has a specific holder or identifier
        if (inventory.getHolder() instanceof CustomInventoryHolder) {
            System.out.println("Custom inventory closed");
            // Perform actions specific to your custom inventory
        } else {
            System.out.println("Closed inventory: " + inventory.toString());
        }
    }
}
