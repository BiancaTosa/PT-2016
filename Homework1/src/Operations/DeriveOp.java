package Operations;



import PolynomInfo.Polynomial;
import PolynomInfo.Term;

public class DeriveOp implements UniOperation{

	public Polynomial execute(Polynomial p) {
		Polynomial newPol = new Polynomial();
		for (Term term : p.getTerms()){
			newPol.getTerms().add(new Term(term.getCoeff() * term.getDegree(), term.getDegree() - 1));
		}
		newPol.sortPolynom();
		return newPol;
	}
}
