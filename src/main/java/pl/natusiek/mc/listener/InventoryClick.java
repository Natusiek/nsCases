package pl.natusiek.mc.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import pl.natusiek.mc.basic.ChestOpening;

import static pl.natusiek.mc.helper.ColorHelper.colored;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.isCancelled()) return;
        if(e.getInventory() == null) return;
        if(e.getCurrentItem() == null) return;
        if(e.getCurrentItem().getType().equals(Material.AIR)) return;

        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        if(e.getInventory().getTitle() !=null && e.getInventory().getTitle().equalsIgnoreCase(colored("&6Magiczna Skrzynia"))) {
            if(i.getType().equals(Material.ENDER_CHEST) && i.hasItemMeta()) {
                ChestOpening c = new ChestOpening(p);
                p.openInventory(c.getInventory());
                e.setCancelled(true);
                return;
            }
        }
    }
}