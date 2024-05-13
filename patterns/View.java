package patterns;

public class View {
    //get console size details
    ConsoleSize consoleSize = new ConsoleSize();
    private int consoleHeight = consoleSize.getHeight();
    private int consoleWidth = consoleSize.getWidth();

    private int rowCount;
    private int colsCount;
    private String bgColor;
    private int alignContent;
    private int viewHeight;
    private int viewWidth;

    public View(String... attributes){

        alignContent = 0;
        rowCount = 1;
        colsCount = 1;

        for (String attr : attributes) {
            if (attr != null) {
                if(attr.toLowerCase().matches("attop")){
                    alignContent = 0;
                }
                else if(attr.toLowerCase().matches("atcenter")){
                    alignContent = 1;
                }
                else if(attr.toLowerCase().matches("atbottom")){
                    alignContent = 2;
                }
                else if(attr.toLowerCase().startsWith("cols-")){
                    String colsCountInChar = attr.substring(5);
                    colsCount = Integer.parseInt(colsCountInChar);
                }
                else if(attr.toLowerCase().startsWith("rows-")){
                    String rowCountInChar = attr.substring(5);
                    rowCount = Integer.parseInt(rowCountInChar);
                }
                else if(attr.toLowerCase().startsWith("#")){
                    bgColor = attr;
                }
            }
        }

        //viewHeight should be total height divided by rows
        viewHeight = rowCount;

        //viewWidth should be total height divided by rows
        viewWidth = colsCount;
    
    }

    public int getViewHeight(){
        return viewHeight;
    }

    public int getViewWidth(){
        return viewWidth;
    }

    public String getAlign(){
        if(alignContent == 0){
            return "top aligned";
        }
        else if(alignContent == 1){
            return "center aligned";
        }
        else if(alignContent == 2){
            return "bottom aligned";
        }

        return "default is top align";
    }

    public String getBgColor(){
        return bgColor;
    }

    public String renderView(String... texts){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    
        StringBuilder viewBuilder = new StringBuilder();

        // Set background color (if provided)
        if (bgColor != null && !bgColor.isEmpty()) {
            bgColor = hexToRgb(bgColor);
        }

        // Add empty lines to align vertically
        int verticalPadding = calculateVerticalPadding(texts.length);

        for(int i=0; i<verticalPadding; i++){
            viewBuilder.append(bgColor).append(" ".repeat(consoleWidth)).append("\n");
        }

        for (String text : texts) {
            viewBuilder.append(bgColor).append(text);
        }

        // Add empty lines to complete vertical alignment
        int leftoverPadding = viewHeight - verticalPadding - texts.length;
        
        for(int i=0; i<leftoverPadding; i++){
            viewBuilder.append(bgColor).append(" ".repeat(consoleWidth)).append("\n");
        }

        viewBuilder.append("\u001B[0m");

        return viewBuilder.toString();
    }

    private int calculateVerticalPadding(int numberOfLines){

        if(alignContent == 1){
            int leftovers = viewHeight - numberOfLines;
            return leftovers/2;
        }
        else if(alignContent == 2){
            int leftovers = viewHeight - numberOfLines;
            return leftovers;
        }

        return 0;
    }

    private static String hexToRgb(String hexCode) {
        if (hexCode.startsWith("#")) {
            hexCode = hexCode.substring(1);
        }
        int r = Integer.parseInt(hexCode.substring(0, 2), 16);
        int g = Integer.parseInt(hexCode.substring(2, 4), 16);
        int b = Integer.parseInt(hexCode.substring(4, 6), 16);
        
        String colorString = ("\u001B[" + "48;2;" + r + ";" + g + ";" + b + "m");

        return colorString;
    }
    
}
