package domy.commands;

import domy.PlayerCommandExecutor;
import domy.domy_factory.Panelak;
import domy.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PanelakCommand extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirka = 10;
        int delka = 10;
        int vyskaPatra = 6;
        int pocetPodlazi = 6;
        try {
            if (args.length == 4) {
                sirka = Integer.parseInt(args[0]);
                delka = Integer.parseInt(args[1]);
                vyskaPatra = Integer.parseInt(args[2]);
                pocetPodlazi = Integer.parseInt(args[3]);
            } else if (args.length != 4 && args.length != 0) {
                player.sendMessage("Zadej ctyri rozmery, sirku a delku domu, vysku sten kazdeho patra a pocet podlazi.");
                return true;
            }
            Panelak panelak = new Panelak(new AbsLocation(playerLocation), delka, sirka, pocetPodlazi, vyskaPatra);
            panelak.postavDum();
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }
}
