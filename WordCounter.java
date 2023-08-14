package Codesoft;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text or provide a file path: ");
        String userInput = sc.nextLine();
        String text;
        if (userInput.endsWith(".txt"))
        {
            try
            {
                File file = new File(userInput);
                Scanner fileScanner = new Scanner(file);
                text = fileScanner.useDelimiter("\\Z").next();
                fileScanner.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println("File not found.");
                return;
            }
        }
        else
        {
            text = userInput;
        }
        String[] words = text.split("[\\s\\p{Punct}]+");
        int Count = 0;
        for (String word : words)
        {
            if (!word.isEmpty())
            {
                Count++;
            }
        }
        System.out.println("Total word count: " +Count);
    }
}