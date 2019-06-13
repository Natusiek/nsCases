package pl.natusiek.mc.basic;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;
import pl.natusiek.mc.CasePlugin;
import pl.natusiek.mc.helper.ItemBuilder;

import static pl.natusiek.mc.helper.ColorHelper.colored;

public class ChestOpening {

    private Inventory inventory;
    private Player player;
    private ChestEnum status;
    private int place;
    private BukkitTask task;

    public ChestOpening(Player p) {
        player = p;
        inventory = Bukkit.createInventory(null, 27, colored("&6Otwieranie..."));
        status = ChestEnum.OPENING;
        first();
        place = 11;
        task = Bukkit.getScheduler().runTaskTimerAsynchronously(CasePlugin.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(place >= 0) {
                    p.openInventory(inventory);
                    update();
                } else {
                    return;
                }
            }
        },0,6);
    }

    private void first() {
        ItemStack grey = new ItemBuilder(Material.STAINED_GLASS_PANE).withName("&8*").build();
        inventory.setItem(0, grey);
        inventory.setItem(1, grey);
        inventory.setItem(2, grey);
        inventory.setItem(3, grey);
        inventory.setItem(4, grey);
        inventory.setItem(5, grey);
        inventory.setItem(6, grey);
        inventory.setItem(7, grey);
        inventory.setItem(8, grey);

        inventory.setItem(9, CasePlugin.random());
        inventory.setItem(10, CasePlugin.random());
        inventory.setItem(11, CasePlugin.random());
        inventory.setItem(12, CasePlugin.random());
        inventory.setItem(13, CasePlugin.random());
        inventory.setItem(14, CasePlugin.random());
        inventory.setItem(15, CasePlugin.random());
        inventory.setItem(16, CasePlugin.random());
        inventory.setItem(17, CasePlugin.random());

        inventory.setItem(18, grey);
        inventory.setItem(19, grey);
        inventory.setItem(20, grey);
        inventory.setItem(21, grey);
        inventory.setItem(22, grey);
        inventory.setItem(23, grey);
        inventory.setItem(24, grey);
        inventory.setItem(25, grey);
        inventory.setItem(26, grey);
    }

    private void update() {
        place--;

        if(place <= 0) {
            end();
            task.cancel();
            return;
        }

        ItemStack s1 = inventory.getItem(10);
        ItemStack s2 = inventory.getItem(11);
        ItemStack s3 = inventory.getItem(12);
        ItemStack s4 = inventory.getItem(13);
        ItemStack s5 = inventory.getItem(14);
        ItemStack s6 = inventory.getItem(15);
        ItemStack s7 = inventory.getItem(16);
   //     ItemStack s8 = inventory.getItem(17);

        player.playSound(player.getLocation(), Sound.LAVA_POP, 0.7F, 1.9F);

        inventory.setItem(10,  s1);
        inventory.setItem(11, s2);
        inventory.setItem(12, s3);
        inventory.setItem(13, s4);
        inventory.setItem(14, s5);
        inventory.setItem(15, s6);
        inventory.setItem(16, s7);
        inventory.setItem(17, CasePlugin.random());
    }

    private void end() {
        if(status == ChestEnum.OPENING && player != null && player.isOnline()) {
            status = ChestEnum.OPENED;
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1F, 1F);
            ItemStack won = inventory.getItem(13);
            player.getInventory().addItem(won);
            player.closeInventory();
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}

