package game;

import game.Creature.BattleCreature.Character.Hero;
import game.Creature.BattleCreature.Monster.Goblin;
import game.Creature.BattleCreature.Monster.Monster;
import game.Creature.BattleCreature.Monster.Slime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static game.util.Util.*;

public class Stage_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cmd = 0;

        System.out.print("勇者の名前を入力してください：");
        String heroName = input.next();
        Hero hero = new Hero(heroName);

//        System.out.print("大魔法使いの名前を入力してください：");
//        String greatWizardName = input.next();
//        GreatWizard greatWizard = new GreatWizard(greatWizardName);
        System.out.println("ステージ１　スタート！\n");

        //魔物を召喚する＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Goblin('A'));
        monsters.add(new Goblin('B'));
        monsters.add(new Slime('A'));
        monsters.add(new Slime('B'));
        //＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
        boolean isBattling = true;

        while (isBattling){
            System.out.println("こっちのターン、開始！\n＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
            sleepWithoutException(500);
            System.out.println("フィールド上の魔物：");
            for (int i = 0; i < monsters.size(); i++) {
                sleepWithoutException(100);
                System.out.println((i + 1) + monsters.get(i).getName());
            }
            sleepWithoutException(500);

            System.out.print("\nコマンド：\n1、通常攻撃\n2、秘技\n3、逃げる（ゲーム終了）\n >> ");
            cmd = input.nextInt();

            switch (cmd) {
                //Java 12以降では、->　と書けばbreakはいらない
                case 1 -> {
                    System.out.print("攻撃対象の番号 >> ");
                    int target = input.nextInt() - 1;
                    hero.attack(monsters.get(target));
                    if (monsters.get(target).getIsDead()) monsters.remove(target);
                }
                case 2 -> {
                    hero.skill(monsters);
                    monsters.removeIf(Monster::getIsDead);
                }
                case 3 -> {
                    hero.run();
                    isBattling = false;
                }
            }
            sleepWithoutException(500);
            System.out.println("\nこっちのターン、終了！\n＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");

            pressEnter();
            if (monsters.isEmpty()) {
                System.out.println("\n敵が全滅した！");
                System.out.println("ステージクリア！");
                input.close();
                break;
            }

            System.out.println("敵のターン、開始！\n＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
            sleepWithoutException(500);
            System.out.println("フィールド上の魔物：");
            for (int i = 0; i < monsters.size(); i++) {
                sleepWithoutException(100);
                System.out.println((i + 1) + monsters.get(i).getName());
            }

            sleepWithoutException(500);
            System.out.print("\n");

            for (Monster monster : monsters){
                Random rand = new Random();
                int action = rand.nextInt(100);

                if (action < 60) {
                    monster.attack(hero);
                } else if (action < 95) {
                    monster.skill_1(hero);
                }else {
                    monster.run();
                }
            }
            monsters.removeIf(Monster::getNotInBattle);

            System.out.println("敵のターン、終了！\n＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
            pressEnter();
        }
    }

}
