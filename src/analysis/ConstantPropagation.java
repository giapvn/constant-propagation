package analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import soot.Body;
import soot.G;
import soot.Local;
import soot.PatchingChain;
import soot.Unit;
import soot.jimple.Stmt;
import soot.toolkits.graph.UnitGraph;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.ForwardFlowAnalysis;
import soot.util.Chain;
import resource.State;

public class ConstantPropagation extends ForwardFlowAnalysis<Unit, State> {

	private UnitGraph unitGraph;
	private Map<Unit, State> stateByUnitIn;
	private Map<Unit, State> stateByUnitOut;
	private List<Unit> unitAnalysed = new ArrayList<Unit>();
	
	public ConstantPropagation(DirectedGraph<Unit> graph) {
		super(graph);
		this.graph = graph;
		this.unitGraph = (UnitGraph)this.graph;
		stateByUnitIn = new HashMap<Unit, State>();
		stateByUnitOut = new HashMap<Unit, State>();
		
		doAnalysis();
	}

	@Override
	protected void flowThrough(State in, Unit unit, State out) {
		unitAnalysed.add(unit);
		stateByUnitIn.put(unit, in);//save inputState
		copy(in, out);
		Stmt stmt = (Stmt)unit;
		
		stateByUnitOut.put(unit, out);
	}

	@Override
	protected State newInitialFlow() {
		return new State();
	}

	@Override
	protected void merge(State in1, State in2, State out) {
		
	}

	@Override
	protected void copy(State source, State dest) {
		for (Local local: source.keySet()) {
			dest.put(local, source.get(local));
		}
	}
}
