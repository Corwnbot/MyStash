package mystash;

import org.bukkit.plugin.java.JavaPlugin;

public class MyStash extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InventoryCloseListener(), this);
        getLogger().info("MyStash has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MyStash has been disabled!");
    }
}
