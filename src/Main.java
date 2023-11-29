import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JEditorPane jep = new JEditorPane();
        jep.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(jep);
        JFrame f = new JFrame("Test HTML");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(scrollPane);
        f.setSize(200,80);
        f.setVisible(true);


        while (true) {
            try {

                jep.setContentType("text/html");
                jep.setText("<html>Loading...</html>");
                jep.setPage("https://arduinotemperatureandhumidity-default-rtdb.firebaseio.com/ShumPLUStemp.json");


            }catch (IOException e) {
                jep.setContentType("text/html");
                jep.setText("<html>Could not load</html>");
            }
            TimeUnit.SECONDS.sleep(5);
        }

    }
}