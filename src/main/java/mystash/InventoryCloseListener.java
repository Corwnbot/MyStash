package mystash;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryCloseListener implements Listener {
    private DataManager dataManager;

    public InventoryCloseListener(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getInventory().getName().equals("My Stash")) {
            ItemStack[] items = event.getInventory().getContents();
            dataManager.savePlayerStash(event.getPlayer().getUniqueId(), items);
        }
    }
}