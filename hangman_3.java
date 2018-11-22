import java.util.*;
import java.io.*;
class hangman_3
{
    Scanner sc = new Scanner(System.in);
    int n_choice ;
    String[] arr;
    int a;//for random number generation
    int b;//for random number generation
    int an;//for random number generation
    String word;
    int guess_len;
    String guess;
    int hang;
    int score;
    int score1;//void repeat
    String category;
    private static Scanner x;//scanner step 1
    //game module$$$$$
    void main_menu()throws FileNotFoundException
    {
        //header
        System.out.println("\f\t\t\t88");                                                                            
        System.out.println("\t\t\t88                                                                                        ");                                                                             
        System.out.println("\t\t\t88                                                                                        ");                                                                             
        System.out.println("\t\t\t88,dPPYba,  ,adPPYYba, 8b,dPPYba,   ,adPPYb,d8 88,dPYba,,adPYba,  ,adPPYYba, 8b,dPPYba,   ");   
        System.out.println("\t\t\t88P'    '8a ''     `Y8 88P'   `'8a a8'    `Y88 88P'   '88'    '8a ''     `Y8 88P'   `'8a  ");  
        System.out.println("\t\t\t88       88 ,adPPPPP88 88       88 8b       88 88      88      88 ,adPPPPP88 88       88  ");  
        System.out.println("\t\t\t88       88 88,    ,88 88       88 '8a,   ,d88 88      88      88 88,    ,88 88       88  "); 
        System.out.println("\t\t\t88       88 `'8bbdP'Y8 88       88  `'YbbdP'Y8 88      88      88 `'8bbdP'Y8 88       88  ");  
        System.out.println("\t\t\t                                    aa,    ,88                                            ");
        System.out.println("\t\t\t                                     'Y8bbdP'                                             ");    
        System.out.println("\t\t\t                                                                                          ");
        System.out.println("                                                                                          ");
        System.out.println("                                                                                          ");   
        System.out.println("                                                                                          ");
        System.out.println("                                                                                          ");  
        //end of header
        System.out.println("\n\n");
        highscore();//highscore display in the main menu
        
        //presenting options in the first menu
        System.out.println("\n\t\t\t\t\t\t\tPLAY (p) > ");
        System.out.println("\n\t\t\t\t\t\t\tQUIT (q) > ");
        System.out.println("\n\t\t\t\t\t\t\tABOUT (a) > ");
        System.out.println("\n\t\t\t\t\t\t\tHOW TO PLAY(h) >");
        char menu = sc.next().charAt(0);// to accept user choice for switch case
        menu = Character.toLowerCase(menu);
        //if the choice is play, give sub menu to 
        switch(menu)
        {
            case 'p':// the user has chosen to play
            System.out.println("\f\tCHOOSE a category:- ");
            //enter category names
            System.out.println("\n\tOption 1: Food and fruits");
            System.out.println("\n\tOption 2: Subjects and fields of study");
            System.out.println("\n\tOption 3: Sports");
            System.out.println("\n\tOption 4: Movies");
            System.out.println("\n\tOption 5: Shows"); 
            System.out.println("\n\tOption 6: Animals");
            String submenu[] = {"Food and fruits", "Subjects and fields of study", "Sports", "Movies", "Shows", "Animals"};
            System.out.println("\n\tEnter your CHOICE (1-6) :- ");
            
            char choice = sc.next().charAt(0);//choice of category
            n_choice = (int)choice - 48;
            boolean flag1 = false;
            while (flag1 == false)
            {
                if(n_choice>=1 && n_choice<=6)
                    flag1 = true;
                else
                {
                    System.out.println ("\n\tEnter numbers only from 1 to 6!!!");
                    choice = sc.next().charAt(0);//choice of category
                    n_choice = (int)choice - 48;
                }
            }
            category = submenu[n_choice - 1];

            break;
            case 'q':// quit game
            System.exit(0);
            break;
            case 'a'://about

            System.out.println("\fThis game is created by Aravind Krishnan A and Advik Giridhar as a part of our 10th grade Board Project.");
            System.out.println("Hangman is a game in which one player tries to guess the letters of a word in seven chances.");
            System.out.println("We record the failed attempts by the player by drawing a gallow and a man hanging on it,line by line (mistake by mistake)");
            System.out.println("\n***********************************************ACKNOWLEDGEMENTS***********************************************\n\nWe extend a special thanks to our computer teacher Mrs.Padma and the ICSE Board for this wonderful opportunity");
            System.out.println("We are also grateful to our parents for their undying support throughout the course of this project");
            System.out.println("\nFun for all ages... we hope you enjoy this classic game ;) ... GOOD LUCK");
            System.out.println("\n< TO GO BACK (b)");
            char back1 = sc.next().charAt(0);//to go back to main menu
            back1 = Character.toLowerCase(back1);
            boolean flag2 = false;
            //handling invalid inputs
            while(flag2 == false)
            {
                if(back1 == 'b')
                {
                    flag2 = true;
                    main_menu();
                }
                else
                {
                    System.out.println("INVALID Input (press b to go back)");
                    back1 = sc.next().charAt(0);
                    back1 = Character.toLowerCase(back1);
                }
            }
            break;

            case 'h'://how to play

            System.out.println("\f\t>press p to start the game");
            System.out.println("\t>choose a category");
            System.out.println("\t>your word consists of the same number of letters as dashes on the screen");
            System.out.println("\t>with every wrong guess a part of the man's body is added to the gallow");
            System.out.println("\t>you gain points based on the number of wrong guesses you made in the process of guessing");
            System.out.println("\t>if you lose all seven of your lives in a round... you lose and you may not proceed adding to your previous game score");
            System.out.println("\n\n\n\n<back (b)");
            char back2 = sc.next().charAt(0);
            back2 = Character.toLowerCase(back2);//to go back to main menu
            boolean flag3 = false;
            //handling invalid inputs
            while(flag3 == false)
            {
                if(back2 == 'b')
                {
                    flag3 = true;
                    main_menu();
                }
                else
                {
                    System.out.println("INVALID Input (press b to go back to home page)");
                    back2 = sc.next().charAt(0);
                    back2 = Character.toLowerCase(back2);
                }
            }
            break;

            default ://handling invalid inputs
            main_menu();
            break;
        }
    }

