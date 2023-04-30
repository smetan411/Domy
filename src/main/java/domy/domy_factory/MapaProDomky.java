package domy.domy_factory;

import domy.domy_factory.Domek;
import domy.pocatek.AbsLocation;
import org.bukkit.World;

public class MapaProDomky {
    private final AbsLocation pocatekDomku;
    private final World svet;
    public MapaProDomky(AbsLocation pocatekDomku, World svet) {
        this.pocatekDomku = pocatekDomku;
        this.svet = svet;
    }


    public void postavMapu(int[][] mapa) {

        for (int sloupec = 0; sloupec < mapa.length; sloupec++) {
            for (int radek = 0; radek < mapa[sloupec].length; radek++) {
                Domek domek = new Domek(this.pocatekDomku.plus(sloupec*20, 0, radek*20), svet, 10, 10, 6);
                if (mapa[radek][sloupec] == 1) {
                    domek.postavDomek();
                }
            }
        }
    }
}




