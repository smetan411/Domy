package domy.commands;

import domy.PlayerCommandExecutor;
import domy.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class DomekCommand extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirkaDomu = 10;
        int delkaDomu = 10;
        int vyskaPatra = 6;
        try {
            if (args.length == 3) {
                sirkaDomu = Integer.parseInt(args[0]);
                delkaDomu = Integer.parseInt(args[1]);
                vyskaPatra = Integer.parseInt(args[2]);
            } else if (args.length != 3 && args.length != 0) {
                player.sendMessage("Zadej tri rozmery, sirku a delku domu, vysku sten.");
                return true;
            }
            domy.domy_factory.Domek domek = new domy.domy_factory.Domek(new AbsLocation(playerLocation), world, delkaDomu, sirkaDomu, vyskaPatra);
            domek.postavDomek();
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }
}


