package graph;

public abstract class AbstractObject implements Comparable{
	public final boolean isLT (Comparable object){
		return compare (object) < 0;
	}
	public final boolean isLE (Comparable object){
		return compare (object) <= 0;
	}
	public final boolean isGT (Comparable object){
		return compare (object) > 0;
	}
	public final boolean isGE (Comparable object){
		return compare (object) >= 0;
	}
	public final boolean isEQ (Comparable object){
		return compare (object) == 0;
	}
	public final boolean isNE (Comparable object){
		return compare (object) != 0;
	}
	public final boolean equals (Object object){
		if (object instanceof Comparable)
			return isEQ((Comparable) object);
		else
			return false;
	}
	// ...
}
