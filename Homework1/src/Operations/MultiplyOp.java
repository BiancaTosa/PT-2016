package Operations;

import PolynomInfo.Polynomial;
import PolynomInfo.Term;

public class MultiplyOp implements BiOperation {
	@Override
	public Polynomial execute(Polynomial p1, Polynomial p2) {
		Polynomial newPol = new Polynomial();
		for (Term t1 : p1.getTerms()) {
			for (Term t2 : p2.getTerms()) {
				newPol.addTerm(new Term(t1.getCoeff() * t2.getCoeff(), t1.getDegree() + t2.getDegree()));
			}
		}
		newPol.sortPolynom();
		return newPol;
	}

}
