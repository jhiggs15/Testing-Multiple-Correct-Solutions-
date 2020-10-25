// John Higgins - jhiggins
// Sam Rowe - sprowe
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Examples {
    HeapChecker aTester = new HeapChecker();
    MtHeap aMTHeap = new MtHeap();
    IHeap aHeap;
    IHeap answer;

    // addEltTester Testing
    @Test
    public void addEltTesterNormalHeap(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                aMTHeap,
                                new DataHeap(600,aMTHeap,aMTHeap)));

        answer = aHeap.addElt(12);
        assertTrue(aTester.addEltTester(aHeap,12, answer));
    }

    @Test
    public void addEltTesterNegativeHeap(){
        aHeap =
                new DataHeap(-4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(-1,
                                aMTHeap,
                                new DataHeap(3,aMTHeap,aMTHeap)));

        answer = aHeap.addElt(12);
        assertTrue(aTester.addEltTester(aHeap,12, answer));
    }

    @Test
    public void addEltTesterSwithcedAnswer(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));

        answer =
                new DataHeap(4,
                     new DataHeap(11,
                            new DataHeap(12,
                                    new DataHeap(25,aMTHeap,aMTHeap)
                                    ,aMTHeap),
                            new DataHeap(67, aMTHeap,aMTHeap)),
                     new DataHeap(10,
                            new DataHeap(75,aMTHeap,aMTHeap),
                            new DataHeap(600,aMTHeap,aMTHeap)));

        assertTrue(aTester.addEltTester(aHeap,12, answer));
    }

    @Test
    public void addEltTesterSwitchedAnswer2(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));

        answer =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(12,
                                        new DataHeap(600,aMTHeap,aMTHeap),
                                        aMTHeap)));

        assertTrue(aTester.addEltTester(aHeap,12, answer));
    }

    @Test
    public void addEltTesterTotalElementsIncorrect(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer = aHeap.addElt(12);
        answer = answer.addElt(24);

        assertFalse(aTester.addEltTester(aHeap,12, answer));
    }

    @Test
    public void addEltTesterSameHeapReturned(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));

        assertFalse(aTester.addEltTester(aHeap,12, aHeap));
    }

    @Test
    public void addEltTesterElementTotalElementsIncorrectAndNumberNeverAdded(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));

        answer =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,
                                        new DataHeap(50,aMTHeap,aMTHeap),
                                        aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));

        assertFalse(aTester.addEltTester(aHeap,4, answer));
    }

    @Test
    public void addEltTesterOtherEltsOccurWrongNumberOfTimes(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));

        answer =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,
                                        new DataHeap(25,aMTHeap,aMTHeap),
                                        aMTHeap),
                                new DataHeap(67,
                                        new DataHeap(67, aMTHeap,aMTHeap),
                                        aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer = answer.addElt(430);

        assertFalse(aTester.addEltTester(aHeap,430, answer));
    }

    @Test
    public void addEltTesterDifferntElement(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));

        answer =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(420, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer = answer.addElt(430);

        assertFalse(aTester.addEltTester(aHeap,430, answer));
    }

    @Test
    public void addEltTesterNotValidHeapErrorInFirstLSub(){
        aHeap =
                new DataHeap(11,
                    new DataHeap(12,
                            new DataHeap(12,aMTHeap,aMTHeap),
                            new DataHeap(67, aMTHeap,aMTHeap)),
                    new DataHeap(10,
                            new DataHeap(75,aMTHeap,aMTHeap),
                            new DataHeap(600,aMTHeap,aMTHeap)));

        answer =
                new DataHeap(11,
                        new DataHeap(4,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer = answer.addElt(24);

        assertFalse(aTester.addEltTester(aHeap,24, answer));
    }

    @Test
    public void addEltTesterBadHeapErrorInRoot(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(12,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer =
                new DataHeap(100,
                        new DataHeap(12,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer = answer.addElt(16);

        assertFalse(aTester.addEltTester(aHeap,16, answer));
    }

    @Test
    public void addEltTesterBadHeapGiven(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(12,
                                new DataHeap(2,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer = aHeap.addElt(16);


        assertFalse(aTester.addEltTester(aHeap,16, answer));
    }

    @Test
    public void addEltTesterBadHeapErrorInFirstRSecondRSub(){
        aHeap =
                new DataHeap(8,
                        new DataHeap(11,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(11,aMTHeap,aMTHeap)));
        answer =
                new DataHeap(8,
                        new DataHeap(11,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(4,aMTHeap,aMTHeap)));
        answer = answer.addElt(24);

        assertFalse(aTester.addEltTester(aHeap,24, answer));
    }

    @Test
    public void addEltTesterHeapMinimumAppearsMultipleTimes(){
        aHeap =
                new DataHeap(8,
                        new DataHeap(8,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(8,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(20,aMTHeap,aMTHeap)));
        answer = aHeap.addElt(8);

        assertTrue(aTester.addEltTester(aHeap,8, answer));
    }

    @Test
    public void addEltTesterEmptyHeap(){
        aHeap = new MtHeap();
        answer = aHeap.addElt(24);

        assertTrue(aTester.addEltTester(aHeap,24, answer));
    }

    @Test
    public void addEltTesterOneElementHeap(){
        aHeap = new DataHeap(4,aMTHeap, aMTHeap);
        answer = aHeap.addElt(3);

        assertTrue(aTester.addEltTester(aHeap,3, answer));
    }

    @Test
    public void addEltTesterOneSidedHeap(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(6,aMTHeap,aMTHeap),
                        aMTHeap);
        answer = aHeap.addElt(24);

        assertTrue(aTester.addEltTester(aHeap,24, answer));
    }

    @Test
    public void addEltTesterOneSidedHeapExpanded(){
        aHeap =
                new DataHeap(3,
                        new DataHeap(5,
                                new DataHeap(8,
                                        new MtHeap(),
                                        new MtHeap()),
                                new MtHeap()),
                        new MtHeap());
        answer = aHeap.addElt(24);

        assertTrue(aTester.addEltTester(aHeap,24, answer));
    }

    // remMinEltTester Testing
    @Test
    public void remMinEltTesterNormalHeap(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer = aHeap.remMinElt();

        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterRemovedWrongNumberOfTimes(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(11,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(600,aMTHeap,aMTHeap)));
        answer = aHeap.remMinElt();
        answer = answer.remMinElt();

        assertFalse(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterNormalHeapErrorInFirstLSub(){
        aHeap = new DataHeap(11,
                new DataHeap(2,
                        new DataHeap(18,aMTHeap,aMTHeap),
                        new DataHeap(67, aMTHeap,aMTHeap)),
                new DataHeap(10,
                        new DataHeap(75,aMTHeap,aMTHeap),
                        new DataHeap(600,aMTHeap,aMTHeap)));
        answer = aHeap.remMinElt();

        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterBadHeapErrorInRoot(){
        aHeap =
                new DataHeap(100,
                        new DataHeap(12,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(10,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(20,aMTHeap,aMTHeap)));
        answer = aHeap.remMinElt();

        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterHeapsNotTheSameAndOtherInvalid(){
        aHeap = new DataHeap(8,
                new DataHeap(11,
                        new DataHeap(12,aMTHeap,aMTHeap),
                        new DataHeap(67, aMTHeap,aMTHeap)),
                new DataHeap(12,
                        new DataHeap(75,aMTHeap,aMTHeap),
                        new DataHeap(20,aMTHeap,aMTHeap)));

        answer = new DataHeap(8,
                new DataHeap(11,
                        new DataHeap(12,aMTHeap,aMTHeap),
                        new DataHeap(67, aMTHeap,aMTHeap)),
                new DataHeap(4,
                        new DataHeap(75,aMTHeap,aMTHeap),
                        new DataHeap(20,aMTHeap,aMTHeap)));
        aHeap.remMinElt();

        assertFalse(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterHeapsNotTheSame(){
        aHeap = new DataHeap(8,
                new DataHeap(11,
                        new DataHeap(12,aMTHeap,aMTHeap),
                        new DataHeap(67, aMTHeap,aMTHeap)),
                new DataHeap(12,
                        new DataHeap(75,aMTHeap,aMTHeap),
                        new DataHeap(20,aMTHeap,aMTHeap)));

        answer = new DataHeap(8,
                new DataHeap(11,
                        new DataHeap(12,aMTHeap,aMTHeap),
                        new DataHeap(67, aMTHeap,aMTHeap)),
                new DataHeap(19,
                        new DataHeap(75,aMTHeap,aMTHeap),
                        new DataHeap(20,aMTHeap,aMTHeap)));
        answer = answer.remMinElt();

        assertFalse(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterRemovedSameListReturned(){
        aHeap =
                new DataHeap(8,
                        new DataHeap(11,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(14,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                aMTHeap));

        assertFalse(aTester.remMinEltTester(aHeap, aHeap));
    }

    @Test
    public void remMinEltTesterMinimumElementAppearsMultipleTimes(){
        aHeap =
                new DataHeap(8,
                        new DataHeap(8,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                aMTHeap),
                        new DataHeap(8,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(20,aMTHeap,aMTHeap)));

        answer = aHeap.remMinElt();
        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterEmptyHeap(){
        aHeap = new MtHeap();
        answer = aHeap.remMinElt();

        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterOneElementHeap(){
        aHeap = new DataHeap(3,aMTHeap, aMTHeap);
        answer = aHeap.remMinElt();

        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterOneSidedHeap(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(6,aMTHeap,aMTHeap),
                        aMTHeap);
        answer = aHeap.addElt(24);

        assertTrue(aTester.addEltTester(aHeap,24, answer));
    }

    @Test
    public void remMinEltTesterOneSidedHeapExpanded(){
        aHeap =
                new DataHeap(4,
                        new DataHeap(6,
                                new DataHeap(38,aMTHeap,aMTHeap)
                                ,aMTHeap),
                        aMTHeap);
        answer = aHeap.addElt(24);

        assertTrue(aTester.addEltTester(aHeap,24, answer));
    }

    @Test
    public void remMinEltTesterDuplicateMinimum(){
        aHeap =
                new DataHeap(8,
                        new DataHeap(8,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(8,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(20,aMTHeap,aMTHeap)));
        answer = aHeap.remMinElt();

        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterSwitched(){
        aHeap =
                new DataHeap(8,
                        new DataHeap(12,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(15,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(20,aMTHeap,aMTHeap)));
        answer =
                new DataHeap(12,
                        new DataHeap(15,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(20,aMTHeap,aMTHeap)),
                        new DataHeap(12,
                                aMTHeap,
                                new DataHeap(67, aMTHeap, aMTHeap)));

        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterSwitched2(){
        aHeap =
                new DataHeap(8,
                        new DataHeap(12,
                                new DataHeap(12,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(15,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(20,aMTHeap,aMTHeap)));
        answer =
                new DataHeap(12,
                        new DataHeap(12,
                                new DataHeap(67, aMTHeap, aMTHeap),
                                aMTHeap),
                        new DataHeap(15,
                                new DataHeap(75,aMTHeap,aMTHeap),
                                new DataHeap(20,aMTHeap,aMTHeap)));

        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

    @Test
    public void remMinEltTesterNegativeHeap(){
        aHeap =
                new DataHeap(-4,
                        new DataHeap(-2,
                                new DataHeap(25,aMTHeap,aMTHeap),
                                new DataHeap(67, aMTHeap,aMTHeap)),
                        new DataHeap(-1,
                                aMTHeap,
                                new DataHeap(3,aMTHeap,aMTHeap)));

        answer = aHeap.remMinElt();
        assertTrue(aTester.remMinEltTester(aHeap, answer));
    }

}
