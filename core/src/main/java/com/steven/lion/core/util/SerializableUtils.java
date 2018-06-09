package com.steven.lion.core.util;

import com.steven.lion.core.entity.User;
import org.apache.shiro.codec.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 项目名称:com.steven.lion.core.util
 * 类名称:SerializableUtils
 * 描述:
 * 创建人:steven
 * 创建时间:2018-06-09 19:19
 */
public class SerializableUtils {

    public static String serialize(Object object) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            return Base64.encodeToString(bos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("serialize object error", e);
        }
    }
    public static Object deserialize(String objectStr) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(objectStr));
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("deserialize object error", e);
        }
    }

    public static void main(String[] args) {
        try{
            User user = new User();
            user.setUsername("gxt");
            user.setPassword("123456");
            String str = SerializableUtils.serialize(user);
            System.out.println(str);
            User user1 = (User) SerializableUtils.deserialize(str);
            System.out.println(user1.getPassword());
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
