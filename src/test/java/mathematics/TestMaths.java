package mathematics;

import exceptions.MathsException;
import interfaces.IMaths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestMaths {
    private IMaths maths;

    @Rule
    public ExpectedException e = ExpectedException.none();

    @Before
    public void setUp(){
        this.maths = new Maths();
    }


    //ADDITIONS
    @Test
    public void testAdditionCasGeneralNombrePositif(){
        Assert.assertEquals(maths.addition(2,3),5);
    }

    @Test
    public void testAdditionCasGeneralNombreNegatif(){
        Assert.assertEquals(maths.addition(2,-3),-1);
    }

    @Test
    public void testAdditionCasInverseNombreNegatif(){
        Assert.assertEquals(maths.addition(-3,2),-1);
    }

    @Test
    public void testAdditionCasDoubleNombreNegatif(){
        Assert.assertEquals(maths.addition(-3,-2),-5);
    }

    @Test
    public void testAdditionCas0(){
        Assert.assertEquals(maths.addition(3,0),3);
    }


    //SOUSTRACTIONS
    @Test
    public void testSoustractionCasGeneralNombrePositif(){
        Assert.assertEquals(maths.soustraction(3,2),1);
    }

    @Test
    public void testSoustractionCasGeneralNombreNegatif(){
        Assert.assertEquals(maths.soustraction(3,-2),5);
    }

    @Test
    public void testSoustractionCasInverseNombreNegatif(){
        Assert.assertEquals(maths.soustraction(-2,3),-5);
    }

    @Test
    public void testSoustractionCasDoubleNombreNegatif(){
        Assert.assertEquals(maths.soustraction(-2,-3),1);
    }

    @Test
    public void testSoustractionCas0(){
        Assert.assertEquals(maths.soustraction(2,0),2);
    }


    //MULTIPLICATIONS

    @Test
    public void testMultiplicationCasGeneralPositif(){
        Assert.assertEquals(maths.multiplication(2,3),6);
    }

    @Test
    public void testMultiplicationCasGeneralNegatif(){
        Assert.assertEquals(maths.multiplication(2,-3),-6);
    }

    @Test
    public void testMultiplicationCasInverseNegatif(){
        Assert.assertEquals(maths.multiplication(-3,2),-6);
    }

    @Test
    public void testMultiplicationCasDoubleNegatif(){
        Assert.assertEquals(maths.multiplication(-3,-2),6);
    }

    @Test
    public void testMultiplicationCas0(){
        Assert.assertEquals(maths.multiplication(3,0),0);
    }


    //DIVISIONS
    @Test
    public void testDivisionCasGeneralNombrePositif() {
        try{
            Assert.assertEquals(maths.division(4,2),2.0,10);
        } catch(Exception e){
            System.out.println("Error");
        }
    }

    @Test
    public void testDivisionCasGeneralNombreNegatif() {
        try{
            Assert.assertEquals(maths.division(-4,2),-2.0,10);
        } catch(Exception e){
            System.out.println("Error");
        }
    }

    @Test
    public void testDivisionCasInverseNombreNegatif() {
        try{
            Assert.assertEquals(maths.division(4,-2),-2.0,10);
        } catch(Exception e){
            System.out.println("Error");
        }
    }

    @Test
    public void testDivisionCasDoubleNombreNegatif() {
        try{
            Assert.assertEquals(maths.division(-4,-2),2.0,10);
        } catch(Exception e){
            System.out.println("Error");
        }
    }

    @Test
    public void testDivisionCas0() throws MathsException {
        e.expect(MathsException.class);
        e.expectMessage("Division par zéro interdite");
        maths.division(1,0);
    }
}
