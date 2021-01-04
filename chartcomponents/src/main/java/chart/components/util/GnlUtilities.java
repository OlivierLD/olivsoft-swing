package chart.components.util;

import chart.components.util.local.ChartComponentsResourceBundle;

public final class GnlUtilities {
    public static String buildMessage(String id) {
        return buildMessage(id, null);
    }

    public static String buildMessage(String id, String[] data) {
        String mess = ChartComponentsResourceBundle.getChartComponentsResourceBundle().getString(id);
        for (int i = 0; data != null && i < data.length; i++) {
            String toReplace = String.format("{$%d}", (i + 1));
//            System.out.println("Replacing " + toReplace + " with " + data[i] + " in " + mess);
            mess = mess.replace(toReplace, data[i]);
//            mess = replaceString(mess, toReplace, data[i]);
        }
        return mess;
    }

    // TODO Use String.replace (see above)
//    public static String replaceString(String orig, String oldStr, String newStr) {
//        String ret = orig;
//        int indx = 0;
//        for (boolean go = true; go; ) {
//            indx = ret.indexOf(oldStr, indx);
//            if (indx < 0) {
//                go = false;
//            } else {
//                ret = ret.substring(0, indx) + newStr + ret.substring(indx + oldStr.length());
//                indx += 1 + oldStr.length();
//            }
//        }
//        return ret;
//    }
}
