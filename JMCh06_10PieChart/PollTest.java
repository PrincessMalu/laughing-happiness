/**
 *  TODO Helps test the Progress of Poll classes
 *
 *  @author  Malavika Nair
 *  @version September 6, 2019
 *  @author  Period: 1st
 *  @author  Assignment: JMCh06_10PieChart
 *
 *  @author  Sources: None
 */
public class PollTest
{
    /**
     * TODO test class for progress with the PollDisplay class.
     * @param args
     */
    public static void main(String[] args)
    { PollDisplayPanel votingMachine =
                     new PollDisplayPanel("Tami", "Brian", "Liz");
      votingMachine.vote1();
      votingMachine.vote2();
      votingMachine.vote2();
      System.out.println(votingMachine);
    }
}
