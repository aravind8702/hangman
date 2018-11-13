import java.io.*;
class highscore_reset
{

    public static void main() throws FileNotFoundException
    {
        PrintWriter pw = new PrintWriter(new File("board.csv"));
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
}
