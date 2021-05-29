package com.iut.as2021.metiers;

import com.iut.as2021.exceptions.MathsExceptions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculerTest {
    private Calculer maths;

    @Before
    public void setUp(){
        maths = new Calculer();
    }

    @Rule
    public ExpectedException e = ExpectedException.none();

    @Test
    public void testAddition() {
        Assert.assertEquals(maths.addition("2+5",1),7,2);
    }
    @Test
    public void testAddition2() {
        Assert.assertEquals(maths.addition("1+2",1),3,2);
    }
    @Test
    public void testAddition3() {
        Assert.assertEquals(maths.addition("24+5",2),29,2);
    }
    @Test
    public void testAddition4() {
        Assert.assertEquals(maths.addition("-2+5",2),3,2);
    }
    @Test
    public void testAddition5() {
        Assert.assertEquals(maths.addition("2+-5",1),-3,2);
    }
    @Test
    public void testAddition6() {
        Assert.assertEquals(maths.addition("2+50",1),52,2);
    }
    @Test
    public void testAddition7() {
        Assert.assertEquals(maths.addition("2 + 5",2),7,2);
    }
    @Test
    public void testAddition8() {
        Assert.assertEquals(maths.addition("2+5",1),7,2);
    }

    @Test
    public void testSoustraction(){
        Assert.assertEquals(maths.soustraction("1-2",1),-1,2);
    }
    @Test
    public void testSoustraction2(){
        Assert.assertEquals(maths.soustraction("2-1",1),1,2);
    }
    @Test
    public void testSoustraction3(){
        Assert.assertEquals(maths.soustraction("-2-2",2),-4,2);
    }
    @Test
    public void testSoustraction4(){
        Assert.assertEquals(maths.soustraction("2--1",1),3,2);
    }
    @Test
    public void testSoustraction5(){
        Assert.assertEquals(maths.soustraction("32-2",2),30,2);
    }

    @Test
    public void testMultiplication(){
        Assert.assertEquals(maths.multiplication("1*2",1),2,2);
    }
    @Test
    public void testMultiplication2(){
        Assert.assertEquals(maths.multiplication("3*-2",1),-6,2);
    }
    @Test
    public void testMultiplication3(){
        Assert.assertEquals(maths.multiplication("-3*-2",2),6,2);
    }
    @Test
    public void testMultiplication4(){
        Assert.assertEquals(maths.multiplication("10*2",2),20,2);
    }
    @Test
    public void testMultiplication5(){
        Assert.assertEquals(maths.multiplication("10*-2",2),-20,2);
    }

    @Test
    public void testDivision() throws Exception {
        Assert.assertEquals(maths.division("2/2",1),1,2);
    }
    @Test
    public void testDivision2() throws Exception {
        Assert.assertEquals(maths.division("2/1",1),2,2);
    }
    @Test
    public void testDivision3() throws Exception {
        Assert.assertEquals(maths.division("1/2",1),0.5,2);
    }
    @Test
    public void testDivision4() throws Exception {
        Assert.assertEquals(maths.division("-1/2",2),-0.5,2);
    }
    @Test
    public void testDivision5() throws Exception {
        Assert.assertEquals(maths.division("1/5",1),0.2,2);
    }
    @Test
    public void testDivision6() throws Exception {
        Assert.assertEquals(maths.division("2/-1",1),-2,2);
    }
    @Test
    public void testDivisionException() throws Exception {
        e.expect(MathsExceptions.class);
        e.expectMessage("Division par zero impossible");
        maths.division("2/0",1);
    }
}
