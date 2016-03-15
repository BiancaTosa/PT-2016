package PolynomInfo;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial {
	private ArrayList<Term> terms = new ArrayList<Term>();

	public ArrayList<Term> getTerms() {
		return terms;
	}

	public void setPolynom(ArrayList<Term> terms) {
		this.terms = terms;
	}

	public void addTerm(Term term) {
		boolean add = false;
		for (Term t : this.terms) {
			if (term.getDegree() == t.getDegree()) {
				add = true;
				t.setCoeff(term.getCoeff() + t.getCoeff());
			}
		}
		if (!add) {
			terms.add(term);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Term term : terms) {
			if (term == terms.get(0)) {
				if (term.getCoeff() == 0.0) {
					sb.append("");
				} else if (term.getCoeff() == 1.0) {
					if (term.getDegree() == 0) {
						sb.append("");
					} else if (term.getDegree() == 1) {
						sb.append("x");
					} else {
						sb.append("x^");
						sb.append(term.getDegree());
					}

				} else if (term.getCoeff() == -1.0) {
					sb.append("-");
					if (term.getDegree() == 0) {
						sb.append("");
					} else if (term.getDegree() == 1) {
						sb.append("x");
					} else {
						sb.append("x^");
						sb.append(term.getDegree());
					}

				} else {
					sb.append(term.getCoeff());
					if (term.getDegree() == 0) {
						sb.append("");
					} else if (term.getDegree() == 1) {
						sb.append("x");
					} else {
						sb.append("x^");
						sb.append(term.getDegree());
					}
				}
			} else {
				if (term.getCoeff() == 0.0) {
					sb.append("");
				} else if (term.getCoeff() > 1.0) {
					sb.append("+");
					sb.append(term.getCoeff());
					if (term.getDegree() == 0) {
						sb.append("");
					} else if (term.getDegree() == 1) {
						sb.append("x");
					} else {
						sb.append("x^");
						sb.append(term.getDegree());
					}
				} else if (term.getCoeff() == 1.0) {
					sb.append("+");
					if (term.getDegree() == 0) {
						sb.append("");
					} else if (term.getDegree() == 1) {
						sb.append("x");
					} else {
						sb.append("x^");
						sb.append(term.getDegree());
					}
				} else if (term.getCoeff() == -1.0) {
					sb.append("-");
					if (term.getDegree() == 0) {
						sb.append("");
					} else if (term.getDegree() == 1) {
						sb.append("x");
					} else {
						sb.append("x^");
						sb.append(term.getDegree());
					}
				} else {
					sb.append(term.getCoeff());
					if (term.getDegree() == 0) {
						sb.append("");
					} else if (term.getDegree() == 1) {
						sb.append("x");
					} else {
						sb.append("x^");
						sb.append(term.getDegree());
					}
				}
			}
		}
		return sb.toString();
	}

	public void sortPolynom() {
		Collections.sort(terms, new TermsComparator());
	}

	public double leadingCoeff() {
		for (Term t : terms) {
			if (t.getDegree() == this.polynomDegree()) {
				return t.getCoeff();
			}
		}
		return 0;
	}

	public int polynomDegree() {
		int max = -1;
		for (Term t : terms) {
			if (max < t.getDegree() && t.getCoeff() != 0) {
				max = t.getDegree();
			}
		}
		return max;
	}

}
