import java.util.*;
import java.io.*;
class hangman_28_10
{
    Scanner sc = new Scanner(System.in);
    int choice ;
    String[] arr;
    int a;
    int b;
    int an;
    String word;
    int c;
    int guess_len;
    String guess;
    int hang;
    int score;
    int highscore;
    private static Scanner x;//scanner step 1
    void input()//accept all inputs
    {
        choice = sc.nextInt();//choice of category
    }

    void arrays()//to define arrays and obtain the word from them
    {
        if (choice == 1)
            arr = new String[]{"idlis", "dosas", "vadas", "rices"};
        if (choice == 2)
            arr = new String[]{"maths", "science", "language", "social"};
        a = arr.length - 1;//to find limit of the array for use in random number generator
        b = 0;//lower limit
        an = (int) (Math.random()*(a-b) + b);//random number within limit of 
        word = arr[an];//word at random position
        //System.out.println(word);
        //System.out.println(an);
    }

    void len_str()//to find length of word excluding repititions
    {
        String mod = word + " ";//modifiable string
        c = 0;//counter
        for (int i = 0; i< mod.length() - 1; i++)
        {
            char ch1 = mod.charAt(i);
            for (int j = i +1;j< mod.length() - 1; j++)
            {
                char ch2 = mod.charAt(j);
                if (ch1 == ch2 && ch1 != '*')
                {    
                    c++;
                }
            }
            //System.out.println(ch1);
            //System.out.println(c);
            mod = mod.replace(ch1, '*');
            //c = 0;
        }
        guess_len = word.length() - c;//eliminating repeated letters from length
        System.out.println(guess_len);
        System.out.println(c);
    }

    void guess()
    {
        String mod3 = word + " ";//for guess
        String mod2 = word + " ";//for guess_len
        guess = "";
        hang = 0;
        for (int i = 0; i<=word.length() - 1; i++)
            guess += "_";
        System.out.println(guess);//prints number of dashes
        while (guess_len != 0)
        {   char ch = sc.next().charAt(0);//to accept user input of letter
            int detect = mod2.indexOf(ch);//to check if the character is there in the sting
            if (detect == -1)
            {
                hang ++;
            }
            if (hang == 7)//man hangs at 7 tries
            {
                System.out.println("GAME OVER");
                return;
            }
            if (detect != -1)
            {
                //System.out.println("yaay!");
                for (int j = 0; j<mod3.length()-1; j++)
                {
                    char ch3 = mod3.charAt(j);
                    if (ch3 == ch)
                    {
                        char arr[] = guess.toCharArray();//string to array
                        arr[j] = ch;
                        guess = "";
                        for (int i = 0;i<arr.length;i++)
                        {
                            char ch4 = arr[i];
                            guess = guess+ch4;
                        }
                        //guess = guess.replace(guess.charAt(j),ch);
                        //clear screen
                        //System.out.println(guess);
                    }
                }
                System.out.println(guess);
                guess_len--;
                mod2 = mod2.replace(ch, '*');

            }
        }
        if (guess_len == 0)
            System.out.println("yaay!");
    }

    void score()
    {
        score = ((7 - hang)+1);
        System.out.println("You scored1: " + score);
    }
   
    void highscore()throws FileNotFoundException
    {
        //printing highscore
        if(score > highscore)
            highscore = score;
        PrintWriter pw = new PrintWriter(new File("board.csv"));//trace filepath
        StringBuilder sb = new StringBuilder();
        sb.append(highscore);
        pw.write(sb.toString());//writes into the csv file
        pw.close();
        System.out.println("You scored: " + score);
        
        //reading csv file
        
        String filepath = "board.csv";
        String id = "";
        boolean found = false;
        try
        {
            x = new Scanner(new File(filepath));//scanner step 2 (new declared only here);
            x.useDelimiter("[,\n]");

            while(x.hasNext() )
            {
                id = x.next();
                found = true;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
        if (found == true)
        {     
            int id1 = Integer.parseInt(id);
            System.out.println("highscore = " + id1);
        }
        else 
            System.out.println("Record not found");
    }
    
    void restart()throws FileNotFoundException
    {
        System.out.println("Restart or quit? r/q");
        char re = sc.next().charAt(0);
        if (re == 'r')
            main();
        else if (re == 'q')
            System.exit(0);
    }

    void main()throws FileNotFoundException
    {
        input();
        arrays();
        len_str();
        guess();
        score();
        highscore();
        restart();
    }
}
