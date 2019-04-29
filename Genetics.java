import java.util.Arrays;

public class Genetics
{
    public String[][] calculateMonohybrid(String parent1, String parent2)
    {
        String[][] result = new String[2][2];
        //Split the parents into individual characters
        String p1_1 = parent1.substring(0,1);
        String p1_2 = parent1.substring(1);
        String p2_1 = parent2.substring(0, 1);
        String p2_2 = parent2.substring(1);
        //Combine each
        String combination1 = p1_1 + p2_1;
        String combination2 = p1_1 + p2_2;
        String combination3 = p2_1 + p1_2;
        String combination4 = p2_2 + p1_2;
        //Add each combination to the results array
        result[0][0] = combination1;
        result[1][0] = combination2;
        result[0][1] = combination3;
        result[1][1] = combination4;

        //return output
        return result;

    }


    public static void main(String [] args)
    {
        Genetics genetics = new Genetics();
        String [][] monoTest = genetics.calculateMonohybrid("Aa", "AA");
        System.out.println(Arrays.deepToString(monoTest));

    }
}