package mix.plugin.serverStatus.logic;

import mix.plugin.serverStatus.Config.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SaveUserData {
    public SaveUserData(JavaPlugin plugin, ConfigManager config, Player player) {
        String uuid = player.getUniqueId().toString();
        config.set("PlayerData." + uuid + ".MCID", player.getName());
        config.save();
    }
}
