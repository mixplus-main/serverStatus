package mix.plugin.serverStatus;

import mix.plugin.serverStatus.Config.ConfigManager;
import mix.plugin.serverStatus.logic.Event;
import mix.plugin.serverStatus.logic.OnlinePlayers;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private ConfigManager config;
    private OnlinePlayers onlinePlayers;

    @Override
    public void onEnable() {
        // Plugin startup logic
        config = new ConfigManager(this);
        config.set("server", "online");
        config.save();
        System.out.println("Main");

        this.onlinePlayers = new OnlinePlayers(this, config);
        onlinePlayers.update();

        getServer().getPluginManager().registerEvents(
                new Event(this, config),
                this
        );

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
        config.set("server", "offline");
        config.save();
        onlinePlayers.update();
    }
}
