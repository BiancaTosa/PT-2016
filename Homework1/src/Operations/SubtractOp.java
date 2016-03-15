package Operations;

import PolynomInfo.Polynomial;
import PolynomInfo.Term;

public class SubtractOp implements BiOperation {

	@Override
	public Polynomial execute(Polynomial p1, Polynomial p2) {

		// TODO Auto-generated method stub
		Polynomial newPol = new Polynomial();
		for (Term t : p2.getTerms()) {
			if (t.getCoeff() != 0) {
				newPol.getTerms().add(new Term(-t.getCoeff(), t.getDegree()));
			}

		}
		for (Term term1 : p1.getTerms()) {
			if (term1.getCoeff() != 0) {
				newPol.addTerm(term1);
			}
		}
		newPol.sortPolynom();
		return newPol;
	}

}
