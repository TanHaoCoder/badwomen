package badwomen.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;

/**
 * @description:
 * @author: tanhao
 * @time: 2020/2/26 2:29
 */
public class Md5Hash {
    /**
     * 用户注册时加密用户的密码
     * 输入密码明文 返回密文与盐值 注册使用
     * @param password
     * @return 第一个是盐值  第二个是密码
     */
    public static String[] encryptPassword(String password)
    {
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String ciphertext = new org.apache.shiro.crypto.hash.Md5Hash(password,salt,3).toString();

        String[] strings = new String[]{salt, ciphertext};

        return strings;
    }

    /**
     * 获得本次输入的密码的密文
     * 应用范围：登录 更新密码
     * @param password
     * @param salt
     * @return 密文
     */
    public static String getInputPasswordCiph(String password, String salt)
    {
        if(salt == null)
        {
            password = "";
        }

        String ciphertext = new org.apache.shiro.crypto.hash.Md5Hash(password,salt,3).toString();

        return ciphertext;
    }

    public static void main(String[] args) {
        System.out.println(getInputPasswordCiph("root", "daa886c187aa602e225f3766fabe9d7c"));
    }
}

