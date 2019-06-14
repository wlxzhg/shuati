package cn.xiaozhigang.code.basic.json.FastJson;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class main {
    public static void main(String[] args) {
        String jsonStr = "{\"CLPP\":\"本田\",\"CLYS\":\"其它\",\"CPH\":\"陕A4345\",\"SJ\":\"2019-05-22 09:35:57\"}";

        JSONObject jsonObject = JSON.parseObject(jsonStr);
        System.out.println(jsonObject.get("CLPP"));
        System.out.println(jsonObject.get("CLYS"));
        System.out.println(jsonObject.get("CPH"));
        System.out.println(jsonObject.get("SJ"));

        jsonStr.indexOf(null);
//        JSONObject
    }
}
