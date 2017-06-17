package Training.Json.Jackson.Dish_1;

public class Ingredient {
	private String name;
	private Type type;
	public Ingredient(){}
	public Ingredient(String name, Type type){
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
    public String toString() {
	    return name + " " + type;
    }
    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        Ingredient ingredient;
        if(o instanceof Ingredient) {
            ingredient = (Ingredient)o;
        } else {
            return false;
        }
        return ingredient.name.equals(this.name) && ingredient.type.equals(this.type);
    }
    @Override
    public int hashCode() {
	    return name.hashCode() * 12 + type.hashCode() * 11;
    }
	
}