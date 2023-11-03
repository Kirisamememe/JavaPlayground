package game.Creature.BattleCreature.Monster;

import game.Creature.BattleCreature.BattleCreature;
import game.Creature.BattleCreature.Character.Character;

public abstract class Monster extends BattleCreature {

    private boolean notInBattle = false;

    public void attack(Character target){
        super.attack(target);
    }

    public void attack(Monster target){
        super.attack(target);
    }

    public abstract void skill_1(Character target);

    public void setNotInBattle(){
        notInBattle = true;
    }
    public boolean getNotInBattle(){
        return notInBattle;
    }

}
