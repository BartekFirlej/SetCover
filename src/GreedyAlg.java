import java.util.HashSet;
import java.util.Set;

public class GreedyAlg {
    private DataGenerator problemData;
    private Set<Integer> problemSolution;
    public Set<Integer> getProblemSolution() {
        return problemSolution;
    }
    GreedyAlg(DataGenerator problemData){
        this.problemData=problemData;
        Set<Integer> checkAllRows = new HashSet<Integer>();         // contains id for all rows
        Set<Integer> allRows = new HashSet<Integer>();              // contains id for all rows
        this.problemSolution = new HashSet<Integer>();              //contains chosen cols
        for(int i=0;i<problemData.getRowsNumber();i++)
            allRows.add(i);                                         // allrows must be contained in solution
        while(!allRows.isEmpty()){                                 // till i pop all rows as found
            int greedyCol = 0;                                    // number of greedycol
            int greedyColPower = 0;                               // number of items it contains
            for(int i=0;i<problemData.getColsNumber();i++){        //for each column
                if(!problemSolution.contains(i)){                 // if isnt picked yet
                    int containsElements = 0;                     //items counter
                    for(int j=0;j<problemData.getRowsNumber();j++){      // for each row in this col
                        if(problemData.arr[j][i]==1 && allRows.contains(j))   // if this col contains row and this row isnt covered yet
                            containsElements+=1;                              // increment items counter
                    }
                    if(containsElements>greedyColPower){                     // if current column covers more element then greediest
                        greedyCol=i;                                      // mark this column as greediest
                        greedyColPower=containsElements;                  // power of set covered by greedies column
                    }
                }
            }
            this.problemSolution.add(greedyCol);                         // after i checked every col add the gredies to solution
            for(int j=0;j<problemData.getRowsNumber();j++)                    // remove every not-yet covered element by this col from all row
                if(problemData.arr[j][greedyCol]==1 && allRows.contains(j))
                    allRows.remove(j);
        }
    }
    public Set<Integer> getSolution(){
        return this.problemSolution;
    }
}
