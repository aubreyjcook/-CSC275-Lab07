
public class Ogre extends Entity {
	public void attack(int damageToInflict, Entity playerToAttack) {
		playerToAttack.setIntLife(this.intLife - damageToInflict);
	}
}