    void arrays()//to define arrays and obtain the word from them
    {
        if (n_choice == 1)
            arr = new String[]{"idli", "aloo paratha", "cereal", "pancake", "dosa", "omelette","baked beans", "pomegranate", "avocado", "passion fruit", "cranberry", "apricot", "cantaloupe", "nectarine","apple", "banana", "bread", "sandwich", "burger", "pizza", "bagel", "baguette", "guava", "pomagranate", "cake", "pastry", "ice cream", "pasta", "noodles", "spaghetti", "ketchup", "mayonnaise","dumplings", "fried rice", "apple pie", "salad", "tomato soup","orange", "grape", "dates", "grapefruit" };
        if (n_choice == 2)
            arr = new String[]{"mathematics", "computer science", "physics", "history", "geography", "chemistry", "biology", "literature", "sociology","economics", "software engineering", "law", "medicine", "nursing", "agricultural", "archaeology","political science", "biotechnology", "industrial design", "animal science", "mechanical engineering", "sound engineering", "philosophy", "journalism", "linguistics", "arts", "astronomy", "statistics", };
        if (n_choice == 3)
            arr = new String[]{"badminton", "tennis", "volleyball", "hockey", "archery", "wrestling", "golf", "surfing","kayaking", "canoeing", "rafting", "diving", "rowing", "synchronised swimming", "boxing", "gymnastics", "cycling", "discus throw", "fencing", "judo", "karate", "kickboxing", "long jump", "high jump", "pole vault", "sprint", "walking", "weightlifting", "cricket", "dodgeball", "football", "golf", "handball", "ice hockey", "lacrosse", "polo", "rugby", "squash", "skydiving", "paragliding", "parachuting", "snowboarding", "formula racing", "chess"};
        if (n_choice == 4)
            arr = new String[]{"the avengers", "john wick", "the social network", "titanic", "the wolf of wall street", "mission impossible", "ratatouille", "the shawshank redemption", "forrest gump", "schindler's list", "the godfather", "the green mile", "hotel rwanda", "the bucket list", "the terminal", "catch me if you can", "saving private ryan", "cast away", "blood diamond", "gandhi", "titanic", "the pursuit of happyness", "little miss sunshine", "gladiator", "the matrix", "king kong", "troy", "toy story", "shrek", "iron man", "the prestige", "django unchained", "avatar", "harry potter", "star wars", "the lord of the rings", "the amazing spiderman", "johnny english", "mr beans holiday", "terminator", "justice league", "transporter", "rambo", "rocky", "escape plan", "the incredibles", "jurassic park", "now you see me", "the da vinci code", "angels and demons", "inferno", "jaws", "the dark knight", "man of steel", "jumanji", "pirates of the carribean", "rainman", "ice age", "the conjuring", "cars","despicable me"};
        if (n_choice == 5)
            arr = new String[]{"riverdale", "friends", "bojack horesemen", "orange is the new black", "the flash", "gotham", "black mirror","game of thrones", "the walking dead", "legends of tomorrow", "dexter", "breaking bad", "arrow", "the big bang theory", "brooklyn nine nine", "two and a half men", "breathe", "how i met your mother", "suits", "the simpsons", "family guy", "south park", "the vampire diaries", "the x files", "curb your enthusiasm", "rick and morty", "sherlock", "supernatural", "modern family", "prison break", "the office", "house of cards", "star trek", "survivor", "ncis", "hannibal", "glee", "grimm", "pretty little liars", "gossip girl", "saturday night live", "top gear", "mr bean", "whose line is it anyway", "impractical jokers", "scooby doo",  };
        if (n_choice == 6)
            arr = new String[]{"racoon", "hedgehog", "armadillo", "hyena", "aardvark", "albatross", "alligator", "alpaca", "anteater", "badger", "baboon", "bear", "beaver", "bat", "bison", "boar", "buffalo","bison", "camel", "cat", "caterpillar", "cow", "chameleon", "cheetah", "chicken", "chimpanzee", "crab", "crocodile", "crane", "deer", "dog", "dogfish", "dolphin", "donkey", "dove", "duck", "eagle", "echinda", "eel", "elephant", "ferret", "falcon", "fox", "frog", "gazelle", "gerbil", "giraffe", "goat", "gorilla", "guinea pig", "hamster", "hawk", "horse", "hyena", "impala", "jaguar", "jellyfish", "kangaroo", "komodo dragon", "koala", "lemur", "leopard", "lion", "llama", "lobster", "mallard", "mammoth", "mandrill", "mongoose", "monkey", "mole", "moose", "mouse", "octopus", "ostrich", "otter", "oyster", "panther", "pigeon", "polar bear", "porpoise", "porcupine", "rabbit", "raccoon", "reindeer", "rhinoceros", "salamander", "salmon", "sea lion", "sheep", "skunk", "sloth", "snail", "shark", "spider", "squid", "squirrel", "turtle", "wallaby", "walrus", "whale", "wombat", "zebra" };
        a = arr.length - 1;//to find limit of the array for use in random number generator
        b = 0;//lower limit
        an = (int) (Math.random()*(a-b) + b);//random number within limit of 
        word = arr[an];//word at random position
    }

