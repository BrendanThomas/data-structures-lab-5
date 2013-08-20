README - Lab 5, Part 1 - Brendan Thomas

Tests the ratio of items queued/dequeued (produced/consumed) when the probability ratio of a coin toss is changed.

Compilation and running commands:

cd XXX/lab5-thomas-brendan

javac lab5/queues/*.java part1/ProducerConsumer.java

cd part1

export CLASSPATH=/XXX/lab5-thomas-brendan:.

java ProducerConsumer

---------------------

Run ProducerConsumer a total of 4 times. The QUEUESIZE in ProducerConsumer.java will initially be set at 100. The subsequent 3 times it should be changed to 10, 3, and 1. The running and compilation commands are similar, but it is not necessary to recompile anything from lab5/queues, since they'll already be compiled. To be clear, upon changing the QUEUESIZE, the commands should be as follows:

cd XXX/lab5-thomas-brendan

javac part1/ProducerConsumer.java

cd part1

export CLASSPATH=/XXX/lab5-thomas-brendan:.

java ProducerConsumer


