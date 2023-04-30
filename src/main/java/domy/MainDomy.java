package domy;

import domy.commands.*;
import domy.desky.Deska;
import domy.desky.ZedSJ;
import domy.desky.ZedVZ;
import domy.teren.MazaniKolemHrace;
import domy.teren.ZarovnaniTerenu;
import domy.teren.ZarovnaniTerenuNahoru;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainDomy extends JavaPlugin {

    @Override
    public void onEnable() {
        World world = getServer().getWorlds().get(0);
        getCommand("+zarovnejTeren").setExecutor(new ZarovnaniTerenu());
        getCommand("+zarovnejTerenNahoru").setExecutor(new ZarovnaniTerenuNahoru());
        getCommand("+vymazToKolem").setExecutor(new MazaniKolemHrace());
        getCommand("+zakladovaDeska").setExecutor(new Deska());
        getCommand("+zedSeverJih").setExecutor(new ZedSJ(10, 15));
        getCommand("+zedVychodZapad").setExecutor(new ZedVZ(10, 15));
        getCommand("+schodisteJih").setExecutor(new SchodisteJih());
        getCommand("+schodisteSever").setExecutor(new SchodisteSever());
        getCommand("+schodisteVychod").setExecutor(new SchodisteVychod());
        getCommand("+schodisteZapad").setExecutor(new SchodisteZapad());
        getCommand("+domek").setExecutor(new DomekCommand());
        getCommand("+vylepsenyDomek").setExecutor(new VylepsenyDomekCommand());
        getCommand("+panelak").setExecutor(new PanelakCommand());
        getCommand("+radoveDomky").setExecutor(new RadoveDomky());
        getCommand("+dlouhyPanelak").setExecutor(new DlouhyPanelak());
        getCommand("+vesnice").setExecutor(new Vesnicka());
        getCommand("+velkaVesnice").setExecutor(new VelkaVesnice());
        getCommand("+manhattan").setExecutor(new Manhattan());

    }


}
