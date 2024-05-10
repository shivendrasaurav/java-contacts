package patterns;

public class Text {

    private String textColor;
    private boolean textBold;
    private boolean textItalic;
    private boolean textUnderline;
    private boolean textLight;

    
    public Text(String... attributes) {
        for (String attr : attributes) {
            if (attr != null) {
                switch (attr.toLowerCase()) {
                    case "bold":
                        textBold = true;
                        break;
                    case "italic":
                        textItalic = true;
                        break;
                    case "underline":
                        textUnderline = true;
                        break;
                    case "light":
                        textLight = true;
                        break;
                    default:
                        // Assume it's a color (hex code)
                        textColor = attr;
                        break;
                }
            }
        }
    }

    public String RenderText(String contentString) {
        StringBuilder escapeCode = new StringBuilder("\u001B[");

        // Add style attributes
        if (textBold) {
            escapeCode.append("1;");
        }
        if (textItalic) {
            escapeCode.append("3;");
        }
        if (textUnderline) {
            escapeCode.append("4;");
        }
        if (textLight) {
            escapeCode.append("2;");
        }

        // Set foreground color (if provided)
        if (textColor != null && !textColor.isEmpty()) {
            int[] rgb = hexToRgb(textColor);
            escapeCode.append("38;2;").append(rgb[0]).append(";").append(rgb[1]).append(";").append(rgb[2]).append(";");
        }

        // Remove trailing semicolon and add "m" for mode
        escapeCode.deleteCharAt(escapeCode.length() - 1);
        escapeCode.append("m");

        // Construct the styled text
        String styledText = escapeCode + contentString + "\u001B[0m"; // Reset all styles

        return styledText;
    }

    private static int[] hexToRgb(String hexCode) {
        if (hexCode.startsWith("#")) {
            hexCode = hexCode.substring(1);
        }
        int r = Integer.parseInt(hexCode.substring(0, 2), 16);
        int g = Integer.parseInt(hexCode.substring(2, 4), 16);
        int b = Integer.parseInt(hexCode.substring(4, 6), 16);
        return new int[]{r, g, b};
    }

}
