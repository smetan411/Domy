package domy.domy_factory;

import domy.pocatek.AbsLocation;
import org.bukkit.World;

public class MapaProPanelaky {
    private final AbsLocation pocatekDomu;
    private final World svet;
    public MapaProPanelaky(AbsLocation pocatekDomu, World svet) {
        this.pocatekDomu = pocatekDomu;
        this.svet = svet;
    }
    public void postavMapu(int[][] mapa) {

        for (int sloupec = 0; sloupec < mapa.length; sloupec++) {
            for (int radek = 0; radek < mapa[sloupec].length; radek++) {
                int pocetPodlazi = (int) Math.round(Math.random() * 100);
                if(pocetPodlazi < 30){
                    pocetPodlazi = 6;
                }
                else if(pocetPodlazi >=30 && pocetPodlazi < 60){
                    pocetPodlazi = 10;
                }
                else if(pocetPodlazi >=60 && pocetPodlazi < 100) {
                    pocetPodlazi = 15;
                }
                Panelak panelak = new Panelak(this.pocatekDomu.plus(sloupec*20, 0, radek * 20), 10, 10, pocetPodlazi, 6);
                if (mapa[radek][sloupec] == 1) {
                    panelak.postavDum();
                }
            }
        }
    }
}




