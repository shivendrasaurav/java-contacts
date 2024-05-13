package patterns;

class Main {

    public static void main(String args[]){
        
        Text titleText = new Text("#000000", "bold");
        Text menuText = new Text("#dadada", "light");

        View headerView = new View("atCenter", "#daccfa", "rows-4");
        View menuView = new View("atCenter", "#1e1e1e", "rows-22");
        View footerView = new View("atCenter", "#daccfa", "rows-4");
        
        System.out.println(
            headerView.renderView(
                titleText.RenderText("Contacts", "center"),
                menuText.RenderText("your own contacts app, now in a terminal", "center")
            ) + menuView.renderView(
                menuText.RenderText("List All Contacts [lc]", "center"),
                menuText.RenderText("Add New Contact [ac]", "center"),
                menuText.RenderText("Find A Contact [fc]", "center"),
                menuText.RenderText(" ", "center"),
                menuText.RenderText(" ", "center"),
                menuText.RenderText(" ", "center"),
                menuText.RenderText("Exit App [altf4]", "center")
            ) + footerView.renderView(
                titleText.RenderText("Navigation: ", "left"),
                menuText.RenderText("Press chars in square brackets + enter to navigate. For example press lc and enter to open list all contacts view", "left")
            )
        );

        
    }

}