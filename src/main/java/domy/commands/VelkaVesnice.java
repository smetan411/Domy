package domy.commands;

import domy.PlayerCommandExecutor;
import domy.domy_factory.MapaProDomky;
import domy.pocatek.AbsLocation;
import domy.teren.ZarovnaniTerenu;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class VelkaVesnice extends PlayerCommandExecutor {
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

            int delkaVesnice = 20;
            int sirkaVesnice = 20;
            int[][] mapa = new int[delkaVesnice][sirkaVesnice];
            for (int i = 0; i < sirkaVesnice-1; i++) {
                for (int j = 0; j < delkaVesnice-1; j++) {
                    mapa[i][j] = (int) Math.round(Math.random() * 100);
                    if(mapa[i][j] > 50){
                        mapa[i][j] = 1;
                    }
                    else mapa [i][j] = 0;
                }
            }


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

