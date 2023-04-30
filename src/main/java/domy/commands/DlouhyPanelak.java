package domy.commands;

import domy.PlayerCommandExecutor;
import domy.domy_factory.Panelak;
import domy.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class DlouhyPanelak extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirka = 10;
        int delka = 10;
        int vyskaPatra = 6;
        int pocetPodlazi = 6;
        int pocetPanelaku = 5;
        try {
            if (args.length == 5) {
                sirka = Integer.parseInt(args[0]);
                delka = Integer.parseInt(args[1]);
                vyskaPatra = Integer.parseInt(args[2]);
                pocetPodlazi = Integer.parseInt(args[3]);
                pocetPanelaku = Integer.parseInt(args[4]);
            } else if (args.length != 4 && args.length != 0) {
                player.sendMessage("Zadej pet parametru, sirku a delku domu, vysku sten kazdeho patra, pocet podlazi a pocet panelaku.");
                return true;
            }
            AbsLocation pocatekDomu = new AbsLocation(playerLocation);
            for (int i = 0; i < pocetPanelaku; i++) {
                Panelak panelak = new Panelak(pocatekDomu, delka, sirka, pocetPodlazi, vyskaPatra);
                pocatekDomu = pocatekDomu.plus(sirka,0,0);
                panelak.postavDum();
            }

        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }
}
