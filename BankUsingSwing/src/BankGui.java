import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;

public class BankGui {

    int balance = 0;
    List<String> history = new ArrayList<>();

    JFrame frame = new JFrame("The Bank");
    JPanel panel = new JPanel();
    JLabel currentBalance = new JLabel(balance + " Kronor");
    JLabel balanceHeader = new JLabel("Balance: ");
    JPanel historyList = new JPanel();


    public BankGui() {
        
        JTextField inputDepositMoney = new JTextField();
        JButton depositBtn = new JButton("Deposit Money");
        depositBtn.addActionListener(e -> {
            depositMoney(inputDepositMoney.getText());
        });

        JTextField inputWithdrawMoney = new JTextField();
        JButton withdrawBtn = new JButton("Withdraw Money");
        withdrawBtn.addActionListener(e -> {
            withdrawMoney(inputWithdrawMoney.getText());
        });

        panel.setLayout(new GridLayout(4, 1));
        panel.add(balanceHeader);
        panel.add(currentBalance);
        panel.add(inputDepositMoney);
        panel.add(depositBtn);
        panel.add(inputWithdrawMoney);
        panel.add(withdrawBtn);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void depositMoney(String deposit) {
        balance += Integer.parseInt(deposit);
        System.out.println("Deposit money, " + deposit + "Balance is now " + balance);
        history.add("You deposited " + deposit + " kronor");
        printBalance();
        printHistory();
    }

    public void withdrawMoney(String withdraw) {
        balance -= Integer.parseInt(withdraw);
        System.out.println("Withdraw money, " + withdraw + "Balance is now " + balance);
        history.add("you withdrew " + withdraw + " kronor");
        printBalance();
        printHistory();
    }

    public void printBalance() {
        System.out.println("Update balance i UI");
        currentBalance.setText(balance + " Kronor");
    }

    public void printHistory() {
        System.out.println("Show history");

        historyList.setLayout(new GridLayout(history.size(), 1));
        historyList.removeAll();

        for (String item : history) {
            System.out.println("print out history " + item);
            JLabel addHistory = new JLabel(item);
            historyList.add(addHistory);
        }

        panel.add(historyList);
        frame.pack();
    }
    public static void main(String[] args) {
        new BankGui();
        

    }
    
}
