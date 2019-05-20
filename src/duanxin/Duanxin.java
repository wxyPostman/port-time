package duanxin;


import com.github.qcloudsms.*;

public class Duanxin {
	// 短信应用 SDK AppID
	static int appid = 1400172450; // SDK AppID 以1400开头

	// 短信应用 SDK AppKey
	static String appkey = "fe722901c24c7d2d5a47be042283a4de";

	// 需要发送短信的手机号码
//	static String[] phoneNumbers = {"21212313123", "12345678902", "12345678903"};

	// 短信模板 ID，需要在短信应用中申请
	static int templateId = 330052; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请

	// 签名
	static String smsSign = "小桥流水网"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请

	public static void sendOne(String param1,String param2,String phoneNumber){

        try {
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.send(0, "86",phoneNumber,
            		param1+"验证码："+param2+"，请于"+3+"分钟内填写。如非本人操作，请忽略本短信。", "", "");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

	

}
