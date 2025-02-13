public class StringPerformance{
    public static void comparePerformance(int N){
        
        String test ="";
      //Measure string concatenation time

        long start = System.nanoTime();
        for(int i = 0; i < N; i++){
            test += "yamanyu76";
        }
        long end = System.nanoTime()-start;

        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(test);
        }
        long endB = System.nanoTime()-start;

        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for(int i = 0; i < N; i++){
            sbf.append(test);
        }
        long endBu = System.nanoTime()-start;
        System.out.println(N + " | " + (end / 1_000_000.0) + " ms | " + 
                   (endB / 1_000_000.0) + " ms | " + 
                   (endBu / 1_000_000.0) + " ms");  
    }
    public static void main(String[] args){
        int datasetSizes[] = {1000, 10000, 100000};
        System.out.println("Dataset Size | String Concatenation  | StringBuilder | StringBuffer ");
        for(int N : datasetSizes){
            comparePerformance(N);
        }
    }
}