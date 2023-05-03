import java.util.HashSet;
import java.util.Set;

public class GreedyAlg {
    DataGenerator problemData;
    Set<Integer> problemSolution;

    public Set<Integer> getProblemSolution() {
        return problemSolution;
    }

    GreedyAlg(DataGenerator problemData){
        this.problemData=problemData;
       /* System.out.println(problemData.getData());
        System.out.println();
        System.out.println();*/
        Set<Integer> checkAllRows = new HashSet<Integer>();              // contains id for all rows
        Set<Integer> allRows = new HashSet<Integer>();              // contains id for all rows
        this.problemSolution = new HashSet<Integer>();              //contains chosen cols
        for(int i=0;i<problemData.getRowsNumber();i++){
            checkAllRows.add(i);// set of all rows to compare with solution to find the best
            allRows.add(i);
        }

        while(!allRows.isEmpty()){
            int greedyCol = 0;
            int greedyColPower = 0;
            for(int i=0;i<problemData.getColsNumber();i++){
                if(!problemSolution.contains(i)){
                    int containsElements = 0;
                    for(int j=0;j<problemData.getRowsNumber();j++){
                        if(problemData.arr[j][i]==1 && allRows.contains(j))
                            containsElements+=1;
                    }
                    System.out.print(i+": "+containsElements+"; ");
                    if(containsElements>greedyColPower){
                        greedyCol=i;
                        greedyColPower=containsElements;
                    }

                }
            }
            this.problemSolution.add(greedyCol);
            //System.out.println(greedyCol);
            for(int j=0;j<problemData.getRowsNumber();j++)
                if(problemData.arr[j][greedyCol]==1 && allRows.contains(j))
                    allRows.remove(j);
            /*System.out.println(allRows);
            System.out.println(problemSolution);
            System.out.println();
            System.out.println();
            System.out.println();*/
        }
    }

    public Set<Integer> getSolution(){
        return this.problemSolution;
    }
}
