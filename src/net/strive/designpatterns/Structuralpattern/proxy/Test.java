package net.strive.designpatterns.Structuralpattern.proxy;

/**
 * @author Administrator
 *         代理模式
 *         适用性
 *         1.远程代理（RemoteProxy）为一个对象在不同的地址空间提供局部代表。
 *         <p/>
 *         2.虚代理（VirtualProxy）根据需要创建开销很大的对象。
 *         <p/>
 *         3.保护代理（ProtectionProxy）控制对原始对象的访问。
 *         <p/>
 *         4.智能指引（SmartReference）取代了简单的指针，它在访问对象时执行一些附加操作。
 */
public class Test {

    public static void main(String[] args) {
        Object obj = new ProxyObject();
        obj.action();
    }

}
