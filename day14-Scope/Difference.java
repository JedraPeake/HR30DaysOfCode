/**
 * Created by PeakeAndSons on 2016-12-30.
 */
public class Difference {
    private int[] elements;
    public int maximumDifference;
    Difference(int[] temp)
    {
        elements=temp;
    }

    void computeDifference()
    {
        int tempDifference=0;
        for(int i=0;i<elements.length;i++)
        {
            for (int j=0; j<elements.length;j++)
            {
                tempDifference = elements[i] - elements[j];

                if (tempDifference > maximumDifference) {
                    maximumDifference = tempDifference;
                }
            }
        }
    }
}
