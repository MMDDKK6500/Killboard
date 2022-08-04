package works.mmddkk;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import works.mmddkk.handlers.PlayerHandler;

public final class Killboard extends JavaPlugin {
    FileConfiguration config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        loadConfig();

        //register command executor
        //getCommand("fly").setExecutor(new Fly());
        //just as an example

        //instantiate handlers
        new PlayerHandler(this);
    }

    @Override
    public void onLoad() {
        Bukkit.getLogger().info("[Killboard] Plugin is loaded");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("[Killboard] Shutting Down");
    }

    private void loadConfig() {
        config = getConfig();
        config.addDefault("killboard-enabled", true);
        config.options().copyDefaults(true);
        saveConfig();
    }
}
