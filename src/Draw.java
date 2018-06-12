import java.util.Scanner;

public class Draw
{
    private Scanner scanner = new Scanner(System.in);

    public String drawPrompt( String prompt)
    {
        System.out.print(prompt);
        String string = this.scanner.next();
        return string;
    }

    public void drawText( String text)
    {
        System.out.print(text);

    }


}
