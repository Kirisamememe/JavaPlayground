package game.Creature.BattleCreature.Character;

public class GreatWizard extends Wizard{
    public GreatWizard(String name){
        setName(name);
        setMaxHp(400);
        setHp(400);

        setATK(20);
        setDEF(8);
    }

    public void run(){
        System.out.println(getName() + "はテレポートで安全な場所に転移した");
        System.out.println("GAME-OVER");
        System.out.println("最終HPは" + getHp() + "でした！\n");
    }
}
