import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win1 extends JFrame implements ActionListener {

    private JLabel info;
    private JTextField D, A, H;

    private JLabel qlabel, nlabel, tc_label, to_label, total;
    private JButton computeButton = new JButton("محاسبه کن");

    private double qw;
    private int n_;
    private double negahdari, segaresh, sum;

    public Win1() {

        setTitle("کنترل موجودی فصل1");
        setSize(600, 600);
        setLayout(new GridLayout(4, 4));

        info = new JLabel("MAKE BY ZANA ABDI");
        D = new JTextField("تقاضا");
        A = new JTextField("هزینه سفارش دهی");
        H = new JTextField("هزینه نگهداری");

        // Add button and action listener
        add(computeButton, 3, 0, 1, 1);
        computeButton.addActionListener(this);

        qlabel = new JLabel("q");
        nlabel = new JLabel("N");
        tc_label = new JLabel("tc");
        to_label = new JLabel("to");
        total = new JLabel("total");

        // Add all components to the layout
        add(info, 0, 0, 3, 3);
        add(D, 0, 1, 3, 3);
        add(A, 0, 2, 3, 3);
        add(H, 0, 3, 3, 3);

        add(qlabel, 1, 0, 1, 1);
        add(nlabel, 1, 1, 1, 1);
        add(tc_label, 1, 2, 1, 1);
        add(to_label, 1, 3, 1, 1);
        add(total, 0, 4, 3, 1);
    }

    private void add(JComponent component, int x, int y, int w, int h) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        getContentPane().add(component, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get values from text fields
        double demand = Double.parseDouble(D.getText());
        double setupCost = Double.parseDouble(A.getText());
        double holdingCost = Double.parseDouble(H.getText());

        // Calculate parameters
        qw = Math.sqrt((2 * demand * setupCost) / holdingCost);
        n_ = (int) (demand / qw);
        negahdari = (holdingCost * qw) / 2 + (demand * setupCost);
        segaresh = (demand * setupCost) / qw;
        sum = negahdari + segaresh;

        // Update labels with results (assuming they have JLabels)
        qlabel.setText("q: " + qw);
        nlabel.setText("N: " + n_);
        tc_label.setText("tc: " + negahdari);
        to_label.setText("to: " + segaresh);
        total.setText("total: " + sum);
    }
}
