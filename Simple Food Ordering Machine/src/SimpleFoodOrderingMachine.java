import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

public class SimpleFoodOrderingMachine {
    private JPanel root;
    private JLabel topLabel;
    private JButton tempuraButton;
    private JButton ramenButton;
    private JButton udonButton;
    private JTextPane receivedInfo;
    private JButton sobaButton;
    private JButton sushiButton;
    private JButton sukiyakiButton;
    private JButton checkoutButton;
    private int totalPrice = 0;
    private JLabel totalLabel;
    private int tempuraCount = 0;
    private int ramenCount = 0;
    private int udonCount = 0;
    private int sobaCount = 0;
    private int sushiCount = 0;
    private int sukiyakiCount = 0;

    public void order(String food, int price) {
        int confirmation = JOptionPane.showConfirmDialog(null,
                "Would you like to order "+food+"?","Order Confirmation",
                JOptionPane.YES_NO_OPTION);

        if(confirmation == 0){
            if(food.equals("Tempura")){
                tempuraCount++;
            }
            else if(food.equals("Ramen")){
                ramenCount++;
            }
            else if(food.equals("Udon")){
                udonCount++;
            }
            else if(food.equals("Soba")){
                sobaCount++;
            }
            else if(food.equals("Sushi")){
                sushiCount++;
            }
            else if(food.equals("Sukiyaki")){
                sukiyakiCount++;
            }
            String text = "";
            if(tempuraCount > 0){
                text += String.format(
                        "Tempura   ×%d   %5d yen\n",
                        tempuraCount,
                        tempuraCount * 500
                );
            }
            if(ramenCount > 0){
                text += String.format(
                        "Ramen     ×%d   %5d yen\n",
                        ramenCount,
                        ramenCount * 900
                );
            }
            if(udonCount > 0){
                text += String.format(
                        "Udon      ×%d   %5d yen\n",
                        udonCount,
                        udonCount * 650
                );
            }
            if(sobaCount > 0){
                text += String.format(
                        "Soba   ×%d   %5d yen\n",
                        sobaCount,
                        sobaCount * 450
                );
            }
            if(sushiCount > 0){
                text += String.format(
                        "Sushi     ×%d   %5d yen\n",
                        sushiCount,
                        sushiCount * 1350
                );
            }
            if(sukiyakiCount > 0){
                text += String.format(
                        "Sukiyaki      ×%d   %5d yen\n",
                        sukiyakiCount,
                        sukiyakiCount * 20000
                );
            }
            receivedInfo.setText(text);

            totalPrice += price;
            totalLabel.setText("Total: " + totalPrice + " yen");

            JOptionPane.showMessageDialog(null,"Order for " +food+ " received.");
        }
    }
    public void checkout() {
        int confirmation = JOptionPane.showConfirmDialog(null,
                "Would you like to checkout?",
                "Checkout Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you!");

            // リセット
            receivedInfo.setText("");
            totalPrice = 0;
            totalLabel.setText("Total: 0 yen");
        }
    }
    public ImageIcon resizeIcon(String path, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(path));
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SimpleFoodOrderingMachine");
        frame.setContentPane(new SimpleFoodOrderingMachine().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SimpleFoodOrderingMachine() {

        receivedInfo.setText("");
        totalLabel.setText("Total: 0 yen");

        tempuraButton.setIcon(resizeIcon("tempura.jpg", 150, 150));
        ramenButton.setIcon(resizeIcon("Ramen.jpg", 150, 150));
        udonButton.setIcon(resizeIcon("Udon.jpg", 150, 150));
        sobaButton.setIcon(resizeIcon("Soba.jpg", 150, 150));
        sushiButton.setIcon(resizeIcon("Sushi.jpg", 150, 150));
        sukiyakiButton.setIcon(resizeIcon("Sukiyaki.jpg", 150, 150));


        tempuraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order("Tempura",500);
            }
        });
        ramenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order("Ramen",900);
            }
        });
        udonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    order("Udon",650);
                }

        });
        sobaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {order("Soba",450);}
        });
        sushiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {order("Sushi",1350);}
        });
        sukiyakiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {order("Sukiyaki",20000);}
        });
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { checkout(); }
        });
    }
}
