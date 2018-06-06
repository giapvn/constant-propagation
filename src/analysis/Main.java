package analysis;

import java.util.Map;

import soot.Body;
import soot.BodyTransformer;
import soot.PackManager;
import soot.Transform;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;

public class Main {
	private static void addPackManager() {
		PackManager.v().getPack("jtp").add(
				new Transform("jtp.myTransform", new BodyTransformer() {
					
					@Override
					protected void internalTransform(Body b, String phaseName, Map<String, String> options) {
						UnitGraph unitGraph = new ExceptionalUnitGraph(b);
						ConstantPropagation cp = new ConstantPropagation(unitGraph);
					}
				}));
	}
	
	public static void main(String[] args) {
		addPackManager();
		soot.Main.main(args);
	}
}