    void len_str()//to find length of word excluding repititions
    {
        // '*' is a character used to to replace the checked letters in string mod
        String mod1 = word + " ";//modifiable string
        int c1 = 0;//counter
        int c2 = 0;//counter
        for (int i = 0; i< mod1.length() - 1; i++)
        {
            char ch1 = mod1.charAt(i);
            for (int j = i +1;j< mod1.length() - 1; j++)
            {
                char ch2 = mod1.charAt(j);
                // checking if the character is repeated except if it is a replacement character(*) 
                if (ch1 == ch2 && ch1 != '*')
                {    
                    c1++;
                }
            }
            if (ch1 == ' ')//excluding spaces in word length calculations
            {
                c2++;
            }
            mod1 = mod1.replace(ch1, '*');
        }
        guess_len = word.length() - c1 - c2;//eliminating repeated letters and whitespaces from length
        
        // following statements only for debugging purposes in case of errors (not displayed anywhere because screen is frequently refreshed)
        System.out.println(guess_len);
        System.out.println(c1);
        System.out.println(c2);
    }

    void guess()
    {
        String mod3 = word + " ";//for guess
        String mod2 = word + " ";//for guess_len
        guess = "";
        hang = 0;
        for (int i = 0; i<=word.length() - 1; i++)
        {    
            if(word.charAt(i) == ' ')
                guess += " ";
            else
                guess += "_";
        }
        //ascii man first display
        System.out.println("\f");
        System.out.println("\n\t\t\t\t\t\t\tCATEGORY: " + category);
        System.out.println("\t    _________");
        System.out.println("\t    |/ ");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t    |");
        System.out.println("\t____|____\t\t\t\t\t  " + guess);// guess prints no of dashes
        //ascii man ends
        int counter = 0;
        char used_letters[] = new char[27];
        while (guess_len != 0)// until word is guesssed
        {   
            char ch = '1';
            counter++;
            while(Character.isLetter(ch) == false)//always enter the loop atleast once
            {    
                System.out.println("\n\t\t\t\t\t\t\tPLEASE enter a letter: ");
                String ch_str = sc.nextLine();
                ch_str = ch_str.toLowerCase();
                for(int  j = 0; ch_str.length() != 1; j++)//to prevent entry of more than one letter at a time
                {
                    if (j != 0)//so that it does not display message without entry of a letter(s)
                        System.out.println("\n\t\t\t\t\t\t\tPLEASE enter only ONE LETTER AT A TIME!!");
                    ch_str = sc.nextLine();//accepts as string tyre for handling invalid inputs
                    ch_str = ch_str.toLowerCase();
                }
                ch = ch_str.charAt(0);//to accept user input of letter
            }

            for(int i = 0; i<counter; i++)//to check for used letters
            {
                if(used_letters[i] ==ch)
                {
                    System.out.println("\n\t\t\t\t\t\t\tPLEASE DO NOT enter the SAME LETTER... TRY Again: ");
                    i = 0;//to reset the index of array to 0
                    String ch_str = sc.nextLine();
                    for(int j = 0; ch_str.length() != 1; j++)
                    {
                        if (j != 0)
                            System.out.println("\n\t\t\t\t\t\t\tPLEASE enter only ONE LETTER AT A TIME!!");
                        ch_str = sc.nextLine();
                        ch_str = ch_str.toLowerCase();
                    }
                    ch = ch_str.charAt(0);
                }
                else// if letter is not repeated, add letter to used_letters[]
                {
                    used_letters[counter] = ch;
                    //System.out.println(used_letters[counter]);
                }

            }
            int detect = mod2.indexOf(ch);//to check if the character is there in the string
            if (detect == -1)//if the character is not present
            {
                hang ++;
            }

            else if (detect != -1)
            {
                //System.out.println("yaay!");
                for (int j = 0; j<mod3.length()-1; j++)
                {
                    char ch3 = mod3.charAt(j);
                    if (ch3 == ch) // to check which position the letter ch is at
                    {
                        char arr[] = guess.toCharArray();//string to array(with dashes)
                        arr[j] = ch;
                        guess = "";// resetting guess
                        for (int i = 0;i<arr.length;i++)
                        {
                            char ch4 = arr[i];
                            guess = guess+ch4;//restoring guess with modificaations
                        }
                    }

                }

                guess_len--;
                mod2 = mod2.replace(ch, '*');
            }
            //ascii man module
            System.out.println("\f");
            System.out.println("\n\t\t\t\t\t\t\tCATEGORY: " + category);
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
                System.out.println("\t____|____\t\t\t\t\t  " + guess);

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
                System.out.println("\t____|____\t\t\t\t\t  " + guess);

            }
            if(hang == 2)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     (o o)");
                System.out.println("\t    |"); 
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t\t\t  " + guess);

            } 
            if(hang == 3)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     (o o)");
                System.out.println("\t    |       |");
                System.out.println("\t    |       |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t\t\t  " + guess);

            }   
            if(hang == 4)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     (o o)");
                System.out.println("\t    |     \\ |");
                System.out.println("\t    |      \\|");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t\t\t  " + guess);

            } 
            if(hang == 5)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     (o o)");
                System.out.println("\t    |     \\ | /");
                System.out.println("\t    |      \\|/");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t\t\t  " + guess);

            } 
            if(hang == 6)
            {
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     (o o)");
                System.out.println("\t    |     \\ | /");
                System.out.println("\t    |      \\|/");
                System.out.println("\t    |      /");
                System.out.println("\t    |     /");
                System.out.println("\t    |");
                System.out.println("\t____|____\t\t\t\t\t  " + guess);

            } 
            if (hang == 7)//man hangs at 7 tries
            {
                System.out.println("\n\t\t\t .88888.                                   .88888.                            ");
                System.out.println("\t\t\td8'   `88                                 d8'   `8b                           ");
                System.out.println("\t\t\t88        .d8888b. 88d8b.d8b. .d8888b.    88     88 dP      Pd .d8888b. 88d889");
                System.out.println("\t\t\t88   YP88 88'  `88 88'`88'`88 88ooood8    88     88  88    d8' 88ooood8 88'  ");
                System.out.println("\t\t\tY8.   .88 88.  .88 88  88  88 88.  ...    Y8.   .8P   88  88'  88.  ... 88     "); 
                System.out.println("\t\t\t `88888'  `88888P  88  88  88 `88888P'     `8888P'     888P'   `88888P' dP      ");
                // ascii man
                System.out.println("\t    _________");
                System.out.println("\t    |/      |");
                System.out.println("\t    |     (o o)");
                System.out.println("\t    |     \\ | /\t\t\t\t\tYOUR WORD WAS: " + word);
                System.out.println("\t    |      \\|/");
                System.out.println("\t    |      / \\");
                System.out.println("\t    |     /   \\");
                System.out.println("\t    |");
                System.out.println("\t____|____");
                System.out.println("\n\t\t\t\t\t\t\tSCORE: " + score1);
                return;
            }
            //ascii man ends  

            //onscreen elements
            System.out.println("\n\t\t\t\t\t\t\tGuesses LEFT: " + (7-hang));
            System.out.println("\n\t\t\t\t\t\t\tSCORE: " + score1);
        }
        if (guess_len == 0)
            System.out.println("\n\t\t\t\t\t\t\tWOOOHOOO!");
    }
    // scoring module$$$$$
    void score()
    {
        score = ((7 - hang));
        System.out.println("\n\t\t\t\t\t\t\tGAME SCORE: " + score);
    }

    void repeat()throws FileNotFoundException
    {
        int n = arr.length;//to generate random number again
        for(score1 = score; hang != 7; score1 += score, n--)//all guesses after the first word
        {
            System.out.println("\n\t\t\t\t\t\t\tSCORE: " + score1);
            System.out.println("\n\t\t\t\t\t\t\tWould you like to CONTINUE? (y/n): ");
            char cont = sc.next().charAt(0);
            cont = Character.toLowerCase(cont);
            //for handling invalid inputs
            boolean flag = false;
            while (flag == false)
            {    
                if(cont == 'y' || cont == 'n')
                {
                    flag = true;
                    if (cont == 'n')
                    {
                        highscore(); 
                        main();
                    }
                }
                else
                {
                    System.out.println("\n\t\t\t\t\t\t\tENTER ONLY y OR n!");
                    cont = sc.next().charAt(0);
                    cont = Character.toLowerCase(cont);
                }
            }

            for (int i = an+1; i<n; i++)//to remove used word from the array to ensure there is no repitition
            {
                arr[i-1] = arr[i];
            }
            // only for debugging purposes
            System.out.println("ARRAY elements: ");
            for(int i = 0; i<n; i++)
            {
                System.out.println(arr[i]);
            }
            a = n - 1;//to find limit of the array for use in random number generator
            b = 0;//lower limit
            an = (int) (Math.random()*(a-b) + b);//random number within limit of 
            word = arr[an];//word at random position
            if(n == 1)//when the limit of the array is reached
            {
                System.out.println("\n\t\t\t\t\t\t\tLIMIT REACHED!!!!!");
                return;
            }
            //only void arrays is not re-executed since the same array is in use
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
            System.out.println("\n\t\t\t\t\t\t\tERROR");
        }
        if (found == true)
        {     
            highscore = Integer.parseInt(high_str);
            System.out.println("\n\t\t\t\t\t\t\tHIGHSCORE: " + highscore);
        }
        else 
        {    
            System.out.println("\n\t\t\t\t\t\t\tRecord NOT found");
            highscore = 0;
        }

        //printing highscore
        if(score1 > highscore)
        {
            highscore = score1;
            PrintWriter pw = new PrintWriter(new File("board.csv"));//trace filepath
            StringBuilder sb = new StringBuilder();
            sb.append(highscore);
            pw.write(sb.toString());//writes into the csv file
            pw.close();
            System.out.println("\n\t\t\t\t\t\t\tHIGHSCORE: " + highscore);
        }
    }

    void restart()throws FileNotFoundException
    {
        System.out.println("\n\t\t\t\t\t\t\tRESTART or QUIT? r/q");
        char re = sc.next().charAt(0);
        re = Character.toLowerCase(re);
        
        // to handle invalid inputs
        boolean flag = false;
        while(flag == false)
        {
            if (re == 'r')
            {    
                main();
                flag = true;
            }
            else if (re == 'q')
            {    
                System.exit(0);
                flag = true;
            }
            else
            {
                System.out.println("ENTER ONLY r OR q!");
                //re = sc.next().charAt(0);
                re = Character.toLowerCase(sc.next().charAt(0));
            }
        }
    }

    static void main()throws FileNotFoundException
    {
        hangman_3 obj = new hangman_3();
        obj.main_menu();
        obj.arrays();
        obj.len_str();
        obj.guess();
        obj.score();
        obj.repeat();
        obj.highscore();
        obj.restart();
    }
}
/*notes:  the standard font size must be 12 for proper alignment*/