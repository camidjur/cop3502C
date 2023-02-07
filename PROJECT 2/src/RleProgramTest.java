import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RleProgramTest {
    @Test
    public void countRunsTest(){
        byte[] arr = {4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,8,7};
        int groups = 6;
        assertEquals(groups, RleProgram.countRuns(arr));
    }
    @Test
    public void encodeRleTest(){
        byte[] arr = {4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,8,7};
        byte [] rleData = {2,4,15,1,15,1,5,1,1,8,1,7};
        byte [] actualResults = RleProgram.encodeRle(arr);
        assertArrayEquals(rleData, actualResults);
    }
    @Test
    public void decodeRleTest(){
        byte[] arr = {2,4,15,1,15,1,5,1,1,8,1,7};
        byte [] expectedOutput = {4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,8,7 };
        byte [] actualResults = RleProgram.decodeRle(arr);
        assertArrayEquals(expectedOutput, actualResults);
    }
    @Test
    public void toHexStringTest(){
        byte[] arr = { 3, 15, 6, 4};
        String output = "3f64";
        assertEquals(output, RleProgram.toHexString(arr));
    }
    @Test
    public void getDecodedLengthTest(){
        byte[] arr = { 3, 15, 6, 4};
        int length = 9;
        assertEquals(length, RleProgram.getDecodedLength(arr));
    }
    @Test
    public void stringToDataTest(){
        String input = "3f64";
        byte[] arr = { 3, 15, 6, 4};
        assertArrayEquals(arr, RleProgram.stringToData(input));
    }
    @Test
    public void toRleStringTest(){
        byte[] arr =  { 15, 15, 6, 4};
        String res = "15f:64";
        assertEquals(res, RleProgram.toRleString(arr));
    }
    @Test
    public void stringToRleTest(){
        String input = "15f:64";
        byte[] arr =  { 15, 15, 6, 4};
        assertArrayEquals(arr, RleProgram.stringToRle(input));
    }
}
