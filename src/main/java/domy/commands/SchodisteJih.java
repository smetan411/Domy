package domy.commands;

import domy.PlayerCommandExecutor;
import domy.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class SchodisteJih extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirkaSchodiste;
        int naslapnaHloubkaSchodu;
        int pocetSchodu;
        try {
            if (args.length == 3) {
                sirkaSchodiste = Integer.parseInt(args[0]);
                naslapnaHloubkaSchodu = Integer.parseInt(args[1]);
                pocetSchodu = Integer.parseInt(args[2]);
            } else if (args.length != 3 && args.length != 0) {
                player.sendMessage("Zadej tri rozmery, sirkuSchodiste, hloubkuSchodu a pocetSchodu.");
                return true;
            }
            domy.schody.Schody schody = new domy.schody.Schody();
            schody.postavSchodisteJih(world, new AbsLocation(playerLocation), 10, 2, 6);
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }

        return true;
    }
}
