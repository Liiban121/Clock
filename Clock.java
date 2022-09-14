import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//Clock extends JFrame - the class that is used to make a window in Java.

public class Clock extends JFrame {
  //Declare the variables (the attributes) we will be using to build the clock
  Calendar calendar;
  SimpleDateFormat timeFormat;
  SimpleDateFormat dayFormat;
  SimpleDateFormat dateFormat;

  //Labels are used display information about the date & time to the user
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    //Declare the Clock constructor
    //Inside the constructor we will create the clock,
    //so it displays as soon as the constructor method is called.
    Clock() {
        //Set the clock to close when the user clicks on the X in the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set the title of the clock - you can customize this!
        this.setTitle("Digital Clock");

        //Set the Layout for the frame where the clock is displays.
        this.setLayout(new FlowLayout());

        //Set the size of the clock
        this.setSize(350, 220);

        //Make it a fixed width - so that user
        this.setResizable(false);

        //Initialize the time, day, and date formats
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd MMMMM, YYYY");

        //Create a new label to how the time and set the font and colors
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);

        //Create a labels to hold the day and date and set their fonts
        dayLabel=new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.BOLD,34));

        dateLabel=new JLabel();
        dateLabel.setFont(new Font("Ink Free", Font.BOLD, 30));

        //Add the labels to the clock
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);

        //Most important step ! Set the JFrame to visible
        //so ve can see the clock
        this.setVisible(true);

        //Start the clock so the time is updated
        startClock();

    }

    public void startClock() {

        //This is an infinite loop! we van the time to keep
        //updating constantly.
        while (true) {
            //Update the time label with the current time.
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time) ;

            //Update the day label with the current day.
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            //Update the date label with the current date.
            date = dateFormat.format (Calendar.getInstance().getTime());
            dateLabel.setText(date) ;

            //Puts the application to sleep for a short bit (1000 milliseconds)
            //before updating the clock again
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.getStackTrace();
            }//end try

            }//end startClock
        }//end clock

    public static void main(String[] args) {
        //Make a new clock
        new Clock();
    }//end main
    }


