import java.util.Arrays;

public class Genetics
{
    public static String[][] calculateMonohybrid(String parent1, String parent2)
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
        String combination3 = p1_2 + p2_1;
        String combination4 = p1_2 + p2_2;
        //Add each combination to the results array
        result[0][0] = combination1;
        result[1][0] = combination2;
        result[0][1] = combination3;
        result[1][1] = combination4;

        //return output
        return result;

    }
    public static String[][] calculateDihybrid(String parent1, String parent2)
    {
        String [][] result = new String[4][4];
        String[] parent1Combinations = parentCombinations(parent1);
        String[] parent2Combinations = parentCombinations(parent2);
        for(int i = 0; i<parent1Combinations.length; i++)
        {
            for(int j = 0; j<parent2Combinations.length; j++)
            {
                String p1 = parent1Combinations[i];
                String p2 = parent2Combinations[j];
                String combo = p1 + p2;
                String reformattedCombo = reformatCombo(combo);
                result[j][i] = reformattedCombo;
            }
        }
        return result;
    }

    public static String[] parentCombinations(String parent)
    {
        String [] result = new String[4];
        String g1_1 = parent.substring(0,1);
        String g1_2 = parent.substring(1, 2);
        String g2_1 = parent.substring(2, 3);
        String g2_2 = parent.substring(3, 4);
        result[0] = g1_1 + g2_1;
        result[1] = g1_1 + g2_2;
        result[2] = g1_2 + g2_1;
        result[3] = g1_2 + g2_2;

        return result;
    }

    public static String reformatCombo(String combination)
    {
        //Associate like genotype letters
        char g1_1 = combination.substring(0,1).charAt(0);
        char g2_1 = combination.substring(1, 2).charAt(0);
        char g1_2 = combination.substring(2,3).charAt(0);
        char g2_2 = combination.substring(3,4).charAt(0);

        if(Character.isUpperCase(g1_2) && !Character.isUpperCase(g1_1))
        {
            char temp = g1_2;
            g1_2 = g1_1;
            g1_1 = temp;
        }
        if(Character.isUpperCase(g2_2) && !Character.isUpperCase(g2_1))
        {
            char temp = g2_2;
            g2_2 = g2_1;
            g2_1 = temp;

        }
        String associatedResult = String.valueOf(g1_1) + String.valueOf(g1_2) + String.valueOf(g2_1) + String.valueOf(g2_2);

        return associatedResult;
    }


    // public static void main(String [] args)
    // {
    //     Genetics genetics = new Genetics();
    //     String [][] monoTest = genetics.calculateMonohybrid("Aa", "AA");
    //     System.out.println(Arrays.deepToString(monoTest));
    //     System.out.println("----------");
    //     String[] combo = genetics.parentCombinations("AaBB");
    //     String[] combo2 = genetics.parentCombinations("AABb");
    //     System.out.println(Arrays.toString(combo));
    //     System.out.println(Arrays.toString(combo2));
    //     System.out.println("----------");
    //     String[][] diTest = genetics.calculateDihybrid("AaBB", "AABb");
    //     System.out.println(Arrays.deepToString(diTest));
    //     System.out.println("----------");
    //     System.out.println(genetics.reformatCombo("abAB"));
    // }
}