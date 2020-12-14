package com.zyy.mowa.utils;


import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "消息推送")
@RestController
@RequestMapping("api")
public class PushMessage {
    private static String appId = "NDbRU7mUQ076boYBjhzk95";
    private static String appKey = "8w6p2lf27O8IKSv601YTB9";
    private static String masterSecret = "cMVGrtzkgO6Io5wz1roJiA";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";

    @GetMapping("/sendmessage")
    public void sendmessage() {
        // STEP1：获取应用基本信息

        IGtPush push = new IGtPush(url, appKey, masterSecret);

        Style0 style = new Style0();
        // STEP2：设置推送标题、推送内容
        style.setTitle("机器人停线");
        style.setText("故障123");
        // 注释采用默认图标
        // style.setLogo("push.png");  // 设置推送图标
        // STEP3：设置响铃、震动等推送效果
        style.setRing(true);  // 设置响铃
        style.setVibrate(true);  // 设置震动

        // STEP4：选择通知模板
        NotificationTemplate template = new NotificationTemplate();
        template.setAppId(appId);

        template.setAppkey(appKey);
        template.setStyle(style);
        // 点击消息打开应用
        template.setTransmissionType(1);
        // 传递自定义消息
        template.setTransmissionContent("1234");

        // STEP5：定义"AppMessage"类型消息对象,设置推送消息有效期等推送参数
        // List<String> appIds = new ArrayList<String>();
        // appIds.add(appId);
        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        message.setOfflineExpireTime(1000 * 600);  // 时间单位为毫秒

        // STEP6：执行推送
        IPushResult ret = push.pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());

    }


}
