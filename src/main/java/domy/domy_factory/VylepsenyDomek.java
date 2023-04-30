package domy.domy_factory;

import domy.pocatek.AbsLocation;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Bed;
import org.bukkit.block.data.type.Door;

public class VylepsenyDomek {
    private final AbsLocation pocatekDomu;
    private final World svet;
    private final int delkaDomu;
    private final int sirkaDomu;
    private final int vyskaSten;

    public VylepsenyDomek(AbsLocation pocatekDomu, World svet, int delkaDomu, int sirkaDomu, int vyskaSten) {
        this.pocatekDomu = pocatekDomu;
        this.svet = svet;
        this.delkaDomu = delkaDomu;
        this.sirkaDomu = sirkaDomu;
        this.vyskaSten = vyskaSten;
    }

    public void postavDum() {
        postavZakladDesku();
        postavStenuSJ(0);
        postavStenuSJ(sirkaDomu - 1);
        postavStenuVZ(0);
        postavStenuVZ(delkaDomu - 1);
        postavStrop();
        postavSloupy();
        postavPostel();
        postavDvere1();
        postavDvere2();
        postavStrechu1(0);
        postavStrechu2(delkaDomu - 1);
        postavStitStrechy(0);
        postavStitStrechy(sirkaDomu - 1);
        postavBednu1();
        postavBednu2();
        postavEnchantingTable();
        postavKnihovnu();
        postavCraftingTable();
        polozKoberec();
        postavKovarskyStul();
    }


