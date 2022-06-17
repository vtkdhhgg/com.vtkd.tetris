package entities;

import java.awt.*;

/**
 * 可以表示地面里面的障碍物, 不可消除的障碍物, 空白
 * <p>
 * 外部不可以直接new 一个实例, 而应该用 clone() 方法产生实例(防止产生不能识别的类型)
 * 例如长生一个障碍物:
 * ```
 * UnitType aObstacle = UnitType.OBSTACLE.clone();
 * ```
 *
 * @author 君上
 * @version 1.0, 2022.6.10
 */
public class UnitType implements Cloneable {

    /* 定义一些要用到的常量 */


    /**
     * 空白类型的值
     */
    private static final int BLANK_VALUE = 0;
    /**
     * 空白类型
     */
    public static final UnitType BLANK = new UnitType(BLANK_VALUE, Color.white);
    /**
     * 边框类型的值
     */
    private static final int STUBBORN_OBSTACLE_VALUE = 1;
    /**
     * 边框类型
     */
    public static final UnitType STUBBORN_OBSTACLE = new UnitType(
            STUBBORN_OBSTACLE_VALUE, new Color(0x80800));
    /**
     * 障碍物类型的值
     */
    private static final int OBSTACLE_VALUE = 2;
    /**
     * 障碍物类型
     */
    public static final UnitType OBSTACLE = new UnitType(OBSTACLE_VALUE,
            Color.DARK_GRAY);

    /**
     * 值类型
     */
    private int value;

    /**
     * 颜色
     */
    private Color color;

    /**
     * 接受 类型的 私有的 构造方法
     *
     * @param value
     */
    private UnitType(int value) {
        this.value = value;
    }

    /**
     * 接受 类型 和 颜色的私有构造方法
     *
     * @param value
     * @param color
     */
    private UnitType(int value, Color color) {
        this.value = value;
        this.color = color;
    }

    /**
     * 得到值类型
     *
     * @return
     */
    public int getValue() {
        return value;
    }

    /**
     * 设置值类型
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 得到颜色
     *
     * @return
     */
    public Color getColor() {
        return color;
    }

    /**
     * 设置颜色
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 返回一个新的,和自己有一样的颜色并且类型相同的UnitType
     *
     */
//    @Override

    @Override
    public UnitType clone(){
        return new UnitType(this.value, this.color);
    }

    /**
     * 把自己克隆成和指定的UnitType 相同的UnitType, value 和 Color 都会被克隆
     *
     * @param ut
     */
    public void cloneProperties(UnitType ut) {
        this.color = ut.color;
        this.value = ut.value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    /**
     * 相同的类型就是相等,不比较颜色
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnitType other = (UnitType) obj;
        return value == other.value;
    }

}
