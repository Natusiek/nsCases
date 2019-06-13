package pl.natusiek.mc.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import pl.natusiek.mc.basic.ChestOpening;
import pl.natusiek.mc.basic.ChestStart;
import pl.natusiek.mc.helper.ItemBuilder;

import static pl.natusiek.mc.helper.ColorHelper.colored;

public class BlockPlace implements Listener {

    public static ItemStack Ender = new ItemBuilder(Material.ENDER_CHEST).withName("&6Magiczna Skrzynia").build();

    @EventHandler
    public void onPlace(BlockPlaceEvent e ) {
        Player p = e.getPlayer();
        Block b = e.getBlockPlaced();
        if (e.getItemInHand() == null) { return; }
        if(b.getType() == Material.ENDER_CHEST && e.getItemInHand().getItemMeta().getDisplayName() != null && e.getItemInHand().getItemMeta().getDisplayName().equals(colored("&6Magiczna Skrzynia"))) {
            p.openInventory(ChestStart.getInventory());
            e.setCancelled(true);
            p.getInventory().removeItem(new ItemStack[] { Ender });
        }
    }
}
