class Solution {
    private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0)return "Zero";
        String result = "";
        int thousandCount = 0;

        while(num != 0) {
            // every time handle three digits from right
            if(num % 1000 != 0) {
                result = helper(num % 1000) + THOUSANDS[thousandCount] + " " + result;
            }
            num /= 1000;
            thousandCount ++;
        }
        return result.trim();
    }


    // helper return English word with " " only in the back
    // zero return "" because all conditions are alreay in LESS_THAN_20 & TENS
    // should use resursive to simplify conditions
    private String helper(int num) {
        if(num == 0)return "";
        else if(num < 20)return LESS_THAN_20[num] + " ";
        else if(num < 100)return TENS[num / 10] + " " + helper(num % 10);
        // < 1000
        else return  LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);

    }
}
