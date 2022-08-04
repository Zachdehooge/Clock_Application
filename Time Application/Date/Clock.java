package Date;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;

public class Clock extends JFrame {

    public Clock(){

        this.setTitle("Clock");

        ImageIcon image = new ImageIcon("Date/src/Images/Clock.png");
        this.setIconImage(image.getImage());

        final JLabel text = new JLabel();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        text.setText(dtf.format(now));
        text.setBounds(65,-150,1300,500);
        text.setForeground(Color.yellow);
        text.setFont(new Font("Serif", Font.BOLD, 200));
        this.add(text);

        Thread t1 = new Thread() {
                public void run() {
                try {
                    for(;;) {
                        Calendar cal = Calendar.getInstance();
                        int hour = cal.get(Calendar.HOUR_OF_DAY);
                        int minute = cal.get(Calendar.MINUTE);
                        int second = cal.get(Calendar.SECOND);

                        text.setText(hour + ":" + minute + ":" + second);
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };t1.start();

        JLabel month = new JLabel();
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        month.setText("Today's date: " + formattedDate);
        month.setBounds(175,0,1300,500);
        month.setForeground(Color.GREEN);
        month.setFont(new Font("Serif", Font.BOLD, 30));
        this.add(month);

        this.getContentPane().setBackground(Color.gray);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(905, 350);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
