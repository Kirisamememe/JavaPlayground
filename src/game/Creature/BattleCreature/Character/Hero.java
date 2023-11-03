package game.Creature.BattleCreature.Character;

import game.Creature.BattleCreature.Monster.Monster;
import game.Weapon.Sword;

import java.util.List;

import static game.util.Util.print;
import static game.util.Util.sleepWithoutException;

public class Hero extends Character {

    public Sword sword;

    //コンストラクタ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    public Hero(String name){
        setName(name);
        setMaxHp(500);
        setHp(500);

        setATK(25);
        setDEF(5);
    }

    public Hero(){
        this("勇者");
    }
    //＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝

    public void skill(List<Monster> targets){
        print("秘技ーー！\n", 200);
        print("水・鳥・乱・舞！\n\n", 400);
//        System.out.println("秘技・水鳥乱舞！\n");
        sleepWithoutException(300);
        for (Monster target : targets){
            int damage = getATK() * 2 - target.getDEF();
            System.out.println(target.getName() + "に " + damage + " のダメージを与えた！");
            target.damaged(damage);
            if (target.getIsDead()) {
                expIncrease(target);
            }
        }
    }




}
