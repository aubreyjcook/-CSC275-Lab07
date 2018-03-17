
public class Entity {
	static String strName;
	static int intLife;
	static int intEnergy;
	
	Entity(){}
	
	//constructor
	public Entity(String entityName, int entityLife, int entityEnergy) {
		Entity.strName   = entityName;
		Entity.intLife   = entityLife;
		Entity.intEnergy = entityEnergy;
	}
	
	//setter methods
	public void setStrName(String name) {
		Entity.strName = name;
	}
	
	public void setIntLife(int life) {
		Entity.intLife = life;
	}
	
	public void setIntEnergy(int energy) {
		Entity.intEnergy = energy;
	}
	
	//getter methods
	public String getStrName() {
		return strName;
	}
	
	public int getIntLife() {
		return intLife;
	}
	
	public int getIntEnergy() {
		return intEnergy;
	}

}
