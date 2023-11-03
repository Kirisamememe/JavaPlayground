package game.Creature.BattleCreature.Monster;

import game.Creature.BattleCreature.Character.Character;

import static game.util.Util.sleepWithoutException;

public class Slime extends Monster{

    //コンストラクタ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    public Slime(char suffix){
        setMaxHp(50);
        setHp(50);
        setName("スライム" + suffix);

        setExp(300);
        setATK(15);
        setDEF(2);
    }
    //＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


    public void skill_1(Character target){
        System.out.println(getName() + "は" + target.getName() + "に【粘液攻撃】を放った！");
        int damage = getATK() * 3 - target.getDEF();

        sleepWithoutException(300);

        System.out.println(target.getName() + "に " + damage + " のダメージを与えた");
        target.damaged(damage);
    }

    public void run(){
        setNotInBattle();
        System.out.println(getName() + "は変形しながら逃げ出した！\n");
    }

}
