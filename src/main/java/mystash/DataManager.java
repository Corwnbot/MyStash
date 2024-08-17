package mystash;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class DataManager {
    private MyStash plugin;
    private FileConfiguration dataConfig;
    private File dataFile;

    public DataManager(MyStash plugin) {
        this.plugin = plugin;
        dataFile = new File(plugin.getDataFolder(), "data.yml");
        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        dataConfig = YamlConfiguration.loadConfiguration(dataFile);
    }

    public void loadData() {
        for (String key : dataConfig.getConfigurationSection("stashes").getKeys(false)) {
            UUID playerId = UUID.fromString(key);
            ItemStack[] items = dataConfig.getList("stashes." + key).stream()
                    .map(item -> (ItemStack) item)
                    .toArray(ItemStack[]::new);
            // Store items in memory if needed
        }
    }

    public void saveData() {
        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ItemStack[] getPlayerStash(UUID playerId) {
        String path = "stashes." + playerId.toString();
        return dataConfig.getList(path).stream()
                .map(item -> (ItemStack) item)
                .toArray(ItemStack[]::new);
    }

    public void savePlayerStash(UUID playerId, ItemStack[] items) {
        String path = "stashes." + playerId.toString();
        dataConfig.set(path, items);
    }
}