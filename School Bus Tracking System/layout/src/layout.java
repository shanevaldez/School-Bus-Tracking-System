import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class busdata {
    String id;
    int cap = 48;
    int curstu = 48;
    int tratime;

    public busdata(String id, int tratime){
        this.id = id;
        this.tratime = tratime;
    }

}

public class layout extends JFrame{
    private JPanel main;
    private JPanel sidebar;
    private JButton registrationButton;
    private JButton schedulesButton;
    private JButton routesButton;
    private JTextField nm;
    private JTextField pp;
    private JComboBox dp;
    private JButton submitButton;
    private JButton login;
    private JComboBox busno;

    layout () {
        setTitle("School Bus Tracking System");
        setContentPane(main);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<busdata> buses = Arrays.asList(
                        new busdata("No. 1291", 5),
                        new busdata("No. 1292", 30),
                        new busdata("No. 1293", 90),
                        new busdata("No. 1293", 90));
                busdata bestbus = buses.stream().filter(b->b.curstu<b.cap)
                        .min(Comparator.comparingInt(b-> b.tratime)).orElse(null);
                if (bestbus != null){
                    bestbus.curstu++;
                    JOptionPane.showMessageDialog(null, "Student: " + nm.getText() +
                            "\n Bus Number: " + bestbus.id +"\n Estemated Arrival: " + bestbus.tratime + "mins" );
                }
                else {
                    JOptionPane.showMessageDialog(null,"All Buses are Currently Full");
                }
            }
        });
    }
    static void main() {
        new layout();
    }
}