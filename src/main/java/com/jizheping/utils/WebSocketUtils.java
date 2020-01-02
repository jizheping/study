package com.jizheping.utils;

import com.alibaba.fastjson.JSONObject;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WenSocket工具类
 */

@ServerEndpoint("/websocket/{username}")
public class WebSocketUtils {
    private static Integer onlineCount = 0;
    private static Map<String,WebSocketUtils> clients = new ConcurrentHashMap<String,WebSocketUtils>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username")String username,Session session)throws Exception{
        this.username = username;
        this.session = session;

        addOnLineCount();
        clients.put(username,this);
        System.out.println(username + "已经连接啦!");
    }

    @OnClose
    public void onClose()throws Exception{
        clients.remove(username);
        subONLineCount();
    }

    @OnMessage
    public void onMessage(String message)throws Exception{
        JSONObject jsonObject = JSONObject.parseObject(message);
        String msg = (String) jsonObject.get("message");

        if(!jsonObject.get("To").equals("All")){
            sendMessageTo(msg,jsonObject.get("To").toString());
        }else{
            sendMessageAll("给所有人");
        }
    }

    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();
    }

    public void sendMessageTo(String message,String to)throws Exception{
        for(WebSocketUtils item : clients.values()){
            if(item.username.equals(to)){
                item.session.getAsyncRemote().sendText(message);
            }
        }
    }

    public void sendMessageAll(String message)throws Exception{
        for(WebSocketUtils item : clients.values()){
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized void addOnLineCount(){
        WebSocketUtils.onlineCount++;
    }
    
    public static synchronized void subONLineCount(){
        WebSocketUtils.onlineCount--;
    }

    public static synchronized Map<String,WebSocketUtils> getClients(){
        return clients;
    }
}
