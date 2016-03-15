package Operations;

import PolynomInfo.Polynomial;
import PolynomInfo.Term;

public class DivideOp implements BiOperation {
	private Polynomial remainder = new Polynomial();
	
	@Override
	public Polynomial execute(Polynomial p1, Polynomial p2) {
		// TODO Auto-generated method stub
		Polynomial quotient = new Polynomial();
		Polynomial aux = new Polynomial();
		MultiplyOp multiply = new MultiplyOp();
		SubtractOp subtract = new SubtractOp();
		AddOp add = new AddOp();
		int degree = p2.polynomDegree();
		double lc = p2.leadingCoeff();
		for (Term t : p1.getTerms()){
			remainder.addTerm(t);
		}
		while (remainder.polynomDegree() >= degree) {
			aux.getTerms().add(new Term(remainder.leadingCoeff() / lc, (remainder.polynomDegree() - degree)));
			quotient = add.execute(aux, quotient);
			remainder = subtract.execute(remainder, multiply.execute(aux, p2));
			aux.getTerms().clear();

		}
		remainder.sortPolynom();
		quotient.sortPolynom();
		return quotient;

	}
	public Polynomial getRemainder(){
		return this.remainder;
	}
}
