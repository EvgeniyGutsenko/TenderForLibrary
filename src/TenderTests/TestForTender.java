package TenderTests;

import TenderBody.*;
import Exception.UnsuitableArgumentsException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestForTender {

    private Tender bc;

    private static final List<Tender> tender = Arrays.asList(new Tender(Skills.CRANE_OPERATOR, 1),
            new Tender(Skills.CARPENTER, 1), new Tender(Skills.MASON, 1),
            new Tender(Skills.FITTER, 2), new Tender(Skills.ELECTRIC, 2),
            new Tender(Skills.PAINTER, 1));

    private static final Set<Skills> skills1 = new HashSet<>();

    {
        skills1.add(Skills.FITTER);
        skills1.add(Skills.CRANE_OPERATOR);
    }


    private static final Set<Skills> skills2 = new HashSet<>();

    {
        skills2.add(Skills.MASON);
        skills2.add(Skills.ELECTRIC);
    }

    private static final Set<Skills> skills3 = new HashSet<>();

    {
        skills3.add(Skills.FITTER);
        skills3.add(Skills.ELECTRIC);
    }

    private static final Set<Skills> skills4 = new HashSet<>();

    {
        skills4.add(Skills.PAINTER);
    }

    private static final Set<Skills> skills5 = new HashSet<>();

    {
        skills5.add(Skills.CARPENTER);
    }

    private static final Set<Skills> skills6 = new HashSet<>();

    {
        skills6.add(Skills.CARPENTER);
    }

    private static final Set<Skills> skills7 = new HashSet<>();

    {
        skills7.add(Skills.MASON);
    }

    private static final Set<Skills> skills8 = new HashSet<>();

    {
        skills8.add(Skills.FITTER);
        skills8.add(Skills.ELECTRIC);
    }

    private static final Set<Skills> skills9 = new HashSet<>();

    {
        skills9.add(Skills.PAINTER);
        skills9.add(Skills.CRANE_OPERATOR);
    }

    private static final Set<Skills> skills10 = new HashSet<>();

    {
        skills10.add(Skills.FITTER);
        skills10.add(Skills.ELECTRIC);
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

    private static final Map<String, Integer> map_tender = new TreeMap<>();

    {
        map_tender.put(String.valueOf(Skills.CRANE_OPERATOR), 1);
        map_tender.put(String.valueOf(Skills.MASON), 1);
        map_tender.put(String.valueOf(Skills.CARPENTER), 1);
        map_tender.put(String.valueOf(Skills.PAINTER), 1);
        map_tender.put(String.valueOf(Skills.ELECTRIC), 2);
        map_tender.put(String.valueOf(Skills.FITTER), 2);
    }

    private static final List<Worker> brigade1 = Arrays.asList(worker1, worker2, worker3, worker4, worker5);
    private static final List<Worker> brigade2 = Arrays.asList(worker6, worker7, worker8, worker9, worker10);
    private static final List<Worker> brigade3 = Arrays.asList(worker1, worker2, worker4, worker9, worker10);
    private static final List<Worker> brigade4 = Arrays.asList(worker2, worker4, worker7, worker8);
    private static final List<Worker> brigade5 = Arrays.asList(worker1, worker5, worker9, worker10);

    private static final List<Brigade> brigades = Arrays.asList(new Brigade(brigade1, 190000),
            new Brigade(brigade2, 170000),
            new Brigade(brigade3, 140000));

    private static final Map<String, Integer> map_brigade1 = new TreeMap<>();

    {
        map_brigade1.put(String.valueOf(Skills.CARPENTER), 1);
        map_brigade1.put(String.valueOf(Skills.CRANE_OPERATOR), 1);
        map_brigade1.put(String.valueOf(Skills.ELECTRIC), 2);
        map_brigade1.put(String.valueOf(Skills.FITTER), 2);
        map_brigade1.put(String.valueOf(Skills.MASON), 1);
        map_brigade1.put(String.valueOf(Skills.PAINTER), 1);
    }

    private static final Map<String, Integer> map_brigade2 = new TreeMap<>();

    {
        map_brigade2.put(String.valueOf(Skills.CARPENTER), 1);
        map_brigade2.put(String.valueOf(Skills.CRANE_OPERATOR), 1);
        map_brigade2.put(String.valueOf(Skills.ELECTRIC), 2);
        map_brigade2.put(String.valueOf(Skills.FITTER), 2);
        map_brigade2.put(String.valueOf(Skills.MASON), 1);
        map_brigade2.put(String.valueOf(Skills.PAINTER), 1);
    }

    private static final Map<String, Integer> map_brigade3 = new TreeMap<>();

    {
        map_brigade3.put(String.valueOf(Skills.CRANE_OPERATOR), 2);
        map_brigade3.put(String.valueOf(Skills.ELECTRIC), 2);
        map_brigade3.put(String.valueOf(Skills.FITTER), 2);
        map_brigade3.put(String.valueOf(Skills.MASON), 1);
        map_brigade3.put(String.valueOf(Skills.PAINTER), 2);
    }

    private static final Map<String, Integer> map_brigade4 = new TreeMap<>();

    {
        map_brigade4.put(String.valueOf(Skills.ELECTRIC), 2);
        map_brigade4.put(String.valueOf(Skills.FITTER), 1);
        map_brigade4.put(String.valueOf(Skills.MASON), 2);
        map_brigade4.put(String.valueOf(Skills.PAINTER), 1);
    }

    private static final Map<String, Integer> map_brigade5 = new TreeMap<>();

    {
        map_brigade5.put(String.valueOf(Skills.CARPENTER), 1);
        map_brigade5.put(String.valueOf(Skills.CRANE_OPERATOR), 2);
        map_brigade5.put(String.valueOf(Skills.ELECTRIC), 1);
        map_brigade5.put(String.valueOf(Skills.FITTER), 2);
        map_brigade5.put(String.valueOf(Skills.PAINTER), 1);
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
        Map<String, Integer> expected = map_tender;

        Map<String, Integer> actual = bc.convertTenderToMap(tender);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap1() {
        Map<String, Integer> expected = map_brigade1;

        Map<String, Integer> actual = bc.convertWorkerToMap(brigade1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap2() {
        Map<String, Integer> expected = map_brigade2;

        Map<String, Integer> actual = bc.convertWorkerToMap(brigade2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap3() {
        Map<String, Integer> expected = map_brigade3;

        Map<String, Integer> actual = bc.convertWorkerToMap(brigade3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap4() {
        Map<String, Integer> expected = map_brigade4;

        Map<String, Integer> actual = bc.convertWorkerToMap(brigade4);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertWorkerToMap5() {
        Map<String, Integer> expected = map_brigade5;

        Map<String, Integer> actual = bc.convertWorkerToMap(brigade5);

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
