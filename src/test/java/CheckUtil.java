import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhihaosong on 16-1-15.
 */
public class CheckUtil {
    private static final Logger LOG = LoggerFactory.getLogger(CheckUtil.class);
    private static Map<String, List<String>> group = new HashMap<String, List<String>>();
    public static final String GROUP_PREFIX = "infra_sms_group_";
    public static final String IP_SPLIT_CHAR = ";";

    static {
    }

    private static void initGroup(Map<String, String> map) {
        String key = null;
        List<String> ips = null;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            key = getType(entry.getKey());
            if (key != null) {
                ips = getIps(entry.getValue());
                if (ips != null && ips.size() > 0) {
                    group.put(key, ips);
                }
            }
        }
    }

    public static boolean isAllownType(String type) {
        if (type != null && !"".equals(type)) {
            return group.containsKey(type);
        }
        LOG.warn("invalid group type!");
        return false;
    }

    private static String getType(String key) {
        if (key != null && !"".equals(key) && key.startsWith(GROUP_PREFIX)) {
            String value = key.split(GROUP_PREFIX)[1];
            if (value != null && !"".equals(value.trim()) && value.length() == 1) {
                LOG.info("type : " + value);
                return value;
            } else {
                LOG.warn("invalid group type.");
            }
        }
        return null;
    }

    private static List<String> getIps(String value) {
        if (value != null && !"".equals(value.trim())) {
            String[] ips = value.split(IP_SPLIT_CHAR);
            if (ips != null && ips.length > 0) {
                for (String ip : ips) {
                    LOG.info("ip :{}", new Object[]{ip});
                }
                return Arrays.asList(ips);
            } else {
                LOG.warn("invalid group value.");
            }
        }
        return null;
    }

    public static String checkPhoneNum(String phoneNumber) {
        if (phoneNumber != null) {
            Pattern p1 = Pattern.compile("^((\\+{0,1}86){0,1})1[0-9]{10}");
            Matcher m1 = p1.matcher(phoneNumber);
            if (m1.matches()) {
                Pattern p2 = Pattern.compile("^((\\+{0,1}86){0,1})");
                Matcher m2 = p2.matcher(phoneNumber);
                StringBuffer sb = new StringBuffer();
                while (m2.find()) {
                    m2.appendReplacement(sb, "");
                }
                m2.appendTail(sb);
                return sb.toString();
            }
        }
        LOG.info("The format of phoneNum {}  is not correct!Please correct it.", new Object[]{phoneNumber});
        return null;
    }

    public static void main(String[] args) {
        CheckUtil.checkPhoneNum("18201090152");
    }
}
