package api.wmsgk.oil;

public class qb {
    public static final String QQ = "10001";// 你的QQ
    public static final String URL = "https://wmsgk.com/qbtxt-api.php";

    public static <JSONObject> void Get() {
        String result = null;
        String url = URL + "?qq=" + QQ;

        try {
            Object HttpUtil = null;
            result = HttpUtil.sendGet(url, "utf-8");
            JSONObject json = JSONObject.fromObject(result);
            if (json.getInt("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONArray resultarr = json.optJSONArray("result");
                for (int i = 0; i < resultarr.size(); i++) {
                    System.out.println(resultarr.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}