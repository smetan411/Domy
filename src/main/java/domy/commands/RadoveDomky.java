package domy.commands;

import domy.PlayerCommandExecutor;
import domy.domy_factory.Domek;
import domy.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class RadoveDomky extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        int sirkaDomku = 10;
        int delkaDomku = 10;
        int vyskaPatra = 6;
        int pocetDomku = 5;
        try {
            if (args.length == 3) {
                sirkaDomku = Integer.parseInt(args[0]);
                delkaDomku = Integer.parseInt(args[1]);
                vyskaPatra = Integer.parseInt(args[2]);
                pocetDomku = Integer.parseInt(args[3]);
            } else if (args.length != 4 && args.length != 0) {
                player.sendMessage("Zadej ctyri parametry, sirku a delku domu, vysku sten a pocet domku.");
            }
            AbsLocation pocatekDomku = new AbsLocation(playerLocation);
             for (int i = 0; i < pocetDomku; i++) {
                Domek domek = new Domek(pocatekDomku, world, delkaDomku, sirkaDomku, vyskaPatra);
                pocatekDomku = pocatekDomku.plus(0, 0, sirkaDomku);
                domek.postavDomek();
            }
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }
}
