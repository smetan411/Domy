package domy.domy_factory;

import domy.pocatek.AbsLocation;
import domy.schody.Schody;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Door;

public class Panelak {
    private final AbsLocation pocatekDomu;
    private final World svet;
    private final int delkaDomu;
    private final int sirkaDomu;
    private final int pocetPodlazi;
    private final int vyskaPatra;
    private final Schody schodiste = new Schody();

    public Panelak(AbsLocation pocatekDomu, int delkaDomu, int sirkaDomu, int pocetPodlazi, int vyskaPatra) {
        this.pocatekDomu = pocatekDomu;
        this.delkaDomu = delkaDomu;
        this.sirkaDomu = sirkaDomu;
        this.pocetPodlazi = pocetPodlazi;
        this.vyskaPatra = vyskaPatra;
        this.svet = pocatekDomu.getWorld();
    }

    public void postavDum() {
        for (int podlazi = 0; podlazi < pocetPodlazi; podlazi++) {
            postavPodlazi(podlazi);
        }
        for (int podlazi = 0; podlazi < pocetPodlazi; podlazi++) {
            schodiste.postavSchodisteDum(svet, pocatekDomu.plus(2, (podlazi * vyskaPatra)+1, 6), 2, vyskaPatra);
        }
    }

    private void postavPodlazi(int podlazi) {
        postavZakladDeskuStrop(podlazi);
        postavStenuSJ(podlazi, 1);
        postavStenuSJ(podlazi, sirkaDomu);
        postavStenuVZ(podlazi, 0);
        postavStenuVZ(podlazi, delkaDomu - 1);
        postavZakladDeskuStrop(podlazi + 1);
        postavPostel(podlazi);
        postavDvere();
    }

    private void postavDvere() {
        Block blok1 = svet.getBlockAt(pocatekDomu.plus(2, 1, delkaDomu - 2).toLocation());
        blok1.setType(Material.AIR);
        Block blok2 = svet.getBlockAt(pocatekDomu.plus(2, 0, delkaDomu - 2).toLocation());
        blok2.setType(Material.AIR);

        blok1.setType(Material.DARK_OAK_DOOR);
        final Door dvere1 = (Door) blok1.getBlockData();
        dvere1.setOpen(false);
        dvere1.setFacing(BlockFace.NORTH);
        dvere1.setHalf(Bisected.Half.TOP);
        dvere1.setHinge(Door.Hinge.LEFT);
        dvere1.setPowered(false);
        blok1.setBlockData(dvere1);

        blok2.setType(Material.DARK_OAK_DOOR);
        final Door dvere2 = (Door) blok2.getBlockData();
        dvere2.setOpen(false);
        dvere2.setFacing(BlockFace.NORTH);
        dvere2.setHalf(Bisected.Half.BOTTOM);
        dvere2.setHinge(Door.Hinge.LEFT);
        dvere2.setPowered(false);
        blok2.setBlockData(dvere2);
    }

    private void postavPostel(int podlazi) {
        Block blok1 = svet.getBlockAt(pocatekDomu.plus((sirkaDomu - 1), podlazi * vyskaPatra, -1 + delkaDomu / 2).toLocation());
        blok1.setType(Material.YELLOW_BED);
        final Bed postel1 = (Bed) blok1.getBlockData();
        postel1.setPart(Bed.Part.HEAD);
        postel1.setFacing(BlockFace.NORTH);
        blok1.setBlockData(postel1);
        Block blok2 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu - 1, podlazi * vyskaPatra, delkaDomu / 2).toLocation());
        blok2.setType(Material.YELLOW_BED);
        final Bed postel2 = (Bed) blok2.getBlockData();
        postel2.setPart(Bed.Part.FOOT);
        postel2.setFacing(BlockFace.NORTH);
        blok2.setBlockData(postel2);

    }

    private void postavZakladDeskuStrop(int podlazi) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, podlazi * vyskaPatra - 1, j - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        Block svetlo = svet.getBlockAt(pocatekDomu.plus(sirkaDomu / 2, podlazi * vyskaPatra - 2, delkaDomu / 2).toLocation());
        svetlo.setType(Material.LANTERN);
    }

    private void postavStenuSJ(int podlazi, int posun) {
        for (int i = 0; i < delkaDomu; i++) {
            for (int j = 0; j < vyskaPatra; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(posun, (j) + (podlazi * vyskaPatra), i - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        vyrobOknaSJ(podlazi, posun);
    }

    private void postavStenuVZ(int podlazi, int posun) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < vyskaPatra; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, (j) + (podlazi * vyskaPatra), posun - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        vyrobOknaVZ(podlazi, posun);
    }

    private void vyrobOknaSJ(int podlazi, int posun) {
        for (int m = 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(posun, podlazi * vyskaPatra + (n + 1), delkaDomu / 2 - (m + 1)).toLocation());
                okno.setType(Material.GLASS);
            }
        }
    }

    private void vyrobOknaVZ(int podlazi, int posun) {
        for (int m = 0; m < 2; m++) {
            for (int n = 0; n < 2; n++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(m + sirkaDomu / 2, podlazi * vyskaPatra + (n + 1), posun - 1).toLocation());
                okno.setType(Material.GLASS);
            }
        }
    }

}
