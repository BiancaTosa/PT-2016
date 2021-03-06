package PolynomInfo;

import java.util.Comparator;

public class TermsComparator implements Comparator<Term> {

	public int compare(Term t1, Term t2) {
		if (t1.getDegree() > t2.getDegree()) {
			return -1;
		}
		if (t1.getDegree() < t2.getDegree()) {
			return 1;
		}
		return 0;
	}

}
