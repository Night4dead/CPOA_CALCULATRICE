package com.iut.as2021.metiers;

import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.metier.Calculer;
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
    @Test
    public void testAdditionDouble() { Assert.assertEquals(maths.addition("2.3+5.4",1),7.7,2); }
    @Test
    public void testAdditionDouble2() {
        Assert.assertEquals(maths.addition("1.2+2",1),3.2,2);
    }
    @Test
    public void testAdditionDouble3() {
        Assert.assertEquals(maths.addition("24+5.5",2),29.5,2);
    }
    @Test
    public void testAdditionDouble4() {
        Assert.assertEquals(maths.addition("-2.5+5",2),2.5,2);
    }
    @Test
    public void testAdditionDouble5() {
        Assert.assertEquals(maths.addition("-5+5.3",2),0.3,2);
    }

    @Test
    public void testSoustractionDouble(){
        Assert.assertEquals(maths.soustraction("1.5-2",1),-0.5,2);
    }
    @Test
    public void testSoustractionDouble2(){
        Assert.assertEquals(maths.soustraction("2-1.5",1),0.5,2);
    }
    @Test
    public void testSoustractionDouble3(){
        Assert.assertEquals(maths.soustraction("-2.5-2.3",2),-4.8,2);
    }
    @Test
    public void testSoustractionDouble4(){
        Assert.assertEquals(maths.soustraction("2--1.5",1),3.5,2);
    }
    @Test
    public void testSoustractionDouble5(){
        Assert.assertEquals(maths.soustraction("-32.3--2",2),34.3,2);
    }
    @Test
    public void testSoustractionDouble6(){
        Assert.assertEquals(maths.soustraction("-32.3--2.4",2),34.7,2);
    }

    @Test
    public void testMultiplicationDouble(){ Assert.assertEquals(maths.multiplication("1.5*2",1),3,2); }
    @Test
    public void testMultiplicationDouble2(){
        Assert.assertEquals(maths.multiplication("2*2.5",1),5,2);
    }
    @Test
    public void testMultiplicationDouble3(){
        Assert.assertEquals(maths.multiplication("1.5*1.5",2),2.25,2);
    }
    @Test
    public void testMultiplicationDouble4(){
        Assert.assertEquals(maths.multiplication("-10*2.5",2),-25,2);
    }
    @Test
    public void testMultiplicationDouble5(){
        Assert.assertEquals(maths.multiplication("10*-2.5",2),-25,2);
    }
    @Test
    public void testMultiplicationDouble6(){
        Assert.assertEquals(maths.multiplication("-10.5*-2.5",2),26.25,2);
    }
    @Test
    public void testMultiplicationDouble7(){
        Assert.assertEquals(maths.multiplication("10*-2.5",2),-25,2);
    }

    @Test
    public void testDivisionDouble() throws Exception {
        Assert.assertEquals(maths.division("2.5/2",1),1.25,2);
    }
    @Test
    public void testDivisionDouble2() throws Exception {
        Assert.assertEquals(maths.division("2/1.6",1),1.25,2);
    }
    @Test
    public void testDivisionDouble3() throws Exception {
        Assert.assertEquals(maths.division("1.5/2.5",1),0.6,2);
    }
    @Test
    public void testDivisionDouble4() throws Exception {
        Assert.assertEquals(maths.division("-2.5/2",2),-1.25,2);
    }
    @Test
    public void testDivisionDouble5() throws Exception {
        Assert.assertEquals(maths.division("-1.5/-2.5",1),0.6,2);
    }
    @Test
    public void testDivisionDouble6() throws Exception {
        Assert.assertEquals(maths.division("2/-1.6",1),-1.25,2);
    }
    @Test
    public void testDivisionDouble7() throws Exception {
        Assert.assertEquals(maths.division("-2/-1.6",1),1.25,2);
    }
    @Test
    public void testDivisionDoubleException() throws Exception {
        e.expect(MathsExceptions.class);
        e.expectMessage("Division par zero impossible");
        maths.division("2.5/0",1);
    }
}
