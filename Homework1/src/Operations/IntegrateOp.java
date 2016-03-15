package Operations;

import java.text.DecimalFormat;

import PolynomInfo.Polynomial;
import PolynomInfo.Term;

public class IntegrateOp implements UniOperation{

	public Polynomial execute(Polynomial p) {
		Polynomial newPol = new Polynomial();
		DecimalFormat df = new DecimalFormat("#.##");
		for (Term term : p.getTerms()){
			newPol.getTerms().add(new Term(Double.parseDouble(df.format(term.getCoeff() / (term.getDegree() + 1))), term.getDegree() + 1));
		}
		newPol.sortPolynom();
		return newPol;
	}
}
