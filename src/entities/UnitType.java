package entities;

/**
 * 可以表示地面里面的障碍物, 不可消除的障碍物, 空白
 *
 * 外部不可以直接new 一个实例, 而应该用 clone() 方法产生实例(防止产生不能识别的类型)
 * 例如长生一个障碍物:
 * ``
 *  UnitType aObstacle = UnitType.OBSTACLE.clone();
 * ``
 *
 * @version 1.0, 2022.6.10
 *
 * @author 君上
 *
 */
public class UnitType {

    /* 定义一些要用到的常量 */


    /**
     * 空白类型的值
     */
    private static final int BLANK_VALUE = 0;



}
