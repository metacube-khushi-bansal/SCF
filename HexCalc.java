import java.util.Scanner;

public class HexCalc {
    public String addHexaDecimal(String hex1, String hex2) {
        int num1 = Integer.parseInt(hex1, 16);
        int num2 = Integer.parseInt(hex2, 16);
        int result = num1 + num2;
        String hexResult = Integer.toHexString(result).toUpperCase(); // convert the integer sum into hexadec
        return hexResult;
    }

    public String subtractHexaDecimal(String hex1, String hex2) {
        int num1 = Integer.parseInt(hex1, 16);
        int num2 = Integer.parseInt(hex2, 16);
        int result = num1 - num2;
        if (result < 0) {
            return "-" + Integer.toHexString(-result).toUpperCase();
        }
        String hexResult = Integer.toHexString(result).toUpperCase();
        return hexResult;
    }

    public String multiplyHexaDecimal(String hex1, String hex2) {
        int num1 = Integer.parseInt(hex1, 16);
        int num2 = Integer.parseInt(hex2, 16);
        int result = num1 * num2;
        String hexResult = Integer.toHexString(result).toUpperCase();
        return hexResult;
    }

    public String divideHexaDecimal(String hex1, String hex2) {
        int num1 = Integer.parseInt(hex1, 16);
        int num2 = Integer.parseInt(hex2, 16);
        int result = num1 / num2;
        String hexResult = Integer.toHexString(result).toUpperCase();
        return hexResult;
    }

    public boolean hexaDecimalComparison(String hex1, String hex2, char operation) {
        int length1 = hex1.length();
        int length2 = hex2.length();
        // for comparison '='
        if (operation == '=') {
            if (length1 != length2) {
                return false;
            }
            for (int i = 0; i < length1; i++) {
                if (hex1.charAt(i) != hex2.charAt(i))
                    return false; // strings not equal
            }
            return true; // hexadec strings are equal!
        }

        // for comparison '>'
        else if (operation == '>') {
            if (length1 > length2) // hex1 > hex2
                return true;
            else if (length1 < length2)
                return false; // hex1 not greater than hex2

            for (int i = 0; i < length1; i++) {
                if (hex1.charAt(i) > hex2.charAt(i))
                    return true;
                else if (hex1.charAt(i) < hex2.charAt(i))
                    return false;
            }
            return false; // if all char equal, hex1 not greater
        }

        // for comparison '<'
        else if (operation == '<') {
            if (length1 < length2)
                return true; // hex1 is smaller than hex2
            else if (length1 > length2)
                return false; // hex2 not smaller than hex1

            for (int i = 0; i < length1; i++) {
                if (hex1.charAt(i) < hex2.charAt(i))
                    return true;
                else if (hex1.charAt((i)) > hex2.charAt(i))
                    return false;
            }

            return false; // both strings equal
        }
        return true;
    }

    public int hexaDecimalToDecimal(String hex1) {
        int ans = 0;
        int cnt = 0;
        for (int i = hex1.length() - 1; i >= 0; i--) {
            char ch = hex1.charAt(i);
            if (ch >= 'A' && ch <= 'F') {
                ans += Math.pow(16, cnt) * (ch - 'A' + 10);
            } else if (ch >= '0' && ch <= '9') {
                ans += Math.pow(16, cnt) * (ch - '0');
            } else {
                System.out.println("Not a valid hexadec char !Enter valid");
                return 0;
            }
            cnt++;

        }
        return ans;
    }

    public String decimalToHexaDecimal(int decimal) {
        int rem;
        char[] hexaChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        String hexaDecimal = "";
        while (decimal != 0) {
            rem = decimal % 16;
            hexaDecimal = hexaChars[rem] + hexaDecimal;
            decimal = decimal / 16;
        }
        return hexaDecimal;
    }

    public static void main(String[] args) {
        HexCalc hexCalc = new HexCalc();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first hexadecimal String: ");
        String hex1 = scanner.nextLine();
        if (!validHexaDec(hex1.toUpperCase())) {
            System.out.println("Not valid hexadecimal!");
            scanner.close();
            return;
        }

        System.out.println("Enter second hexadecimal String: ");

        String hex2 = scanner.nextLine();
        if (!validHexaDec(hex2.toUpperCase())) {
            System.out.println("Not valid hexadecimal!");
            scanner.close();  
            return;

        }
        scanner.close();

        System.out.println("Addition of " + hex1 + " and " + hex2 + " is : "
                + hexCalc.addHexaDecimal(hex1.toUpperCase(), hex2.toUpperCase()));
        System.out.println("Subtraction of " + hex1 + " and " + hex2 + " is : "
                + hexCalc.subtractHexaDecimal(hex1.toUpperCase(), hex2.toUpperCase()));
        System.out
                .println("Multiplication of " + hex1 + " and " + hex2 + " is : "
                        + hexCalc.multiplyHexaDecimal(hex1.toUpperCase(), hex2.toUpperCase()));
        System.out.println("Divison of " + hex1 + " and " + hex2 + " is : "
                + hexCalc.divideHexaDecimal(hex1.toUpperCase(), hex2.toUpperCase()));

        System.out
                .println("If " + hex1 + " and " + hex2 + " are equal : "
                        + hexCalc.hexaDecimalComparison(hex1.toUpperCase(), hex2.toUpperCase(), '='));
        System.out.println(
                "If " + hex1 + " is greater than  " + hex2 + " : "
                        + hexCalc.hexaDecimalComparison(hex1.toUpperCase(), hex2.toUpperCase(), '>'));
        System.out.println(
                "If " + hex1 + " is smaller than  " + hex2 + " : "
                        + hexCalc.hexaDecimalComparison(hex1.toUpperCase(), hex2.toUpperCase(), '<'));

        System.out.println("Decimal form of " + hex1 + " is: " + hexCalc.hexaDecimalToDecimal(hex1.toUpperCase()));
        System.out.println("Decimal form of " + hex2 + " is: " + hexCalc.hexaDecimalToDecimal(hex2.toUpperCase()));

       
        int decimal =161;
        System.out.println("HexaDecimal form of " + decimal + " is: " + hexCalc.decimalToHexaDecimal(decimal));
    }

    public static boolean validHexaDec(String hexaDec) {
        boolean flag = true;
        for (int i = 0; i < hexaDec.length(); i++) {
            char ch = hexaDec.charAt(i);
            if (ch >= 'A' && ch <= 'F') {
                flag = true;
            } else if (ch >= '0' && ch <= '9')
                flag = true;

            else {
                flag = false;
                return flag;
            }
        }
        return flag;
    }
}
