package game.Creature.BattleCreature.Character;

import game.Creature.BattleCreature.BattleCreature;
import game.Creature.BattleCreature.Monster.Monster;

import java.util.HashMap;
import java.util.Map;

public abstract class Character extends BattleCreature {
    private final Map<Integer, Integer> lvMap = new HashMap<>();

    public Character(){
        setLvMap(2, 300);
        setLvMap(3, 700);
        setLvMap(4, 1200);
        setLvMap(5, 1800);
        setLvMap(6, 2600);
        setLvMap(7, 3600);
        setLvMap(8, 4600);
        setLvMap(9, 5600);
        setLvMap(10, 6600);
    }

    private int currentExp;

    public void attack(Monster target){
        super.attack(target);
        if (target.getIsDead()) {
            expIncrease(target);
        }
    }

    public void attack(Character target){
        super.attack(target);
    }

    public void run(){
        System.out.println(getName() + "は撤退した。");
        System.out.println("GAME-OVER");
        System.out.println("最終HPは" + getHp() + "でした！\n");
    };

    public void sleep(){
        setHpToMax();
        System.out.println(getName() + "は眠って復した！");
        System.out.println(getName() + "の現在のHPは" + getHp() + "\n");
    }

    public void sit(int sec){
        setHp(sec * 2);
        System.out.println(getName() + "は" + sec + "秒座った！");
        System.out.println("HPが" + (sec * 2) + "ポイント回復した！\n");
    }

    public final void slip(){
        setHp(-5);
        System.out.println(getName() + "は転んだ！");
        System.out.println("5のダメージ！\n");
    }

    public void expIncrease(BattleCreature target){
        currentExp += target.getExp();
        System.out.println(getName() + "は " + target.getExp() + " の経験値を獲得した");
        // EntryはMapの各set。
        // entrySet()が返すのはset（Map.Entryオブジェクト）の集合
        for (Map.Entry<Integer, Integer> entry : lvMap.entrySet()) {
            if (currentExp >= entry.getValue()) {
                if (getLv() == entry.getKey() - 1) {
                    levelUp();
                    System.out.println("\n＝＝レベルアップ！＝＝");
                    System.out.println(getName() + "はレベル " + getLv() + " になった！\n");
                }
            }
            else {
                break;
            }
        }
    }
    //魔物が死んだら経験値が手に入る。
    //経験値が一定に達したらレベルアップする
    //経験値が多すぎて一気にレベルがいくつも上がることがある。

    private void setLvMap(int key, int value){
        lvMap.put(key, value);
    }
}
