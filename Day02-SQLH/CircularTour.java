class CircularTour {
    public static int findStartingPump(int[] petrol, int[] distance) {
        int totalSurplus = 0; // Tracks if a solution exists
        int currSurplus = 0;  // Tracks current fuel balance
        int startIndex = 0;   // Potential starting point
        for (int i = 0; i < petrol.length; i++) {
            int gain = petrol[i] - distance[i]; // Surplus at each pump
            totalSurplus += gain;
            currSurplus += gain;
            // If we run out of petrol, reset start index
            if (currSurplus < 0) {
                startIndex = i + 1;  // Move start to the next pump
                currSurplus = 0;      // Reset the surplus
            }
        }
        return (totalSurplus >= 0) ? startIndex : -1; // Possible not
    }
    public static void main(String[] args) {
        int[] petrol = {5, 2, 1, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPump(petrol, distance);
        if (start != -1) {
            System.out.println("Start at petrol pump index: " + start);
        } else {
            System.out.println("No possible circular tour");
        }
    }
}
