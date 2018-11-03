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
    int score1;//void repeat
    //int highscore;
    private static Scanner x;//scanner step 1
    //game module$$$$$
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
        //ascii man
        System.out.println("\f");
        System.out.println("\t    _________");
        System.out.println("\t    |/ ");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t____|____\t\t\t  " + guess);// guess prints no of dashes
        //ascii man ends
        while (guess_len != 0)
        {   
            char ch = '1';
            while(Character.isLetter(ch) == false)
            {    
                System.out.println("please enter a letter: ");
                ch = sc.next().charAt(0);//to accept user input of letter
            }
            int detect = mod2.indexOf(ch);//to check if the character is there in the sting
            if (detect == -1)
            {
                hang ++;
            }

            else if (detect != -1)
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

                guess_len--;
                mod2 = mod2.replace(ch, '*');
            }
            System.out.println("\f");
            if(hang == 0)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t  " + guess);

            } 
            if(hang == 1)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t  " + guess);

            }
            if(hang == 2)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |      (_)");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t  " + guess);

            } 
            if(hang == 3)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |      (_)");
                System.out.println("\t    |       |");
                System.out.println("\t    |       |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t  " + guess);

            }   
            if(hang == 4)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     \\(_)");
                System.out.println("\t    |      \\|");
                System.out.println("\t    |       |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t  " + guess);

            } 
            if(hang == 5)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     \\(_)/");
                System.out.println("\t    |      \\|/");
                System.out.println("\t    |       |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t  " + guess);

            } 
            if(hang == 6)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     \\(_)/");
                System.out.println("\t    |      \\|/");
                System.out.println("\t    |       |");
                System.out.println("\t    |      /");
                System.out.println("\t    |     /");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t  " + guess);

            } 
            if (hang == 7)//man hangs at 7 tries
            {
                System.out.println("GAME OVER\n\n");
                // ascii man
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     \\(_)/");
                System.out.println("\t    |      \\|/\t\t your word was: " + word);
                System.out.println("\t    |       |");
                System.out.println("\t    |      / \\");
                System.out.println("\t    |     /   \\");
                System.out.println("\t    |");
                System.out.println("\t____|____");
                return;
            }
            //ascii man ends  

            //onscreen elements
            System.out.println("\t\t\t\tguesses left: " + (7-hang));
            System.out.println("\t\t\t\tscore: " + score1);
        }
        if (guess_len == 0)
            System.out.println("yaay!");
    }
    // scoring module$$$$$
    void score()
    {
        score = ((7 - hang));
        System.out.println("\n\ngame score: " + score);
    }

    void repeat()throws FileNotFoundException
    {
        int n = arr.length;
        for(score1 = score; hang != 7; score1 += score, n--)
        {
            System.out.println("score: " + score1);
            System.out.println("continue? (y = 1/n = 0): ");
            int cont = sc.nextInt();
            if (cont == 0)
                System.exit(0);
            //input();
            for (int i = an+1; i<n; i++)
            {
                arr[i-1] = arr[i];
            }
            System.out.println("Array elements: ");
            for(int i = 0; i<n; i++)
            {
                System.out.println(arr[i]);
            }
            a = n - 1;//to find limit of the array for use in random number generator
            b = 0;//lower limit
            an = (int) (Math.random()*(a-b) + b);//random number within limit of 
            word = arr[an];//word at random position
            //arrays();
            if(n == 1)
            {
                System.out.println("limit reached!!!");
                return;
            }
            len_str();
            guess();
            score();
        }
    }

    void highscore()throws FileNotFoundException
    {

        //reading csv file
        int highscore;
        String filepath = "board.csv";
        String high_str = "";
        boolean found = false;
        try
        {
            x = new Scanner(new File(filepath));//scanner step 2 (new declared only here);
            x.useDelimiter("[,\n]");

            while(x.hasNext() )
            {
                high_str = x.next();
                found = true;
            }
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
        if (found == true)
        {     
            highscore = Integer.parseInt(high_str);
            //System.out.println("highscore = " + highscore);
        }
        else 
        {    
            System.out.println("Record not found");
            highscore = 0;
        }

        //printing highscore
        if(score1 > highscore)
            highscore = score1;
        PrintWriter pw = new PrintWriter(new File("board.csv"));//trace filepath
        StringBuilder sb = new StringBuilder();
        sb.append(highscore);
        pw.write(sb.toString());//writes into the csv file
        pw.close();
        System.out.println("Highscore: " + highscore);

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

    static void main()throws FileNotFoundException
    {
        hangman_28_10 obj = new hangman_28_10();
        obj.input();
        obj.arrays();
        obj.len_str();
        obj.guess();
        obj.score();
        obj.repeat();
        obj.highscore();
        obj.restart();
    }
}
/*notes:  the standard font size must be 17 for proper alignment*/
