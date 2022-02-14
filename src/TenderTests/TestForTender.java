package TenderTests;

import TenderBody.*;
import Exception.UnsuitableArgumentsException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static TenderBody.Skills.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestForTender {

    private Tender bc;

    private static final List<Tender> tender = Arrays.asList(new Tender(CRANE_OPERATOR, 1),
            new Tender(CARPENTER, 1), new Tender(MASON, 1),
            new Tender(FITTER, 2), new Tender(ELECTRIC, 2),
            new Tender(PAINTER, 1));

    private static final Set<Skills> skills1 = new HashSet<>();

    {
        skills1.add(FITTER);
        skills1.add(CRANE_OPERATOR);
    }


    private static final Set<Skills> skills2 = new HashSet<>();

    {
        skills2.add(MASON);
        skills2.add(ELECTRIC);
    }

    private static final Set<Skills> skills3 = new HashSet<>();

    {
        skills3.add(FITTER);
        skills3.add(ELECTRIC);
    }

    private static final Set<Skills> skills4 = new HashSet<>();

    {
        skills4.add(PAINTER);
    }

    private static final Set<Skills> skills5 = new HashSet<>();

    {
        skills5.add(CARPENTER);
    }

    private static final Set<Skills> skills6 = new HashSet<>();

    {
        skills6.add(CARPENTER);
    }

    private static final Set<Skills> skills7 = new HashSet<>();

    {
        skills7.add(MASON);
    }

    private static final Set<Skills> skills8 = new HashSet<>();

    {
        skills8.add(FITTER);
        skills8.add(ELECTRIC);
    }

    private static final Set<Skills> skills9 = new HashSet<>();

    {
        skills9.add(PAINTER);
        skills9.add(CRANE_OPERATOR);
    }

    private static final Set<Skills> skills10 = new HashSet<>();

    {
        skills10.add(FITTER);
        skills10.add(ELECTRIC);
    }

    private static final Worker worker1 = new Worker(skills1);
    private static final Worker worker2 = new Worker(skills2);
    private static final Worker worker3 = new Worker(skills3);
    private static final Worker worker4 = new Worker(skills4);
    private static final Worker worker5 = new Worker(skills5);
    private static final Worker worker6 = new Worker(skills6);
    private static final Worker worker7 = new Worker(skills7);
    private static final Worker worker8 = new Worker(skills8);
    private static final Worker worker9 = new Worker(skills9);
    private static final Worker worker10 = new Worker(skills10);

    private static final Map<Skills, Integer> map_tender = new TreeMap<>();

    {
        map_tender.put((CRANE_OPERATOR), 1);
        map_tender.put((MASON), 1);
        map_tender.put((CARPENTER), 1);
        map_tender.put((PAINTER), 1);
        map_tender.put((ELECTRIC), 2);
        map_tender.put((FITTER), 2);
    }

    private static final List<Worker> brigade1 = Arrays.asList(worker1, worker2, worker3, worker4, worker5);
    private static final List<Worker> brigade2 = Arrays.asList(worker6, worker7, worker8, worker9, worker10);
    private static final List<Worker> brigade3 = Arrays.asList(worker1, worker2, worker4, worker9, worker10);
    private static final List<Worker> brigade4 = Arrays.asList(worker2, worker4, worker7, worker8);
    private static final List<Worker> brigade5 = Arrays.asList(worker1, worker5, worker9, worker10);

    private static final List<Brigade> brigades = Arrays.asList(new Brigade(brigade1, 190000),
            new Brigade(brigade2, 170000),
            new Brigade(brigade3, 140000));

    private static final Map<Skills, Integer> map_brigade1 = new TreeMap<>();

    {
        map_brigade1.put((CARPENTER), 1);
        map_brigade1.put((CRANE_OPERATOR), 1);
        map_brigade1.put((ELECTRIC), 2);
        map_brigade1.put((FITTER), 2);
        map_brigade1.put((MASON), 1);
        map_brigade1.put((PAINTER), 1);
    }

    private static final Map<Skills, Integer> map_brigade2 = new TreeMap<>();

    {
        map_brigade2.put((CARPENTER), 1);
        map_brigade2.put((CRANE_OPERATOR), 1);
        map_brigade2.put((ELECTRIC), 2);
        map_brigade2.put((FITTER), 2);
        map_brigade2.put((MASON), 1);
        map_brigade2.put((PAINTER), 1);
    }

    private static final Map<Skills, Integer> map_brigade3 = new TreeMap<>();

    {
        map_brigade3.put((CRANE_OPERATOR), 2);
        map_brigade3.put((ELECTRIC), 2);
        map_brigade3.put((FITTER), 2);
        map_brigade3.put((MASON), 1);
        map_brigade3.put((PAINTER), 2);
    }

    private static final Map<Skills, Integer> map_brigade4 = new TreeMap<>();

    {
        map_brigade4.put((ELECTRIC), 2);
        map_brigade4.put((FITTER), 1);
        map_brigade4.put((MASON), 2);
        map_brigade4.put((PAINTER), 1);
    }

    private static final Map<Skills, Integer> map_brigade5 = new TreeMap<>();

    {
        map_brigade5.put((CARPENTER), 1);
        map_brigade5.put((CRANE_OPERATOR), 2);
        map_brigade5.put((ELECTRIC), 1);
        map_brigade5.put((FITTER), 2);
        map_brigade5.put((PAINTER), 1);
    }

    @Before
    public void setUp() throws UnsuitableArgumentsException {
        bc = new Tender();
    }

    @After
    public void tearDown() throws UnsuitableArgumentsException {
        bc = null;
    }

    @Test
    public void testTenderToMap() {
        Map<Skills, Integer> expected = map_tender;

        Map<Skills, Integer> actual = bc.convertTenderToMap(tender);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap1() {
        Map<Skills, Integer> expected = map_brigade1;

        Map<Skills, Integer> actual = bc.convertWorkerToMap((Brigade) brigade1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap2() {
        Map<Skills, Integer> expected = map_brigade2;

        Map<Skills, Integer> actual = bc.convertWorkerToMap((Brigade) brigade2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap3() {
        Map<Skills, Integer> expected = map_brigade3;

        Map<Skills, Integer> actual = bc.convertWorkerToMap((Brigade) brigade3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap4() {
        Map<Skills, Integer> expected = map_brigade4;

        Map<Skills, Integer> actual = bc.convertWorkerToMap((Brigade) brigade4);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap5() {
        Map<Skills, Integer> expected = map_brigade5;

        Map<Skills, Integer> actual = bc.convertWorkerToMap((Brigade) brigade5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testEqualsBrigade1WithTenderPositive() {
        boolean actual = bc.equalsBrigadeWithTender(tender, brigade1);

        assertTrue(actual);
    }

    @Test
    public void testEqualsBrigade2WithTenderPositive() {
        boolean actual = bc.equalsBrigadeWithTender(tender, brigade2);

        assertTrue(actual);
    }

    @Test
    public void testEqualsBrigade3WithTenderNegative() {
        boolean actual = bc.equalsBrigadeWithTender(tender, brigade3);

        assertFalse(actual);
    }

    @Test
    public void testEqualsBrigade4WithTenderNegative() {
        boolean actual = bc.equalsBrigadeWithTender(tender, brigade4);

        assertFalse(actual);
    }

    @Test
    public void testEqualsBrigade5WithTenderNegative() {
        boolean actual = bc.equalsBrigadeWithTender(tender, brigade5);

        assertFalse(actual);
    }

    @Test
    public void testChoiceBrigade() throws UnsuitableArgumentsException {
        List<Brigade> winner = brigades.subList(1, 2);
        List<Brigade> expected = winner;

        List<Brigade> actual = bc.choiceBrigade(tender, brigades);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = UnsuitableArgumentsException.class)
    public void testChoiceBrigadeNegative_IfNoOneBrigadesSuit() throws UnsuitableArgumentsException {
        List<Brigade> noSuitBrigades = Arrays.asList(new Brigade(brigade4, 150000),
                new Brigade(brigade5, 160000));
        bc.choiceBrigade(tender, noSuitBrigades);
    }
}
