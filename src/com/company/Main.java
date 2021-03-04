package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws WeaponIndexException{

        // 0 - холод, 1 - огонь, 2 - вода, 3 - земля, 4 - обычный

        Scanner scanner = new Scanner(System.in);
        int PlayerHelth = 100;
        boolean isBoss = false;
        int enemyIndex = 0;

        Weapon[] weapon = new Weapon[5];
        weapon[0] = new Weapon("Ледяная Скорбь",0,30);
        weapon[1] = new Weapon("Огненный шторм",1,30);
        weapon[2] = new Weapon("Водяной удар",2,30);
        weapon[3] = new Weapon("Месть Природы",3,30);
        weapon[4] = new Weapon("Огромный меч рыцаря",4,10);

        Enemy[] enemy = new Enemy[7];
        enemy[0] = new Enemy("Серебряный рыцарь",30,15,0);
        enemy[1] = new Enemy("Виверна",30,15,0);
        enemy[2] = new Enemy("Демон Капра",30,15,1);
        enemy[3] = new Enemy("Огненный Демон Плавильни",30,15,2);
        enemy[4] = new Enemy("Огонёк",30,15,2);
        enemy[5] = new Enemy("Водяной",30,15,3);
        enemy[6] = new Enemy("Гарпия",30,15,2);

        System.out.println("Приветствую в игре, путник! ");
        System.out.println("Твоя задача одолеть всех врагов в этом подземелье.");
        System.out.println("Для тебя я приготовил нескоьлко оружий, используй их с умом и помни что у каждого есть свой тип атики, и каждый враг на твоем пути уязвим к чему-то одному.");
        System.out.println("Удачи!");

        while (PlayerHelth > 0 && !isBoss){
            System.out.println("У вас осталось "+ PlayerHelth + " жизней");
            System.out.println("Перед тобой стоит: "+ enemy[enemyIndex].getName() + " У него осталось " + enemy[enemyIndex].getHealth() + " жизней" + ".\nВыбири оружие: ");
            for (int i = 0; i < weapon.length;i++){
                System.out.print(i+1+": ");
                weapon[i].WeaponInformation();
            }
            int weaponIndex = scanner.nextInt();
            if (weaponIndex > 0 && weaponIndex < 6){
                if (weapon[weaponIndex - 1].getDamageType() == enemy[enemyIndex].getType()){
                    System.out.println("Вы выбрали верное оружие. Противник побежден\nВы двигаетесь вперед...");
                    enemy[enemyIndex].TakeDamage(weapon[weaponIndex-1].getDamage());
                }
                else if (weapon[weaponIndex - 1].getDamageType() == 4){
                    enemy[enemyIndex].TakeDamage(weapon[weaponIndex - 1].getDamage());
                    PlayerHelth -= enemy[enemyIndex].getDamage();
                }
                else {
                    enemy[enemyIndex].TakeDamage(weapon[weaponIndex - 1].getDamage()/2);
                    PlayerHelth -= enemy[enemyIndex].getDamage();
                }
                if (enemy[enemyIndex].getHealth() <= 0 && enemyIndex !=6)
                    enemyIndex+=1;
                else if (enemyIndex == 6 && enemy[enemyIndex].getHealth() <= 0)
                    isBoss = true;
            }
            else
                throw new WeaponIndexException("Выбрано недоступное оружие");
            System.out.println();
        }
        if (PlayerHelth > 0)
            System.out.println("Приключения продолжаются... ");
        else
            return;

        System.out.println("БИТВА С БОССОМ");
        //Можно доработать и придумать босса после победы над всеми противниками
    }
}
