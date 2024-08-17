package mystash;

import org.bukkit.plugin.java.JavaPlugin;

public class MyStash extends JavaPlugin {
    private DataManager dataManager;

    @Override
    public void onEnable() {
        dataManager = new DataManager(this);
        getCommand("mystash").setExecutor(new MyStashCommand(this, dataManager));
        getServer().getPluginManager().registerEvents(new InventoryCloseListener(dataManager), this);
        dataManager.loadData();
    }

    @Override
    public void onDisable() {
        dataManager.saveData();
    }
}