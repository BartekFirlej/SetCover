import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BruteForce {
    private DataGenerator problemData;
    private Set<Integer> problemSolution;

    public Set<Integer> getProblemSolution() {
        return problemSolution;
    }
    BruteForce(DataGenerator problemData){
        this.problemData=problemData;
        Set<Integer> allRows = new HashSet<Integer>();              // contains id for all rows
        Set<Integer> bestSolution = new HashSet<Integer>();         // contains temporary best solution (id of chosen cols)
        for(int i=0;i<problemData.getRowsNumber();i++)
            allRows.add(i);                                               // set of all rows to compare with solution to find the best
        for(int i=0;i<problemData.getColsNumber();i++)
            bestSolution.add(i);                                          // at the begin best solution contains number of all cols
        for(int i=1;i<Math.pow(2,problemData.getColsNumber());i++){                // for every subset 2^n
            Set<Integer> covered = new HashSet<Integer>(); // rows covered by this subset
            Set<Integer> tempSolution = new HashSet<Integer>();         // contains temporary best solution (id of chosen cols)
            int temp=i;                                    // changing to bites to see which columns subset contains
            int position = 0;                                 // position
            while(temp!=0){                          // changing to binary so 7 means 111
                if(temp%2==1){
                    tempSolution.add(position);                      // if this number contains this col add it to tempSolution
                    for(int j=0;j<problemData.getRowsNumber();j++)  //for all rows in this col
                        if(problemData.getArr()[j][position]==1)     // if this column covers row
                            covered.add(j);                          // we add this row to covered
                }
                position++;                                 // after each calculation position gets bigger
                temp=temp/2;                               // number is devided because its changing to binary
            }
            if(covered.equals(allRows) && tempSolution.size()<bestSolution.size()) // if this solution covers all elements and contains less cols then best solution
                bestSolution=tempSolution;
        }
        this.problemSolution=bestSolution;
    }
}
