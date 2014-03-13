readme.txt
last modified: 14/03/2014

sample api usage:

    Border border = BorderBuilder.build("5 5");
    Mower mower1 = MowerBuilder.build("1 2 N");
    Mower mower2 = MowerBuilder.build("3 3 E");

    ShearingSequence shearing = new ShearingSequence(
        new MowerMove(mower1, "GAGAGAGAA"),
        new MowerMove(mower2, "AADAADADDA"));
    shearing.runShearing();

sample provided as test units (

mvn clean test : launch all tests.

ShearingSequenceTest : launch the shearing with two mowers (sample written below).


