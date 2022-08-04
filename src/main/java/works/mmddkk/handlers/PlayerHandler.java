package works.mmddkk.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import works.mmddkk.Killboard;
import works.mmddkk.ScoreHelper;

public class PlayerHandler implements Listener {

    Killboard plugin;

    public PlayerHandler(Killboard lplugin) {
        Bukkit.getPluginManager().registerEvents(this, lplugin);
        plugin = lplugin;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {

        FileConfiguration config = plugin.getConfig();

        Player player = event.getPlayer();

        if (config.getBoolean("killboard-enabled")) {
            ScoreHelper helper = ScoreHelper.createScore(player);
            helper.setTitle("&bKillboard");
            helper.setSlot(4, "&7&m--------------");
            helper.setSlot(3, "&aKills: &c" + player.getStatistic(Statistic.PLAYER_KILLS));
            helper.setSlot(2, "&4Deaths: &c" + player.getStatistic(Statistic.DEATHS));
            helper.setSlot(1, "&7&m--------------");
            //helper.setSlot(1, "&7Made by &4MMDDKK#6500");
        }
    }
}
