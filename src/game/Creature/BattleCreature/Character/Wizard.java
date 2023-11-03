package game.Creature.BattleCreature.Character;

import game.Creature.BattleCreature.Monster.Monster;

public class Wizard extends Character {

    //コンストラクタ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    public Wizard(String name){
        setName(name);
        setMaxHp(350);
        setHp(350);

        setATK(10);
        setDEF(3);
    }

    public Wizard(){
        this("魔法使い");
    }
    //＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


    public void fireBall(Monster target){
        target.damaged(25);
        System.out.println(getName() + "は" + target.getName() + "をファイアボールで攻撃した！");
        System.out.println(target.getName() + "に25ポイントのダメージを与えた");
    }

    public void heal(Character target){
        target.setHp(10);
        System.out.println(getName() + "は" + target.getName() + "のHPを10回復した\n");
    }

}
