package game.Creature.BattleCreature;

import game.Creature.Creature;

public abstract class BattleCreature implements Creature {
    private int hp = 0;
    private int maxHp = 0;
    private boolean isDead = false;
    private String name = "戦う生き物";
    private int lv = 1;
    private int exp;

    private int ATK;
    private int DEF;


    public void attack(BattleCreature target){
        int damage = getATK() - target.getDEF();
        System.out.println(getName() + "は" + target.getName() + "を攻撃した！");
        System.out.println(target.getName() + "に" + damage + "ポイントのダメージを与えた");
        target.damaged(damage);
    }

    public void damaged(int damage){
        setHp(getHp() - Math.max(damage, 0));
        if (getHp() > 0) {
            System.out.println(getName() + "の現在のHPは >> " + hp + "\n");
        }
        else if (!getIsDead()) {
            die();
            System.out.println(getName() + "が死んだ\n");
            setName(getName() + "の死体");
        } else {
            System.out.println(getName() + "はもう死んでいる\n");
        }
    }

    public String getName(){
        return "【" + this.name + "】";
    }

    public void setName(String name){
        if (name.length() > 12) {
            throw new IllegalArgumentException("名前が長すぎる。処理を中断");
        }
        this.name = name;
    }

    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp = Math.min(hp, maxHp);
    }

    public void setMaxHp(int maxHp){
        this.maxHp = maxHp;
    }

    public int getMaxHp(){
        return maxHp;
    }

    public void setHpToMax(){
        setHp(getMaxHp());
    }

    public void setExp(int exp){
        this.exp = exp;
    }

    public void setATK(int ATK){
        this.ATK = ATK;
    }

    public int getATK(){
        return this.ATK;
    }

    public void setDEF(int DEF){
        this.DEF = DEF;
    }

    public int getDEF(){
        return this.DEF;
    }

    public int getExp(){
        return this.exp;
    }


    public int getLv(){
        return this.lv;
    }

    public void levelUp(){
        this.lv++;
        setMaxHp(getMaxHp() + 100);
        setHp(getMaxHp());
        setATK(getATK() + 10);
        setDEF(getDEF() + 5);
    }

    public boolean getIsDead(){
        return this.isDead;
    }

    private void die(){
        this.isDead = true;
    }
}
