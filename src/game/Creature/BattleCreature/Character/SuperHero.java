package game.Creature.BattleCreature.Character;

public class SuperHero extends Hero {
    boolean flying;

    public SuperHero(String name){
        super(name);
    }


    //メソッド＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝


    public void fly(){
        this.flying = true;
        System.out.println(getName() + "は飛び上がった！");
    }

    public void land(){
        this.flying = false;
        System.out.println(getName() + "は着地した！");
    }

    public void run(){
        System.out.println(getName() + "は戦略的撤退を決断した");
        System.out.println("GAME-OVER");
        System.out.println("最終HPは" + getHp() + "でした！\n");
    }

}
