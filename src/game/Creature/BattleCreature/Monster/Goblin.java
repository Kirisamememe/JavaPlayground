package game.Creature.BattleCreature.Monster;

import game.Creature.BattleCreature.Character.Character;

import static game.util.Util.sleepWithoutException;


public class Goblin extends Monster{

    //コンストラクタ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    public Goblin(char suffix){
        setMaxHp(100);
        setHp(100);
        setName("ゴブリン" + suffix);

        setExp(300);
        setATK(25);
        setDEF(5);
    }
    //＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


    //メソッド＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝
    public void skill_1(Character target){
        System.out.println(getName() + "は" + target.getName() + "に【ゴブリンスマッシュ】を放った！");
        int damage = getATK() * 3 - target.getDEF();

        sleepWithoutException(300);

        System.out.println(target.getName() + "に " + damage + " のダメージを与えた");
        target.damaged(damage);
    }

    public void run() {
        setNotInBattle();
        System.out.println(getName() + "は逃げ出した！\n");
    }

}
