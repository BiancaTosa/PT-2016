package Interface;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Operations.AddOp;
import Operations.SubtractOp;
import Operations.DeriveOp;
import Operations.DivideOp;
import Operations.IntegrateOp;
import Operations.MultiplyOp;
import PolynomInfo.Polynomial;
import PolynomInfo.Term;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel operationsPanel = new JPanel();
	private JPanel executionPanel = new JPanel();
	private JPanel insertPanel = new JPanel();
	private JPanel resultPanel = new JPanel();
	private JButton buttons[] = new JButton[7];
	private JLabel firstResult = new JLabel();
	private JLabel secondResult = new JLabel();
	private JLabel firstPolynom = new JLabel();
	private JLabel secondPolynom = new JLabel();

	private JTextField polynomText1 = new JTextField(20);
	private JTextField polynomText2 = new JTextField(20);
	private Polynomial polynomeOne = new Polynomial();
	private Polynomial polynomeTwo = new Polynomial();
	private boolean donePressed = false;

	public GUI() {
		super("Polynomials");
		buildGUI();
		readData(firstResult);
		displayResult();

		setVisible(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void readData(JLabel result) {
		for (int i = 0; i < 7; i++) {
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton source = (JButton) e.getSource();
					if (!donePressed) {
						if (source.equals(buttons[0])) {
							donePressed = true;
							Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
							Matcher m1 = p.matcher(polynomText1.getText());
							Matcher m2 = p.matcher(polynomText2.getText());
							while (m1.find()) {
								polynomeOne.addTerm(
										new Term(Integer.parseInt(m1.group(1)), Integer.parseInt(m1.group(2))));
							}
							while (m2.find()) {
								polynomeTwo.addTerm(
										new Term(Integer.parseInt(m2.group(1)), Integer.parseInt(m2.group(2))));
							}
							polynomeOne.sortPolynom();
							polynomeTwo.sortPolynom();
							firstPolynom.setText("First polynomial: " + polynomeOne.toString());
							secondPolynom.setText("Second polynomial: \n" + polynomeTwo.toString());
						}
					} else {
						if (source.equals(buttons[1])) {
							AddOp add = new AddOp();
							secondResult.setText(null);
							firstResult.setText("Sum : " + add.execute(polynomeOne, polynomeTwo).toString());
						} else if (source.equals(buttons[2])) {
							SubtractOp subtract = new SubtractOp();
							subtract.execute(polynomeOne, polynomeTwo);
							secondResult.setText(null);
							firstResult
									.setText("Difference : " + subtract.execute(polynomeOne, polynomeTwo).toString());
						} else if (source.equals(buttons[3])) {
							IntegrateOp integrate = new IntegrateOp();
							firstResult
									.setText("First polynom integration: " + integrate.execute(polynomeOne).toString());
							secondResult.setText(
									"Second polynom integration: " + integrate.execute(polynomeTwo).toString());
						} else if (source.equals(buttons[4])) {
							DeriveOp differentiate = new DeriveOp();
							firstResult.setText(
									"First polynom derivative: " + differentiate.execute(polynomeOne).toString());
							secondResult.setText(
									"Second polynom derivative: " + differentiate.execute(polynomeTwo).toString());
						} else if (source.equals(buttons[5])) {
							MultiplyOp multiply = new MultiplyOp();
							secondResult.setText(null);
							firstResult.setText(
									"Multiplication: " + multiply.execute(polynomeOne, polynomeTwo).toString());
						} else if (source.equals(buttons[6])) {
							DivideOp divide = new DivideOp();
							firstResult.setText("Quotient: " + divide.execute(polynomeOne, polynomeTwo).toString());
							if (divide.getRemainder() != null)
								secondResult.setText("Reminder: " + divide.getRemainder().toString());
						}
					}
				}
			});
		}
	}

	private void buildGUI() {
		setLayout(new GridLayout(2, 2));
		buttons[0] = new JButton("Done");
		buttons[1] = new JButton("Add");
		buttons[2] = new JButton("Subtract");
		buttons[3] = new JButton("Integrate");
		buttons[4] = new JButton("Differentiate");
		buttons[5] = new JButton("Multiply");
		buttons[6] = new JButton("Divide");

		operationsPanel.add(buttons[1]);
		operationsPanel.add(buttons[2]);
		operationsPanel.add(buttons[3]);
		operationsPanel.add(buttons[4]);
		operationsPanel.add(buttons[5]);
		operationsPanel.add(buttons[6]);

		insertPanel.add(new JLabel("First Polynom"));
		insertPanel.add(polynomText1);
		insertPanel.add(new JLabel("Second Polynom"));
		insertPanel.add(polynomText2);

		executionPanel.add(buttons[0]);

		add(insertPanel);
		add(executionPanel);
		add(operationsPanel);
	}

	private void displayResult() {
		resultPanel.add(firstPolynom);
		resultPanel.add(secondPolynom);
		resultPanel.add(firstResult);
		resultPanel.add(secondResult);
		add(resultPanel);
	}
}
