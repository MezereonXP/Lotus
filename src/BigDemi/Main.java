package BigDemi;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Scanner;
import javax.print.attribute.standard.NumberUp;

/**
 * @program: Main
 * @description:
 * @author: mezereonxp Email: mezereonxp@gmail.com
 * @create: 2018/9/10
 **/
public class Main {
    public static void main(String[] args) {
//        BigInteger bigInteger = new BigInteger(a+"");
//        BigInteger bigInteger1 = new BigInteger(b+"");
//        BigInteger result = bigInteger.divide(bigInteger1);
//        System.out.println(result);
        fractionToDecimal(-50, 8);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        BigInteger partOfBigNum = new BigInteger("0");
        java.math.BigDecimal a = new java.math.BigDecimal(numerator + "");
        java.math.BigDecimal b = new java.math.BigDecimal(denominator + "");
        java.math.BigDecimal c = a.divide(b, 1000, java.math.BigDecimal.ROUND_HALF_EVEN);
        java.math.BigDecimal d = a.divide(b, 0, BigDecimal.ROUND_DOWN);
        int flag = c.compareTo(java.math.BigDecimal.ZERO) >= 0 ? 1 : -1;
        a = a.abs();
        b = b.abs();
        if (b.equals(BigDecimal.ONE)) {
            return a.multiply(new BigDecimal(flag)).toString();
        }
        if (a.equals(java.math.BigDecimal.ZERO)) {
            return "0";
        }
        if (a.compareTo(b) > 0) {
            partOfBigNum = partOfBigNum.add(d.abs().toBigInteger());
            a = a.subtract(b.multiply(d.abs()));
        }
        if (a.equals(b)) {
            return "" + (partOfBigNum.add(BigInteger.ONE)).multiply(new BigInteger(flag + ""));
        }
        if (a.equals(java.math.BigDecimal.ZERO)) {
            return "" + (partOfBigNum.multiply(new BigInteger(flag + "")));
        }
        java.math.BigDecimal result = a.divide(b, 4000, java.math.BigDecimal.ROUND_HALF_EVEN);
        for (int i = 0; i < 10; i++) {
            result = result.multiply(new java.math.BigDecimal("10"));
            while (result.compareTo(new java.math.BigDecimal("1")) > 0) {
                result = result.subtract(java.math.BigDecimal.ONE);
            }
        }
        java.math.BigDecimal temp = result.multiply(new java.math.BigDecimal("10"));
        while (temp.compareTo(new java.math.BigDecimal("1")) > 0) {
            temp = temp.subtract(java.math.BigDecimal.ONE);
        }
        int length = 1;
        java.math.BigDecimal divide = temp.subtract(result).abs();
        while (divide.compareTo(new java.math.BigDecimal("1E-1000")) > 0) {
            if (temp.equals(new BigDecimal(0E-4000))) {
                length = 0;
                break;
            }
            length++;
            temp = temp.multiply(new java.math.BigDecimal("10"));
            while (temp.compareTo(new java.math.BigDecimal("1")) >= 0) {
                temp = temp.subtract(java.math.BigDecimal.ONE);
            }
            divide = temp.subtract(result).abs();
        }
        result = a.divide(b, 4000, java.math.BigDecimal.ROUND_HALF_EVEN);
        String s = result.abs().toPlainString().substring(2);
        int position = getFront(s, length);
        char[] chars = s.toCharArray();
        String re = (flag == -1 ? "-" : "") + partOfBigNum + ".";
        for (int i = 0; i < position; i++) {
            re = re + (chars[i]);
        }
        if (!(length == 1 && chars[position] == '0')) {
            re = re + ("(");
            for (int i = 0; i < length; i++) {
                re = re + (chars[position + i]);
            }
            re = re + (")");
        }
        return re;
    }

    private static int getFront(String substring, int length) {
        int position = 0;
        char[] chars = substring.toCharArray();
        for (int i = 0; i < length; i++) {
            if (chars[position + i] != chars[position + i + length]) {
                i = -1;
                position++;
            }
        }
        return position;
    }
}
