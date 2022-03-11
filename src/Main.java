import Gun.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        int slot;
        int count;

        while (true) {
            System.out.format("У игрока %d ячеек с оружием,"
                            + " введите номер ячейки, чтобы выстрелить,"
                            + " -1 чтобы выйти%n",
                    player.getSlotsCount()
            );

            count = player.getSlotsCount();

            slot = scanner.nextInt();
            if (slot < count && slot >= 0){
                player.shotWithWeapon(slot);
            }else {
                System.out.println("В ячейке нет оружия");
            }
            if (slot == -1){
                break;
            }
        }
        System.out.println("GG");
    }
}

class Player {
    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[] {
                new Kirka(),
                new Pistol(),
                new AutoGun(),


        };
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public void shotWithWeapon(int slot) {
        Weapon weapon = weaponSlots[slot];
        weapon.shot();
    }
}