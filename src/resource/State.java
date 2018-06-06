package resource;

import java.util.HashMap;
import java.util.ArrayList;

import soot.Local;
import soot.Value;

abstract class StateType {
	String name;
	int value;
	
	StateType(String name) {this.name = name;}
	StateType(String name, int value) {
		this.name = name;
		this.value = value;
	}
	boolean isTop() {return false;}
	boolean isBottom() {return false;}
	boolean isConstant() {return false;}
}

class Top extends StateType {
	static private Top top = new Top();
	
	private Top() {super("top");}
	static Top getTop() {return top;}
	boolean isTop() {return true;}
}

class Bottom extends StateType {
	static private Bottom bottom = new Bottom();
	
	private Bottom() {super("bottom");}
	static Bottom getBottom() {return bottom;}
	boolean isBottom() {return true;}
}

class Constant extends StateType {
	static private Constant constant = new Constant();
	
	private Constant() {super("constant");}
	private Constant(int value) {
		super("constant", value);}
	static Constant getConstant() {return constant;}
	boolean isConstant() {return true;}
	int getValue() {return super.value;}
}

public class State extends HashMap<Local, StateType> {
	private static final long serialVersionUID = 1L;

	public State() {
		super();
	}
	
	public StateType put(Local local, StateType stateType) {
		return super.put(local, stateType);
	}
	
	public StateType get(Local local) {
		return super.get(local);
	}
}
