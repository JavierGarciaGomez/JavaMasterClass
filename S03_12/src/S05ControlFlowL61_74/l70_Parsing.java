package S05ControlFlowL61_74;

public class l70_Parsing {
    public static void main(String[] args) {
        /* 70. Parsing */
        String numberAsString = "2";
        int number = Integer.parseInt(numberAsString);

        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
        System.out.println(canPack(-3, 2, 12));

        /* 71. Reading user input */
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter your name and age");
//        String name = scanner.nextLine();
//        int edad = scanner.nextInt();
//
//        System.out.println("Hola: " + name + edad);
//
//        scanner.close();

        System.out.println(getBucketCount(-3.4,2.1,1.5,2));
        System.out.println(getBucketCount(3.4,2.1,1.5,2));
        System.out.println(getBucketCount(2.75,3.25,2.5,1));
        System.out.println(getBucketCount(-3.4,2.1,1.5));
        System.out.println(getBucketCount(3.4,2.1,1.5));
        System.out.println(getBucketCount(7.25,4.3, 2.35));
        System.out.println(getBucketCount(3.4,1.5));
        System.out.println(getBucketCount(6.26,2.2));
        System.out.println(getBucketCount(3.26,0.75));
    }

    /* Ex 24*/

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) return false;
        if (goal <= (bigCount * 5 + smallCount)) {
            for (int i = 0; i <= bigCount; i++) {
                for (int j = 0; j <= smallCount; j++) {
                    if ((i * 5 + j) != 0 && (i * 5 + j) % goal == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* Ex28.*/
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        int numBuckets;
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets<0) return -1;

        double numBucketsD=(((width*height)/areaPerBucket)-extraBuckets);
        if(numBucketsD>(int)numBucketsD){
            numBuckets=(int)numBucketsD+1;
        } else numBuckets=(int)numBucketsD;
        return numBuckets;
    }


    public static int getBucketCount(double width, double height, double areaPerBucket) {
        int numBuckets;
        if (width <= 0 || height <= 0 || areaPerBucket <= 0) return -1;

        double numBucketsD=(((width*height)/areaPerBucket));
        if(numBucketsD>(int)numBucketsD){
            numBuckets=(int)numBucketsD+1;
        } else numBuckets=(int)numBucketsD;
        return numBuckets;
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        int numBuckets;
        if (area <= 0 || areaPerBucket <= 0) return -1;
        double numBucketsD=(((area)/areaPerBucket));
        if(numBucketsD>(int)numBucketsD){
            numBuckets=(int)numBucketsD+1;
        } else numBuckets=(int)numBucketsD;
        return numBuckets;
    }

}