    private void postavZakladDesku() {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, -1, j - 1).toLocation());
                aktualniBlok.setType(Material.OAK_WOOD);
            }
        }
    }

    private void postavStenuSJ(int posun) {
        for (int i = 0; i < delkaDomu; i++) {
            for (int j = 0; j < vyskaSten; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(posun + 1, (j), i - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(posun + 1, (l + 1), delkaDomu / 2 - (k)).toLocation());
                okno.setType(Material.GLASS);
            }
        }
    }

    private void postavStenuVZ(int posun) {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < vyskaSten; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, (j), posun - 1).toLocation());
                aktualniBlok.setType(Material.STONE);
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                Block okno = svet.getBlockAt(pocatekDomu.plus(k + sirkaDomu / 2, (l + 1), posun - 1).toLocation());
                okno.setType(Material.GLASS);
            }
        }
    }

    private void postavStrop() {
        for (int i = 0; i < sirkaDomu; i++) {
            for (int j = 0; j < delkaDomu; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i + 1, vyskaSten, j - 1).toLocation());
                aktualniBlok.setType(Material.CHISELED_QUARTZ_BLOCK);
            }
        }
        Block svetlo1 = svet.getBlockAt(pocatekDomu.plus(2 + sirkaDomu / 2, vyskaSten - 1, delkaDomu / 2).toLocation());
        svetlo1.setType(Material.LANTERN);
        Block svetlo2 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu / 2, vyskaSten - 1, delkaDomu / 2).toLocation());
        svetlo2.setType(Material.LANTERN);
        Block svetlo3 = svet.getBlockAt(pocatekDomu.plus(-2 +sirkaDomu / 2, vyskaSten - 1, delkaDomu / 2).toLocation());
        svetlo3.setType(Material.LANTERN);
    }

    private void postavSloupy() {
        for (int i = 0; i < vyskaSten; i++) {
            Block sloup1 = svet.getBlockAt(pocatekDomu.plus(1, i, -1).toLocation());
            sloup1.setType(Material.OAK_WOOD);
            Block sloup2 = svet.getBlockAt(pocatekDomu.plus(1, i, delkaDomu - 2).toLocation());
            sloup2.setType(Material.OAK_WOOD);
            Block sloup3 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu, i, -1).toLocation());
            sloup3.setType(Material.OAK_WOOD);
            Block sloup4 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu, i, delkaDomu - 2).toLocation());
            sloup4.setType(Material.OAK_WOOD);
        }
    }


    private void postavStrechu1( int posun) {
        for (int i = 0; i < sirkaDomu + 2; i++) {
            for (int j = 0; j < 2 + delkaDomu / 2; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i, j - 1 + vyskaSten, (posun - 3) + j).toLocation());
                aktualniBlok.setType(Material.RED_NETHER_BRICK_STAIRS);
                Directional kridlice = (Directional) aktualniBlok.getBlockData();
                kridlice.setFacing(BlockFace.SOUTH);
                aktualniBlok.setBlockData(kridlice);
            }
        }
    }

    private void postavStrechu2(int posun) {
        for (int i = 0; i < sirkaDomu + 2; i++) {
            for (int j = 0; j < 2 + delkaDomu / 2; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(i, j - 1 + vyskaSten, (posun + 1) - j).toLocation());
                aktualniBlok.setType(Material.RED_NETHER_BRICK_STAIRS);
                Directional kridlice = (Directional) aktualniBlok.getBlockData();
                kridlice.setFacing(BlockFace.NORTH);
                aktualniBlok.setBlockData(kridlice);
            }
        }
    }

    private void postavStitStrechy(int posun) {

        for (int i = 0; i < 8; i++) {
            Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(1 + posun, 1 + vyskaSten, i).toLocation());
            aktualniBlok.setType(Material.OAK_WOOD);
        }
        for (int i = 0; i < 6; i++) {
            Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(1 + posun, 2 + vyskaSten, i + 1).toLocation());
            aktualniBlok.setType(Material.OAK_WOOD);
        }
        for (int i = 0; i < 4; i++) {
            Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(1 + posun, 3 + vyskaSten, i + 2).toLocation());
            aktualniBlok.setType(Material.OAK_WOOD);
        }
        for (int i = 0; i < 2; i++) {
            Block aktualniBlok = svet.getBlockAt(pocatekDomu.plus(1 + posun, 4 + vyskaSten, i + 3).toLocation());
            aktualniBlok.setType(Material.OAK_WOOD);
        }
    }

    public void postavDvere1() {
        Block blok1 = svet.getBlockAt(pocatekDomu.plus(3, 1, delkaDomu - 2).toLocation());
        blok1.setType(Material.AIR);
        Block blok2 = svet.getBlockAt(pocatekDomu.plus(3, 0, delkaDomu - 2).toLocation());
        blok2.setType(Material.AIR);

        blok1.setType(Material.DARK_OAK_DOOR);
        final Door dvere1 = (Door) blok1.getBlockData();
        dvere1.setOpen(false);
        dvere1.setFacing(BlockFace.NORTH);
        dvere1.setHalf(Bisected.Half.TOP);
        dvere1.setHinge(Door.Hinge.RIGHT);
        dvere1.setPowered(false);
        blok1.setBlockData(dvere1);

        blok2.setType(Material.DARK_OAK_DOOR);
        final Door dvere2 = (Door) blok2.getBlockData();
        dvere2.setOpen(false);
        dvere2.setFacing(BlockFace.NORTH);
        dvere2.setHalf(Bisected.Half.BOTTOM);
        dvere2.setHinge(Door.Hinge.RIGHT);
        dvere2.setPowered(false);
        blok2.setBlockData(dvere2);
    }

    public void postavDvere2() {
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


    public void postavPostel() {
        Block blok1 = svet.getBlockAt(pocatekDomu.plus((sirkaDomu - 1), 0, -1 + delkaDomu / 2).toLocation());
        blok1.setType(Material.YELLOW_BED);
        final Bed postel1 = (Bed) blok1.getBlockData();
        postel1.setPart(Bed.Part.HEAD);
        postel1.setFacing(BlockFace.NORTH);
        blok1.setBlockData(postel1);

        Block blok2 = svet.getBlockAt(pocatekDomu.plus(sirkaDomu - 1, 0, delkaDomu / 2).toLocation());
        blok2.setType(Material.YELLOW_BED);
        final Bed postel2 = (Bed) blok2.getBlockData();
        postel2.setPart(Bed.Part.FOOT);
        postel2.setFacing(BlockFace.NORTH);
        blok2.setBlockData(postel2);
    }

    public void postavBednu1() {
        Block blok = svet.getBlockAt(pocatekDomu.plus(sirkaDomu - 1, 0, delkaDomu - 3).toLocation());
        blok.setType(Material.CHEST);
        Directional bedna = (Directional) blok.getBlockData();
        bedna.setFacing(BlockFace.WEST);
        blok.setBlockData(bedna);
    }

    public void postavBednu2() {
        Block block = svet.getBlockAt(pocatekDomu.plus(sirkaDomu - 1, 0, 0).toLocation());
        block.setType(Material.CHEST);
        Directional bedna = (Directional) block.getBlockData();
        bedna.setFacing(BlockFace.SOUTH);
        block.setBlockData(bedna);
    }

    public void postavEnchantingTable() {
        Block table = svet.getBlockAt(pocatekDomu.plus(sirkaDomu / 2, 0, 0).toLocation());
        table.setType(Material.ENCHANTING_TABLE);
    }

    public void postavKnihovnu() {
        Block knihovna = svet.getBlockAt(pocatekDomu.plus(2, 0, 0).toLocation());
        knihovna.setType(Material.BOOKSHELF);
    }

    public void postavCraftingTable() {
        Block table = svet.getBlockAt(pocatekDomu.plus(sirkaDomu/2, 0, delkaDomu-3).toLocation());
        table.setType(Material.CRAFTING_TABLE);
    }

    public void polozKoberec() {
        for (int i = 0; i < sirkaDomu - 4; i++) {
            for (int j = 0; j < delkaDomu - 4; j++) {
                Block blok = svet.getBlockAt(pocatekDomu.plus(i + 3, 0, j + 1).toLocation());
                blok.setType(Material.PURPLE_CARPET);
            }
        }
    }

    public void postavKovarskyStul() {
        Block table = svet.getBlockAt(pocatekDomu.plus(2, 0, 3).toLocation());
        table.setType(Material.SMITHING_TABLE);
    }
}
