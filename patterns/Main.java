package patterns;

public class Main {

    public static void main(String args[]){
        
        Text styledText = new Text("#ff0000", "bold");
        System.out.println(styledText.RenderText("Red Bold Text"));

        Text newStyledText = new Text("#00ff00", "light", "italic");
        System.out.println(newStyledText.RenderText("Green Italic Text - Dimmed"));

    }
    
}
