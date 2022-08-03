package works.mmddkk.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import works.mmddkk.Killboard;

public class TorchHandler implements Listener {
    public TorchHandler(Killboard plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTorchPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() != Material.TORCH) return;

        if (!event.getPlayer().hasPermission("firstplugin.torch.diamond")) return;

        event.getBlock().setType(Material.DIAMOND_BLOCK);
    }
}
