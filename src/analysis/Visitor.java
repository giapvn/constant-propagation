package analysis;

import resource.State;

import soot.G;
import soot.Local;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.GotoStmt;
import soot.jimple.IdentityStmt;
import soot.jimple.IfStmt;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.LookupSwitchStmt;
import soot.jimple.NopStmt;
import soot.jimple.Stmt;
import soot.jimple.TableSwitchStmt;
import soot.jimple.internal.JimpleLocalBox;

public class Visitor {
	State input, output;
	
	private static Visitor visitor = new Visitor();
	public static Visitor getVisitor() {
		return visitor;
	}
	public Visitor() {}
	
	public void visit(Stmt stmt, State input, State output) {
		this.input = input;
		this.output = output;
		visit(stmt);
	}
	
	private void visit(Stmt stmt) {
		if(stmt instanceof IdentityStmt) {
			visit((IdentityStmt)stmt);
		}else if(stmt instanceof AssignStmt) {
			visit((AssignStmt)stmt);
		}else {
			
		}
	}
	
	private void visit(IdentityStmt stmt) {
		G.v().out.println("Identity --> " + stmt.toString());
	}
	
	private void visit(AssignStmt stmt) {
		Value lhs = stmt.getLeftOp();
		Value rhs = stmt.getRightOp();
	}
}
