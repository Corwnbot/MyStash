package mystash;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MyStashCommand implements CommandExecutor {
    private MyStash plugin;
    private DataManager dataManager;

    public MyStashCommand(MyStash plugin, DataManager dataManager) {
        this.plugin = plugin;
        this.dataManager = dataManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory stash = Bukkit.createInventory(player, 27, "My Stash");

            // Load items from data
            ItemStack[] items = dataManager.getPlayerStash(player.getUniqueId());
            stash.setContents(items);

            player.openInventory(stash);
            return true;
        }
        return false;
    }
}