public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aSplit = a.split("\\+|i");
        int aReal = Integer.parseInt(aSplit[0]);
        int aComplex = Integer.parseInt(aSplit[1]);

        String[] bSplit = b.split("\\+|i");
        int bReal = Integer.parseInt(bSplit[0]);
        int bComplex = Integer.parseInt(bSplit[1]);


        return (aReal * bReal - aComplex * bComplex) + "+" + (aReal * bComplex + aComplex * bReal) + "i";
    }
}
