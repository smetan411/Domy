package domy.commands;

import domy.PlayerCommandExecutor;
import domy.domy_factory.MapaProDomky;
import domy.pocatek.AbsLocation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Vesnicka extends PlayerCommandExecutor {
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

            int[][] mapa = {
                    {1, 0, 1, 0},
                    {0, 1, 0, 1},
                    {1, 0, 1, 0},
                    {1, 0, 0, 1},
            };

            AbsLocation pocatekDomku = new AbsLocation(playerLocation);
            MapaProDomky vesnice = new MapaProDomky(pocatekDomku, world);
            vesnice.postavMapu(mapa);
        } catch (
                NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }
}

