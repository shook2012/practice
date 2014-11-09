package net.strive.designpatterns.Creationalpattern.singleton;

/**
 * @author strive
 *         适用性
 *         1.当类只能有一个实例而且客户可以从一个众所周知的访问点访问它时。
 *         <p/>
 *         2.当这个唯一实例应该是通过子类化可扩展的，并且客户应该无需更改代码就能使用一个扩展的实例时。
 */
public class Test {

    public static void main(String[] args) {
        Singleton sing1 = Singleton.getInstance();

        Singleton sing2 = Singleton.getInstance();

        System.out.println(sing1);

        System.out.println(sing2);

    }

}
