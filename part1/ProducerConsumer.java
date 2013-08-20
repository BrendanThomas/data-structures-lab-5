import lab5.queues.*;
public class ProducerConsumer {
    private static final int N = 1000000;
    private static final int QUEUESIZE = 100;
    private static double headProbability = 0.0;
    private static int numberSuccessfulConsumers = 0;
    private static double ratio = 0.0;
    private static BoundedQueueInterface<Integer> queue =
            new ArrayBndQueue<Integer>(new Integer[QUEUESIZE]);
        
    public static void main (String[] args) {
      for(int i = 0; i < 11; i++)
      {
        for(int j=0; j<N; j++)
        {
            if (coinFlipIsHeads())
                produce();
            else
                consume();
        }
        ratio = (double)numberSuccessfulConsumers/(N/2);
        //ratio of balanced Producer/Consumer [exactly half iterations would be consumed and succeed]
        System.out.printf("QUEUESIZE = %d\nheadProbability = %f\nRatio = %f\n\n",
                          QUEUESIZE, headProbability, ratio);
        numberSuccessfulConsumers = 0;
        headProbability = headProbability + 0.1;
      }   
    }

    public static void produce() {
        if (!queue.isFull()) 
            queue.enqueue( (int)(10*Math.random()) );
    }

    public static void consume() {
        if (!queue.isEmpty())
        {
          numberSuccessfulConsumers++;
          queue.dequeue();
        }
    }

    public static boolean coinFlipIsHeads() {
        return Math.random() < headProbability;
    }
}