
public class Archer extends Playable {
	public void attack(int damageToInflict, Entity playerToAttack) {
		playerToAttack.setIntLife(this.intLife - damageToInflict);
	}

}
