last modified: 15/03/2014

prerequisite:
 * maven 2
 * jdk 6
 * access to central maven repositories.

sample api usage:

   // define the border of the lawn
   Border border = BorderBuilder.build("5 5");

   // create the mowers in their initial positions
   Mower mower1 = MowerBuilder.build("1 2 N");
   Mower mower2 = MowerBuilder.build("3 3 E");

   // create drivers for mowers.
   MowerDriverImpl driver1 = new MowerDriverImpl(border, mower1);
   MowerDriverImpl driver2 = new MowerDriverImpl(border, mower2);

   // define the shearing sequences (drivers + list of orders)
   ShearingSequences shearing = new ShearingSequences(
           new ShearingSequence(driver1, "GAGAGAGAA"),
           new ShearingSequence(driver2, "AADAADADDA"));

   // run the sequence
   shearing.runShearing();

sample provided as a test unit (ShearingSequencesTest).

How to launch:

> mvn clean test -Dtest=ShearingSequencesTest



