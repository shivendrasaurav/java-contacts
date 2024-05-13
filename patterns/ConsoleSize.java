package patterns;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ConsoleSize {
    
    private int height;
    private int width;

    public ConsoleSize(){        
        
        // Move the cursor to a specific position
        System.out.print("\033[999;999H");
        
        // Request terminal size report
        System.out.print("\033[6n");

        try {
            // Create an instance of Robot class
            Robot robot = new Robot();
            // Simulate pressing the Enter key
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        
        // Read the response from the terminal
        StringBuilder response = new StringBuilder();
        try {
            int character;
            while ((character = System.in.read()) != 'R') { // 'R' indicates the end of the response
                response.append((char) character);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Parse the response to get the terminal dimensions
        String[] parts = response.toString().split(";");
        int rows = Integer.parseInt(parts[0].substring(parts[0].lastIndexOf('[') + 1));
        int cols = Integer.parseInt(parts[1]);
        
        this.height = rows;
        this.width = cols;
    }

    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }

}
